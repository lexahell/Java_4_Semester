package com.example.demo.repository;

import com.example.demo.model.PostOffice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostOfficeRepository extends JpaRepository<PostOffice, Long> {
    Optional<PostOffice> findByName(String name);
    List<PostOffice> findAllByCityName(String cityName);
}
