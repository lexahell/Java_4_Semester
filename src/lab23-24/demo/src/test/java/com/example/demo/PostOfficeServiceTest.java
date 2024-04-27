package com.example.demo;

import com.example.demo.model.DTO.PostOfficeDTO;
import com.example.demo.model.PostOffice;
import com.example.demo.repository.PostOfficeRepository;
import com.example.demo.service.PostOfficeService;
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
public class PostOfficeServiceTest {

    @Mock
    PostOfficeRepository postOfficeRepository;

    @Test
    void add(){
        PostOffice postOffice1 = new PostOffice("Post_office1", "city1");
        PostOffice postOffice2 = new PostOffice("Post_office2", "city2");
        PostOffice postOffice3 = new PostOffice("Post_office3", "city3");

        PostOfficeDTO postOfficeDTO1 = new PostOfficeDTO("Post_office1", "city1");
        PostOfficeDTO postOfficeDTO2 = new PostOfficeDTO("Post_office2", "city2");
        PostOfficeDTO postOfficeDTO3 = new PostOfficeDTO("Post_office3", "city3");



        Mockito.when(postOfficeRepository.findByName("Post_office1")).thenReturn(Optional.of(postOffice1));
        Mockito.when(postOfficeRepository.findByName("Post_office3")).thenReturn(Optional.empty());

        PostOfficeService postOfficeService = new PostOfficeService(postOfficeRepository);

        Assertions.assertFalse(postOfficeService.addPostOffice(postOfficeDTO1));
        Assertions.assertTrue(postOfficeService.addPostOffice(postOfficeDTO3));
    }
    @Test
    void delete(){
        PostOffice postOffice1 = new PostOffice("Post_office1", "city1");
        PostOffice postOffice2 = new PostOffice("Post_office2", "city2");
        PostOffice postOffice3 = new PostOffice("Post_office3", "city3");

        Mockito.when(postOfficeRepository.findByName("Post_office1")).thenReturn(Optional.of(postOffice1));
        Mockito.when(postOfficeRepository.findByName("Post_office3")).thenReturn(Optional.empty());

        PostOfficeService postOfficeService = new PostOfficeService(postOfficeRepository);

        Assertions.assertTrue(postOfficeService.deletePostOffice(postOffice1.getName()));
        Assertions.assertFalse(postOfficeService.deletePostOffice(postOffice3.getName()));
    }
    @Test
    void getAll(){
        PostOffice postOffice1 = new PostOffice("Post_office1", "city1");
        PostOffice postOffice2 = new PostOffice("Post_office2", "city2");
        PostOffice postOffice3 = new PostOffice("Post_office3", "city3");

        Mockito.when(postOfficeRepository.findAll()).thenReturn(List.of(postOffice1, postOffice2));

        PostOfficeService postOfficeService = new PostOfficeService(postOfficeRepository);
        Assertions.assertTrue(postOfficeService.getPostOffices().containsAll(List.of(postOffice1, postOffice2)));
    }
    @Test
    void getByName(){
        PostOffice postOffice1 = new PostOffice("Post_office1", "city1");
        PostOffice postOffice2 = new PostOffice("Post_office2", "city2");
        PostOffice postOffice3 = new PostOffice("Post_office3", "city3");

        Mockito.when(postOfficeRepository.findByName("Post_office1")).thenReturn(Optional.of(postOffice1));
        Mockito.when(postOfficeRepository.findByName("Post_office3")).thenReturn(Optional.empty());

        PostOfficeService postOfficeService = new PostOfficeService(postOfficeRepository);

        Assertions.assertEquals(postOfficeService.getPostOfficeByName("Post_office1"), postOffice1);
        Assertions.assertNull(postOfficeService.getPostOfficeByName("Post_office3"));
    }
    @Test
    void getByCityName(){
        PostOffice postOffice1 = new PostOffice("Post_office1", "city1");
        PostOffice postOffice2 = new PostOffice("Post_office2", "city2");
        PostOffice postOffice3 = new PostOffice("Post_office3", "city3");

        Mockito.when(postOfficeRepository.findAllByCityName("city1")).thenReturn(List.of(postOffice1));
        Mockito.when(postOfficeRepository.findAllByCityName("city3")).thenReturn(List.of());

        PostOfficeService postOfficeService = new PostOfficeService(postOfficeRepository);

        Assertions.assertEquals(postOfficeService.getPostOfficeByCityName("city1"), List.of(postOffice1));
        Assertions.assertEquals(postOfficeService.getPostOfficeByCityName("city3"), List.of());
    }
}
