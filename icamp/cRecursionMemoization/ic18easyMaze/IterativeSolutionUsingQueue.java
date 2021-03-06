package icamp.cRecursionMemoization.ic18easyMaze;

// You are given a 2D array that represents a maze. It can have 2 values - 0 and 1.
// 1 represents a wall in the maze and 0 represents a path. The objective of the maze
// is to reach the bottom right corner, or A[A.length-1][A.length-1].
// You start from A[0][0] and can only go right or down. Find if a path exists
// to the bottom right of the maze from A[0][0]. For e.g, 2 paths exist in the following maze:
// 0 1 1 1 
// 0 0 0 1
// 1 0 0 0
// 1 1 1 0

import java.util.*;

class IterativeSolutionUsingQueue {
    static boolean pathExistsIn(int[][] maze, Logging log) {
        if (maze == null) {
            return false;
        }
        Queue<Coordinate> bookmarks = new LinkedList<>();
        Set<Coordinate> explored = new HashSet<>();
        int height = maze.length;
        int width = maze[0].length;
        int posX = 0;
        int posY = 0;
        int iterations = 0;
        boolean foundExit = false;
        while (true) {
            iterations++;
            explored.add(new Coordinate(posX, posY));
            if (log == Logging.FULL)
                System.out.println(posX + " " + posY);
            // standing on exit tile
            if (posX == height - 1 && posY == width - 1) {
                // last check required for an edge case
                // where the maze is 1x1 and it's a wall
                // замуровали демоны!!!
                foundExit = maze[posX][posY] == 0;
                break;
            }
            // right next to exit tile and it's a wall
            if (posX == height - 2 && posY == width - 1 && maze[posX + 1][posY] == 1
            || posX == height - 1 && posY == width - 2 && maze[posX][posY + 1] == 1) {
                break;
            }

            if (posY + 1 == width || maze[posX][posY + 1] == 1) {
                if (posX + 1 == height || maze[posX + 1][posY] == 1) {
                    // blocked on both right and down - time to start backtracking
                    Coordinate next = bookmarks.poll();
                    while (explored.contains(next)) {
                        next = bookmarks.poll();
                    }
                    if (next == null) {
                        break;
                    } else {
                        posX = next.getX();
                        posY = next.getY();
                    }
                } else {
                    posX++; // the path down is free = take it
                }
            } else {
                if (posX + 1 < height && maze[posX + 1][posY] == 0) {
                    // when both paths right and down are available
                    // save coords of right tile for later if you get stuck
                    bookmarks.add(new Coordinate(posX + 1, posY));
                }
                posY++; // the path right is free = take it, takes priority over down
            }
        }

        if (log == Logging.FULL)
            System.out.println("Took " + iterations + " turns.");
        return foundExit;
    }
}
