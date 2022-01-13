package pl.kognitywistyka.ppa.tictactoe;

/**
 * Created by pwilkin on 13.01.2022.
 */
public class MainState {

    protected GameState currentState;
    protected Statistics statistics;

    public MainState() {
        this.currentState = new GameState();
        this.statistics = new Statistics();
    }

    public GameState getCurrentState() {
        return currentState;
    }

    public Statistics getStatistics() {
        return statistics;
    }
}
