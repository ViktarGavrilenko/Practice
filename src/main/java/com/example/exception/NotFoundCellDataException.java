package com.example.exception;

public class NotFoundCellDataException extends Exception {
    public NotFoundCellDataException() {
        super("Требуемые данные в файле не найдены, проверьте файл!");
    }
}
