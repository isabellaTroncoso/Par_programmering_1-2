package com.pairprogammering.project.game;

import com.pairprogammering.project.score.BlackjackScoring;
import com.pairprogammering.project.deckcards.Card;
import com.pairprogammering.project.deckcards.Deck;

public class GameRound {

    private Deck deck = new Deck();
    private Player player = new Player("Player", 0);
    private Player dealer = new Player("Dealer", 0);
    BlackjackScoring scoring = new BlackjackScoring();


    private final UserInterface ui = new UserInterface();

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
        resetHands();
        deck.shuffle();

        dealInitialCards();
        showInitialHands();


        if (isBlackjackOrBust()) {
            return;
        }
        if (!handleTurn(player, "Player")) {
            if (!dealerTurn()) {
                ui.showMessage(GameLogic.determineWinner(player, dealer));
            }
        }
    }

    private void dealInitialCards() {
        for (int i = 0; i < 2; i++) {
            player.addCard(deck.drawCard());
            dealer.addCard(deck.drawCard());
        }
    }

    private void showInitialHands() {
        ui.showHand("Player", player.getHand(), scoring.calculateScore(player.getHand(), 0));
        ui.showHand("Dealer", dealer.getHand(), scoring.calculateScore(dealer.getHand(),  0));
    }

    private boolean isBlackjackOrBust() {
        int pScore = scoring.calculateScore(player.getHand(), 0);
        int dScore = scoring.calculateScore(dealer.getHand(), 0);

        if (pScore == 21 && dScore == 21) {
            ui.showMessage("Both have Blackjack! It's a tie!");
            return true;
        }
        return false;
    }

    public boolean handleTurn(Player player, String name) {
        while (true) {
            String choice = ui.askPlayerChoice();
            if (choice.equalsIgnoreCase("hit")) {
                player.addCard(deck.drawCard());
                int total = scoring.calculateScore(player.getHand(), 0);
                ui.showHand(name, player.getHand(), total);

                if (total > 21) {
                    ui.showMessage(name + " busts!");
                    return true;
                } else if (total == 21) {
                    ui.showMessage(name + " hits 21!");
                    return false;
                }
            } else if (choice.equalsIgnoreCase("stand")) {
                return false;
            } else {
                ui.showMessage("Invalid choice. Please enter 'hit' or 'stand'.");
            }
        }
    }

    private boolean dealerTurn() {
        while (scoring.calculateScore(dealer.getHand(), 0) < 17) {
            Card card = deck.drawCard();
            dealer.addCard(card);
            ui.showMessage("Dealer drew: " + card);
        }

        int total = scoring.calculateScore(dealer.getHand(),0);
        ui.showHand("Dealer", dealer.getHand(), total);

        if (total > 21) {
            ui.showMessage("Dealer busts! ♥♠♣♦ You win! ♣♦♥♠");
            return true;
        }
        return false;
    }

    private void resetHands() {
        player.clearHand();
        dealer.clearHand();
    }
}

// kolla med kristoffer vad han tycker om handleturn metoden
// ändra bort lite metod namn så att det passar med funktionen