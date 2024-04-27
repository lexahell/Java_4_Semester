package com.example.demo.model.DTO;

import lombok.Getter;
import lombok.ToString;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

@Getter
@ToString
public class DepartureDTO {
    private String type;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date departureDate;

    private long postOfficeId;

    public DepartureDTO(String type, Date departureDate, long postOfficeId) {
        this.type = type;
        this.departureDate = departureDate;
        this.postOfficeId = postOfficeId;
    }
}
