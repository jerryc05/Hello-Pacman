package Pacman.ui.square.model;


import Pacman.ui.PacmanGameSquare;
import Pacman.util.Coordinate;
import Pacman.util.Direction;
import Pacman.util.Movable;

public abstract class Ghost extends PacmanGameSquare implements Movable {

  /**
   * Coordinate of Pacman
   */
  private final Coordinate _coordinate;

  public Ghost(int x, int y){
    _coordinate = new Coordinate(x, y);
  }

  @Override
  public boolean canMove(Direction direction) {
    throw new UnsupportedOperationException("Not implemented!");
  }

  @Override
  public void moveNow(Direction direction) {
    throw new UnsupportedOperationException("Not implemented!");
  }

  @Override
  public String toString() {
    return "G";
  }
}
