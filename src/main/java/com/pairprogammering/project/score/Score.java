package com.pairprogammering.project.score;

import com.pairprogammering.project.deckcards.Card;

import java.util.List;

public interface Score {

    int calculateScore(List<Card> hand, int score);
}
