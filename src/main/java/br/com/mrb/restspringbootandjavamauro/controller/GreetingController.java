package br.com.mrb.restspringbootandjavamauro.controller;

import br.com.mrb.restspringbootandjavamauro.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";

    @RequestMapping("/greeting")
    public Greeting greeting(
            @RequestParam(value = "name", defaultValue = "World")
            String name) {

        return new Greeting(0, String.format(template, name));
    }
}
