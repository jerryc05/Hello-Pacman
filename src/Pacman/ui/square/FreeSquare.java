package Pacman.ui.square;

import Pacman.ui.Square;
import Pacman.util.Constants;

public class FreeSquare extends Square {

  public FreeSquare(int x, int y) {
    super(x, y);
    withColor(Constants.COLOR_FREE);
  }

  @Override
  public boolean canRunInto() {
    return true;
  }

  @Override
  public String toString() {
    return " ";
  }
}
