package Pacman.ui.square;

import Pacman.ui.Square;
import Pacman.util.Constants;

/**
 * [Extra Credit*] Fruit Squares!
 * Works similar to energizer, except for not frightening the ghosts.
 */
public abstract class FruitSquare extends Square {

  private FruitSquare(int x, int y) {
    super(x, y);
  }

  public static FruitSquare getRandomFruit(int x, int y) {
    switch ((int) (Math.random() * 5)) {
      case 0:
        return new FruitSquareCherry(x, y);
      case 1:
        return new FruitSquareStrawberry(x, y);
      case 2:
        return new FruitSquareOrange(x, y);
      case 3:
        return new FruitSquareApple(x, y);
      case 4:
      default:
        return new FruitSquareMelon(x, y);
    }
  }

  @Override
  public boolean canRunInto() {
    return true;
  }

  @Override
  public String toString() {
    return "F";
  }

  static class FruitSquareCherry extends FruitSquare {

    FruitSquareCherry(int x, int y) {
      super(x, y);
      withColor(Constants.COLOR_FRUIT_CHERRY);
    }

    @Override
    public int eaten() {
      return 100;
    }

    @Override
    public String toString() {
      return "c";
    }
  }

  static class FruitSquareStrawberry extends FruitSquare {

    FruitSquareStrawberry(int x, int y) {
      super(x, y);
      withColor(Constants.COLOR_FRUIT_STRAWBERRY);
    }

    @Override
    public int eaten() {
      return 300;
    }

    @Override
    public String toString() {
      return "s";
    }
  }

  static class FruitSquareOrange extends FruitSquare {

    FruitSquareOrange(int x, int y) {
      super(x, y);
      withColor(Constants.COLOR_FRUIT_ORANGE);
    }

    @Override
    public int eaten() {
      return 500;
    }

    @Override
    public String toString() {
      return "o";
    }
  }

  static class FruitSquareApple extends FruitSquare {

    FruitSquareApple(int x, int y) {
      super(x, y);
      withColor(Constants.COLOR_FRUIT_APPLE);
    }

    @Override
    public int eaten() {
      return 700;
    }

    @Override
    public String toString() {
      return "a";
    }
  }

  static class FruitSquareMelon extends FruitSquare {

    FruitSquareMelon(int x, int y) {
      super(x, y);
      withColor(Constants.COLOR_FRUIT_MELON);
    }

    @Override
    public int eaten() {
      return 700;
    }

    @Override
    public String toString() {
      return "m";
    }
  }
}