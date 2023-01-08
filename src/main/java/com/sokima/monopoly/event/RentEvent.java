package com.sokima.monopoly.event;

import com.sokima.monopoly.event.exception.LoseGameException;
import com.sokima.monopoly.event.exception.RentException;
import com.sokima.monopoly.cell.Cell;
import com.sokima.monopoly.cell.business.BusinessCell;
import com.sokima.monopoly.player.Bank;
import com.sokima.monopoly.player.Businessman;
import com.sokima.monopoly.player.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RentEvent implements Event {

    private static final Logger log = LoggerFactory.getLogger(RentEvent.class);

    /**
     * if player is owner of cell he doesn't pay
     * if owner is bank, player doesn't pay
     * in other situation pay rent
     *
     * @param player the {@link Businessman}
     * @param onCell the {@link Cell} where player is staying
     * @throws RentException occurs when are not possible to take rent from player
     * @throws LoseGameException occurs when player balance is negative
     */
    @Override
    public void onEvent(Businessman player, Cell onCell) throws RentException, LoseGameException {
        BusinessCell onBusinessCell = (BusinessCell) onCell;
        Player owner = onBusinessCell.getOwner();

        if (owner instanceof Bank) {
            throw new RentException("Owner is a bank.. Fail to take a rent.");
        }

        if (owner.equals(player)) {
            throw new RentException("Player is an owner.. Fail to take a rent.");
        }

        Long rent = onBusinessCell.getRent();

        player.withdrawBalance(rent);
        Long balanceAfterRent = player.getBalance();

        if (balanceAfterRent < 0) {
            throw new LoseGameException();
        }

        ((Businessman) owner).topUpBalance(rent);
        printMessage(player);
    }

    @Override
    public void printMessage(Businessman player) {
        log.info("{} is paid a rent. Game is continuing..", player.getName());
    }
}
