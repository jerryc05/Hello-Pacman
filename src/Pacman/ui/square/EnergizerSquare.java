package Pacman.ui.square;

import Pacman.ui.Square;
import Pacman.util.Constants;

public class EnergizerSquare extends Square {

  public EnergizerSquare(int x, int y) {
    super(x, y);
    withColor(Constants.COLOR_ENERGIZER);
  }

  @Override
  public boolean canRunInto() {
    return true;
  }

  @Override
  public int eaten() {
    // todo ghosts get frightened here
    return 100;
  }

  @Override
  public String toString() {
    return "E";
  }
}
