package com.example.exception;

public class ArrayListNotNullException extends Throwable {
    public ArrayListNotNullException() {
        super("ArrayList пустой");
    }
}
