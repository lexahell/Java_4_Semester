package com.example.demo.model.DTO;

import lombok.Getter;

@Getter
public class PostOfficeDTO {
    private String name;
    private String cityName;

    public PostOfficeDTO(String name, String cityName) {
        this.name = name;
        this.cityName = cityName;
    }
}
