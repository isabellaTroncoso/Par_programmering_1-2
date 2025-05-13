import com.pairprogammering.project.deckcards.Card;
import com.pairprogammering.project.deckcards.Deck;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {

    @Test
    public void testDeckCreation() {
        Deck deck = new Deck();
        assertNotNull(deck);
        assertEquals(52, deck.cards.size());
    }

    @Test
    public void testShuffle() {
        Deck deck = new Deck();
        ArrayList<Card> originalOrder = new ArrayList<>(deck.cards);
        deck.shuffle();
        assertNotEquals(originalOrder, deck.cards);
    }

    @Test
    public void testDrawCard() {
        Deck deck = new Deck();
        deck.shuffle();
        Card drawnCard = deck.drawCard();
        assertNotNull(drawnCard);
        assertEquals(51, deck.cards.size());
    }
}
