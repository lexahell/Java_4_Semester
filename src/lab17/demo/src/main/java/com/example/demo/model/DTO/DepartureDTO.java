package com.example.demo.model.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.util.Date;

@Getter
public class DepartureDTO {
    private String type;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date departureDate;

    private long postOfficeId;

    public DepartureDTO(String type, Date departureDate) {
        this.type = type;
        this.departureDate = departureDate;
    }
}
