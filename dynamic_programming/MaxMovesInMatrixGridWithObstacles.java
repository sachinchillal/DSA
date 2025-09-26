package dynamic_programming;

import helper.Logger;
import helper.TestCaseArray;

public class MaxMovesInMatrixGridWithObstacles {

  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[][] { { 0 } }, 1),
      new TestCaseArray(new int[][] { { 1 } }, 0),
      new TestCaseArray(new int[][] { { 0, 0 } }, 2),
      new TestCaseArray(new int[][] { { 0, 1 } }, 1),
      new TestCaseArray(new int[][] { { 0, 0, 1 } }, 2),

      new TestCaseArray(new int[][] { { 0, 1, 0 } }, 1),
      new TestCaseArray(new int[][] { { 1, 0, 0 } }, 0),

      new TestCaseArray(new int[][] { { 0, 0 }, { 1, 1 } }, 2),
      new TestCaseArray(new int[][] { { 0, 0, 1 }, { 1, 0, 0 }, { 1, 0, 0 } }, 5),
      new TestCaseArray(new int[][] { { 0, 0, 1 }, { 1, 0, 0 }, { 1, 0, 1 } }, 4),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = longestPathInGrid(testCase.A_2Array);
      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  /**
   * Find the maximum numbers of move can be made start from 0,0
   * Move only right or down
   * 0 indicates empty space
   * 1 indicates obstacle or wall, can't make a move
   * 
   * @param A
   * @return
   */
  static int longestPathInGrid(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;

    // If starting cell is blocked
    if (grid[0][0] == 1)
      return 0;

    // DP table to store max moves to each cell
    int[][] dp = new int[rows][cols];
    dp[0][0] = 1; // Start from (0,0)

    // Fill first row
    for (int j = 1; j < cols; j++) {
      if (grid[0][j] == 0 && dp[0][j - 1] > 0) {
        dp[0][j] = dp[0][j - 1] + 1;
      }
    }

    // Fill first column
    for (int i = 1; i < rows; i++) {
      if (grid[i][0] == 0 && dp[i - 1][0] > 0) {
        dp[i][0] = dp[i - 1][0] + 1;
      }
    }

    // Fill rest of the grid
    for (int i = 1; i < rows; i++) {
      for (int j = 1; j < cols; j++) {
        if (grid[i][j] == 0) {
          int fromTop = dp[i - 1][j];
          int fromLeft = dp[i][j - 1];
          if (fromTop > 0 || fromLeft > 0) {
            dp[i][j] = Math.max(fromTop, fromLeft) + 1;
          }
        }
      }
    }

    // Find the maximum reachable cell
    int maxMoves = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        maxMoves = Math.max(maxMoves, dp[i][j]);
      }
    }
    Logger.log(dp);

    return maxMoves;
  }

}
