package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.GameController;

public class ChessApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        GameController controller = new GameController();
        ChessBoardView boardView = new ChessBoardView(controller);

        Scene scene = new Scene(boardView, 640, 640);
        primaryStage.setTitle("Ajedrez Bot");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
