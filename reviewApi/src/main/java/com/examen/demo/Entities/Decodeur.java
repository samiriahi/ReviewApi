package com.examen.demo.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Decodeur {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDecodeur;

    @Column(nullable = false)
    private String addrMac;

    @Column(nullable = false)
    private String descriptionSTb;

    @Column(nullable = false)
    private String img;

    @Column(nullable = false)
    private String typeStb;

    @Column(nullable = false)
    @JsonProperty("DEV")
    private boolean dev;

    @OneToMany(mappedBy = "decodeur")
    @JsonIgnoreProperties("decodeur")
    private List<ReviewDecodeur> reviews;
}
