package com.pairprogammering.project.Card;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Deck {
    ArrayList<Card> cards;
    Random random = new Random();

    public Deck() {
        cards = new ArrayList<>();

        String [] suit = {"Hearts", "Clubs", "Diamonds", "Spades"};
        String [] value = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        for (String suits : suit) {
            for (String values : value) {
                cards.add(new Card(suits, values));
            }
        }
    }

    void shuffle() {
        Collections.shuffle(cards);
    }

    void drawCard(){
     random.nextInt(0,13);
    }

    void discardCard(){
    cards.remove(cards.size()-1);
    }

}
