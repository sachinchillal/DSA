package knapsack;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

  static class ItemComparator implements Comparator<int[]> {
    public int compare(int[] a, int[] b) {
      double a1 = (1.0 * a[0] / a[1]);
      double b1 = (1.0 * b[0] / b[1]);
      // return Double.compare(a1, b1);
      return Double.compare(b1, a1); // sort by descending order
    }
  }

  double knapsackDivisibleItems(int[] P, int[] W, int C) {
    int n = P.length;
    int[][] items = new int[n][2];

    for (int i = 0; i < items.length; i++) {
      items[i][0] = P[i];
      items[i][1] = W[i];
    }
    Arrays.sort(items, new ItemComparator());

    double R = 0.0;
    int currentCapacity = C;
    for (int i = 0; i < items.length; i++) {
      if (items[i][1] <= currentCapacity) {
        R += items[i][0];
        currentCapacity -= items[i][1];
      } else {
        R += (1.0 * items[i][0]) / items[i][1];
        // currentCapacity = 0; // optional
        break;
      }
    }
    return R;
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
