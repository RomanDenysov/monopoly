package com.sokima.monopoly.event.exception;

/**
 * Generic Event Exception
 */
public abstract class EventException extends Exception {

    protected EventException() {
        super();
    }

    protected EventException(String message) {
        super(message);
    }
}
