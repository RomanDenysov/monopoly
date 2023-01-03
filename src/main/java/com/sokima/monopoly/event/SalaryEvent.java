package com.sokima.monopoly.event;

import com.sokima.monopoly.dto.player.Businessman;

public class SalaryEvent implements Event{

    /**
     * pay a salary after a round
     *
     * @param player the {@link Businessman}
     */
    @Override
    public void onEvent(Businessman player) {

    }

    @Override
    public void printMessage() {

    }
}
