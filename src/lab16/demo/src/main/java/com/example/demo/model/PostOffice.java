package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "post_offices")
public class    PostOffice {
    @Id
    @SequenceGenerator(name = "post_offices_seq", sequenceName = "post_offices_sequence", allocationSize = 1)
    @GeneratedValue(generator = "post_offices_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "city_name")
    private String cityName;

    @JsonIgnoreProperties("postOffice")
    @OneToMany(mappedBy = "postOffice")
    private List<Departure> departures;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCityName() {
        return cityName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public PostOffice() {}

    public PostOffice(String name, String cityName) {
        this.name = name;
        this.cityName = cityName;
    }
}
