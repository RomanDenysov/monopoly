package com.sokima.monopoly.dto.deck.company;

import com.sokima.monopoly.dto.deck.Cell;
import com.sokima.monopoly.event.RentEvent;
import com.sokima.monopoly.dto.player.Player;

public abstract class BusinessCell extends Cell {

    /**
     * price to buy a business cell
     */
    private Long price;

    /**
     * rent to pay after owning
     */
    private Long rent;

    /**
     * current owner of business cell
     */
    private Player owner;

    /**
     * rent event to execute
     */
    private RentEvent event;

    /**
     * @return the type of {@link BusinessCell} cell
     */
    public abstract String getType();
}
