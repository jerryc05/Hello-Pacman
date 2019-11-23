package Pacman.Model.Ghost;


import Pacman.Util.Direction;
import Pacman.Util.Movable;

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
