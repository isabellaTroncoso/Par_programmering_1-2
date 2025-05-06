package com.pairprogammering.project.blackjack;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        Card card = deck.drawCard();
        System.out.println("The card is shuffled and we have drawn the card: " + card);

        deck.discardCard(card);
    }
}
