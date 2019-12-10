package Pacman;

import java.util.ArrayList;

import Pacman.ui.Square;
import Pacman.ui.model.Ghost;
import Pacman.ui.model.Pacman;
import Pacman.ui.model.ghost.ChasingGhost;
import Pacman.ui.square.DotSquare;
import Pacman.ui.square.EnergizerSquare;
import Pacman.ui.square.FreeSquare;
import Pacman.ui.square.FruitSquare;
import Pacman.ui.square.WallSquare;
import Pacman.util.Constants;
import Pacman.util.Coordinate;
import Pacman.util.Direction;
import cs015.fnl.PacmanSupport.SquareType;
import cs015.fnl.PacmanSupport.SupportMap;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
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
  private static       GridPane         _pane;
  /**
   * The only Pacman in game
   */
  private static       Pacman           _pacman;
  /**
   * If _countdown > 0, then the game has not started;
   * otherwise, the game has started;
   */
  private static       int              _countdown;
  /**
   * [Extra Credit*] Change this to make ghosts move slower than Pacman.
   */
  private static       boolean          _shallGhostsMove;

  static {
    _ghosts = new ArrayList<>(3);
    _squares = new Square[Constants.MAZE_SIDE_LENGTH][Constants.MAZE_SIDE_LENGTH];
    _countdown = Constants.COUNT_DOWN_SECONDS;
  }

  public static void start(GridPane pane) {
    _pane = pane;
    parseSupportMap();
    initKeyEvent();
    initTimeline();
  }

  private static void parseSupportMap() {
    SquareType[][] supportMap = SupportMap.getSupportMap();

    for (int col = 0; col < Constants.MAZE_SIDE_LENGTH; ++col) {
      for (int row = 0; row < Constants.MAZE_SIDE_LENGTH; ++row){
        switch (supportMap[col][row]) {

          case WALL:
            _squares[row][col] = new WallSquare(row, col);
            break;

          case FREE:
            _squares[row][col] = new FreeSquare(row, col);
            break;

          case DOT:
            if (Math.random() < .02)
              _squares[row][col] = new FruitSquare(row, col);
            else
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
        _pane.add(_squares[row][col].getRectangle(), row, col);
      }
    }
    debugPacmanMaze();
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
        if (_shallGhostsMove)
          for (Ghost ghost : _ghosts)
            ghost.tryMove();
        _shallGhostsMove = !_shallGhostsMove;

        debugPacmanMaze();
      }
    };

    KeyFrame keyFrame = new KeyFrame(Duration.seconds(.5), eventEventHandler);
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

  public static Square getSquareByCoordinate(Coordinate coordinate) {
    return getSquareByCoordinate(coordinate.getX(), coordinate.getY());
  }

  public static Square getSquareByCoordinate(int x, int y) {
    return _squares[x][y];
  }

  public static void setSquare(Square square) {
    _pane.getChildren().remove(_squares[square.getX()][square.getY()].getRectangle());
    _pane.add(square.getRectangle(), square.getX(), square.getY());
    _squares[square.getX()][square.getY()] = square;
  }

  private static void debugPacmanMaze() {
    for (int col = 0; col < Constants.MAZE_SIDE_LENGTH; ++col) {
      for (int row = 0; row < Constants.MAZE_SIDE_LENGTH; ++row)
        System.out.print(_squares[row][col]);
      System.out.println();
    }
    System.out.println("Score: [" + _pacman.getScore() + "]!");
    System.out.println();
  }
}
