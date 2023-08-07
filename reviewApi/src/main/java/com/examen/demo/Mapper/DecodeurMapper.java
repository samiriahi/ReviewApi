package com.examen.demo.Mapper;



import com.examen.demo.DTO.DecodeurDTO;
import com.examen.demo.Entities.Decodeur;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DecodeurMapper {

    DecodeurMapper INSTANCE = Mappers.getMapper(DecodeurMapper.class);

    DecodeurDTO decodeurToDecodeurDTO(Decodeur decodeur);

    Decodeur decodeurDTOToDecodeur(DecodeurDTO decodeurDTO);
}