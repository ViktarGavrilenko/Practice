package com.example.exception;

public class StrEmptyException extends Exception {
    public StrEmptyException() {
        super("Пустая строка");
    }

}
