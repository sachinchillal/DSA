package knapsack;

public class CoinChangeOnce {

  public static int countCombinations(int[] coins, int sum) {
    int n = coins.length;
    int[][] dp = new int[n + 1][sum + 1];

    // Base case: one way to make sum 0 (choose nothing)
    for (int i = 0; i <= n; i++) {
      dp[i][0] = 1;
    }

    // Build the DP table
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= sum; j++) {
        // Exclude current coin: No pick
        dp[i][j] = dp[i - 1][j];

        // Include current coin if it doesn't exceed the sum
        if (coins[i - 1] <= j) {
          // Pick
          dp[i][j] += dp[i - 1][j - coins[i - 1]];
        }
      }
    }

    return dp[n][sum];
  }

  public static int countWays(int[] coins, int target) {
    int n = coins.length;
    int[][] dp = new int[n + 1][target + 1];

    // Base case: one way to make sum 0 (choose nothing)
    for (int i = 0; i <= n; i++) {
      dp[i][0] = 1;
    }

    // Fill the DP table
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= target; j++) {
        if (j >= coins[i - 1]) {
          // Include the coin (only once) + exclude the coin
          dp[i][j] = dp[i - 1][j - coins[i - 1]] + dp[i - 1][j];
        } else {
          // Exclude the coin
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return dp[n][target];
  }

}
