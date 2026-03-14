/*
 * Time Complexity: O(4^(n*n)) in worst case
 *   - At each cell we may explore up to 4 directions
 *
 * Space Complexity: O(n*n)
 *   - For visited matrix + recursion stack
 *
 * Uses Backtracking to explore all possible paths from (0,0) to (n-1,n-1).
 */
import java.util.*;

class Solution {


    public ArrayList<String> ratInMaze(int[][] maze) {

        int n = maze.length;

        ArrayList<String> path = new ArrayList<>();

        // To track visited cells and avoid cycles
        boolean[][] visited = new boolean[n][n];

        String ans = "";

        helper(maze, 0, 0, ans, path, visited);

        return path;
    }

    public void helper(int[][] maze, int r, int c,
                       String ans,
                       ArrayList<String> path,
                       boolean[][] visited) {

        int n = maze.length;

        // Boundary check + blocked cell + already visited
        if (r < 0 || c < 0 || r >= n || c >= n ||
            maze[r][c] == 0 || visited[r][c]) {
            return;
        }

        // Destination reached
        if (r == n - 1 && c == n - 1) {
            path.add(ans);
            return;
        }

        // Mark current cell as visited
        visited[r][c] = true;

        // Explore all 4 directions
        helper(maze, r + 1, c, ans + "D", path, visited); // Down
        helper(maze, r, c - 1, ans + "L", path, visited); // Left
        helper(maze, r, c + 1, ans + "R", path, visited); // Right
        helper(maze, r - 1, c, ans + "U", path, visited); // Up

        // Backtrack: unmark the cell
        visited[r][c] = false;
    }
}