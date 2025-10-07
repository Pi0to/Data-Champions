package com.datachampions.Data.Champions.exceptions;

public class UnavaibleModeException extends RuntimeException {

    public UnavaibleModeException() {
        super("The game mode is not supported for statistics.");
    }

    public UnavaibleModeException(String message) {
        super(message);
    }
}
