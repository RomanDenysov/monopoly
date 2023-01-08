package com.sokima.monopoly.event;

import com.sokima.monopoly.event.exception.EventException;
import com.sokima.monopoly.cell.business.BusinessCell;
import com.sokima.monopoly.player.Businessman;
import com.sokima.monopoly.util.CellGeneratorUtil;
import com.sokima.monopoly.util.PlayerGeneratorUtil;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RentEventTest {

    private static final Logger log = LoggerFactory.getLogger(RentEventTest.class);

    @Autowired
    @Qualifier("rentEvent")
    private Event rentEvent;

    @Test
    void testOnRentWhenOwnerIsBank() {
        BusinessCell businessCell = CellGeneratorUtil.generateBusinessCellBank();
        Businessman businessman = PlayerGeneratorUtil.generateEmptyBusinessman();

        try {
            rentEvent.onEvent(businessman, businessCell);
            fail();
        } catch (EventException e) {
            log.info("Event Exception was caught.. Method works properly.");
        }
    }

    @Test
    void testOnRentWhenOwnerIsPlayer() {
        BusinessCell businessCell = CellGeneratorUtil.generateBusinessCellPlayer();
        Businessman businessman = PlayerGeneratorUtil.generateBusinessmanOwner();

        try {
            rentEvent.onEvent(businessman, businessCell);
            fail();
        } catch (EventException e) {
            log.info("Event Exception was caught.. Method works properly.");
        }
    }

    @Test
    void testOnRentWhenRentIsTaken() {
        Long rent = 1000L;
        Long balance = 1000L;

        BusinessCell businessCell = CellGeneratorUtil.generateBusinessCellPlayer(rent);
        Businessman businessman = PlayerGeneratorUtil.generateBusinessman(balance);

        Long ownerBalanceBeforeRent = businessCell.getOwner().getBalance();
        Long playerBalanceBeforeRent = businessman.getBalance();

        try {
            rentEvent.onEvent(businessman, businessCell);
        } catch (EventException e) {
            log.error("Event Exception was thrown.. Method doesn't work properly.");
            fail();
        }

        Long ownerBalanceAfterRent = businessCell.getOwner().getBalance();
        Long playerBalanceAfterRent = businessman.getBalance();

        assertNotEquals(playerBalanceBeforeRent, playerBalanceAfterRent);
        assertNotEquals(ownerBalanceBeforeRent, ownerBalanceAfterRent);

        assertEquals(playerBalanceBeforeRent - rent, playerBalanceAfterRent);
        assertEquals(ownerBalanceBeforeRent + rent, ownerBalanceAfterRent);
    }

    @Test
    void testOnRentWhenPlayerLoses() {
        Long rent = 1000L;
        Long balance = 900L;

        BusinessCell businessCell = CellGeneratorUtil.generateBusinessCellPlayer(rent);
        Businessman businessman = PlayerGeneratorUtil.generateBusinessman(balance);

        Long ownerBalanceBeforeRent = businessCell.getOwner().getBalance();

        try {
            rentEvent.onEvent(businessman, businessCell);
            fail();
        } catch (EventException e) {
            log.info("Event Exception was thrown.. Method works properly.");
        }

        Long ownerBalanceAfterRent = businessCell.getOwner().getBalance();
        assertEquals(ownerBalanceBeforeRent, ownerBalanceAfterRent);
    }
}
