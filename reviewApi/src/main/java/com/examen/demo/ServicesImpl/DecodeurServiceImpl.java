package com.examen.demo.ServicesImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.demo.Entities.Decodeur;
import com.examen.demo.Entities.ReviewDecodeur;
import com.examen.demo.Repositories.DecodeurRepository;
import com.examen.demo.Repositories.ReviewDecodeurRepository;
import com.examen.demo.Services.DecodeurService;

@Service
public class DecodeurServiceImpl implements DecodeurService {
	
	private DecodeurRepository decodeurRepository;
	private ReviewDecodeurRepository reviewDecodeurRepository;
		
	
	
	@Autowired
	public DecodeurServiceImpl(DecodeurRepository decodeurRepository ,ReviewDecodeurRepository reviewDecodeurRepository) {
		super();
		this.decodeurRepository = decodeurRepository;
		this.reviewDecodeurRepository = reviewDecodeurRepository;
	}
	
	
	@Override
	public Decodeur getDecoderByAddressMac (String addressMac) {
	    return decodeurRepository.findByAddrMac(addressMac) ;
	}
	
	
	@Override
	public List<Decodeur> getDecodeurs(){
		return decodeurRepository.findAll();
	}
	
	@Override
	public ReviewDecodeur addReviewDecodeur (String addressMac , String comment , int rating ,String userId ) {
	
		Decodeur decodeur = decodeurRepository.findByAddrMac(addressMac) ; // get decoder by addressMac ( attribute unique) 
		ReviewDecodeur reviewDecodeur = new ReviewDecodeur() ;
				
		reviewDecodeur.setComment(comment);
		reviewDecodeur.setRating(rating);
		reviewDecodeur.setUserId(userId);
		reviewDecodeur.setDate(new Date());
		reviewDecodeur.setDecodeur(decodeur);	
		reviewDecodeurRepository.save(reviewDecodeur) ;
		return reviewDecodeur ;	
	}
	
	@Override
	public ReviewDecodeur updateReviewDecodeur(long reviewDecoderId, String comment, int rating) {
		
	    ReviewDecodeur reviewDecodeur = reviewDecodeurRepository.findById(reviewDecoderId).get();
	    reviewDecodeur.setComment(comment);
	    reviewDecodeur.setRating(rating);
	    reviewDecodeur.setDate(new Date());
	    reviewDecodeurRepository.save(reviewDecodeur);
	    return reviewDecodeur;
	}
	
	@Override
	public String deleteReviewDecodeur(long reviewDecodeurId) {
		reviewDecodeurRepository.deleteById(reviewDecodeurId);
		return "Decoder Review Deleted Successfully." ; 
	}

	
	
	
	
	
	
	
	/*
	public List<DecodeurDTO> getDecodeurs() {
        List<Decodeur> decodeurs = decodeurRepository.findAll();
        return decodeurs.stream()
            .map(DecodeurMapper.INSTANCE::decodeurToDecodeurDTO)
            .collect(Collectors.toList());
    }*/
	
	
}
