package dynamic_programming;

import helper.TestCaseArray;

public class MinMovesInMatrixGrid {

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : MaxMovesInMatrixGrid.TestCases) {
      int expected = testCase.R;
      int result = shortestPathInTheGrid(testCase.M, testCase.N);
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
   * Find the minimum number of moves that can be made starting from (0,0)
   * Only moves allowed are right or down
   * No obstacles in the matrix
   *
   * @param m number of rows
   * @param n number of columns
   * @return minimum number of moves using DP
   */
  static int shortestPathInTheGrid(int m, int n) {
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
        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
      }
    }
    // The bottom-right cell contains the minimum path length
    return dp[m - 1][n - 1];
  }

}
