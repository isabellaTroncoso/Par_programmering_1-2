import com.pairprogammering.project.blackjackgame.BlackjackCalculate;
import com.pairprogammering.project.deckcards.Card;
import com.pairprogammering.project.blackjackgame.BlackjackScore;
import static org.junit.jupiter.api.Assertions.*;

import com.pairprogammering.project.game.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlackjackScoreTest {
    @Test
    void determineWinner_ShouldDeclarePlayerAsWinner() {

        Card card1 = new Card("♠", "Queen");
        Card card2 = new Card("♥", "10");

        Card card3 = new Card("♠", "9");
        Card card4 = new Card("♦", "9");

        Player player = new Player("Player",0);
        Player dealer = new Player("Dealer",0);

        BlackjackScore blackjackScore = new BlackjackScore(player,dealer);

        blackjackScore.playerHand = new ArrayList<>(Arrays.asList(card1, card2));
        blackjackScore.dealerHand = new ArrayList<>(Arrays.asList(card3, card4));

        player.setHand(BlackjackScore.playerHand);
        dealer.setHand(BlackjackScore.dealerHand);

        String winner = BlackjackScore.determineWinner(BlackjackScore.player, BlackjackScore.dealer);

        assertEquals("♣♦♥♠ Player wins! ♥♠♣♦", winner);
    }

    @Test
    void showScoreOrStatusFromEveryCardDraw_countingPoints(){
        BlackjackCalculate scoring = new BlackjackCalculate();

        List<Card> hand = new ArrayList<>();
        hand.add(new Card("♠", "10"));
        hand.add(new Card("♥", "9"));
        System.out.println("Current hand: " + scoring.calculateScore(hand,0));
        assertEquals(19, scoring.calculateScore(hand,0));
    }
}





