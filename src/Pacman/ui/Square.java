package Pacman.ui;

import Pacman.util.Constants;
import Pacman.util.Coordinate;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Square {

  private final Rectangle _rectangle;

  {
    _rectangle = new Rectangle(Constants.SQUARE_LENGTH, Constants.SQUARE_LENGTH);
  }

  public Square(int x, int y) {
    withCoordinate(x, y);
  }

  public abstract boolean canRunInto();

  public abstract int eaten();

  public Square withCoordinate(Coordinate coordinate) {
    return withCoordinate(coordinate.getX(), coordinate.getY());
  }

  public Square withCoordinate(int x, int y) {
    _rectangle.setX(x * Constants.SQUARE_LENGTH);
    _rectangle.setY(y * Constants.SQUARE_LENGTH);
    return this;
  }

  public Square withColor(Color color) {
    this._rectangle.setFill(color);
    return this;
  }

  public int getX() {
    return (int) (this._rectangle.getX() / Constants.SQUARE_LENGTH);
  }

  public int getY() {
    return (int) (this._rectangle.getY() / Constants.SQUARE_LENGTH);
  }

  public Rectangle getRectangle() {
    return _rectangle;
  }
}