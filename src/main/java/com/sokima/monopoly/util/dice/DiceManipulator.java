package com.sokima.monopoly.util.dice;

import com.sokima.monopoly.model.dice.Dice;

import java.util.ArrayList;
import java.util.List;

/**
 * Util class for simulating roll a dice
 */
public final class DiceManipulator {

    private DiceManipulator() {

    }

    /**
     * generate list of dices with random value between 1 and 6
     *
     * @param countOfDice the needed count dice to generate
     * @return list of dices with random value
     */
    public static List<Dice> nextDice(int countOfDice) {
        List<Dice> dices = new ArrayList<>();

        for (int i = 0; i < countOfDice; i++) {
            dices.add(new Dice());
        }
        return dices;
    }
}
