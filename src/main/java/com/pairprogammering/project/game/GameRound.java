package com.pairprogammering.project.game;

import com.pairprogammering.project.blackjackgame.BlackjackCalculate;
import com.pairprogammering.project.blackjackgame.BlackjackScore;
import com.pairprogammering.project.deckcards.Deck;
import com.pairprogammering.project.blackjackgame.BlackjackTurns;

public class GameRound {

    private final Player player = new Player("Player", 0);
    private final Player dealer = new Player("Dealer", 0);
    private final BlackjackCalculate scoring = new BlackjackCalculate();
    private final Deck deck = new Deck(player, dealer, scoring);
    private final BlackjackTurns turn = new BlackjackTurns(deck, dealer, scoring);
    private final UserInterface ui = new UserInterface();
    private final BlackjackScore score = new BlackjackScore(player,dealer);

    public void play() {
        boolean playAgain;
        ui.welcomeMessage();
        do {
            playRound();
            playAgain = ui.askPlayAgain();
        } while (playAgain);

        ui.showMessage("♣♦♥♠ Thanks for playing! ♥♠♣♦");
    }

    public void playRound() {
        deck.resetHands();
        deck.shuffle();

        deck.dealInitialCards();
        deck.showInitialHands();


        if (score.isBlackjackTie()) {
            return;
        }
        if (!turn.playerTurn(player, "Player")) {
            if (!turn.dealerTurn()) {
                ui.showMessage(score.determineWinner(player,dealer));
            }
        }
    }
}