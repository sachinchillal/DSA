package dynamic_programming;

import java.util.Arrays;

import helper.TestCaseArray;

public class HouseRobber {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, 0),
      new TestCaseArray(new int[] { 1 }, 1),
      new TestCaseArray(new int[] { 1, 2 }, 2),
      new TestCaseArray(new int[] { 2, 1 }, 2),
      new TestCaseArray(new int[] { 1, 2, 3 }, 4),

      new TestCaseArray(new int[] { 1, 2, 3, 4 }, 6),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 9),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 12),
      new TestCaseArray(new int[] { 1, 2, -3, 3, 4, -4 }, 6),
      new TestCaseArray(new int[] { 1, -1, 2, -2, 3, -3 }, 6),

      new TestCaseArray(new int[] { 4, -2, -2, 4 }, 8),
      new TestCaseArray(new int[] { -1, -1, -1, -1 }, 0),
      new TestCaseArray(new int[] { 0, 0, 0 }, 0),
      new TestCaseArray(new int[] { 5, -5, 10, -10 }, 15),
      new TestCaseArray(new int[] { 1, 2, 3, 5, 4 }, 8),
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      // int result = maxPossibleStolenValue(testCase.A);
      // int result = maxLoot( testCase.A);
      int result = maxLoot2(testCase.A);
      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  static int maxLoot(int[] A) {
    int n = A.length;
    if (n < 1) {
      return 0;
    }
    int[] dp = new int[n + 1];

    if (A[0] > 0) {
      dp[1] = A[0];
    }

    for (int i = 2; i <= n; i++) {
      dp[i] = Math.max(dp[i - 1], A[i - 1] + dp[i - 2]);
    }
    // Important to visualize the DP array
    // System.out.println(Arrays.toString(dp));

    return dp[n];
  }

  static int maxLoot2(int[] A) {
    int n = A.length;
    if (n == 0) {
      return 0;
    }
    int[] dp = new int[n];
    Arrays.fill(dp, -1);
    // i can be 0
    // if i is n then logic changes
    return maxLootAtIRecursion(0, A, dp);
  }

  static int maxLootAtIRecursion(int i, int[] A, int[] dp) {
    if (i >= A.length) {
      return 0;
    }
    if (dp[i] != -1) {
      return dp[i];
    }
    int lootNextHouse = maxLootAtIRecursion(i + 1, A, dp);
    int lootCurrentHouseAnd2nd = maxLootAtIRecursion(i + 2, A, dp) + A[i];
    dp[i] = Math.max(lootNextHouse, lootCurrentHouseAnd2nd);
    return dp[i];
  }

  static int maxPossibleStolenValue(int[] A) {
    int n = A.length;
    if (n == 0)
      return 0;
    if (n == 1)
      return Math.max(0, A[0]);

    int[] dp = new int[n];
    dp[0] = Math.max(0, A[0]);
    dp[1] = Math.max(dp[0], A[1]);

    for (int i = 2; i < n; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + A[i]);
    }
    return dp[n - 1];
  }

}
