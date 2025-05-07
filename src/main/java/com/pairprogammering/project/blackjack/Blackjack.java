package com.pairprogammering.project.blackjack;

public class Blackjack {
    private GameLogic game;

    public Blackjack() {
        this.game = new GameLogic();
    }

    public void play() {
        game.startGame();
        game.playerHit();
        game.dealerTurn();
        game.determineWinner();
        game.playAgain();
    }
}
