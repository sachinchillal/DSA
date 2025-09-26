package dynamic_programming;

import helper.Logger;
import helper.TestCaseArray;

public class MaxPathSumInMatrixGrid {

  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[][] { { 0 } }, 0),
      new TestCaseArray(new int[][] { { 1 } }, 1),
      new TestCaseArray(new int[][] { { 0, 0 } }, 0),
      new TestCaseArray(new int[][] { { 0, 1 } }, 1),
      new TestCaseArray(new int[][] { { 0, 0, 1 } }, 1),

      new TestCaseArray(new int[][] { { 0, 1, 0 } }, 1),
      new TestCaseArray(new int[][] { { 1, 0, 0 } }, 1),

      new TestCaseArray(new int[][] { { 0, 1 }, { 1, 1 } }, 2),
      new TestCaseArray(new int[][] { { 1, 1 }, { 1, 1 } }, 3),
      new TestCaseArray(new int[][] { { 0, 0, 1 }, { 1, 0, 0 }, { 1, 0, 0 } }, 2),
      new TestCaseArray(new int[][] { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } }, 21),
      new TestCaseArray(new int[][] { { 1, 2, 3 }, { 4, 2, 5 }, { 7, 8, 9 } }, 29),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = maxPathSumInGrid(testCase.A_2Array);
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
   * Find the maximum path sum can be made start from 0,0
   * Move only right or down
   * M[i][j] indicates value at cell (i,j)
   * 
   * @param A
   * @return
   */
  static int maxPathSumInGrid(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;

    // DP table to store max moves to each cell
    int[][] dp = new int[rows][cols];
    dp[0][0] = grid[0][0]; // Start from (0,0)

    // Fill first row
    for (int j = 1; j < cols; j++) {
      dp[0][j] = dp[0][j - 1] + grid[0][j];
    }

    // Fill first column
    for (int i = 1; i < rows; i++) {
      dp[i][0] = dp[i - 1][0] + grid[i][0];
    }

    // Fill rest of the grid
    for (int i = 1; i < rows; i++) {
      for (int j = 1; j < cols; j++) {
        int fromTop = dp[i - 1][j];
        int fromLeft = dp[i][j - 1];
        dp[i][j] = Math.max(fromTop, fromLeft) + grid[i][j];

        // If diagonal moves are allowed
        // int diagonal = dp[i - 1][j - 1]; // diagonal move
        // dp[i][j] = Math.max(dp[i][j], diagonal + grid[i][j]);
      }
    }

    // Logger.log(dp);

    return dp[rows - 1][cols - 1];
  }

}
