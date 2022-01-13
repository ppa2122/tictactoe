package pl.kognitywistyka.ppa.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by pwilkin on 16.12.2021.
 */
public class StatisticsController implements MainStateHolder {
    @FXML
    private Label statsPanel;

    private MainState mainState;

    public void setMainState(MainState mainState) {
        this.mainState = mainState;
        Statistics stats = mainState.getStatistics();
        StringBuilder sb = new StringBuilder();
        sb.append("X wins: " + stats.getCrossWins()).append("\n");
        sb.append("O wins: " + stats.getCircleWins()).append("\n");
        sb.append("Draws: " + stats.getDraws());
        statsPanel.setText(sb.toString());
    }

    public MainState getMainState() {
        return mainState;
    }
}
