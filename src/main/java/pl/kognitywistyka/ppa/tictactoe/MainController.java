package pl.kognitywistyka.ppa.tictactoe;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * Created by pwilkin on 16.12.2021.
 */
public class MainController {

    @FXML
    private AnchorPane contents;

    private GameState gameState;

    public void showStats(ActionEvent actionEvent) {
        loadAsMainContent("statistics.fxml");
    }

    public void showGame(ActionEvent actionEvent) {
        loadAsMainContent("board.fxml");
    }

    private void loadAsMainContent(String name) {
        FXMLLoader fxmlLoader = new FXMLLoader(TicTacToeApplication.class.getResource(name));
        try {
            Pane root = fxmlLoader.load();
            GameStateHolder controller = fxmlLoader.getController();
            controller.setGameState(gameState);
            contents.getChildren().clear();
            contents.getChildren().add(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
        showGame(null);
    }

    public GameState getGameState() {
        return gameState;
    }
}
