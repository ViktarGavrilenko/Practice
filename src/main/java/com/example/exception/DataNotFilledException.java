package com.example.exception;

public class DataNotFilledException extends Exception {
    public DataNotFilledException() {
        super("Таблица без данных, заполните таблицу!");
    }
}
