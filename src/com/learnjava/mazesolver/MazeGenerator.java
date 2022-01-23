package com.learnjava.mazesolver;

import java.util.LinkedList;

public class MazeGenerator {

    public static void main(String[] args) {
        generateMaze();
        // test how to commit changes in vs code to github
    }

    // m: between 2 and 10
    // n: between 2 and 10
    // maze elements is either 1 or 0, but there is a "2" at one place
    // m.path = new LinkedList<>()
    // m.start: randomly pick a position, but you need to do boundary check. start
    // is between the min and max value of both m and n
    public static Maze generateMaze() {
        Maze m = new Maze();
        int y = (int) (Math.random() * 9 + 2);
        int x = (int) (Math.random() * 9 + 2);
        int yStart = (int) (Math.random() * y);
        int xStart = (int) (Math.random() * x);
        int yFinal = (int) (Math.random() * y);
        int xFinal = (int) (Math.random() * x);

        m.maze = new int[y][x];

        for (int i = 0; i < m.maze.length; i++) {
            for (int j = 0; j < m.maze[i].length; j++) {
                m.maze[i][j] = (int) (Math.round(Math.random()));
            }
        }
        m.maze[yFinal][xFinal] = 2;
        m.path = new LinkedList<Position>();
        m.start = new Position(yStart, xStart);
        return m;
    }
}