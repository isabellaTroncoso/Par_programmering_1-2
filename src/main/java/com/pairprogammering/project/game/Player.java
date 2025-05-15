package com.pairprogammering.project.game;

import com.pairprogammering.project.deckcards.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;

    public Player(String name, int score) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public List<Card> getHand() {
        return hand;
    }

    public String getName() {
        return name;
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
