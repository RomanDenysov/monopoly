package com.sokima.monopoly.player;

public class Businessman extends Player {

    public void topUpBalance(Long topUp) {
        balance += topUp;
    }

    public void withdrawBalance(Long withdraw) {
        balance -= withdraw;
    }
}
