package pl.kognitywistyka.ppa.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TicTacToeController {

    private GameState gameState;

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    @FXML
    private Button topleft;
    @FXML
    private Button topmid;
    @FXML
    private Button topright;
    @FXML
    private Button midleft;
    @FXML
    private Button midmid;
    @FXML
    private Button midright;
    @FXML
    private Button bottomleft;
    @FXML
    private Button bottommid;
    @FXML
    private Button bottomright;

    public void fieldClicked(ActionEvent event) {
        Button button = (Button) event.getSource();
        String txt = button.getText();
        if ("X".equals(txt)) {
            button.setText("O");
        } else if ("O".equals(txt)) {
            button.setText("X");
        } else {
            throw new IllegalStateException("Found invalid value: " + txt);
        }
    }
    
}