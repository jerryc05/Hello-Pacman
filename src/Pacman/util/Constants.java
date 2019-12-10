package Pacman.util;

import java.util.Random;

import javafx.scene.paint.Color;

public interface Constants {

  int
    SQUARE_LENGTH           = 20,
    MAZE_SIDE_LENGTH        = 23,
    COUNT_DOWN_SECONDS      = 2;

  Color
    COLOR_WALL      = Color.DARKCYAN,
    COLOR_FREE      = Color.rgb((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)),
    COLOR_DOT       = Color.DARKORANGE,
    COLOR_ENERGIZER = Color.rgb(new Random().nextInt(256), (int) (Math.random() * 256), (int) (Math.random() * 256)),
    COLOR_PACMAN    = Color.rgb(new Random().nextInt(256), (int) (Math.random() * 256), (int) (Math.random() * 256)),
    COLOR_GHOST     = Color.rgb(new Random().nextInt(256), (int) (Math.random() * 256), (int) (Math.random() * 256));
}
