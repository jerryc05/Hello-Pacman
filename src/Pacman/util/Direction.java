package Pacman.util;

public enum Direction {

  /**
   * Four possible directions of any object
   */
  UP, DOWN, LEFT, RIGHT;

  /**
   * Get the opposite direction of the current one
   */
  public Direction getOppositeDirection() {
    switch (this) {
      case UP:
        return DOWN;

      case DOWN:
        return UP;

      case LEFT:
        return RIGHT;

      case RIGHT:
      default:
        return LEFT;
    }
  }

  /**
   * Move the coordinate one step according to this direction
   */
  public Coordinate parseCoordinate(Coordinate coordinate) {
    return parseCoordinate(coordinate.getX(), coordinate.getY());
  }

  /**
   * Move the coordinate one step according to this direction
   */
  public Coordinate parseCoordinate(int x, int y) {
    switch (this) {
      case UP:
        return new Coordinate(x, y - 1);

      case DOWN:
        return new Coordinate(x, y + 1);

      case LEFT:
        return new Coordinate(x - 1, y);

      case RIGHT:
      default:
        return new Coordinate(x + 1, y);
    }
  }
}
