package com.sokima.monopoly.model.cell.event;

import com.sokima.monopoly.model.cell.Cell;
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
