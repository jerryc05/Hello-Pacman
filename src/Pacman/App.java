package Pacman;

import Pacman.util.Constants;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is the  main class where your Pacman game will start.
 * The main method of this application calls the App constructor. You
 * will need to fill in the constructor to instantiate your game.
 * <p>
 * Class comments here...
 */
public class App extends Application {

  /*
   * Here is the mainline! No need to change this.
   */
  public static void main(String[] argv) {
    // launch is a method inherited from Application
    launch(argv);
  }

  @Override
  public void start(Stage stage) {
    // Create top-level object, set up the scene, and show the stage here.

    //set up scene, instantiate top-level object, and show the stage.
    Scene scene = new Scene(PaneOrganizer.getRoot(),
      (Constants.MAZE_SIDE_LENGTH + 4) * Constants.SQUARE_LENGTH,
      (Constants.MAZE_SIDE_LENGTH + 4) * Constants.SQUARE_LENGTH);
    stage.setScene(scene);
    stage.setTitle("Pacman❤");
    stage.setResizable(false);
    stage.show();
  }
}
