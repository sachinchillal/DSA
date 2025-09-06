package knapsack;

import java.util.Arrays;

public class UnboundedKnapsack {
  int knapsackRepetitionAllowed(int[] P, int[] W, int C) {
    int n = P.length;
    int[][] dp = new int[n + 1][C + 1];
    for (int[] a : dp) {
      Arrays.fill(a, -1);
    }
    // Pass i = 0 instead of n
    return knapsackMaxProfit(P, W, C, 0, dp);
  }

  int knapsackMaxProfit(int[] P, int[] W, int C, int i, int[][] dp) {
    // Base Case
    if (i == P.length || C == 0)
      return 0;

    // Check if we have previously calculated the same subproblem
    if (dp[i][C] != -1)
      return dp[i][C];

    int pick = 0;

    // Pick nth item if it does not exceed the capacity of knapsack
    if (W[i] <= C) {
      // no change in i
      pick = P[i] + knapsackMaxProfit(P, W, C - W[i], i, dp);
    }
    // Don't pick the nth item
    int notPick = knapsackMaxProfit(P, W, C, i + 1, dp);

    // Store the result in memo[n][W] and return it
    return dp[i][C] = Math.max(pick, notPick);
  }
}
