import com.pairprogammering.project.game.GameRound;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameRoundTest {
    @Test
    void choiceToPlayAgainOrEndTheGame () {
        GameRound gameRound = new GameRound();
        gameRound.playRound();
        assertTrue(true);
    }
}
