package com.example.demo.controller;

import com.example.demo.model.DTO.PostOfficeDTO;
import com.example.demo.model.PostOffice;
import com.example.demo.service.PostOfficeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postoffice")
public class PostOfficeController {
    private final PostOfficeService postOfficeService;

    public PostOfficeController(PostOfficeService postOfficeService) {
        this.postOfficeService = postOfficeService;
    }

    @PostMapping("/add")
    public String addPostOffice(@RequestBody PostOfficeDTO postOfficeDTO) {
        PostOffice postOffice = new PostOffice(postOfficeDTO.getName(), postOfficeDTO.getCityName());
        if (postOfficeService.addPostOffice(postOffice)) {
            return "Post office added";
        } else {
            return "Post office cannot be added";
        }
    }

    // Пример удаления
    //POST http://localhost:8080/postoffice/delete?id=12345
    @PostMapping("/delete")
    public String deletePostOffice(@RequestBody String name) {
        if (postOfficeService.deletePostOffice(name)) {
            return "Post office deleted";
        } else {
            return "Post office cannot be deleted";
        }
    }

    @GetMapping("/show")
    public List<PostOffice> showPostOffices() {
        return postOfficeService.getPostOffices();
    }
}
