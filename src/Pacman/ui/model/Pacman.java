package Pacman.ui.model;

import Pacman.PacmanGame;
import Pacman.ui.Square;
import Pacman.ui.square.FreeSquare;
import Pacman.util.Constants;
import Pacman.util.Coordinate;
import Pacman.util.Direction;
import Pacman.util.Movable;

public class Pacman extends Square implements Movable {

  /**
   * Current direction of Pacman
   */
  private Direction _currentDirection;

  /**
   * [Extra Credit*] Pacman's next direction to move when it currently cannot do so
   */
  private Direction _intendedDirection;

  /**
   * Remaining lives of Pacman
   */
  private int _lives = 3;

  /**
   * Construct Pacman instance from coordinate and direction
   *
   * @param x         X coordinate
   * @param y         Y coordinate
   * @param direction direction that Pacman intended to move
   */
  public Pacman(int x, int y, Direction direction) {
    super(x, y);
    withColor(Constants.COLOR_PACMAN);
    this._intendedDirection = direction;
    this._currentDirection = direction;
  }

  @Override
  public boolean tryMove() {
    Direction direction = canMove();
    if (direction != null) moveNow(direction);
    return direction != null;
  }

  public boolean canMove(Direction direction) {
    Coordinate newCoordinate = direction.parseCoordinate(getX(), getY());
    return PacmanGame.getSquareByIndex(newCoordinate.getX(), newCoordinate.getY()).canRunInto();
  }

  public Direction canMove() {
    if (canMove(_intendedDirection))
      return _intendedDirection;
    else if (canMove(_currentDirection))
      return _currentDirection;
    else
      return null;
  }

  public void moveNow(Direction direction) {
    if (_currentDirection != direction)
      _currentDirection = direction;

    PacmanGame.setSquareByIndex(new FreeSquare(getX(), getY()));
    Coordinate newCoordinate = _currentDirection.parseCoordinate(getX(), getY());
    withCoordinate(newCoordinate);
    PacmanGame.setSquareByIndex(this);
  }

  public Direction getCurrentDirection() {
    return _currentDirection;
  }

  public Direction getIntendedDirection() {
    return _intendedDirection;
  }

  public void setIntendedDirection(Direction direction) {
    this._intendedDirection = direction;
  }

  @Override
  public boolean canRunInto() {
    return true;
  }

  @Override
  public String toString() {
    return "P";
  }
}
