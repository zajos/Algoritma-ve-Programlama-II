/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ch13;

/**
 *
 * @author Emre
 */
public class AreaCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Rectangle rectangle=new Rectangle(4,3);
        Circle circle=new Circle(4);
        showArea(rectangle);
        showArea(circle);
        
    }
    public static void showArea(Shape s){
        double area=s.area();
        System.out.println("The area of the shape is "+area);
    }
}
