package knapsack;

import java.util.Arrays;

import helper.TestCaseArray;

public class IsExistSubsetSum {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] { 1, 2, 4, 3 }, 5, true),
      new TestCaseArray(new int[] { 1, 2, 4, 3 }, 8, true),
      new TestCaseArray(new int[] { 1, 2, 4, 3 }, 9, true),
      new TestCaseArray(new int[] { 1, 2, 4, 3 }, 10, true),
      new TestCaseArray(new int[] { 1, 2, 4, 3 }, 11, false),

      new TestCaseArray(new int[] { 2, 3, 1, 1 }, 4, true),
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      boolean expected = testCase.Rb;
      boolean result = isExistSubsetWithGivenSum(testCase.A, testCase.N);
      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  static boolean isExistSubsetWithGivenSum(int[] A, int sum) {
    int n = A.length;
    int[][] dp = new int[n + 1][sum + 1];

    for (int[] d : dp) {
      Arrays.fill(d, -1);
    }

    return isSubsetSum(A, sum, n, dp);
  }

  static boolean isSubsetSum(int[] A, int sum, int n, int[][] dp) {
    if (sum == 0) {
      return true;
    }
    if (n < 1) {
      return false;
    }
    if (dp[n][sum] != -1) {
      return dp[n][sum] == 1;
    }
    if ((A[n - 1] > sum)) {
      dp[n][sum] = isSubsetSum(A, sum, n - 1, dp) ? 1 : 0;
    } else {
      boolean notPick = isSubsetSum(A, sum, n - 1, dp);
      boolean pick = isSubsetSum(A, sum - A[n - 1], n - 1, dp);

      dp[n][sum] = (notPick || pick) ? 1 : 0;
    }
    return dp[n][sum] == 1;
  }

}
