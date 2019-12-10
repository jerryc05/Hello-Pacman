package Pacman.model.Ghost;


import Pacman.util.Direction;
import Pacman.util.Movable;

public abstract class Ghost implements Movable {

  @Override
  public boolean canMove(Direction direction) {
    throw new UnsupportedOperationException("Not implemented!");
  }

  @Override
  public void moveNow(Direction direction) {
    throw new UnsupportedOperationException("Not implemented!");
  }
}
