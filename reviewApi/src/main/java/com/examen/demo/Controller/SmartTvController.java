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

import com.examen.demo.Entities.ReviewSmartTv;
import com.examen.demo.Entities.SmartTv;
import com.examen.demo.Services.SmartTvService;


@RestController
@RequestMapping(path = {"/smartTv"})
public class SmartTvController {
	
	private SmartTvService smartTvService ;
		
	@Autowired
	public SmartTvController( SmartTvService smartTvService) {
	    this.smartTvService = smartTvService;
	}
		 
	@GetMapping
	  public ResponseEntity<List<SmartTv>> getAllSmartTV() {
	   List<SmartTv> allSmartTv = smartTvService.getAllSmartTV(); 
	   return ResponseEntity.ok(allSmartTv); 
	}
	
	
	 @GetMapping("/{idSmartTv}")
		public  ResponseEntity<SmartTv> getSmartTv (@PathVariable("idSmartTv") long idSmartTv)  {
		 SmartTv smartTv = smartTvService.getSmartTvById(idSmartTv);
		 return new  ResponseEntity<>(smartTv, HttpStatus.OK);
	}
		 
	@PostMapping("/addReview")
	  public ResponseEntity<ReviewSmartTv> addReviewSmartTv(@RequestParam("idSmartTv") long idSmartTv,
	                                                        @RequestParam("comment") String comment,
	                                                        @RequestParam("rating") int rating,
	                                                        @RequestParam("userId") String userId ) {

        ReviewSmartTv reviewSmartTv = smartTvService.addReviewSmartTv(idSmartTv, comment, rating, userId);
        return new ResponseEntity<>(reviewSmartTv, HttpStatus.OK);
	}
	
	 @PostMapping("/updateReview")
	  public ResponseEntity<ReviewSmartTv> updateReviewSmartTv(@RequestParam("idReview") Long idReview,
			  												   @RequestParam("comment") String comment,
			  												   @RequestParam("rating") int rating ) {
		 
		ReviewSmartTv reviewSmartTv = smartTvService.updateReviewSmartTv(idReview, comment, rating);
		return new ResponseEntity<>(reviewSmartTv, HttpStatus.OK);
	}

	 @DeleteMapping("/reviews/{idReviewSmartTv}")
	    public ResponseEntity<String> deleteReviewSmartTv(@PathVariable long idReviewSmartTv) {

		 String result = smartTvService.deleteReviewSmartTv(idReviewSmartTv);
	     return ResponseEntity.ok(result);
	}
	 
	 	
	

}
