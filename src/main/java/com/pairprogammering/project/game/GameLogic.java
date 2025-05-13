package com.pairprogammering.project.game;

import com.pairprogammering.project.Player;
import com.pairprogammering.project.deckcards.Card;

import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    public Player player;
    public Player dealer;
    public static ArrayList<Card> playerHand;
    public static ArrayList<Card> dealerHand;


    public GameLogic() {
        this.player = new Player("Player", 0);
        this.dealer = new Player("Dealer", 0);
        this.playerHand = new ArrayList<>();
        this.dealerHand = new ArrayList<>();
    }

    public static int calculateScore(List<Card> hand) {
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

        while (score > 21 && aceCount > 0) {
            score -= 10;
            aceCount--;
        }

        return score;
    }

    public static String determineWinner(Player player, Player dealer) {
        int playerTotal = calculateScore(player.getHand());
        int dealerTotal = calculateScore(dealer.getHand());

        if (playerTotal > dealerTotal) {
            return "♣♦♥♠ Player wins! ♥♠♣♦";
        } else if (dealerTotal > playerTotal) {
            return "Dealer wins!";
        } else {
            return "It's a tie!";
        }
    }
}