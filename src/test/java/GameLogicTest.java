import com.pairprogammering.project.blackjack.Card;
import com.pairprogammering.project.blackjack.GameLogic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class GameLogicTest {
    @Test
    void calculateScore_ShouldTreatAceAs11Or1() {
        List<Card> hand = Arrays.asList(
                new Card("♠", "Ace"),
                new Card("♥", "9"),
                new Card("♣", "5")
        );

        GameLogic gameLogic = new GameLogic();
        int total = gameLogic.calculateScore(hand);

        Assertions.assertEquals(15, total);
    }

    @Test
    void calculateScore_ShouldReturnCorrectTotalForHandWithNoAces() {
        // Arrange – skapa en hand utan ess
        List<Card> hand = Arrays.asList(
                new Card("Hearts", "2"),
                new Card("Hearts", "3")
        );

        GameLogic gameLogic = new GameLogic();

        // Act
        int total = gameLogic.calculateScore(hand);

        // Assert
        Assertions.assertEquals(5, total);
    }

    @Test
    void calculateScore_ShouldHandleFaceCardsCorrectly() {
        List<Card> hand = Arrays.asList(
                new Card("Spades", "King"),
                new Card("Diamonds", "Queen")
        );

        GameLogic gameLogic = new GameLogic();
        int total = gameLogic.calculateScore(hand);

        Assertions.assertEquals(20, total);
    }


}
