package com.learnjava.oop;

// Should extends from Shape and implements getArea method
public class Triangle extends Shape {
    public Triangle(double height, double width) {
        myHeight = height;
        myWidth = width;
    }

    public double getArea() {
        return myHeight * myWidth / 2;
    }
}
