package pl.kognitywistyka.ppa.tictactoe;

/**
 * Created by pwilkin on 16.12.2021.
 */
public interface GameStateHolder {
    public void setGameState(GameState gameState);
    public GameState getGameState();
}
