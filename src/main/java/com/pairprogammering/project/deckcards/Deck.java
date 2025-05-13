package com.pairprogammering.project.deckcards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    public ArrayList<Card> cards;
    ArrayList<Card> discardPile;

    Random random = new Random();

    public Deck() {
        cards = new ArrayList<>();
        discardPile = new ArrayList<>();

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

    public void discardCard(Card card) {
        if (card != null) {
            discardPile.add(card);
            System.out.println("Card discarded " + card);
        }
    }








}
