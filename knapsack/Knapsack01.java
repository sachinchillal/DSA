package knapsack;

import java.util.Arrays;

public class Knapsack01 {

  public static int knapsack01Tabulation(int[] P, int[] W, int C) {
    int n = P.length;
    int[][] dp = new int[n + 1][C + 1];

    // Build the DP table in a bottom-up manner
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= C; j++) {
        int pick = 0;

        int k = i - 1;
        int w = W[k];
        // Pick ith item if it does not exceed the capacity of knapsack
        if (w <= j)
          pick = P[k] + dp[k][j - w];

        // Don't pick the ith item
        int notPick = dp[k][j];

        // Store the maximum of picking and not picking the ith item
        dp[i][j] = Math.max(pick, notPick);
      }
    }

    // The maximum value that can be obtained with capacity C is in dp[n][C]
    return dp[n][C];
  }

  /**
   * 01 Knapsack Problem using Tabulation (Bottom-Up DP)
   * Without using extra variable
   * 
   * @param P
   * @param W
   * @param C
   * @return
   */
  public static int knapsack01Tabulation2(int[] P, int[] W, int C) {
    int n = P.length;
    int[][] dp = new int[n + 1][C + 1];

    // Build the DP table in a bottom-up manner
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= C; j++) {
        int pick = 0;

        // Pick ith item if it does not exceed the capacity of knapsack
        if (W[i - 1] <= j)
          pick = P[i - 1] + dp[i - 1][j - W[i - 1]];

        // Don't pick the ith item
        int notPick = dp[i - 1][j];

        // Store the maximum of picking and not picking the ith item
        dp[i][j] = Math.max(pick, notPick);
      }
    }

    // The maximum value that can be obtained with capacity C is in dp[n][C]
    return dp[n][C];
  }

  int knapsack01Property(int[] P, int[] W, int C) {
    int n = P.length;
    int[][] dp = new int[n + 1][C + 1];
    for (int[] a : dp) {
      Arrays.fill(a, -1);
    }
    return knapsackMaxProfit(P, W, C, n, dp);
  }

  int knapsackMaxProfit(int[] P, int[] W, int C, int n, int[][] dp) {
    // Base Case
    if (n == 0 || C == 0)
      return 0;

    // Check if we have previously calculated the same subproblem
    if (dp[n][C] != -1)
      return dp[n][C];

    int pick = 0;

    // Pick nth item if it does not exceed the capacity of knapsack
    if (W[n - 1] <= C)
      pick = P[n - 1] + knapsackMaxProfit(P, W, C - W[n - 1], n - 1, dp);

    // Don't pick the nth item
    int notPick = knapsackMaxProfit(P, W, C, n - 1, dp);

    // Store the result in memo[n][W] and return it
    return dp[n][C] = Math.max(pick, notPick);
  }
}
