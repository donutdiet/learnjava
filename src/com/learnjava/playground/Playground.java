package com.learnjava.playground;

public class Playground {

    public static void main(String[] args) {
        String s = "hello";
        String t = "hello";
        String h = new String("hello");
        System.out.println(s.equals(t));
        System.out.println(s.equals(h));
        System.out.println(s.hashCode());
        System.out.println(h.hashCode());
    }
}
