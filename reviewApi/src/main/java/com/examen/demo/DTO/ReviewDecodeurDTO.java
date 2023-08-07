package com.examen.demo.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDecodeurDTO {

    private Long idReview;
    private int rating;
    private Date date;
    private String comment;
    private String userId;
    
    private DecodeurDTO decodeur ; // This field represents the id of the associated Decodeur entity.

}
