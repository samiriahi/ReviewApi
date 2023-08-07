package com.examen.demo.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDecodeur {
	
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
    @JoinColumn(name="idDecoder")
    @JsonIgnoreProperties("reviews")
    private Decodeur decodeur;
}
