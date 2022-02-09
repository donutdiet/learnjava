package com.learnjava.oop;

import java.util.ArrayList;

public class ShapeDemo {
    // You should create a list of Shapes. It should contain at least one Rectangle
    // and at least one Triangle.
    // When you loop each method, you should call getArea method to print out its
    // area value
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        Triangle triangle1 = new Triangle(10, 10);
        Rectangle rectangle1 = new Rectangle(10, 10);

        shapes.add(triangle1);
        shapes.add(rectangle1);

        for (Shape shape : shapes) {
            System.out.println(shape.getArea());
        }
    }
}
