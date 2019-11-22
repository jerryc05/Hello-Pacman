package Pacman;

public class Ghost implements Movable {

  /**
   * Current state of the ghost: {frightened | not frightened}
   */
  private boolean _isFrightened;


  @Override
  public boolean canMove(Direction direction) {
    throw new UnsupportedOperationException("Not implemented!");
  }

  @Override
  public void moveNow(Direction direction) {
    throw new UnsupportedOperationException("Not implemented!");
  }
}
