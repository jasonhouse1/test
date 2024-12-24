public class hw13_5{
  public static void main(String[] args) {
    Circle circle1 = new Circle(3, "white", true);
    Circle circle2 = new Circle(4, "yellow", true);

    GeometricObject largerCircle = GeometricObject.max(circle1, circle2);
    System.out.println("Larger Circle: " + largerCircle);

    // 測試兩個矩形
    Rectangle rectangle1 = new Rectangle(3, 5, "white", true);
    Rectangle rectangle2 = new Rectangle(4, 6, "yellow", true);

    GeometricObject largerRectangle = GeometricObject.max(rectangle1, rectangle2);
    System.out.println("Larger Rectangle: " + largerRectangle);
  }
}

abstract class GeometricObject implements Comparable<GeometricObject>{
  private String color = "white";
  private boolean filled;
  private java.util.Date dateCreated;

  /** Construct a default geometric object */
  protected GeometricObject() {
    dateCreated = new java.util.Date();
  }

  /** Construct a geometric object with color and filled value */
  protected GeometricObject(String color, boolean filled) {
    dateCreated = new java.util.Date();
    this.color = color;
    this.filled = filled;
  }

  /** Return color */
  public String getColor() {
    return color;
  }

  /** Set a new color */
  public void setColor(String color) {
    this.color = color;
  }

  /** Return filled. Since filled is boolean,
   *  the get method is named isFilled */
  public boolean isFilled() {
    return filled;
  }

  /** Set a new filled */
  public void setFilled(boolean filled) {
    this.filled = filled;
  }

  /** Get dateCreated */
  public java.util.Date getDateCreated() {
    return dateCreated;
  }

  /** Return a string representation of this object */
  public String toString() {
    return "created on " + dateCreated + "\ncolor: " + color +
      " and filled: " + filled;
  }

  /** Abstract method getArea */
  public abstract double getArea();

  /** Abstract method getPerimeter */
  public abstract double getPerimeter();

  public int compareTo(GeometricObject other){
    return Double.compare(this.getArea(), other.getArea());
  }

  public static GeometricObject max(GeometricObject o1, GeometricObject o2){
    return o1.compareTo(o2) >= 0 ? o1 : o2;
  }
}

class Circle extends GeometricObject {
  private double radius;

  public Circle(double r, String color, boolean filled){
    super(color, filled);
    this.radius = r;
  }
  public double getRadius() {
    return this.radius;
  }

  @Override
  public double getArea() {
    return Math.PI * radius * radius;
  }

  @Override
  public double getPerimeter(){
    return 2 * radius * Math.PI;
  }

  @Override
  public String toString() {
    return "Circle with radius: " + radius;
  }
}
class Rectangle extends GeometricObject {
  private double width;
  private double height;

  public Rectangle(double w, double h, String color, boolean filled) {
    super(color, filled);
    this.width = w;
    this.height = h;
  }

  @Override
  public double getArea() {
    return width * height;
  }

  @Override
  public double getPerimeter() {
    return (width + height) * 2;
  }

  @Override
  public String toString() {
    return "Rectangle with width: " + width + " and height: " + height;
  }
}
