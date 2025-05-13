package com.pairprogammering.project;

public class GameRound {
    private GameLogic game;

    public GameRound() {
        this.game = new GameLogic();
    }

    public void play() {
//        game.startGame();
//        game.playerHit();
//        game.dealerTurn();
//        game.determineWinner();
        game.playAgain();
    }
}
