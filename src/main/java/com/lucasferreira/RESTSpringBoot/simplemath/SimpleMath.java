package com.lucasferreira.RESTSpringBoot.simplemath;

import com.lucasferreira.RESTSpringBoot.request.converters.NumberConverter;

public class SimpleMath {

    public static Double sum(String numberOne, String numberTwo) {
        return NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo);
    }

    public static Double subtraction(String numberOne, String numberTwo) {
        return NumberConverter.convertToDouble(numberOne) - NumberConverter.convertToDouble(numberTwo);
    }

    public static Double multiplication(String numberOne, String numberTwo) {
        return NumberConverter.convertToDouble(numberOne) * NumberConverter.convertToDouble(numberTwo);
    }

    public static Double division(String numberOne, String numberTwo) {
        if (NumberConverter.convertToDouble(numberTwo) == 0) {
            throw new ArithmeticException("Cannot divide by 0");
        }
        return NumberConverter.convertToDouble(numberOne) / NumberConverter.convertToDouble(numberTwo);
    }

    public static Double mean(String numberOne, String numberTwo) {
        return (NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo)) / 2;
    }

    public static Double sqrtRoot(String number) {
        return Math.sqrt(NumberConverter.convertToDouble(number));
    }




}
