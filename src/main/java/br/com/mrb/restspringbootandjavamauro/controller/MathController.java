package br.com.mrb.restspringbootandjavamauro.controller;

import br.com.mrb.restspringbootandjavamauro.converter.NumberConverter;
import br.com.mrb.restspringbootandjavamauro.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static br.com.mrb.restspringbootandjavamauro.converter.NumberConverter.convertToDouble;
import static br.com.mrb.restspringbootandjavamauro.converter.NumberConverter.isNumeric;


@RestController
public class MathController {

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
            method=RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a value numeric");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }


    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}",
            method=RequestMethod.GET)
    public Double subtraction(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a value numeric");
        }
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}",
            method=RequestMethod.GET)
    public Double multiplication(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a value numeric");
        }
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}",
            method=RequestMethod.GET)
    public Double division(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a value numeric");
        }
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }


    @RequestMapping(value = "/mean/{numberOne}/{numberTwo}",
            method=RequestMethod.GET)
    public Double mean(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a value numeric");
        }
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) /2;
    }

    @RequestMapping(value = "/squareRoot/{number}",
            method=RequestMethod.GET)
    public Double squareRoot(
            @PathVariable(value = "number") String number
    ) throws Exception{

        if(!isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return Math.sqrt(convertToDouble(number));
    }

}
