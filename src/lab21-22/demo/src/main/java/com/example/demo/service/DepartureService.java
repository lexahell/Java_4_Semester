package com.example.demo.service;

import com.example.demo.model.DTO.DepartureDTO;
import com.example.demo.model.Departure;
import com.example.demo.model.PostOffice;
import com.example.demo.repository.DepartureRepository;
import com.example.demo.repository.PostOfficeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class DepartureService {
    private final DepartureRepository departureRepository;
    private final PostOfficeRepository postOfficeRepository;
    private final EmailService emailService;
    @Transactional
    public boolean addDeparture(DepartureDTO departureDTO) {
        Optional<PostOffice> postOffice = postOfficeRepository.findById(departureDTO.getPostOfficeId());
        if(postOffice.isPresent()){
            if(departureRepository.findByType(departureDTO.getType()).isEmpty()){
                departureRepository.save(new Departure(departureDTO.getType(), departureDTO.getDepartureDate(), postOffice.get()));
                log.info("Departure added {}", departureDTO);
                return true;
            }
        }
        log.info("Departure addition failed {}", departureDTO);
        emailService.sendEmail("aleksey-grigorev7@mail.ru","Departure added", departureDTO.toString());
        return false;
    }
    @Transactional
    public boolean deleteDeparture(Long id) {
        Optional<Departure> departure = departureRepository.findById(id);
        if(departure.isPresent()){
            departureRepository.delete(departure.get());
            log.info("Departure deleted {}", departure.get());
            return true;
        }
        log.info("Departure deletion failed {}", id);
        return false;
    }
    @Transactional
    public List<Departure> getDepartures() {
        log.info("Finding all departures");
        return departureRepository.findAll();
    }
    @Transactional
    public Departure getDepartureByType(String type) {
        log.info("Finding departure by type {}", type);
        return departureRepository.findByType(type).orElse(null);
    }
    @Transactional
    public List<Departure> getDeparturesByDepartureDate(Date departureDate) {
        log.info("Finding games by departure date {}", departureDate);
        return departureRepository.findAllByDepartureDate(departureDate);
    }
}
