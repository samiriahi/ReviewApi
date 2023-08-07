package com.examen.demo.Services;

import java.util.List;

import com.examen.demo.Entities.Decodeur;
import com.examen.demo.Entities.ReviewDecodeur;

public interface DecodeurService {

	List<Decodeur> getDecodeurs();

	ReviewDecodeur addReviewDecodeur(String addressMac, String comment, int rating, String userId);

	ReviewDecodeur updateReviewDecodeur(long reviewDecoderId, String comment, int rating);

	String deleteReviewDecodeur(long reviewDecodeurId);

	Decodeur getDecoderByAddressMac(String addressMac);


}
