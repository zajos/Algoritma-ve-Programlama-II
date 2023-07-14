
package ch13;

/**
 *
 * @author Emre
 */
public class Circle implements Shape{
    private double radius=0;
    public Circle(){
        setRadius(radius);
    }
    public Circle(double radius){
        setRadius(radius);
    }

    /**
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return getRadius()*getRadius()*3.14;
    }
    
}
