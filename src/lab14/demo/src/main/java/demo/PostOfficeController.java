package demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/postOffices")
public class PostOfficeController {
    private ArrayList<PostOffice> repo;

    public PostOfficeController() {
        repo = new ArrayList<>();
    }

    @GetMapping("/")
    public List<PostOffice> getPostOffices() {
        return repo;
    }

    @PostMapping("/")
    public PostOffice createPostOffice(@RequestBody PostOffice newPostOffice) {
        repo.add(newPostOffice);
        PostOffice postOffice = repo.get(repo.size() - 1);
        postOffice.id = repo.size() - 1;
        return postOffice;
    }
    /*
    Пример тела запроса
    {
        "name": "Central Post Office",
        "cityName": "New York"
    }
    */

    @DeleteMapping("/{id}")
    public PostOffice deletePostOffice(@PathVariable Long id) {
        try {
            PostOffice postOffice = repo.get(id.intValue());
            repo.remove(id.intValue());
            return postOffice;
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
