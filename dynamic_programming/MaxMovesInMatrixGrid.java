package dynamic_programming;

import helper.TestCaseArray;

public class MaxMovesInMatrixGrid {

  static TestCaseArray[] TestCases = {
      new TestCaseArray(1, 1, 0),
      new TestCaseArray(1, 2, 1),
      new TestCaseArray(1, 3, 2),
      new TestCaseArray(2, 1, 1),
      new TestCaseArray(2, 2, 2),
      new TestCaseArray(2, 3, 3),
      new TestCaseArray(2, 4, 4),
      new TestCaseArray(2, 5, 5),
      new TestCaseArray(3, 3, 4),
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = longestPathInTheGrid(testCase.M, testCase.N);
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
   * Find the maximum number of moves that can be made starting from (0,0)
   * Only moves allowed are right or down
   * No obstacles in the matrix
   *
   * @param m number of rows
   * @param n number of columns
   * @return maximum number of moves using DP
   */
  static int longestPathInTheGrid(int m, int n) {
    // Create a DP table to store the number of moves to reach each cell
    int[][] dp = new int[m][n];

    // Initialize the starting point
    dp[0][0] = 0;

    // Fill the first row and first column
    for (int i = 1; i < m; i++) {
      dp[i][0] = dp[i - 1][0] + 1;
    }
    for (int j = 1; j < n; j++) {
      dp[0][j] = dp[0][j - 1] + 1;
    }

    // Fill the rest of the table
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + 1;
      }
    }

    // The bottom-right cell contains the longest path length
    return dp[m - 1][n - 1];
  }

  /**
   * Find the maximum number of moves that can be made starting from (0,0)
   * Only moves allowed are right or down
   * No obstacles in the matrix
   *
   * @param m number of rows
   * @param n number of columns
   * @return maximum number of moves
   */
  static int longestPathInTheGrid2(int m, int n) {
    if (m <= 0 || n <= 0) {
      return 0; // Invalid grid dimensions
    }
    return m + n - 2;
  }

}
