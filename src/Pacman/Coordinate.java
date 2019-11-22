package Pacman;

public class Coordinate {

  /**
   * X coordinate of any object
   */
  private int _x;

  /**
   * X coordinate of any object
   */
  private int _y;

  /**
   * [Optional*] Hide constructor, we will use the factory method below
   */
  private Coordinate() {
  }

  /**
   * The factory method to create an Coordinate instance
   */
  public static Coordinate fromCoordinate(int x, int y) {
    Coordinate coordinate = new Coordinate();
    coordinate._x = x;
    coordinate._y = y;
    return coordinate;
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
}
