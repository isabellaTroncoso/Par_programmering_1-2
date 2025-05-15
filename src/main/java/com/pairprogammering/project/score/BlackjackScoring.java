package com.pairprogammering.project.score;

import com.pairprogammering.project.deckcards.Card;

import java.util.List;

public class BlackjackScoring implements Score {
    @Override
    public int calculateScore(List<Card> hand, int score) {
        score = 0;
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
}
