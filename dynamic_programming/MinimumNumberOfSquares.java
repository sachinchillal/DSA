package dynamic_programming;

import java.util.Arrays;

public class MinimumNumberOfSquares {
  /**
   * Using Dynamic Programming Top-Down approach
   * 
   * @param n
   * @return
   */
  public int minimumNumberOfSquares(int n) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    return minSquaresRec(n, dp);
  }

  public static int minSquaresRec(int n, int[] dp) {
    // Base case
    if (n <= 3)
      return n;

    // If the result is already computed
    if (dp[n] != -1)
      return dp[n];

    // Initialize result
    int R = n;

    // Try every number i and see if it can form a square
    for (int i = 1; i * i <= n; i++) {
      R = Math.min(R, 1 + minSquaresRec(n - i * i, dp));
    }
    dp[n] = R;
    return R;
  }
}