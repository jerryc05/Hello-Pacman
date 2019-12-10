package Pacman;

import Pacman.ui.*;
import Pacman.ui.square.model.ghost.ChasingGhost;
import Pacman.ui.square.model.Pacman;
import Pacman.ui.square.DotSquare;
import Pacman.ui.square.EnergizerSquare;
import Pacman.ui.square.FreeSquare;
import Pacman.ui.square.WallSquare;
import Pacman.util.Constants;
import Pacman.util.Direction;
import cs015.fnl.PacmanSupport.SquareType;
import cs015.fnl.PacmanSupport.SupportMap;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class PacmanGame implements EventHandler<KeyEvent> {

  /**
   * Pane of the entire Pacman Game
   */
  private static Pane _pane;

  /**
   * The only Pacman in game
   */
  private static Pacman _pacman;

  /**
   * 2D-Array of the Square Maze
   */
  private static final PacmanGameSquare[][] _squares;

  /**
   * Handle click event of the pane.
   */
  private static final EventHandler<KeyEvent> _handler;

  static {
    _squares = new PacmanGameSquare[Constants.MAZE_SIDE_LENGTH][Constants.MAZE_SIDE_LENGTH];
    _handler = new EventHandler<>() {
      @Override
      public void handle(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
          case UP:
            _pacman.setIntendedDirection(Direction.UP);
            break;
          case DOWN:
            _pacman.setIntendedDirection(Direction.DOWN);
            break;
          case LEFT:
            _pacman.setIntendedDirection(Direction.LEFT);
            break;
          case RIGHT:
            _pacman.setIntendedDirection(Direction.RIGHT);
            break;
        }
      }
    };
  }

  public static void start(Pane pane) {
    _pane = pane;
    parseSupportMap();
    countDown(Constants.COUNT_DOWN_SECONDS);
  }

  private static void parseSupportMap() {
    SquareType[][] supportMap = SupportMap.getSupportMap();

    for (int row = 0; row < supportMap.length; ++row) {
      for (int col = 0; col < supportMap[row].length; ++col) {
        Rectangle rectangle = new Rectangle(
                row * Constants.SQUARE_LENGTH,
                col * Constants.SQUARE_LENGTH);
        rectangle.setStroke(Color.WHITE);
        switch (supportMap[row][col]) {
          case WALL:
            rectangle.setFill(Constants.COLOR_WALL);
            _squares[row][col] = new WallSquare();
            break;
          case FREE:
            rectangle.setFill(Constants.COLOR_FREE);
            _squares[row][col] = new FreeSquare();
            break;
          case DOT:
            rectangle.setFill(Constants.COLOR_DOT);
            _squares[row][col] = new DotSquare();
            break;
          case ENERGIZER:
            rectangle.setFill(Constants.COLOR_ENERGIZER);
            _squares[row][col] = new EnergizerSquare();
            break;
          case PACMAN_START_LOCATION:
            rectangle.setFill(Constants.COLOR_PACMAN);
            _pacman = new Pacman(row, col, Direction.RIGHT);
            _squares[row][col] = _pacman;

            break;
          case GHOST_START_LOCATION:
            rectangle.setFill(Constants.COLOR_GHOST);
            _squares[row][col] = new ChasingGhost(row, col);
            break;
          default:
            throw new IllegalStateException("Unknown Square Type!");
        }

        System.out.print(_squares[row][col]);
        _pane.getChildren().add(rectangle);
      }
      System.out.println();
    }

  }

  /**
   * [Extra Credit*] count down `seconds` seconds before game start
   */
  private static void countDown(int seconds) {
    for (; seconds > 0; --seconds) {
      // todo implement timeline starting with paused state
      // todo decrement count down label in game after every second
      // todo start game now
    }
  }

//  private void tryMove() {
//    _pacman.moveNow(null);
//    checkCollision();
//
//    for (Ghost ghost : _ghosts)
//      ghost.moveNow(null);
//    checkCollision();
//
//    throw new UnsupportedOperationException("Not implemented!");
//  }
//
//  private boolean checkCollision() {
//    throw new UnsupportedOperationException("Not implemented!");
//  }
}
