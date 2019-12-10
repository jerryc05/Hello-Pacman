package Pacman.ui.square;

import Pacman.ui.Square;
import Pacman.util.Constants;

public class DotSquare extends Square {

  public DotSquare(int x, int y) {
    super(x, y);
    withColor(Constants.COLOR_DOT);
  }

  @Override
  public boolean canRunInto() {
    return true;
  }

  @Override
  public String toString() {
    return "·";
  }
}
