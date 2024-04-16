package demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/departures")
public class DepartureController {
    private ArrayList<Departure> repo;

    public DepartureController() {
        repo = new ArrayList<>();
    }

    @GetMapping("/")
    public List<Departure> getDepartures() {
        return repo;
    }

    @PostMapping("/")
    public Departure createDeparture(@RequestBody Departure newDeparture) {
        repo.add(newDeparture);
        Departure departure = repo.get(repo.size() - 1);
        departure.id = repo.size() - 1;
        return departure;
    }
        /*
    Пример тела запроса
    {
        "type": "Air",
        "departureDate": "2024-04-16"
    }
    */

    @DeleteMapping("/{id}")
    public Departure deleteDeparture(@PathVariable Long id) {
        try {
            Departure departure = repo.get(id.intValue());
            repo.remove(id.intValue());
            return departure;
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}

