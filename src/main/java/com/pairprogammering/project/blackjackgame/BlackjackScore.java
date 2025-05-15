package com.pairprogammering.project.blackjackgame;

import com.pairprogammering.project.deckcards.Card;
import com.pairprogammering.project.game.Player;
import com.pairprogammering.project.game.UserInterface;

import java.util.ArrayList;

public class BlackjackScore {
    public static ArrayList<Card> playerHand;
    public static ArrayList<Card> dealerHand;
    public static Player player;
    public static Player dealer;
    static BlackjackCalculate scoring = new BlackjackCalculate();
    private final UserInterface ui = new UserInterface();

    public BlackjackScore(Player player, Player dealer) {
        this.player = player;
        this.dealer = dealer;

    }

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

    public boolean isBlackjackTie() {
        int pScore = scoring.calculateScore(player.getHand(), 0);
        int dScore = scoring.calculateScore(dealer.getHand(), 0);

        if (pScore == 21 && dScore == 21) {
            ui.showMessage("Both have Blackjack! It's a tie!");
            return true;
        }
        return false;
    }
}