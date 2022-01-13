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

    private MainState mainState;

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
            MainStateHolder controller = fxmlLoader.getController();
            controller.setMainState(mainState);
            contents.getChildren().clear();
            contents.getChildren().add(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setMainState(MainState mainState) {
        this.mainState = mainState;
        showGame(null);
    }

    public MainState getGameState() {
        return mainState;
    }
}
