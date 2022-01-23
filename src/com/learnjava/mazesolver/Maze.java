package com.learnjava.mazesolver;

import java.util.LinkedList;

public class Maze {
    int[][] maze;
    LinkedList<Position> path;
    Position start;

    @Override
    public String toString() {
        String str = new String();
        for (int i = 0; i < this.maze.length; i++) {
            for (int j = 0; j < this.maze[i].length; j++) {
                str += this.maze[i][j] + " ";
            }
            str += System.lineSeparator();
        }
        str += "starting point: " + this.start.y + " " + this.start.x;
        return str;
    }
}
