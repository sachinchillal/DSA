package knapsack;

import java.util.Arrays;

public class CoinChange {
  public static void main(String[] args) {
    int[] coins = { 1, 2, 3, 4 };
    // int sum = 8;
    int sum = 5;
    System.out.println("Number of combinations to make sum " + sum + ": " + countCombinations(coins, sum));
  }

  // Function to count the number of combinations to make the given sum
  // O(N * S) time complexity and O(S) space complexity
  public static int countCombinations(int[] coins, int sum) {
    int[] dp = new int[sum + 1];

    // Base case: There is one way to make sum 0 (no coins)
    dp[0] = 1;

    // Iterate over each coin
    for (int coin : coins) {
      // Update dp[] for all sums from coin to target sum
      for (int j = coin; j <= sum; j++) {
        dp[j] += dp[j - coin];
        // System.out.print(j + " ");
      }
      // System.out.println();
      // System.out.println();
      // System.out.println(Arrays.toString(dp));
    }

    return dp[sum];
  }
}
