package com.pairprogammering.project.blackjack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameLogic gameLogic = new GameLogic();
        gameLogic.startGame();
        gameLogic.playerHit();

    }
}
