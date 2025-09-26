package dynamic_programming;

import helper.TestCaseArray;

public class UniquePathsWithObstacles {

  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[][] { { 0, 0, 0 } }, 1),
      new TestCaseArray(new int[][] { { 0, 0 }, { 0, 0 } }, 2),
      new TestCaseArray(new int[][] { { 0, 0 }, { 0, 0 }, { 0, 0 } }, 3),
      new TestCaseArray(new int[][] { { 0 } }, 1),
      new TestCaseArray(new int[][] { { 0, 0 } }, 1),
      new TestCaseArray(new int[][] { { 1 } }, 0),
      new TestCaseArray(new int[][] { { 0, 1 }, { 0, 0 } }, 1),
      new TestCaseArray(new int[][] { { 0, 0 }, { 1, 0 } }, 1),
      new TestCaseArray(new int[][] { { 0, 0 }, { 0, 1 }, { 0, 0 } }, 1),
      new TestCaseArray(new int[][] { { 0, 0 }, { 1, 0 }, { 0, 0 } }, 1),
      new TestCaseArray(new int[][] { { 0, 1 }, { 0, 0 }, { 0, 0 } }, 2),
      new TestCaseArray(new int[][] { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }, 3),
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = uniquePathsWithObstacles(testCase.A_2Array);
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
   * 1 = Obstacle
   * 0 = Empty cell
   * 
   * @param A
   * @return
   */
  public static int uniquePathsWithObstacles(int[][] A) {
    int m = A.length;
    int n = A[0].length;

    // If the start or end point is an obstacle, there are no paths.
    if (A[0][0] == 1 || A[m - 1][n - 1] == 1) {
      return 0;
    }

    int[][] dp = new int[m][n];

    // Initialize the first row
    for (int j = 0; j < n; j++) {
      if (A[0][j] == 0) {
        dp[0][j] = 1;
      } else {
        // If an obstacle is encountered, the rest of the path is blocked.
        break;
      }
    }

    // Initialize the first column
    for (int i = 0; i < m; i++) {
      if (A[i][0] == 0) {
        dp[i][0] = 1;
      } else {
        // If an obstacle is encountered, the rest of the path is blocked.
        break;
      }
    }

    // Fill the DP table
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (A[i][j] == 0) {
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        } else {
          dp[i][j] = 0;
        }
      }
    }
    return dp[m - 1][n - 1];
  }

}
