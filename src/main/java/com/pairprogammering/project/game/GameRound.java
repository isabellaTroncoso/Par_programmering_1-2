package com.pairprogammering.project.game;

import com.pairprogammering.project.Player;
import com.pairprogammering.project.UserInterface;
import com.pairprogammering.project.deckcards.Card;
import com.pairprogammering.project.deckcards.Deck;

import java.util.ArrayList;
import java.util.Scanner;

import static com.pairprogammering.project.game.GameLogic.calculateScore;
import static com.pairprogammering.project.game.GameLogic.determineWinner;

public class GameRound {
    private GameLogic game;
    private Deck deck = new Deck();
    public Player player;
    public Player dealer;
    public ArrayList<Card> playerHand;
    public ArrayList<Card> dealerHand;
    private final UserInterface ui = new UserInterface();


    public GameRound() {
        this.game = new GameLogic();
        this.player = new Player("Player", 0);
        this.dealer = new Player("Dealer", 0);
        this.deck = new Deck();
        this.playerHand = new ArrayList<>();
        this.dealerHand = new ArrayList<>();
    }

    public void play() {
        boolean playAgain;
        do {
            ui.welcomeMessage();
            playRound();
            playAgain = ui.askPlayAgain();
        } while (playAgain);

        ui.showMessage("Thanks for playing!");
    }

    private void playRound() {
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
        ui.showHand("Player", player.getHand(), GameLogic.calculateScore(player.getHand()));
        ui.showHand("Dealer", dealer.getHand(), GameLogic.calculateScore(dealer.getHand()));
    }

    private boolean isBlackjackOrBust() {
        int pScore = GameLogic.calculateScore(player.getHand());
        int dScore = GameLogic.calculateScore(dealer.getHand());

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
                int total = GameLogic.calculateScore(player.getHand());
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
        while (GameLogic.calculateScore(dealer.getHand()) < 17) {
            Card card = deck.drawCard();
            dealer.addCard(card);
            ui.showMessage("Dealer drew: " + card);
        }

        int total = GameLogic.calculateScore(dealer.getHand());
        ui.showHand("Dealer", dealer.getHand(), total);

        if (total > 21) {
            ui.showMessage("Dealer busts! You win!");
            return true;
        }

        return false;
    }

}
