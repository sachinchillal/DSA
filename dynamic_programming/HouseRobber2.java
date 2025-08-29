package dynamic_programming;

import java.util.Arrays;

import helper.TestCaseArray;

public class HouseRobber2 {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[][] { { 1 }, { 1 } }, 1),
      new TestCaseArray(new int[][] { { 1 }, { 3 } }, 3),
      new TestCaseArray(new int[][] { { 1, 2 }, { 2, 1 } }, 2),
      new TestCaseArray(new int[][] { { 1, 2 }, { 3, 4 } }, 4),
      new TestCaseArray(new int[][] { { 1, 2, 3 }, { 3, 2, 1 } }, 6),

      new TestCaseArray(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }, 10),
      new TestCaseArray(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } }, 14),
      new TestCaseArray(new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 } }, 24),
      new TestCaseArray(new int[][] { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 } }, 30),
      new TestCaseArray(new int[][] { { 1, 2, 3, 4, 5, 6 }, { 6, 5, 4, 3, 2, 1 } }, 16),
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = maxPossibleStolenValue(testCase.A_2Array);
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
   * Choose the maximum stolen value from the 2D array.
   * Cannot rob adjacent houses
   * - including vertical
   * - including horizontal
   * - including diagonals
   * 
   * @param A
   * @return
   */
  static int maxPossibleStolenValue(int[][] A) {
    int n = A[0].length;

    // Handle the base case for an empty grid
    if (n == 0) {
      return 0;
    }

    // We can create a 1D array from the 2D grid,
    // where each element is the maximum of the two elements in that column.
    int[] columnMax = new int[n];
    for (int i = 0; i < n; i++) {
      columnMax[i] = Math.max(A[0][i], A[1][i]);
    }

    // dp[i] will store the maximum sum considering the first i elements of
    // columnMax
    int[] dp = new int[n];

    // Base cases
    dp[0] = columnMax[0];

    if (n > 1) {
      dp[1] = Math.max(columnMax[0], columnMax[1]);
    }

    // Fill the DP table
    for (int i = 2; i < n; i++) {
      // Recurrence relation:
      // Case 1: Don't include the current element (columnMax[i]), so the max sum is
      // dp[i-1]
      // Case 2: Include the current element, so the max sum is columnMax[i] + dp[i-2]
      dp[i] = Math.max(dp[i - 1], columnMax[i] + dp[i - 2]);
    }
    // System.out.println(Arrays.toString(dp));

    return dp[n - 1];
  }

}
