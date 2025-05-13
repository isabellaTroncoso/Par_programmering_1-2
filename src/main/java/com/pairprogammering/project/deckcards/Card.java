package com.pairprogammering.project.deckcards;

public class Card {
    String suit;
    String value;

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }
}