package com.sokima.monopoly.event.exception;

/**
 * Rent Exception occurs when failing take a rent
 */
public class RentException extends EventException {

    public RentException(String message) {
        super(message);
    }
}
