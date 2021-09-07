package com.example.exception;

public class FileNotFoundException extends Exception {
    public FileNotFoundException() {
        super("Файл не найден!");
    }
}
