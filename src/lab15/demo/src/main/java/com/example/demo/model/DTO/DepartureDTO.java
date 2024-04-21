package com.example.demo.model.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class DepartureDTO {
    private String type;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date departureDate;

    public DepartureDTO(String type, Date departureDate) {
        this.type = type;
        this.departureDate = departureDate;
    }

    public String getType() {
        return type;
    }

    public Date getDepartureDate() {
        return departureDate;
    }
}
