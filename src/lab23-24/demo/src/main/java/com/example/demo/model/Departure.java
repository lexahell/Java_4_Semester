package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
@Entity
@Table(name = "departures")
public class Departure {
    @Id
    @SequenceGenerator(name = "departures_seq", sequenceName = "departures_sequence", allocationSize = 1)
    @GeneratedValue(generator = "departures_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Setter
    @Column(name = "type")
    private String type;

    @Setter
    @Column(name = "departuredate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date departureDate;

    @Setter
    @JsonIgnoreProperties("departures")
    @ManyToOne
    private PostOffice postOffice;

    public Departure() {}

    public Departure(String type, Date departureDate, PostOffice postOffice) {
        this.type = type;
        this.departureDate = departureDate;
        this.postOffice = postOffice;
    }
}
