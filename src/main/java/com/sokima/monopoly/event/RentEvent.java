package com.sokima.monopoly.event;

import com.sokima.monopoly.event.exception.RentException;
import com.sokima.monopoly.model.cell.Cell;
import com.sokima.monopoly.model.cell.business.BusinessCell;
import com.sokima.monopoly.model.player.Bank;
import com.sokima.monopoly.model.player.Businessman;
import com.sokima.monopoly.model.player.Player;

public class RentEvent implements Event {
    /**
     * if player is owner of cell he doesn't pay
     * if owner is bank, player doesn't pay
     * in other situation pay rent
     *
     * @param player the {@link Businessman}
     * @param onCell the {@link Cell} where player is staying
     */
    @Override
    public void onEvent(Businessman player, Cell onCell) throws RentException {
        BusinessCell onBusinessCell = (BusinessCell) onCell;
        Player owner = onBusinessCell.getOwner();

        if(owner instanceof Bank) {
            throw new RentException("Owner is a bank.. Fail to take a rent.");
        }

        if(owner.equals(player)) {
            throw new RentException("Player is an owner.. Fail to take a rent.");
        }

        Long rent = onBusinessCell.getRent();
        Long currentBalance = player.getBalance();
        long newBalance = currentBalance - rent;

        if(newBalance < 0) {
            // TODO make custom exception LoseGameException
            throw new RuntimeException("Balance is zero");
        }

        player.setBalance(newBalance);
        printMessage(player);
    }

    @Override
    public void printMessage(Businessman player) {
        System.out.printf("%s is paid a rent. Game is continuing..", player.getName());
    }
}
