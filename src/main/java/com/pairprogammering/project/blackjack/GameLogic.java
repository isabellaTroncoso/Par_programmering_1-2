package com.pairprogammering.project.blackjack;

public class GameLogic {
    private Deck deck;
    private Player player;
    private Player dealer;

    public GameLogic() {
        this.deck = new Deck();
        this.player = new Player("Player", 0);
        this.dealer = new Player("Dealer", 0);
    }

    public void startGame() {
        deck.shuffle();
        // Additional game logic goes here
    }

    public void playerHit() {
        Card card = deck.drawCard();
    }

    public void dealerHit() {
        Card card = deck.drawCard();

    }


}
