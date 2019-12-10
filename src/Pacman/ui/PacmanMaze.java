package Pacman.ui;

import Pacman.model.Ghost.Ghost;
import Pacman.model.Pacman;

public class PacmanMaze {
  /**
   * The only pacman in maze
   */
  private Pacman _pacman;

  /**
   * The array of Ghosts in maze
   */
  private Ghost[] _ghosts;

  /**
   * Create an instance Pacman Maze
   *
   * @param pacman The pacman in the game
   * @param ghosts Ghosts in the game
   */
  private PacmanMaze(Pacman pacman, Ghost[] ghosts) {
    this._pacman = pacman;
    this._ghosts = ghosts;
  }

  private void tryMove() {
    _pacman.moveNow(null);
    checkCollision();

    for (Ghost ghost : _ghosts)
      ghost.moveNow(null);
    checkCollision();

    throw new UnsupportedOperationException("Not implemented!");
  }

  private boolean checkCollision() {
    throw new UnsupportedOperationException("Not implemented!");
  }
}
