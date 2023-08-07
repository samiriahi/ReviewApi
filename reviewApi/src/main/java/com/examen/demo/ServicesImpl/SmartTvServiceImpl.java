package com.examen.demo.ServicesImpl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.demo.Entities.ReviewSmartTv;
import com.examen.demo.Entities.SmartTv;
import com.examen.demo.Repositories.ReviewSmartTvRepository;
import com.examen.demo.Repositories.SmartTvRepository;
import com.examen.demo.Services.SmartTvService;

@Service
public class SmartTvServiceImpl implements SmartTvService {
	
	private SmartTvRepository smartTvRepository ;
	private ReviewSmartTvRepository reviewSmartTvRepository;
	
	
	@Autowired
	public SmartTvServiceImpl(SmartTvRepository smartTvRepository , ReviewSmartTvRepository reviewSmartTvRepository ) {
		super();
		this.smartTvRepository = smartTvRepository;
		this.reviewSmartTvRepository = reviewSmartTvRepository;	
	}
	
	
	@Override
	public SmartTv getSmartTvById (Long idSmartTv) {
	    return smartTvRepository.findById(idSmartTv).get() ;
	}
	
	
	@Override
    public List<SmartTv> getAllSmartTV() {
        return smartTvRepository.findAll();
    }
	
	
	@Override
	public ReviewSmartTv addReviewSmartTv (long idSmartTv , String comment , int rating ,String userId ) {
	
		SmartTv smartTv = smartTvRepository.findById(idSmartTv).orElse(null) ; // get Smart TV By Id ( attribute unique) 
		
		ReviewSmartTv reviewSmartTv = new ReviewSmartTv() ;
				
		reviewSmartTv.setComment(comment);
		reviewSmartTv.setRating(rating);
		reviewSmartTv.setUserId(userId);
		reviewSmartTv.setDate(new Date());
		reviewSmartTv.setSmartTv(smartTv);	
		reviewSmartTvRepository.save(reviewSmartTv) ;
		return reviewSmartTv ;
	}
	
	@Override
	public ReviewSmartTv updateReviewSmartTv (long idReviewSmartTv , String comment , int rating ) {
	
		ReviewSmartTv reviewSmartTv = reviewSmartTvRepository.findById(idReviewSmartTv).get() ; 				
		reviewSmartTv.setComment(comment);
		reviewSmartTv.setRating(rating);
		reviewSmartTv.setDate(new Date());
		reviewSmartTvRepository.save(reviewSmartTv) ;
		return reviewSmartTv ;
	}

	@Override
	public String deleteReviewSmartTv(long idReviewSmartTv) {
		reviewSmartTvRepository.deleteById(idReviewSmartTv);
		return "Smart Review TV Deleted Successfully." ; 
	}
	

}
