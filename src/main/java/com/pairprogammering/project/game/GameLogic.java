package com.pairprogammering.project.game;

import com.pairprogammering.project.score.BlackjackScoring;
import com.pairprogammering.project.deckcards.Card;

import java.util.ArrayList;

public class GameLogic {
    public static Player player = new Player("Player", 0);
    public static Player dealer = new Player("Dealer", 0);
    public static ArrayList<Card> playerHand  = new ArrayList<>();
    public static ArrayList<Card> dealerHand = new ArrayList<>();
    static BlackjackScoring scoring = new BlackjackScoring();


    public static String determineWinner(Player player, Player dealer) {
        int playerTotal = scoring.calculateScore(player.getHand(), 0);
        int dealerTotal = scoring.calculateScore(dealer.getHand(), 0);

        if (playerTotal > dealerTotal) {
            return "♣♦♥♠ Player wins! ♥♠♣♦";
        } else if (dealerTotal > playerTotal) {
            return "Dealer wins!";
        } else {
            return "It's a tie!";
        }
    }
}