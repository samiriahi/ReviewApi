package com.examen.demo.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DecodeurDTO {

    private Long idDecodeur;
    private String addrMac;
    private String descriptionSTb;
    private String img;
    private String typeStb;
    private boolean dev;
   
    private List<ReviewDecodeurDTO> reviews;
    
}

