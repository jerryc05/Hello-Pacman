package Pacman.util;

public class Coordinate {

  /**
   * X coordinate of any object
   */
  private int _x;

  /**
   * Y coordinate of any object
   */
  private int _y;

  /**
   * Construct an coordinate instance
   *
   * @param x X coordinate
   * @param y Y coordinate
   */
  public Coordinate(int x, int y) {
    this._x = x;
    this._y = y;
  }

  public int getX() {
    return this._x;
  }

  public int getY() {
    return this._y;
  }

  public void setX(int x) {
    this._x = x;
  }

  public void setY(int y) {
    this._y = y;
  }

  @Override
  public String toString() {
    return "(" + this._x + ", " + this._y + ")";
  }
}
