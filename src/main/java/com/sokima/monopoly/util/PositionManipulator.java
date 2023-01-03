package com.sokima.monopoly.util;

import com.sokima.monopoly.model.dice.Dice;

import java.util.List;

/**
 * Util class for calculating next position on the table
 */
public final class PositionManipulator {

    private PositionManipulator() {

    }

    /**
     * calculate next position number using {@link List<Dice>} values
     *
     * @param currentPosition current position on table
     * @param dices the generated dices
     * @param numberOfCells cells count
     * @return next position number
     */
    public static Integer nextPosition(Integer currentPosition, List<Dice> dices, Integer numberOfCells) {
        Integer position = currentPosition;

        for (Dice dice : dices) {
            position += dice.getDiceValue();
        }

        position = position % numberOfCells;
        return position;
    }
}
