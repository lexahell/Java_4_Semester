package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "departures")
public class Departure {
    @Id
    @SequenceGenerator(name = "departures_seq", sequenceName = "departures_sequence", allocationSize = 1)
    @GeneratedValue(generator = "departures_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "departuredate")
    private Date departureDate;

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Departure() {}

    public Departure(String type, Date departureDate) {
        this.type = type;
        this.departureDate = departureDate;
    }
}
