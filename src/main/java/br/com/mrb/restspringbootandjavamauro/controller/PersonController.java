package br.com.mrb.restspringbootandjavamauro.controller;

import br.com.mrb.restspringbootandjavamauro.exceptions.UnsupportedMathOperationException;
import br.com.mrb.restspringbootandjavamauro.math.SimpleMath;
import br.com.mrb.restspringbootandjavamauro.model.Person;
import br.com.mrb.restspringbootandjavamauro.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static br.com.mrb.restspringbootandjavamauro.converter.NumberConverter.convertToDouble;
import static br.com.mrb.restspringbootandjavamauro.converter.NumberConverter.isNumeric;


@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;

    @RequestMapping(value = "/{id}",
            method=RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable(value = "id") String id) {
        return service.findById(id);
    }

}
