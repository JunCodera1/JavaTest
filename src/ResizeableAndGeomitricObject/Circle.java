package ResizeableAndGeomitricObject;

public class Circle implements GeomitricObject {
    
    public double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    public double getRadius() {
        return radius;
    }
    
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    public String toString() {
    	return "Circle before resize: radius = " + radius + ", perimeter = " + getPerimeter() + ", area = " + getArea(); 
    }
}
