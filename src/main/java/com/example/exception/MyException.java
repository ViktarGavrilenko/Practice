package com.example.exception;

public class MyException extends Exception {
    public String toString() {
        return "Ошибка обработана классом " + super.toString();
    }
}
