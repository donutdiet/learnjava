package com.learnjava.oop;

// Should extends from Shape and implements getArea method
public class Rectangle extends Shape {
    public Rectangle(double height, double width) {
        myHeight = height;
        myWidth = width;
    }

    public double getArea() {
        return myHeight * myWidth;
    }
}
