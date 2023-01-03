package com.sokima.monopoly.dto.deck.event;

import com.sokima.monopoly.dto.deck.Cell;
import com.sokima.monopoly.event.Event;

public abstract class EventCell extends Cell {

    /**
     * message to print
     */
//    @Config(message = "standard message")
    private String eventMessage;

    /**
     * event to happen
     */
    private Event event;
}
