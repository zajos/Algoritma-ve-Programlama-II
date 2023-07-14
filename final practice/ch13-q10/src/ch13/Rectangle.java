/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch13;

/**
 *
 * @author Emre
 */
public class Rectangle implements Shape{
    private double height;
    private double width;
    public Rectangle(){
        height=0;
        width=0;
    }
    public Rectangle(double height, double width){
        this.height=height;
        this.width=width;
    }
    @Override
    public double area() {
        double area=height*width*0.5;
        return area;
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(double width) {
        this.width = width;
    }
    
}
