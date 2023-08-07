package com.examen.demo.Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmartTv {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSmartTv;
    
	@Column(nullable = false)
	private String RpiUrl;
    
	@Column(nullable = false)
	private String webCamUrl;
    
	@Column(nullable = false)
	private boolean notify;
	
	
	
	@OneToMany(mappedBy = "smartTv")
	@JsonIgnoreProperties("smartTv")
	private List<ReviewSmartTv> reviews;

}
