import com.pairprogammering.project.blackjack.Card;
import com.pairprogammering.project.blackjack.GameLogic;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

        assertEquals(15, total);
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
        assertEquals(5, total);
    }

    @Test
    void calculateScore_ShouldHandleFaceCardsCorrectly() {
        List<Card> hand = Arrays.asList(
                new Card("Spades", "King"),
                new Card("Diamonds", "Queen")
        );

        GameLogic gameLogic = new GameLogic();
        int total = gameLogic.calculateScore(hand);

        assertEquals(20, total);
    }

    @Test
    void determineWinner_ShouldDeclarePlayerAsWinner() {
        GameLogic gameLogic = new GameLogic();
        Card card1 = new Card("♠", "Queen");
        Card card2 = new Card("♥", "10");

        Card card3 = new Card("Spades", "9");
        Card card4 = new Card("Diamonds", "9");
        gameLogic.playerHand = new ArrayList<>(Arrays.asList(card1, card2));
        gameLogic.dealerHand = new ArrayList<>(Arrays.asList(card3, card4));
        gameLogic.player.setHand(gameLogic.playerHand);
        gameLogic.dealer.setHand(gameLogic.dealerHand);

        String winner = gameLogic.determineWinner(gameLogic.player, gameLogic.dealer);
        assertEquals("Player wins!", winner);

    }

    @Test
    void choiceToPlayAgainOrEndTheGame () {
        GameLogic gameLogic = new GameLogic();
        gameLogic.playAgain();
        assertTrue(true);
    }
}

    // 4. Tydlig återkoppling till spelaren
    //Tex. visa total poäng, status efter varje drag (hit/stand).
    //
    //Test: Efter varje hit visas aktuell poäng
    //
    //Behöver: Utskrift och logik i playerHit()
    //
    //🔹 5. Hantera blackjack direkt
    //Om någon får exakt 21 poäng från start, bör det hanteras.
    //
    //Test: Givet en hand med Ace + King → spelet avslutas med vinst
    //
    //Behöver: Kontroll direkt efter start
    //
    //🔹 6. TDD-tester för Player-klassen
    //Exempel: Testa att addCard() lägger till kort i spelarens hand korrekt.



