package com.sokima.monopoly.util;

import com.sokima.monopoly.player.Bank;
import com.sokima.monopoly.player.Businessman;

public final class PlayerGeneratorUtil {

    private PlayerGeneratorUtil() {
    }

    public static Businessman generateEmptyBusinessman() {
        return new Businessman();
    }

    public static Bank generateEmptyBank() {
        return new Bank();
    }

    public static Businessman generateBusinessmanOwner() {
        Businessman businessman = new Businessman();
        businessman.setName(KindOfPlayer.BUSINESSMAN_OWNER.name());
        return businessman;
    }

    public static Businessman generateBusinessman() {
        Businessman businessman = new Businessman();
        businessman.setName(KindOfPlayer.BUSINESSMAN.name());
        return businessman;
    }

    public static Businessman generateBusinessman(Long balance) {
        Businessman businessman = generateBusinessman();
        businessman.setBalance(balance);
        return businessman;
    }

    private enum KindOfPlayer {
        BUSINESSMAN_OWNER,
        BUSINESSMAN,

        BANK_OWNER,
        BANK
    }
}
