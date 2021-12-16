package pl.kognitywistyka.ppa.tictactoe;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import pl.kognitywistyka.ppa.tictactoe.GameState.GameStage;
import pl.kognitywistyka.ppa.tictactoe.GameState.TicOrTac;

public class TicTacToeController implements Initializable, GameStateHolder {

    private GameState gameState;
    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
        restartGame(null);
    }

    @FXML
    private Label gameInfo;
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

    private Map<Button, int[]> mapToCoordinates;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mapToCoordinates = new HashMap<>();
        mapToCoordinates.put(topleft, new int[] { 0, 0 });
        mapToCoordinates.put(topmid, new int[] { 0, 1 });
        mapToCoordinates.put(topright, new int[] { 0, 2 });
        mapToCoordinates.put(midleft, new int[] { 1, 0 });
        mapToCoordinates.put(midmid, new int[] { 1, 1 });
        mapToCoordinates.put(midright, new int[] { 1, 2 });
        mapToCoordinates.put(bottomleft, new int[] { 2, 0 });
        mapToCoordinates.put(bottommid, new int[] { 2, 1 });
        mapToCoordinates.put(bottomright, new int[] { 2, 2 });
    }

    private void updateGameInfo() {
        GameStage stage = gameState.getStage();
        String label = "";
        switch (stage) {
            case START:
                label = "Click to start the game as X";
                break;
            case PLAYING:
                TicOrTac who = gameState.getWhoseTurn();
                label = who.getRep() + " to move";
                break;
            case CROSS_WINS:
                label = "Game over, X wins!";
                break;
            case CIRCLE_WINS:
                label = "Game over, O wins!";
                break;
            case TIE:
                label = "Game over, it is a tie!";
                break;
        }
        gameInfo.setText(label);
    }

    public void fieldClicked(ActionEvent event) {
        Button button = (Button) event.getSource();
        int[] coords = mapToCoordinates.get(button);
        if (gameState.isLegalMove(coords[0], coords[1])) {
            gameState.makeAMove(coords[0], coords[1]);
            button.setText(gameState.getField(coords[0], coords[1]).getRep());
        }
        updateGameInfo();
    }

    public void restartGame(ActionEvent actionEvent) {
        gameState.reset();
        clearButtons();
        updateGameInfo();
    }

    private void clearButtons() {
        for (Button button : mapToCoordinates.keySet()) {
            button.setText("");
        }
    }
}