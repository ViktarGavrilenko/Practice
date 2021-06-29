package com.example.exception;

public class StrNullException extends Exception {
    public StrNullException() {
        super("Строка не инициализирована");
    }
}
