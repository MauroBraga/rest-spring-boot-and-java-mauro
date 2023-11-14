package br.com.mrb.restspringbootandjavamauro.controller;

import br.com.mrb.restspringbootandjavamauro.converter.NumberConverter;
import br.com.mrb.restspringbootandjavamauro.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static br.com.mrb.restspringbootandjavamauro.converter.NumberConverter.convertToDouble;
import static br.com.mrb.restspringbootandjavamauro.converter.NumberConverter.isNumeric;
import br.com.mrb.restspringbootandjavamauro.math.SimpleMath;


@RestController
public class MathController {

    private SimpleMath math = new SimpleMath();
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
            method=RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a value numeric");
        }
        return math.sum(convertToDouble(numberOne) , convertToDouble(numberTwo));
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
        return math.subtraction(convertToDouble(numberOne) , convertToDouble(numberTwo));
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
        return math.multiplication(convertToDouble(numberOne) , convertToDouble(numberTwo));
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
        return math.division(convertToDouble(numberOne) , convertToDouble(numberTwo));
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
        return math.mean(convertToDouble(numberOne),  convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/squareRoot/{number}",
            method=RequestMethod.GET)
    public Double squareRoot(
            @PathVariable(value = "number") String number
    ) throws Exception{

        if(!isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.squareRoot(convertToDouble(number));
    }

}
