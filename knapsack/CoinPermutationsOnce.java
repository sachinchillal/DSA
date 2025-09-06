package knapsack;

public class CoinPermutationsOnce {
  public static int countPermutations(int[] coins, int sum) {
    boolean[] used = new boolean[coins.length];
    return backtrack(coins, sum, used);
  }

  private static int backtrack(int[] coins, int remaining, boolean[] used) {
    if (remaining == 0)
      return 1;
    int count = 0;

    for (int i = 0; i < coins.length; i++) {
      if (!used[i] && coins[i] <= remaining) {
        used[i] = true;
        count += backtrack(coins, remaining - coins[i], used);
        used[i] = false; // backtrack
      }
    }

    return count;
  }
}
