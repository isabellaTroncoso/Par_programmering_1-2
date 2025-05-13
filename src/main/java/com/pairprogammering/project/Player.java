package com.pairprogammering.project;

import com.pairprogammering.project.deckcards.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int handValue = 0;
    private List<Card> hand;

    public Player(String name, int handValue) {
        this.name = name;
        this.handValue = 0;
        this.hand = new ArrayList<>();
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public void clearHand() {
        this.hand.clear();
    }
}
