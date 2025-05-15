package com.pairprogammering.project.deckcards;

import com.pairprogammering.project.game.Player;
import com.pairprogammering.project.game.UserInterface;
import com.pairprogammering.project.blackjackgame.BlackjackCalculate;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    public ArrayList<Card> cards;
    ArrayList<Card> discardPile;
    final UserInterface ui = new UserInterface();
    private Player dealer;
    private Player player;
    private BlackjackCalculate scoring;


    public Deck(Player player, Player dealer, BlackjackCalculate scoring) {
        this.cards = new ArrayList<>();
        this.discardPile = new ArrayList<>();
        this.dealer = dealer;
        this.player = player;
        this.scoring = scoring;

        String [] suit = {"♣", "♦", "♥", "♠"};
        String [] value = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (String suits : suit) {
            for (String values : value) {
                cards.add(new Card(suits, values));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        } else {
            return null;
        }
    }

    public void dealInitialCards() {
        for (int i = 0; i < 2; i++) {
            player.addCard(drawCard());
            dealer.addCard(drawCard());
        }
    }

    public void showInitialHands() {
        ui.showHand("Player", player.getHand(), scoring.calculateScore(player.getHand(), 0));
        ui.showHand("Dealer", dealer.getHand(), scoring.calculateScore(dealer.getHand(),  0));
    }

    public void resetHands() {
        player.clearHand();
        dealer.clearHand();
    }
}