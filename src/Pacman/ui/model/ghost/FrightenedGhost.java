package Pacman.ui.model.ghost;

import Pacman.ui.model.Ghost;

public class FrightenedGhost extends Ghost {

  public FrightenedGhost(int x, int y) {
    super(x, y);
  }

  @Override
  public int eaten() {
    // todo ghost get back to pen here
    return 200;
  }
}
