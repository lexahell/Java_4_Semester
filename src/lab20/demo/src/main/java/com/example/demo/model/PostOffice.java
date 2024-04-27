package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@Entity
@Table(name = "post_offices")
public class    PostOffice {
    @Id
    @SequenceGenerator(name = "post_offices_seq", sequenceName = "post_offices_sequence", allocationSize = 1)
    @GeneratedValue(generator = "post_offices_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Setter
    @Column(name = "name")
    private String name;

    @Setter
    @Column(name = "city_name")
    private String cityName;

    @Setter
    @JsonIgnoreProperties("postOffice")
    @OneToMany(mappedBy = "postOffice")
    private List<Departure> departures;

    public PostOffice() {}

    public PostOffice(String name, String cityName) {
        this.name = name;
        this.cityName = cityName;
    }
}
