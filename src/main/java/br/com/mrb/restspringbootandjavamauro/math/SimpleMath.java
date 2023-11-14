package br.com.mrb.restspringbootandjavamauro.math;

public class SimpleMath {

    public Double sum(Double numberOne, Double numberTwo) {
        return numberOne +  numberTwo;
    }

    public Double subtraction(Double numberOne, Double numberTwo) {
        return numberOne -  numberTwo;
    }

    public Double multiplication(Double numberOne, Double numberTwo) {
        return numberOne * numberTwo;
    }

    public static Double division(Double numberOne, Double numberTwo) {
        return numberOne / numberTwo;
    }

    public static Double mean(Double numberOne, Double numberTwo) {
        return (numberOne +  numberTwo) / 2;
    }

    public Double squareRoot(Double number) {
        return Math.sqrt(number);
    }

}
