package com.example.springlearn.controllers;

import com.example.springlearn.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/person")
public class PersonController {
    final PersonService personService;

    public PersonController(PersonService PersonService) {
        this.personService = PersonService;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(Model model) {
        model.addAttribute("person", personService.show());
        return "people/show";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(@RequestParam(defaultValue = "0 ") int id, Model model) {
        try {
            model.addAttribute("person", personService.index(id));
            return "people/show";
        } catch (Exception exception) {
            model.addAttribute("exception", "Произошла ошибка " + exception.getMessage());
            return "errors";
        }
    }

}
