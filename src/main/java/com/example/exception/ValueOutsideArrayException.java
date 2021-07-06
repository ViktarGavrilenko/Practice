package com.example.exception;

public class ValueOutsideArrayException extends Throwable {
    public ValueOutsideArrayException(){
        super("Значение выходит за пределы массива");
    }
}
