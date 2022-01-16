package com.learnjava.mazesolver;

import java.util.LinkedList;

public class MazeSolver {

    static int [][] maze = {
            {2, 0, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
    };
    //0 wall
    //1 path
    //2 destination

    static LinkedList<Position> path = new LinkedList<Position>();

    public static void main(String[] args)  {
        if(solveMaze(new Position(0, 3))==false) {
            System.out.println("no path");
        } else {
            System.out.println("you won");
        }
    }

    private static boolean solveMaze(Position p) {
        path.push(p);

        while(true) {
            int y = path.peek().y;
            int x = path.peek().x;
            maze [y][x] = 0;

            // left
            if(x-1 >= 0) {
                if (maze[y][x - 1] == 2) {
                    System.out.println("moved left");
                    return true;
                } else if (maze[y][x - 1] == 1) {
                    System.out.println("moved left");
                    path.push(new Position(y, x - 1));
                    continue;
                }
            }
            // down
            if(y+1 <= maze.length-1) {
                if (maze[y + 1][x] == 2) {
                    System.out.println("moved down");
                    return true;
                } else if (maze[y + 1][x] == 1) {
                    System.out.println("moved down");
                    path.push(new Position(y + 1, x));
                    continue;
                }
            }
            // up
            if(y-1 >= 0) {
                if (maze[y - 1][x] == 2) {
                    System.out.println("moved up");
                    return true;
                } else if (maze[y - 1][x] == 1) {
                    System.out.println("moved up");
                    path.push(new Position(y - 1, x));
                    continue;
                }
            }
            // right
            if (x+1 <= maze[0].length-1) {
                if (maze[y][x + 1] == 2) {
                    System.out.println("moved right");
                    return true;
                } else if (maze[y][x + 1] == 1) {
                    System.out.println("moved right");
                    path.push(new Position(y, x + 1));
                    continue;
                }
            }
            // dead end
            path.pop();
            System.out.println("moved back");
            if(path.size() <= 0) {;
                return false;
            }
        }
    }

}
