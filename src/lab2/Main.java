package lab2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Human> humans = Arrays.asList(
                new Human(25, "Анна", "Некрасова", LocalDate.of(1996, 5, 15), 65),
                new Human(30, "Борис", "Петров", LocalDate.of(1991, 8, 20), 70),
                new Human(40, "Роман", "Белов", LocalDate.of(1981, 3, 10), 80),
                new Human(35, "Кирилл", "Иванов", LocalDate.of(1986, 12, 5), 75)
        );

        System.out.println("Исходный список людей:");
        humans.forEach(System.out::println);

        // Сортировка по второй букве имени
        List<Human> sortedByNameSecondLetter = humans.stream()
                .sorted(Comparator.comparingInt(h -> h.getFirstName().charAt(1)))
                .toList();
        System.out.println("\nСписок после сортировки по второй букве имени:");
        sortedByNameSecondLetter.forEach(System.out::println);

        // Фильтрация по весу кратно 10
        List<Human> weightDivisibleByTen = humans.stream()
                .filter(h -> h.getWeight() % 10 == 0)
                .toList();
        System.out.println("\nСписок после фильтрации по весу кратному 10:");
        weightDivisibleByTen.forEach(System.out::println);

        // Сортировка по произведению веса на возраст
        List<Human> sortedByWeightTimesAge = humans.stream()
                .sorted(Comparator.comparingInt(h -> h.getWeight() * h.getAge()))
                .toList();
        System.out.println("\nСписок после сортировки по произведению веса на возраст:");
        sortedByWeightTimesAge.forEach(System.out::println);

        // Произведение всех весов
        int totalWeight = humans.stream()
                .map(Human::getWeight)
                .reduce(1, (a, b) -> a * b);
        System.out.println("\nПроизведение всех весов: " + totalWeight);
    }
}

