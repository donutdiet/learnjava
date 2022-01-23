package com.learnjava.mazesolver;

public class MazeSolver3 {
    public static void main(String[] args) {

        Maze m = MazeGenerator.generateMaze();
        System.out.println(m);
        if (solveMaze(m) == false) {
            System.out.println("no path");
        } else {
            System.out.println("you won");
        }
    }

    private static boolean solveMaze(Maze m) {
        Position p = m.start;
        m.path.push(p);

        while (true) {
            int y = m.path.peek().y;
            int x = m.path.peek().x;
            m.maze[y][x] = 0;

            // left
            if (x - 1 >= 0) {
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
            if (y + 1 <= m.maze.length - 1) {
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
            if (y - 1 >= 0) {
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
            if (x + 1 <= m.maze[0].length - 1) {
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
            if (m.path.size() <= 0) {
                return false;
            }
        }
    }
}
