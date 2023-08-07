package com.examen.demo.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmartTvDTO {

    private Long idSmartTv;
    private String RpiUrl;
    private String webCamUrl;
    private boolean notify;
    private List<ReviewSmartTvDTO> reviews;

}
