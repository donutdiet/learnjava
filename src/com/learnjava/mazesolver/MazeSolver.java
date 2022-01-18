package com.learnjava.mazesolver;

import java.util.ArrayList;
import java.util.LinkedList;

public class MazeSolver {

    public static void main(String[] args)  {

        ArrayList<Maze> mazes = new ArrayList<Maze>();

        //0 wall
        //1 path
        //2 destination
        Maze m = new Maze();
        m.maze = new int[][]{
                {2, 0, 0, 1},
                {1, 1, 1, 1},
                {0, 1, 0, 1}
        };
        m.path = new LinkedList<Position>();
        m.start = new Position(2, 2);
        mazes.add(m);

        Maze n = new Maze();
        n.maze = new int[][]{
                {2, 0, 0, 1},
                {1, 1, 1, 1},
                {0, 1, 0, 1}
        };
        n.path = new LinkedList<Position>();
        n.start = new Position(2, 2);
        mazes.add(n);

        for(int i=0; i<mazes.size();  i++) {
            if(solveMaze(mazes.get(i))==false) {
                System.out.println("no path");
            } else {
                System.out.println("you won");
            }
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
            if(m.path.size() <= 0) {;
                return false;
            }
        }
    }

}
