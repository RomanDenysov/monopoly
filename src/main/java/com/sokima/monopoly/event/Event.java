package com.sokima.monopoly.event;

import com.sokima.monopoly.event.exception.EventException;
import com.sokima.monopoly.cell.Cell;
import com.sokima.monopoly.cell.event.EventCell;
import com.sokima.monopoly.player.Businessman;
import org.springframework.stereotype.Component;

@Component
public interface Event {

    /**
     * an event to happen when you land on {@link EventCell}
     *
     * @param player the {@link Businessman}
     */
    void onEvent(Businessman player, Cell onCell) throws EventException;

    /**
     * print message after event
     */
    void printMessage(Businessman player);
}
