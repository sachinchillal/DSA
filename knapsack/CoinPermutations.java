package knapsack;

public class CoinPermutations {

  public static int countPermutations(int[] coins, int sum) {
    int[] dp = new int[sum + 1];
    dp[0] = 1; // Base case: one way to make sum 0

    // Outer loop over all target sums
    for (int i = 1; i <= sum; i++) {
      // Inner loop over all coins
      for (int coin : coins) {
        if (coin <= i) {
          dp[i] += dp[i - coin];
        }
      }
    }

    return dp[sum];
  }

}
