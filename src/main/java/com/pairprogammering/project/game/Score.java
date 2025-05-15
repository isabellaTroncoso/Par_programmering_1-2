package com.pairprogammering.project.game;

import com.pairprogammering.project.deckcards.Card;

import java.util.List;

public interface Score {

    int calculateScore(List<Card> hand, int score);
}
