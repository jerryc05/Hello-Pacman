package Pacman.util;

import javafx.scene.paint.Color;

import java.util.Random;

public interface Constants {
  int
          SQUARE_LENGTH = 20,
          MAZE_SIDE_LENGTH = 23,
          COUNT_DOWN_SECONDS = 5;

  Color
          COLOR_WALL = Color.LAVENDER,
          COLOR_FREE = Color.rgb((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)),
          COLOR_DOT = Color.DARKORANGE,
          COLOR_ENERGIZER = Color.rgb(new Random().nextInt(256), (int) (Math.random() * 256), (int) (Math.random() * 256)),
          COLOR_PACMAN = Color.rgb(new Random().nextInt(256), (int) (Math.random() * 256), (int) (Math.random() * 256)),
          COLOR_GHOST = Color.rgb(new Random().nextInt(256), (int) (Math.random() * 256), (int) (Math.random() * 256));
}
