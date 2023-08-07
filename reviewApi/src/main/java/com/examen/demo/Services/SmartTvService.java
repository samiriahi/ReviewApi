package com.examen.demo.Services;

import java.util.List;

import com.examen.demo.Entities.ReviewSmartTv;
import com.examen.demo.Entities.SmartTv;

public interface SmartTvService {

	List<SmartTv> getAllSmartTV();

	ReviewSmartTv addReviewSmartTv(long idSmartTv, String comment, int rating, String userId);

	ReviewSmartTv updateReviewSmartTv(long idReviewSmartTv, String comment, int rating);

	String deleteReviewSmartTv(long idReviewSmartTv);

	SmartTv getSmartTvById(Long idSmartTv) ;

}
