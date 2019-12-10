package Pacman;

import java.util.ArrayList;

import Pacman.ui.Square;
import Pacman.ui.model.Ghost;
import Pacman.ui.model.Pacman;
import Pacman.ui.model.ghost.ChasingGhost;
import Pacman.ui.square.DotSquare;
import Pacman.ui.square.EnergizerSquare;
import Pacman.ui.square.FreeSquare;
import Pacman.ui.square.WallSquare;
import Pacman.util.Constants;
import Pacman.util.Direction;
import cs015.fnl.PacmanSupport.SquareType;
import cs015.fnl.PacmanSupport.SupportMap;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public abstract class PacmanGame {

  /**
   * The Ghosts in game
   */
  private static final ArrayList<Ghost> _ghosts;
  /**
   * 2D-Array of the Square Maze
   */
  private static final Square[][]       _squares;
  /**
   * Pane of the entire Pacman Game
   */
  private static       Pane             _pane;
  /**
   * The only Pacman in game
   */
  private static       Pacman           _pacman;
  /**
   * If _countdown > 0, then the game has not started; otherwise, the game has started;
   */
  private static       int              _countdown = Constants.COUNT_DOWN_SECONDS;
  /**
   * The score of the Pacman.
   */
  private static       int              _score;

  static {
    _ghosts = new ArrayList<>(3);
    _squares = new Square[Constants.MAZE_SIDE_LENGTH][Constants.MAZE_SIDE_LENGTH];
  }

  public static void start(Pane pane) {
    _pane = pane;
    parseSupportMap();
    initKeyEvent();
    initTimeline();
  }

  private static void parseSupportMap() {
    SquareType[][] supportMap = SupportMap.getSupportMap();

    for (int row = 0; row < supportMap.length; ++row) {
      for (int col = 0; col < supportMap[row].length; ++col) {
        switch (supportMap[row][col]) {

          case WALL:
            _squares[row][col] = new WallSquare(row, col);
            break;

          case FREE:
            _squares[row][col] = new FreeSquare(row, col);
            break;

          case DOT:
            _squares[row][col] = new DotSquare(row, col);
            break;

          case ENERGIZER:
            _squares[row][col] = new EnergizerSquare(row, col);
            break;

          case PACMAN_START_LOCATION:
            _pacman = new Pacman(row, col, Direction.RIGHT);
            _squares[row][col] = _pacman;
            break;

          case GHOST_START_LOCATION:
            _squares[row][col] = new ChasingGhost(row, col);
            break;

          default:
            throw new IllegalStateException("Unknown Square Type!");
        }

        System.out.print(_squares[row][col]);
        _pane.getChildren().add(_squares[row][col].getRectangle());
      }
      System.out.println();
    }
  }

  private static void initKeyEvent() {
    EventHandler<KeyEvent> _handler = new EventHandler<>() {
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
        keyEvent.consume();
      }
    };
    _pane.setOnKeyPressed(_handler);
    _pane.setFocusTraversable(true);
  }

  private static void initTimeline() {
    EventHandler<ActionEvent> eventEventHandler = new EventHandler<>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        if (_countdown > 0) {
          countDown();
          return;
        }

        _pacman.tryMove();
        for (Ghost ghost : _ghosts)
          ghost.tryMove();

        printPacmanMaze();
      }
    };

    KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), eventEventHandler);
    Timeline timeline = new Timeline(keyFrame);
    timeline.setCycleCount(Animation.INDEFINITE);
    timeline.play();
  }

  /**
   * [Extra Credit*] decrement `_countdown` and handle javafx label changes.
   */
  private static void countDown() {
    if (_countdown > 0) {
      System.out.println(_countdown + "s to start!");
      --_countdown;
      // todo implement timeline starting with paused state
      // todo decrement count down label in game after every second
      // todo start game now
    }
  }

  public static Square getSquareByIndex(int x, int y) {
    return _squares[x][y];
  }

  public static void setSquareByIndex(Square square) {
    _pane.getChildren().remove(_squares[square.getX()][square.getY()].getRectangle());
    _pane.getChildren().add(square.getRectangle());
    _squares[square.getX()][square.getY()] = square;
  }

  private static void printPacmanMaze() {
    for (Square[] row : _squares) {
      for (Square square : row)
        System.out.print(square);
      System.out.println();
    }
    System.out.println();
  }
}
