package br.com.mrb.restspringbootandjavamauro.converter;

public class NumberConverter {
    public static Double convertToDouble(String strNumber) {
        if(strNumber==null) return 0D;
        var number = strNumber.replaceAll(",",".");
        if(isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    public static boolean isNumeric(String strNumber) {
        if(strNumber==null) return false;
        var number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
