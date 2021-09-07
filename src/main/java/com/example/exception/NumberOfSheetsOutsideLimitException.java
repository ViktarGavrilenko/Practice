package com.example.exception;

public class NumberOfSheetsOutsideLimitException extends Exception {
    public NumberOfSheetsOutsideLimitException(int numberOfSheets) {
        super("Лист с номером " + numberOfSheets + " отсутствует в вашем xls файле!");
    }
}
