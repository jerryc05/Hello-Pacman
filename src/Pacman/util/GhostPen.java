package Pacman.util;

import java.util.ArrayDeque;

import Pacman.ui.model.Ghost;

public class GhostPen {

  /**
   * The Ghost in game
   */
  private static ArrayDeque<Ghost> _ghosts;

  static {
    _ghosts = new ArrayDeque<>(3);
  }

  public static void enqueue(Ghost ghost) {
    _ghosts.add(ghost);
  }

  public static Ghost dequeue() {
    return _ghosts.pop();
  }
}
