public class PointMain {
  public static void main(String[] args) {
    Point p1 = new Point(1, 4);
    Point p2 = new Point(5, 9);
    p1.moveTo();
    System.out.println(String.format("Point 1: [%s, %s]", p1.getX(), p1.getY()));
    System.out.println(String.format("Point 2: [%s, %s]", p2.getX(), p2.getY()));
    p1.rMoveTo();
    System.out.println(String.format("La distance pt1-pt2 est %s", p1.distance(p2)));
    Rectangle rectangle = new Rectangle(p1, p2, new Point(4, 5), new Point(12, 8));
  }
}