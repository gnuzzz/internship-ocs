package ru.digitalleague.ocs.internship.lesson15;

public class CatalogException extends Exception {

    public CatalogException(String message) {
        super(message);
    }

    public CatalogException(String message, Throwable cause) {
        super(message, cause);
    }

    public CatalogException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
