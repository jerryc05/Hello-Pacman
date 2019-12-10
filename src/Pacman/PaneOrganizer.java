package Pacman;

import Pacman.util.Constants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public abstract class PaneOrganizer {

  private static BorderPane _root = new BorderPane();

  static {
    _root.setPrefSize((Constants.MAZE_SIDE_LENGTH + 4) * Constants.SQUARE_LENGTH,
      (Constants.MAZE_SIDE_LENGTH + 4) * Constants.SQUARE_LENGTH);

    GridPane gamePane = new GridPane();
    gamePane.setPrefSize(
      Constants.MAZE_SIDE_LENGTH * Constants.SQUARE_LENGTH,
      Constants.MAZE_SIDE_LENGTH * Constants.SQUARE_LENGTH);
    gamePane.setPadding(new Insets(
      2 * Constants.SQUARE_LENGTH,
      2 * Constants.SQUARE_LENGTH,
      2 * Constants.SQUARE_LENGTH,
      2 * Constants.SQUARE_LENGTH));
    gamePane.setAlignment(Pos.CENTER);
    gamePane.setStyle("-fx-background-color:#FFFAF0;");

    _root.setCenter(gamePane);
    PacmanGame.start(gamePane);

//    Pane topSpace = new Pane();
//    topSpace.setPrefHeight(2 * Constants.SQUARE_LENGTH);
//    _root.setTop(topSpace);
//
//    Pane leftSpace = new Pane();
//    leftSpace.setPrefWidth(2 * Constants.SQUARE_LENGTH);
//    _root.setLeft(leftSpace);

    Button quit = new Button("Bye-bye!");
    // Registers the button to the click handler.
    quit.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        System.exit(0);
      }
    });

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
}