package com.example.exception;

public class ValueOutsideArrayException extends Exception {
    public ValueOutsideArrayException() {
        super("Значение выходит за пределы массива");
    }
}
