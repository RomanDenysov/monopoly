package com.sokima.monopoly.util.dice;

import lombok.Getter;

import java.util.Random;

@Getter
public class Dice {

    /**
     * dice value between 1 and 6
     */
    private final Integer diceValue;

    public Dice() {
        // generate random value after create obj
        this.diceValue = new Random().nextInt(6) + 1;
    }
}
