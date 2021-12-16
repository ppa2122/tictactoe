package pl.kognitywistyka.ppa.tictactoe;

/**
 * Created by pwilkin on 16.12.2021.
 */
public class StatisticsController implements GameStateHolder{
    private GameState gameState;

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public GameState getGameState() {
        return gameState;
    }
}
