package com.example.exception;

public class ArrayEmptyException extends Exception {
    public ArrayEmptyException() {
        super("Массив пустой");
    }
}
