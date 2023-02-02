package ru.nikita.springcourse.FirstRESTApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nikita.springcourse.FirstRESTApp.models.Person;
import ru.nikita.springcourse.FirstRESTApp.services.PeopleService;
import ru.nikita.springcourse.FirstRESTApp.util.PersonErrorResponse;
import ru.nikita.springcourse.FirstRESTApp.util.PersonNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping()
    public List<Person> getPeople() {
        return peopleService.findAll();     //Jackson конвертирует эти объекты в JSON
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") int id) {
        return peopleService.findOne(id);  // Jackson конвертирует в JSON
    }

    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handleException(PersonNotFoundException e) {
        PersonErrorResponse response = new PersonErrorResponse(
                "Person with this id wasn't found!",
                System.currentTimeMillis()
        );

        // В HTTP ответе тело ответа (response) статус в заголовке
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);   //NOT_FOUND - 404 - статус
    }
}
