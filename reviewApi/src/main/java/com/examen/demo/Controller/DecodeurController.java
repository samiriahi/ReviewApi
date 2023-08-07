package com.examen.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examen.demo.Entities.Decodeur;
import com.examen.demo.Entities.ReviewDecodeur;
import com.examen.demo.Services.DecodeurService;

@RestController
@RequestMapping(path = {"/decodeur"})
public class DecodeurController {

	private DecodeurService decodeurService ;
	
	 @Autowired
	 public DecodeurController( DecodeurService decodeurService) {
	      this.decodeurService = decodeurService;
	 }
	 
	 @GetMapping("/{addressMac}")
		public  ResponseEntity<Decodeur> getDecoder (@PathVariable("addressMac") String addressMac)  {
		 Decodeur decodeur = decodeurService.getDecoderByAddressMac(addressMac);
		 return new  ResponseEntity<>(decodeur, HttpStatus.OK);
	 }
	
	 
	 @GetMapping
	 public ResponseEntity<List<Decodeur>> getAllDecodeurs() {
	    List<Decodeur> decodeurs = decodeurService.getDecodeurs(); 
	    return ResponseEntity.ok(decodeurs); 
	 }
	 
	 @PostMapping("/addReview")
	  public ResponseEntity<ReviewDecodeur> addReviewDecoder(@RequestParam("addressMac") String addressMac,
			  												 @RequestParam("comment") String comment,
	                                                         @RequestParam("rating") int rating,
	                                                         @RequestParam("userId") String userId ) {

       ReviewDecodeur reviewDecodeur = decodeurService.addReviewDecodeur(addressMac, comment, rating, userId);
       return new ResponseEntity<>(reviewDecodeur, HttpStatus.OK);
	 }
	 
	 @PostMapping("/updateReview")
	  public ResponseEntity<ReviewDecodeur> updateReviewDecoder(@RequestParam("idReview") Long idReview,
			  												 	@RequestParam("comment") String comment,
			  												 	@RequestParam("rating") int rating ) {
		 
      ReviewDecodeur reviewDecodeur = decodeurService.updateReviewDecodeur(idReview, comment, rating);
      return new ResponseEntity<>(reviewDecodeur, HttpStatus.OK);
	 }
	 
	 
	 @DeleteMapping("/reviews/{idReviewDecoder}")
	    public ResponseEntity<String> deleteReviewDecoder(@PathVariable long idReviewDecoder) {

		 String result = decodeurService.deleteReviewDecodeur(idReviewDecoder);
	     return ResponseEntity.ok(result);
	}
	
}
