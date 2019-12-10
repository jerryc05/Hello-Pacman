package Pacman.ui.model;

import Pacman.ui.Square;
import Pacman.util.Constants;
import Pacman.util.Movable;

public abstract class Ghost extends Square implements Movable {

  public Ghost(int x, int y) {
    super(x, y);
    withColor(Constants.COLOR_GHOST);
  }

  @Override
  public boolean tryMove() {
//    boolean canMove = canMove(direction);
//    if (canMove) moveNow(direction);
    return false;
  }

  public boolean canMove() {
    throw new UnsupportedOperationException("Not implemented!");
  }

  public void moveNow() {
    throw new UnsupportedOperationException("Not implemented!");
  }

  @Override
  public boolean canRunInto() {
    return true;
  }

  @Override
  public int eaten() {
    // todo ghost get back to pen here
    return 200;
  }

  @Override
  public String toString() {
    return "G";
  }
}
