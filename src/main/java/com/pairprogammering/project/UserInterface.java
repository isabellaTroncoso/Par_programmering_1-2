package com.pairprogammering.project;

import com.pairprogammering.project.deckcards.Card;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner = new Scanner(System.in);

    public String askPlayerChoice() {
        System.out.print("Hit or stand? ");
        return scanner.nextLine();
    }

    public void showHand(String name, List<Card> hand, int score) {
        System.out.println();
        System.out.println(name + "'s hand: ");
        hand.forEach(System.out::println);
        System.out.println("Total points: " + score);
        System.out.println();
    }

    public boolean askPlayAgain() {
        System.out.print("Would you like to play again? (y/n): ");
        return scanner.nextLine().equalsIgnoreCase("y");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void welcomeMessage() {
        System.out.println("""
        ♣♦♥♠ Welcome to Blackjack! ♥♠♣♦

        Rules:
        The goal is to get 21 or as close as possible — without going over.
        The dealer must draw cards until reaching at least 17.
        Don’t forget: an Ace is worth 11, but counts as 1 if 11 would make you bust.
        Best hand wins!

        Good luck!
        Press enter when you're ready..
        """);

        scanner.nextLine();
    }
}
