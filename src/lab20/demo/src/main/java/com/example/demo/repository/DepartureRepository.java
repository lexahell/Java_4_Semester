package com.example.demo.repository;

import com.example.demo.model.Departure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface DepartureRepository extends JpaRepository<Departure, Long> {
    Optional<Departure> findByType(String type);
    List<Departure> findAllByDepartureDate(Date departureDate);
}
