package com.pairprogammering.project.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameLogic {
    private Deck deck;
    public Player player;
    public Player dealer;
    public ArrayList<Card> playerHand;
    public ArrayList<Card> dealerHand;


    public GameLogic() {
        this.deck = new Deck();
        this.player = new Player("Player", 0);
        this.dealer = new Player("Dealer", 0);
    }

    public void startGame() {
        deck.shuffle();

        playerHand = new ArrayList<>();
        dealerHand = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            playerHand.add(deck.drawCard());
            dealerHand.add(deck.drawCard());
        }

        player.setHand(playerHand);
        dealer.setHand(dealerHand);

        System.out.println("Players hand: ");
        for (Card card : playerHand) {
            System.out.println(card);
        }

        System.out.println("Dealers hand: ");
        for (Card card : dealerHand) {
            System.out.println(card);
        }
    }

    public void playerHit() {
        Scanner scanner = new Scanner(System.in);
        String choice;
        boolean playerBust = false;
        boolean dealerBust = false;

        while (true) {
            System.out.print("Hit or stand? ");
            choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("hit")) {
                // Give the player another card
                player.addCard(deck.drawCard());
                System.out.println("Your hand: " + player.getHand());

                // Check for bust
                int playerTotal = calculateScore(playerHand);
                if (playerTotal > 21) {
                    System.out.println("Bust! You lose.");
                    playerBust = true;
                    break;
                }
            } else if (choice.equalsIgnoreCase("stand")) {
                break;
            } else {
                System.out.println("Invalid choice. Please enter 'hit' or 'stand'.");
            }
        }


        /*System.out.println("Do you want to hit or stand?");
        choice = scanner.nextLine();
        if (choice.equals("hit")){
            Card newCard = deck.drawCard();
            player.addCard(newCard);
            System.out.println("You drew: " + newCard);

        } else if (choice.equals("stand")) {
            System.out.println("You chose to stand.");
        } else {
            System.out.println("Invalid choice. Please choose 'hit' or 'stand'.");
        }*/

    }

    public void dealerTurn(List<Card>dealersHand, Deck deck) {
        while (calculateScore (dealersHand) < 17) {
            Card newCard = deck.drawCard();
            dealersHand.add(newCard);
            System.out.println("Dealer drew: " + newCard);
        }
        if (calculateScore(dealersHand) > 21) {
            System.out.println("Dealer busts! You win!");
        } else {
            System.out.println("Dealer's hand: " + dealersHand);
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


    public String determineWinner(Player player, Player dealer) {
        int playerTotal = calculateScore(playerHand);
        int dealerTotal = calculateScore(dealerHand);

        if (playerTotal > dealerTotal) {
            return "Player wins!";
        } else if (dealerTotal > playerTotal) {
            return "Dealer wins.";
        } else {
            return "It's a tie!";
        }
    }


    public void playAgain() {
        boolean playAgain = false;
        String choice = "";

        while (playAgain) {
            System.out.println("Would like to play again? Y/N");

            if (choice.equals("y")) {
                playAgain = true;

            } else if (choice.equals("n")) {
                System.out.println("See you next time!");
                break;
            }
        }
    }
}
