public class hw13_7 {
    public static void main(String[] args) {
        GeometricObject[] objects = new GeometricObject[5];
        for(int i=0; i<5; i++)
            objects[i] = new Square(i);
        for(GeometricObject obj: objects){
            System.out.println("Area: " + obj.getArea());
            if(obj instanceof Colorable){
                ((Colorable) obj).howToColor();
            }
        }
    }   
}
abstract class GeometricObject {
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
}

interface Colorable{
    void howToColor();
}

class Square extends GeometricObject implements Colorable{
    private double side;

    public Square() {
        this.side = 0;
    }
    public Square(double side) {
        this.side = side;
    }
    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }
    public void howToColor() {
        System.out.println("Color all four sides");
    }

    @Override
    public String toString() {
        return "Square with side: " + side;
    }
}