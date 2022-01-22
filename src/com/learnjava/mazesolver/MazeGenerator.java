package com.learnjava.mazesolver;

public class MazeGenerator {

    public static void main(String[] args) {
        generateMaze();


    }

    //  m: between 2 and 10
    //  n: between 2 and 10
    //  maze elements is either 1 or 0, but there is a "2" at one place
    //  m.path = new LinkedList<>()
    //  m.start: randomly pick a position, but you need to do boundary check.  start is between the min and max value of both m and n
    public static Maze generateMaze() {
        Maze m = new Maze();
        return m;
    }
}