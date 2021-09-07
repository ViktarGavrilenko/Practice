package com.example.exception;

public class ArrayListNullException extends Exception {
    public ArrayListNullException() {
        super("ArrayList не инициализирован");
    }
}
