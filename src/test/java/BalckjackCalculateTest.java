import com.pairprogammering.project.blackjackgame.BlackjackCalculate;
import com.pairprogammering.project.deckcards.Card;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BalckjackCalculateTest {

    @Test
    void calculateScore_ShouldTreatAceAs11Or1() {
        BlackjackCalculate scoring = new BlackjackCalculate();
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
        BlackjackCalculate scoring = new BlackjackCalculate();
        List<Card> hand = Arrays.asList(
                new Card("Hearts", "2"),
                new Card("Hearts", "3")
        );

        int total = scoring.calculateScore(hand, 0);
        assertEquals(5, total);
    }

    @Test
    void calculateScore_ShouldHandleFaceCardsCorrectly() {
        BlackjackCalculate scoring = new BlackjackCalculate();
        List<Card> hand = Arrays.asList(
                new Card("Spades", "King"),
                new Card("Diamonds", "Queen")
        );

        int total = scoring.calculateScore(hand, 0);

        assertEquals(20, total);
    }
}
