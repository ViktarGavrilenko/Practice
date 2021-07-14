package com.example.exception;

public class ArrayListNotNullException extends Exception {
    public ArrayListNotNullException() {
        super("ArrayList пустой");
    }
}
