package Pacman;

import Pacman.util.Constants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public abstract class PaneOrganizer {

  private static BorderPane _root = new BorderPane();

  static  {
    _root.setPrefSize((Constants.MAZE_SIDE_LENGTH + 4) * Constants.SQUARE_LENGTH,
            (Constants.MAZE_SIDE_LENGTH + 4) * Constants.SQUARE_LENGTH);

    StackPane gamePane = new StackPane();
    gamePane.setPrefSize(
            Constants.MAZE_SIDE_LENGTH * Constants.SQUARE_LENGTH,
            Constants.MAZE_SIDE_LENGTH * Constants.SQUARE_LENGTH);
    gamePane.setStyle("-fx-background-color:#FFFAF0;");

    _root.setCenter(gamePane);
    PacmanGame.start(gamePane);

    Button quit = new Button("Bye-bye!");
    // Registers the button to the click handler.
    quit.setOnAction(new ClickHandler());

    VBox bottomPane = new VBox();
    bottomPane.setPrefHeight(2 * Constants.SQUARE_LENGTH);
    bottomPane.setStyle("-fx-background-color:#FFFAF0;");
    bottomPane.setAlignment(Pos.CENTER);
    bottomPane.getChildren().add(quit);

    _root.setBottom(bottomPane);
  }

  public static Pane getRoot() {
    return _root;
  }

  /**
   * Implemented the handle method to enable quit button's function.
   */
  private static class ClickHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
      System.exit(0);
    }
  }
}