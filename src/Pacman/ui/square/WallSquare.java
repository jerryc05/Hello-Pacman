package Pacman.ui.square;

import Pacman.ui.Square;
import Pacman.util.Constants;

public class WallSquare extends Square {

  public WallSquare(int x, int y) {
    super(x, y);
    withColor(Constants.COLOR_WALL);
  }

  @Override
  public boolean canRunInto() {
    return false;
  }

  @Override
  public String toString() {
    return "\u2588";
  }
}
