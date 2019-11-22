package Pacman;

public interface Movable {
  /**
   * Check if the object can move in the direction specified
   *
   * @param direction The direction to move
   * @return true if moving is successful, false otherwise
   */
  public boolean canMove(Direction direction);

  /**
   * Move one step in the direction specified
   *
   * @param direction The direction to move
   */
  public void moveNow(Direction direction);
}
