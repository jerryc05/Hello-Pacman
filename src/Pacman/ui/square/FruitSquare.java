package Pacman.ui.square;

import Pacman.ui.Square;
import Pacman.util.Constants;

/**
 * [Extra Credit*] Fruit Square!
 * Works similar to energizer, except for not frightening the ghosts.
 */
public class FruitSquare extends Square {

  public FruitSquare(int x, int y) {
    super(x, y);
    withColor(Constants.COLOR_FRUIT);
  }

  @Override
  public boolean canRunInto() {
    return true;
  }

  @Override
  public int eaten() {
    return 100;
  }

  @Override
  public String toString() {
    return "F";
  }
}

