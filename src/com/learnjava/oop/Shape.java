package com.learnjava.oop;

// Shape base class should have two variables: height and width (double type)
// You should add getter and setter methods for height and width: getHeight(); getWidth(); setWidth(); setHeight()
// it should also have an abstract method: getArea()
public abstract class Shape {
    double myHeight;
    double myWidth;

    public double getheight() {
        return myHeight;
    }

    public double getWidth() {
        return myWidth;
    }

    public void setHeight(double height) {
        myHeight = height;
    }

    public void setWidth(double width) {
        myWidth = width;
    }

    public abstract double getArea();
}
