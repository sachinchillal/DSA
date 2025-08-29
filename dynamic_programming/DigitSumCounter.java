package dynamic_programming;

import helper.TestCaseArray;

public class DigitSumCounter {

  static TestCaseArray[] TestCases = {
      new TestCaseArray(1, 3, 1),
      new TestCaseArray(2, 1, 1),
      new TestCaseArray(2, 2, 2),
      new TestCaseArray(2, 3, 3),
      new TestCaseArray(2, 4, 4),
      new TestCaseArray(2, 5, 5),
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = countSpecialNumberWithDigitsSum(testCase.M, testCase.N);
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
   * Digit Sum Counter
   * OR
   * Number Partitioning
   *
   * Number of n positive numbers / digits
   * whose digits sum has to be given SUM
   * 
   * @param n
   * @param sum
   * @return
   */
  static int countSpecialNumberWithDigitsSum(int n, int sum) {

    // dp[i][j] stores the number of i-digit numbers with digit sum j.
    int[][] dp = new int[n + 1][sum + 1];

    // Base case: for 1 digit, the number of ways to get a sum j is 1,
    // as long as j is between 1 and 9. Leading zeros are not allowed.

    // Initialize for 1-digit numbers (first digit can't be 0)
    for (int j = 1; j <= 9 && j <= sum; j++) {
      dp[1][j] = 1;
    }
    // System.out.println(Arrays.deepToString(dp));

    // Fill the DP table for A digits and sum B
    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= sum; j++) {
        // The current digit can be 0 to 9.
        // We sum up the counts from the previous state (i-1 digits)
        // for all possible last digits (0 to 9).
        for (int k = 0; k <= 9; k++) {
          if (j - k >= 0) {
            dp[i][j] = dp[i][j] + dp[i - 1][j - k];
          }
        }
      }
    }
    // System.out.println(Arrays.deepToString(dp));
    return dp[n][sum];
  }
}