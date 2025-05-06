package com.pairprogammering.project.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        List<Card> playerHand = new ArrayList<>();
        List<Card> dealerHand = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            playerHand.add(deck.drawCard());
            dealerHand.add(deck.drawCard());
        }
        System.out.println("Players hand: ");
        for (Card card : playerHand) {
            System.out.println(card);
        }

        System.out.println("Dealers hand: ");
        for (Card card : dealerHand) {
            System.out.println(card);
        }
    }

    public void playerHit(Scanner scanner) {
        String choice;

        System.out.println("Do you want to hit or stand?");
        choice = scanner.nextLine();
        if (choice.equals("hit")){
            Card newCard = deck.drawCard();
            player.addCard(newCard);
            System.out.println("You drew: " + newCard);

        } else if (choice.equals("stand")) {
            System.out.println("You chose to stand.");
        } else {
            System.out.println("Invalid choice. Please choose 'hit' or 'stand'.");
        }

    }

    public void dealerTurn(List<Card>dealersHand, Deck deck) {
        while (calculateScore (dealersHand) < 17) {
            Card newCard = deck.drawCard();
            dealersHand.add(newCard);
            System.out.println("Dealer drew: " + newCard);
        }
    }

    public int calculateScore(List<Card> hand) {
        int score = 0;
        int aceCount = 0;

        for (Card card : hand) {
            String value = card.getValue();

            if (value.equals("Ace")) {
                score += 11;
                aceCount++;
            } else if (value.equals("King") || value.equals("Queen") || value.equals("Jack")) {
                score += 10;
            } else {
                score += Integer.parseInt(value);
            }
        }

        // Justera om vi har för hög poäng och ess som kan bli 1 istället
        while (score > 21 && aceCount > 0) {
            score -= 10; // Ändra en Ace från 11 till 1
            aceCount--;
        }

        return score;
    }



}
