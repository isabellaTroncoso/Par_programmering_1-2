import com.pairprogammering.project.blackjackgame.BlackjackCalculate;
import com.pairprogammering.project.deckcards.Card;
import com.pairprogammering.project.deckcards.Deck;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.pairprogammering.project.blackjackgame.BlackjackScore.dealer;
import static com.pairprogammering.project.blackjackgame.BlackjackScore.player;
import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {

    @Test
    public void testDeckCreation() {
        Deck deck = new Deck(player, dealer, new BlackjackCalculate());
        assertNotNull(deck);
        assertEquals(52, deck.cards.size());
    }

    @Test
    public void testShuffle() {
        Deck deck = new Deck(player, dealer, new BlackjackCalculate());
        ArrayList<Card> originalOrder = new ArrayList<>(deck.cards);
        deck.shuffle();
        assertNotEquals(originalOrder, deck.cards);
    }

    @Test
    public void testDrawCard() {
        Deck deck = new Deck(player, dealer, new BlackjackCalculate());
        deck.shuffle();
        Card drawnCard = deck.drawCard();
        assertNotNull(drawnCard);
        assertEquals(51, deck.cards.size());
    }
}
