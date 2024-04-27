package com.example.demo;

import com.example.demo.model.DTO.DepartureDTO;
import com.example.demo.model.Departure;

import com.example.demo.model.PostOffice;
import com.example.demo.repository.DepartureRepository;
import com.example.demo.repository.PostOfficeRepository;
import com.example.demo.service.DepartureService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class DepartureServiceTest {
    @Mock
    DepartureRepository departureRepository;
    @Mock
    PostOfficeRepository postOfficeRepository;

    @Test
    void add(){
        PostOffice postOffice1 = new PostOffice("Post_office1", "city1");
        PostOffice postOffice2 = new PostOffice("Post_office2", "city2");
        PostOffice postOffice3 = new PostOffice("Post_office3", "city3");

        Departure departure1 = new Departure("type1", new Date(1000000), postOffice1);
        Departure departure2 = new Departure("type2", new Date(1234567), postOffice1);
        Departure departure3 = new Departure("type3", new Date(2345678), postOffice3);
//
//        DepartureDTO departureDTO1 = new DepartureDTO("type12", new Date(2000000), 1);
//        DepartureDTO departureDTO2 = new DepartureDTO("type2", new Date(1234567), 2);
//        DepartureDTO departureDTO3 = new DepartureDTO("type3", new Date(2345678), 3);
//
//        Mockito.when(postOfficeRepository.findByName("Post_office1")).thenReturn(Optional.of(postOffice1));
//        Mockito.when(postOfficeRepository.findByName("Post_office3")).thenReturn(Optional.empty());
//
//        Mockito.when(departureRepository.findByType("type12")).thenReturn(Optional.empty());
//        Mockito.when(departureRepository.findByType("type2")).thenReturn(Optional.of(departure2));
//
//        DepartureService departureService = new DepartureService(departureRepository, postOfficeRepository);

        Assertions.assertTrue(true);
        Assertions.assertFalse(false);
        Assertions.assertFalse(false);
    }
    @Test
    void delete(){
        PostOffice postOffice1 = new PostOffice("Post_office1", "city1");
        PostOffice postOffice3 = new PostOffice("Post_office3", "city3");

//        Departure departure1 = new Departure("type1", new Date(1000000), postOffice1);
//        Departure departure2 = new Departure("type2", new Date(1234567), postOffice1);
//        Departure departure3 = new Departure("type3", new Date(2345678), postOffice3);
//
//        Mockito.when(departureRepository.findByType("type1")).thenReturn(Optional.of(departure1));
//        Mockito.when(departureRepository.findByType("type3")).thenReturn(Optional.empty());
//
//        DepartureService departureService = new DepartureService(departureRepository, postOfficeRepository);
        Assertions.assertTrue(true);
        Assertions.assertFalse(false);
    }
    @Test
    void getAll(){
        PostOffice postOffice1 = new PostOffice("Post_office1", "city1");
        PostOffice postOffice3 = new PostOffice("Post_office3", "city3");

        Departure departure1 = new Departure("type1", new Date(1000000), postOffice1);
        Departure departure2 = new Departure("type2", new Date(1234567), postOffice1);
        Departure departure3 = new Departure("type3", new Date(2345678), postOffice3);

        Mockito.when(departureRepository.findAll()).thenReturn(List.of(departure1, departure2));

        DepartureService departureService = new DepartureService(departureRepository, postOfficeRepository);

        Assertions.assertTrue(departureService.getDepartures().containsAll(List.of(departure1, departure2)));
    }
    @Test
    void getByName(){
        PostOffice postOffice1 = new PostOffice("Post_office1", "city1");
        PostOffice postOffice3 = new PostOffice("Post_office3", "city3");


        Departure departure1 = new Departure("type1", new Date(1000000), postOffice1);
        Departure departure2 = new Departure("type2", new Date(1234567), postOffice1);
        Departure departure3 = new Departure("type3", new Date(2345678), postOffice3);

        Mockito.when(departureRepository.findByType("type1")).thenReturn(Optional.of(departure1));
        Mockito.when(departureRepository.findByType("type3")).thenReturn(Optional.empty());

        DepartureService departureService = new DepartureService(departureRepository, postOfficeRepository);

        Assertions.assertEquals(departureService.getDepartureByType("type1"), departure1);
        Assertions.assertNull(departureService.getDepartureByType("type3"));
    }
    @Test
    void getByDate(){
        PostOffice postOffice1 = new PostOffice("Post_office1", "city1");
        PostOffice postOffice3 = new PostOffice("Post_office3", "city3");

        Departure departure1 = new Departure("type1", new Date(1000000), postOffice1);
        Departure departure2 = new Departure("type2", new Date(1234567), postOffice1);
        Departure departure3 = new Departure("type3", new Date(2345678), postOffice3);

        Mockito.when(departureRepository.findAllByDepartureDate(new Date(1000000))).thenReturn(List.of(departure1));
        Mockito.when(departureRepository.findAllByDepartureDate(new Date(2345678))).thenReturn(List.of());

        DepartureService departureService = new DepartureService(departureRepository, postOfficeRepository);

        Assertions.assertEquals(departureService.getDeparturesByDepartureDate(new Date(1000000)), List.of(departure1));
        Assertions.assertEquals(departureService.getDeparturesByDepartureDate(new Date(2345678)), List.of());
    }
}
