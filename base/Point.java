import java.lang.Math;

public class Point {
  private double x, y;
  public double distance;

  // Constructor
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void moveTo() {
    this.x = 4;
    this.y = 3;
  }

  public void rMoveTo() {
    this.x += 4;
    this.y += 8;
  }

  public double distance(Point pt2) {
    this.distance = Math.sqrt((pt2.getX() - this.x) * (pt2.getX() - this.x) - (pt2.getY() - this.y) * (pt2.getY() - this.y));
    return this.distance;
  }

  // Getters
  public double getX() {
    return this.x;
  }
  
  public double getY() {
    return this.y;
  }

  public String toString() {
    return (String.format("(%s, %s)", this.x, this.y));
  }
}
