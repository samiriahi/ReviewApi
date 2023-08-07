package com.examen.demo.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ReviewSmartTv {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long idReview;
	 
	 
	 @Column(nullable = false)
	 private int rating;

	 @Temporal(TemporalType.DATE)
	 private Date date;

	 @Column(nullable = false)
	 private String comment;

	 @Column(nullable = false)
	 private String userId; 
	    
	    
	 @ManyToOne
	 @JoinColumn(name="idSmartTV")
	 @JsonIgnoreProperties("reviews")
	 private SmartTv smartTv;
}
