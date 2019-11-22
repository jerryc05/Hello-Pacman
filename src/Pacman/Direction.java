package Pacman;

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
  public void moveNow(Coordinate coordinate) {
    switch (this) {
      case UP:
        coordinate.setY(coordinate.getY() + 1);
        break;

      case DOWN:
        coordinate.setY(coordinate.getY() - 1);
        break;

      case LEFT:
        coordinate.setX(coordinate.getX() - 1);
        break;

      case RIGHT:
      default:
        coordinate.setX(coordinate.getX() + 1);
        break;
    }
  }
}
