package Pacman.ui.square.model;

import Pacman.ui.PacmanGameSquare;
import Pacman.util.Coordinate;
import Pacman.util.Direction;
import Pacman.util.Movable;

public class Pacman extends PacmanGameSquare implements Movable {

  /**
   * Coordinate of Pacman
   */
  private final Coordinate _coordinate;

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
  private int lives = 3;

  /**
   * Construct Pacman instance from coordinate and direction
   *
   * @param x         X coordinate
   * @param y         Y coordinate
   * @param direction direction that Pacman intended to move
   */
  public Pacman(int x, int y, Direction direction) {
    this._coordinate = new Coordinate(x, y);
    this._intendedDirection = direction;
  }

  @Override
  public boolean canMove(Direction direction) {
    throw new UnsupportedOperationException("Not implemented!");
  }

  @Override
  public void moveNow(Direction direction) {
    throw new UnsupportedOperationException("Not implemented!");
  }

  public Direction getCurrentDirection() {
    return _currentDirection;
  }

  public void setCurrentDirection(Direction direction) {
    this._currentDirection = direction;
  }

  public Direction getIntendedDirection() {
    return _intendedDirection;
  }

  public void setIntendedDirection(Direction direction) {
    this._intendedDirection = direction;
  }

  @Override
  public String toString() {
    return "P";
  }
}
