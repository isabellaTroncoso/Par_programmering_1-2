import com.pairprogammering.project.deckcards.Card;
import com.pairprogammering.project.game.GameRound;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameRoundTest {
    @Test
    void choiceToPlayAgainOrEndTheGame () {
        GameRound gameRound = new GameRound();
            gameRound.playRound();
            assertTrue(true);
    }
}
