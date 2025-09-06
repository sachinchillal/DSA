package knapsack;

import java.util.Arrays;

public class Knapsack01 {
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
