package com.sokima.monopoly.cell.business;

import com.sokima.monopoly.cell.Cell;
import com.sokima.monopoly.event.Event;
import com.sokima.monopoly.event.RentEvent;
import com.sokima.monopoly.player.Player;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
    private Event rentEvent;

    /**
     * identifier of businesses
     */
    private String businessName;

    /**
     * path to an icon
     */
    private String urlToImage;

    /**
     * @return the type of {@link BusinessCell} cell
     */
    public abstract String getType();
}
