package icamp.cRecursionMemoization.ic18easyMaze;

public class RecursiveWithoutMemo {
    static boolean pathExistsIn(int[][] maze, Logging log) {
        if (maze == null || maze.length == 0) {
            return false;
        }
        return recursivePathfinder(maze, 0, 0);
    }

    private static boolean recursivePathfinder(int[][] maze, int row, int col) {
        int height = maze.length;
        int width = maze[0].length;
        if (outOfBounds(row, col, height, width) || maze[row][col] == 1) {
            return false;
        }

        if (row == height - 1 && col == width - 1 && maze[row][col] == 0) {
            return true;
        }

        return recursivePathfinder(maze,row + 1, col)
                || recursivePathfinder(maze, row, col + 1);
    }

    private static boolean outOfBounds(int row, int col, int rowLimit, int colLimit) {
        return row == rowLimit || col == colLimit;
    }
}
