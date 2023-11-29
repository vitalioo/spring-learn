package com.example.springlearn.controllers;

import com.example.springlearn.entity.Person;
import com.example.springlearn.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService PersonService) {
        this.personService = PersonService;
    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        return "people/new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute Person person) {
        personService.save(person);
        return "people/successCreatePage";
    }

    @GetMapping()
    public String show(Model model) {
        model.addAttribute("person", personService.findAll());
        return "people/show";
    }

    @GetMapping( "/index")
    public String index(@RequestParam(defaultValue = "0") int id, Model model) {
        try {
            model.addAttribute("person", personService.findOne(id));
            return "people/show";
        } catch (Exception exception) {
            model.addAttribute("exception", "Произошла ошибка " + exception.getMessage());
            return "errors";
        }
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam int id, Model model) {
        personService.delete(id);
        model.addAttribute("person", personService.findAll());
        return "people/show";
    }
}
