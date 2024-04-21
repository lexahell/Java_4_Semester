package com.example.demo.model.DTO;

public class PostOfficeDTO {
    private String name;
    private String cityName;

    public PostOfficeDTO(String name, String cityName) {
        this.name = name;
        this.cityName = cityName;
    }

    public String getName() {
        return name;
    }

    public String getCityName() {
        return cityName;
    }
}
