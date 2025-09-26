package dynamic_programming;

import helper.TestCaseArray;

public class UniquePathsGrid {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(1, 3, 1),
      new TestCaseArray(2, 1, 1),
      new TestCaseArray(2, 2, 2),
      new TestCaseArray(2, 3, 3),
      new TestCaseArray(2, 4, 4),
      new TestCaseArray(2, 5, 5),
      new TestCaseArray(3, 3, 6),
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = uniquePathsWithoutObstacles(testCase.M, testCase.N);
      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  static int uniquePathsWithoutObstacles(int m, int n) {
    int[][] dp = new int[m][n];

    // Initialize the first row
    for (int j = 0; j < n; j++) {
      dp[0][j] = 1;
    }

    // Initialize the first column
    for (int i = 0; i < m; i++) {
      dp[i][0] = 1;
    }

    // Fill the DP table
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    // Logger.log(dp);
    return dp[m - 1][n - 1];
  }

}
