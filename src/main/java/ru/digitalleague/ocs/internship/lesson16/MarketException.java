package ru.digitalleague.ocs.internship.lesson16;

public class MarketException extends Exception {

    public MarketException(String message) {
        super(message);
    }

    public MarketException(String message, Throwable cause) {
        super(message, cause);
    }

    public MarketException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
