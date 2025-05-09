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
        System.out.println("Total points: " + calculateScore(player.getHand()));

        System.out.println("Dealers hand: ");
        for (Card card : dealerHand) {
            System.out.println(card);
        }
        System.out.println("Total points: " + calculateScore(dealer.getHand()));
    }

    public boolean playerTurn() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Hit or stand? ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("hit")) {
                playerHit();// lägg till kort

                int playerTotal = calculateScore(player.getHand());


                if (playerTotal > 21) {
                    System.out.println("Bust! You lose.");
                    return true;
                } else if (playerTotal == 21) {
                    System.out.println("You hit 21! Let's see what the dealer gets.");
                    return false;
                }

            } else if (choice.equalsIgnoreCase("stand")) {
                return false;
            } else {
                System.out.println("Invalid choice. Please enter 'hit' or 'stand'.");
            }
        }
    }





    public void playerHit() {
        player.addCard(deck.drawCard());
        System.out.println("Your hand: " + player.getHand() + " Total points: " + calculateScore(player.getHand()));
    }



    public boolean dealerTurn() {
        while (calculateScore(dealerHand) < 17) {
            Card newCard = deck.drawCard();
            dealerHand.add(newCard);
            System.out.println("Dealer drew: " + newCard);

            if (calculateScore(dealerHand) > 21) {
                System.out.println("Dealer busts! You win!");
                return true;
            }
        }

        int dealerTotal = calculateScore(dealerHand);
        System.out.println("Dealer's hand: " + dealerHand + " Total points: " + calculateScore(dealerHand));
        return dealerTotal > 21;
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


    public String determineWinner() {
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

    public void playOneRound() {
        startGame();

        int playerTotal = calculateScore(player.getHand());
        int dealerTotal = calculateScore(dealer.getHand());

        if (playerTotal == 21 && dealerTotal == 21) {
            System.out.println("Both have Blackjack! It's a tie!");
            return;
        } else if (playerTotal == 21) {
            System.out.println("Blackjack! You win!");
            return;
        } else if (dealerTotal == 21) {
            System.out.println("Dealer has Blackjack! You lose.");
            return;
        }

        boolean playerBusted = playerTurn();

        if (!playerBusted) {
            boolean dealerBusted = dealerTurn();
            if (!dealerBusted) {
                System.out.println(determineWinner());
            }
        }
    }



    public void playAgain() {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            playOneRound(); // spela en runda

            System.out.print("Would you like to play again? (y/n): ");
            String choice = scanner.nextLine();
            playAgain = choice.equalsIgnoreCase("y");
        }

        System.out.println("Thanks for playing!");
    }

}
