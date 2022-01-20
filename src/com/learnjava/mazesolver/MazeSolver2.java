package com.learnjava.mazesolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class MazeSolver2 {

    public static void main(String[] args) throws FileNotFoundException {

        Maze m = new Maze();

        // Read the matrix file and create the maze
        List<int[]> tempList = new ArrayList<>();
        Scanner reader = new Scanner(new File("maze.txt"));
        while(reader.hasNextLine()) {
            String line = reader.nextLine();
            String [] stringArray = line.split(" ");
            int [] intArray = new int[stringArray.length];
            for(int i=0; i<intArray.length; i++) {
                int num = Integer.parseInt(stringArray[i]);
                intArray[i] = num;
            }
            tempList.add(intArray);
        }

        int[][] matrix = new int[tempList.size()][];
        for (int j = 0; j < tempList.size(); j++) {
            matrix[j] =  tempList.get(j);
        }
        m.maze = matrix;
        m.path = new LinkedList<>();
        m.start = new Position(2, 3);
        if(solveMaze(m)==false) {
            System.out.println("no path");
        } else {
            System.out.println("you won");
        }
    }

    private static boolean solveMaze(Maze m) {
        Position p = m.start;
        m.path.push(p);

        while(true) {
            int y = m.path.peek().y;
            int x = m.path.peek().x;
            m.maze [y][x] = 0;

            // left
            if(x-1 >= 0) {
                if (m.maze[y][x - 1] == 2) {
                    System.out.println("moved left");
                    return true;
                } else if (m.maze[y][x - 1] == 1) {
                    System.out.println("moved left");
                    m.path.push(new Position(y, x - 1));
                    continue;
                }
            }
            // down
            if(y+1 <= m.maze.length-1) {
                if (m.maze[y + 1][x] == 2) {
                    System.out.println("moved down");
                    return true;
                } else if (m.maze[y + 1][x] == 1) {
                    System.out.println("moved down");
                    m.path.push(new Position(y + 1, x));
                    continue;
                }
            }
            // up
            if(y-1 >= 0) {
                if (m.maze[y - 1][x] == 2) {
                    System.out.println("moved up");
                    return true;
                } else if (m.maze[y - 1][x] == 1) {
                    System.out.println("moved up");
                    m.path.push(new Position(y - 1, x));
                    continue;
                }
            }
            // right
            if (x+1 <= m.maze[0].length-1) {
                if (m.maze[y][x + 1] == 2) {
                    System.out.println("moved right");
                    return true;
                } else if (m.maze[y][x + 1] == 1) {
                    System.out.println("moved right");
                    m.path.push(new Position(y, x + 1));
                    continue;
                }
            }
            // dead end
            m.path.pop();
            System.out.println("moved back");
            if(m.path.size() <= 0) {
                return false;
            }
        }
    }

}
