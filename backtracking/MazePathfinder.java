package backtracking;

import helper.TestCaseArray;

public class MazePathFinder {

  static TestCaseArray[] TestCases = {
      // new TestCaseArray(new int[][] {}, new int[] {}, new int[] {}, -1),
      new TestCaseArray(new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } },
          new int[] { 0, 0 }, new int[] { 0, 0 }, 0),
      new TestCaseArray(new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } },
          new int[] { 0, 0 }, new int[] { 0, 1 }, 1),
      new TestCaseArray(new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } },
          new int[] { 0, 0 }, new int[] { 0, 2 }, 2),
      new TestCaseArray(new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } },
          new int[] { 0, 0 }, new int[] { 1, 1 }, 2),
      new TestCaseArray(new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } },
          new int[] { 0, 0 }, new int[] { 2, 1 }, 3),
      new TestCaseArray(new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } },
          new int[] { 0, 0 }, new int[] { 2, 2 }, 4),

      new TestCaseArray(new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } },
          new int[] { 0, 0 }, new int[] { 0, 0 }, 0),
      new TestCaseArray(new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } },
          new int[] { 0, 0 }, new int[] { 0, 1 }, 1),
      new TestCaseArray(new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } },
          new int[] { 0, 0 }, new int[] { 0, 2 }, 2),
      new TestCaseArray(new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } },
          new int[] { 0, 0 }, new int[] { 1, 1 }, -1),
      new TestCaseArray(new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } },
          new int[] { 0, 0 }, new int[] { 2, 1 }, 3),
      new TestCaseArray(new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } },
          new int[] { 0, 0 }, new int[] { 2, 2 }, 4),

      new TestCaseArray(new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } },
          new int[] { 0, 0 }, new int[] { 1, 2 }, 3), // if no hurdles
      new TestCaseArray(new int[][] { { 1, 1, 0 }, { 1, 0, 1 }, { 1, 1, 1 } },
          new int[] { 0, 0 }, new int[] { 1, 2 }, 5), // if hurdles
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = findShortestPath(testCase.Matrix, testCase.A, testCase.A2);
      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  // Variable to store the length of the shortest path found
  static int minPath = Integer.MAX_VALUE;

  /**
   * Finds the shortest path in a binary maze from source to destination.
   *
   * @param grid The m x n matrix representing the maze (1 is path, 0 is hurdle).
   * @param src  The source coordinates {row, col}.
   * @param dest The destination coordinates {row, col}.
   * @return The length of the shortest path, or -1 if no path exists.
   */
  static int findShortestPath(int[][] M, int[] src, int[] dest) {
    minPath = Integer.MAX_VALUE;
    if (M == null || M.length == 0 || M[0].length == 0) {
      return -1;
    }

    int rows = M.length;
    int cols = M[0].length;

    // Check if source or destination is a hurdle
    if (M[src[0]][src[1]] == 0 || M[dest[0]][dest[1]] == 0) {
      return -1;
    }

    // A 'visited' matrix to keep track of cells in the current path
    boolean[][] visited = new boolean[rows][cols];

    // Start the backtracking process from the source cell
    findPath(M, src[0], src[1], dest, visited, 0);

    // Return the result
    return minPath == Integer.MAX_VALUE ? -1 : minPath;
  }

  /**
   * The recursive backtracking function.
   *
   * @param grid          The maze.
   * @param r             Current row.
   * @param c             Current column.
   * @param dest          Destination coordinates.
   * @param visited       2D array to mark visited cells for the current path.
   * @param currentLength The length of the path taken so far.
   */
  static void findPath(int[][] M, int r, int c, int[] dest, boolean[][] visited, int currentLength) {
    int rows = M.length;
    int cols = M[0].length;
    // Base Case 1: Out of bounds, is a hurdle, or already visited in this path
    if (r < 0 || r >= rows || c < 0 || c >= cols || M[r][c] == 0 || visited[r][c]) {
      return;
    }

    // Pruning: If the current path is already longer than the shortest path found,
    // stop exploring
    if (currentLength >= minPath) {
      return;
    }

    // Base Case 2: Destination is reached
    if (r == dest[0] && c == dest[1]) {
      // Update the minimum path length
      minPath = Math.min(minPath, currentLength);
      return;
    }

    // Mark the current cell as visited
    visited[r][c] = true;

    /**
     * Draw Direction Diagram to visualize the pathfinding process.
     * __________________ R - 1 , C (Up)
     * ________________________^
     * ________________________|
     * R, C - 1 (Left) <---- R, C ----> R, C + 1 (Right)
     * ________________________|
     * ________________________v
     * __________________ R + 1, C (Down)
     */
    // Recur for all 4 possible movements (Up, Down, Left, Right)
    findPath(M, r - 1, c, dest, visited, currentLength + 1); // Up
    findPath(M, r + 1, c, dest, visited, currentLength + 1); // Down
    findPath(M, r, c - 1, dest, visited, currentLength + 1); // Left
    findPath(M, r, c + 1, dest, visited, currentLength + 1); // Right

    // Backtrack: Unmark the current cell to allow it to be part of other paths
    visited[r][c] = false;
  }

}