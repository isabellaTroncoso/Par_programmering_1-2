import com.pairprogammering.project.score.BlackjackScoring;
import com.pairprogammering.project.deckcards.Card;
import com.pairprogammering.project.game.GameLogic;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameLogicTest {
    @Test
    void calculateScore_ShouldTreatAceAs11Or1() {
        BlackjackScoring scoring = new BlackjackScoring();
        List<Card> hand = Arrays.asList(
                new Card("♠", "Ace"),
                new Card("♥", "9"),
                new Card("♣", "5")
        );

        int total = scoring.calculateScore(hand, 0);

        assertEquals(15, total);
    }

    @Test
    void calculateScore_ShouldReturnCorrectTotalForHandWithNoAces() {
        BlackjackScoring scoring = new BlackjackScoring();
        List<Card> hand = Arrays.asList(
                new Card("Hearts", "2"),
                new Card("Hearts", "3")
        );

        int total = scoring.calculateScore(hand, 0);
        assertEquals(5, total);
    }

    @Test
    void calculateScore_ShouldHandleFaceCardsCorrectly() {
        BlackjackScoring scoring = new BlackjackScoring();
        List<Card> hand = Arrays.asList(
                new Card("Spades", "King"),
                new Card("Diamonds", "Queen")
        );

        int total = scoring.calculateScore(hand, 0);

        assertEquals(20, total);
    }

    @Test
    void determineWinner_ShouldDeclarePlayerAsWinner() {


        Card card1 = new Card("♠", "Queen");
        Card card2 = new Card("♥", "10");

        Card card3 = new Card("♠", "9");
        Card card4 = new Card("♦", "9");

        GameLogic.playerHand = new ArrayList<>(Arrays.asList(card1, card2));
        GameLogic.dealerHand = new ArrayList<>(Arrays.asList(card3, card4));

        GameLogic.player.setHand(GameLogic.playerHand);
        GameLogic.dealer.setHand(GameLogic.dealerHand);

        String winner = GameLogic.determineWinner(GameLogic.player, GameLogic.dealer);

        assertEquals("Player wins!", winner);
    }

    @Test
    void showScoreOrStatusFromEveryCardDraw_countingPoints(){
        BlackjackScoring scoring = new BlackjackScoring();

        List<Card> hand = new ArrayList<>();
        hand.add(new Card("♠", "10"));
        hand.add(new Card("♥", "9"));
        System.out.println("Current hand: " + scoring.calculateScore(hand,0));
        assertEquals(19, scoring.calculateScore(hand,0));
    }
}





