package com.example.exception;

public class ArrayNullException extends Exception{
    public ArrayNullException() {
        super("Массив не инициализирован");
    }
}
