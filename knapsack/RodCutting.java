package knapsack;

import helper.TestCaseArray;

public class RodCutting {

  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] { 1 }, 1),
      new TestCaseArray(new int[] { 2 }, 2),
      new TestCaseArray(new int[] { 3 }, 3),
      new TestCaseArray(new int[] { 1, 3 }, 3),
      new TestCaseArray(new int[] { 2, 3 }, 4),

      new TestCaseArray(new int[] { 3, 1 }, 6),
      new TestCaseArray(new int[] { 2, 3, 1, 2 }, 8),
      new TestCaseArray(new int[] { 2, 3, 1, 5, 6 }, 10),
      new TestCaseArray(new int[] { 0, 4, 1, 4, 5 }, 8),
      new TestCaseArray(new int[] { 2, 3, 0, 5, 2 }, 10),
      new TestCaseArray(new int[] { 1, 5, 6, 7, 3, 2 }, 15),

      new TestCaseArray(new int[] { 1, 5, 6, 7, 3, 8, 9, 10, 2 }, 21),
      new TestCaseArray(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }, 6),
      new TestCaseArray(new int[] { 1, 1, 3, 2, 1, 2, 5, 3, 2, 1, 4, 2 }, 12),
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] A = testCase.A;
      int expected = testCase.R;
      int result = maxProfitOnRodCutting(A);
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
   * Finds the maximum value that can be obtained by cutting a rod of length N.
   *
   * O(N^2) time complexity and O(N) space complexity.
   *
   * @param A An array of size N where A[i] is the price of a rod piece of length
   *          i+1.
   * @return The maximum value obtainable.
   */
  public static int maxProfitOnRodCutting(int[] A) {
    int N = A.length;
    int[] dp = new int[N + 1];

    // Base case: a rod of length 0 has a value of 0.
    dp[0] = 0;

    // Populate the DP table for rod lengths from 1 to N.
    for (int i = 1; i <= N; i++) {
      int maxVal = Integer.MIN_VALUE;

      // For each length 'i', consider all possible cuts.
      // A cut of length 'j' (where 1 <= j <= i) can be made,
      // and the remaining length 'i-j' can be further cut.
      for (int j = 1; j <= i; j++) {
        // The price of a piece of length 'j' is A[j-1].
        // The value of the remaining part of length 'i-j' is dp[i-j].
        maxVal = Math.max(maxVal, A[j - 1] + dp[i - j]);
      }
      dp[i] = maxVal;
    }

    return dp[N];
  }

}
