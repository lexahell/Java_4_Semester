package com.example.demo.controller;

import com.example.demo.model.DTO.DepartureDTO;
import com.example.demo.model.Departure;
import com.example.demo.service.DepartureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departure")
public class DepartureController {
    private final DepartureService departureService;

    public DepartureController(DepartureService departureService) {
        this.departureService = departureService;
    }

    @PostMapping("/add")
    public String addDeparture(@RequestBody DepartureDTO departure) {
        if (departureService.addDeparture(departure)) {
            return "Departure added";
        } else {
            return "Departure cannot be added";
        }
    }

    // Пример удаления
    //POST http://localhost:8080/departure/delete?id=12345
    @PostMapping("/delete")
    public String deleteDeparture(@RequestBody Long id) {
        if (departureService.deleteDeparture(id)) {
            return "Departure deleted";
        } else {
            return "Departure cannot be deleted";
        }
    }

    @GetMapping("/show")
    public List<Departure> showDepartures() {
        return departureService.getDepartures();
    }
}
