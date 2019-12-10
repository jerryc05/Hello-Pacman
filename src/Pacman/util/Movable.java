package Pacman.util;

public interface Movable {
  /**
   * If the object can move, then move; otherwise stay.
   *
   * @return true if moving is successful, false otherwise
   */
  boolean tryMove();
}
