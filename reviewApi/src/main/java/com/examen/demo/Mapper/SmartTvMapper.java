package com.examen.demo.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.examen.demo.DTO.SmartTvDTO;
import com.examen.demo.Entities.SmartTv;



@Mapper(componentModel = "spring")
public interface SmartTvMapper {
	
	SmartTvMapper INSTANCE = Mappers.getMapper(SmartTvMapper.class);

    SmartTvDTO smartTvToSmartTvDTO (SmartTv smartTv);

    SmartTv smartTvDTOToSmartTv (SmartTvDTO smartTvDTO);

}
