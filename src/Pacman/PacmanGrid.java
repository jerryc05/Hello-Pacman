package Pacman;

public class PacmanGrid {

  private Pacman  _pacman;
  private Ghost[] _ghosts;

  private void tryMove() {
    _ghosts[0].moveNow(null);
    checkCollision();
    _pacman.moveNow(null);
    checkCollision();
    throw new UnsupportedOperationException("Not implemented!");
  }

  private boolean checkCollision() {
    throw new UnsupportedOperationException("Not implemented!");
  }
}
