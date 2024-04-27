package com.example.demo.service;

import com.example.demo.model.DTO.PostOfficeDTO;
import com.example.demo.model.PostOffice;
import com.example.demo.repository.PostOfficeRepository;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class PostOfficeService {
    private final PostOfficeRepository postOfficeRepository;

    @Transactional
    public boolean addPostOffice(PostOfficeDTO postOfficeDTO) {
        PostOffice postOffice = new PostOffice(postOfficeDTO.getName(), postOfficeDTO.getCityName());
        if (postOfficeRepository.findByName(postOffice.getName()).isEmpty()){
            postOfficeRepository.save(postOffice);
            log.info("Post Office added {}", postOfficeDTO);
            return true;
        }
        log.info("Post Office addition filed {}", postOfficeDTO);
        return false;
    }

    @Transactional
    public boolean deletePostOffice(String name) {
        Optional<PostOffice> postOffice = postOfficeRepository.findByName(name);
        if(postOffice.isPresent()){
            postOfficeRepository.delete(postOffice.get());
            log.info("Post Oficce deleted {}", postOffice.get());
            return true;
        }
        log.info("Post Office deletion failed {}", name);
        return false;
    }
    @Transactional
    public List<PostOffice> getPostOffices() {
        log.info("Finding all post offices");
        return postOfficeRepository.findAll();
    }
    @Transactional
    public PostOffice getPostOfficeByName(String name) {
        log.info("Finding Post Offices by name {}", name);
        return postOfficeRepository.findByName(name).orElse(null);
    }
    @Transactional
    public List<PostOffice> getPostOfficeByCityName(String cityName) {
        log.info("Finding Post Offices by city name {}", cityName);
        return postOfficeRepository.findAllByCityName(cityName);
    }
}
