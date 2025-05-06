package com.pairprogammering.project.blackjack;

public class Player {
    private String name;
    private int handValue = 0;

    public Player(String name, int handValue) {
        this.name = name;
        this.handValue = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHandValue() {
        return handValue;
    }

    public void setHandValue(int handValue) {
        this.handValue = handValue;
    }
    public void addCard(Card card) {

    }
}
