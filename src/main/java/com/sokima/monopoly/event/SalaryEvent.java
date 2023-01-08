package com.sokima.monopoly.event;

import com.sokima.monopoly.cell.Cell;
import com.sokima.monopoly.player.Businessman;

public class SalaryEvent implements Event {

    /**
     * pay a salary after a round
     *
     * @param player the {@link Businessman}
     */
    @Override
    public void onEvent(Businessman player, Cell onCell) {

    }

    @Override
    public void printMessage(Businessman player) {

    }
}
