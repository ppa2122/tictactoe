package pl.kognitywistyka.ppa.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.kognitywistyka.ppa.tictactoe.GameState.GameStage;
import pl.kognitywistyka.ppa.tictactoe.GameState.TicOrTac;

/**
 * Created by pwilkin on 27.01.2022.
 */
public class GameStateTest {

    private static GameState theState;

    @BeforeAll
    public static void setup() {
        theState = new GameState();
    }

    public static class GameStateTester {
        private final GameState gs;

        public GameStateTester() {
            this.gs = new GameState();
        }

        public GameStateTester makeFirstMove() {
            gs.makeAMove(0, 0);
            return this;
        }

        public GameStateTester makeSecondMove() {
            gs.makeAMove(0, 1);
            return this;
        }

        public GameState gs() {
            return gs;
        }
    }

    @Test
    public void testEmptyState() {
        GameState gs = new GameState();
        Assertions.assertEquals(gs.getStage(), GameStage.START);
    }

    private GameState createEmpty() {
        return new GameState();
    }

    private GameState makeFirstMove(GameState gs) {
        gs.makeAMove(0, 0);
        return gs;
    }

    private GameState makeSecondMove(GameState gs) {
        gs.makeAMove(0, 1);
        return gs;
    }

    @Test
    public void testFieldAfterMove() {
        GameState gs = makeFirstMove(createEmpty());
        Assertions.assertEquals(gs.getField(0, 0), TicOrTac.CROSS);
    }

    @Test
    public void testFieldAfterTwoMoves() {
        GameState gs = makeSecondMove(makeFirstMove(createEmpty()));
        Assertions.assertEquals(gs.getField(0, 1), TicOrTac.CIRCLE);
    }

    @Test
    public void testFieldAfterTwoMovesAlt() {
        GameState gs = new GameStateTester().makeFirstMove().makeSecondMove().gs();
        Assertions.assertEquals(gs.getField(0, 1), TicOrTac.CIRCLE);
    }

    @Test
    public void testStaticAfterMove() {
        theState.reset();
        theState.makeAMove(0, 0);
        Assertions.assertEquals(theState.getField(0, 0), TicOrTac.CROSS);
    }

    @Test
    public void testStaticAfterSecondMove() {
        theState.reset();
        theState.makeAMove(0, 0);
        theState.makeAMove(0, 1);
        Assertions.assertEquals(theState.getField(0, 1), TicOrTac.CIRCLE);
    }

    @Test
    public void testCrossWin() {
        GameState gs = createEmpty();
        gs.makeAMove(1, 1);
        gs.makeAMove(0, 1);
        gs.makeAMove(1, 0);
        gs.makeAMove(0, 0);
        gs.makeAMove(1, 2);
        Assertions.assertEquals(gs.getWinner(), TicOrTac.CROSS);
    }

}
