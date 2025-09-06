package greedy;

public class BestTimeToBuyAndSellStocksII {
  /**
   * Calculates the maximum profit from buying and selling a stock multiple times.
   *
   * @param A list of integers representing the stock prices on consecutive
   *          days.
   * @return The maximum possible profit.
   */
  public int maxProfit(int[] A) {
    int profit = 0;
    for (int i = 1; i < A.length; i++) {
      if (A[i] > A[i - 1]) {
        profit += A[i] - A[i - 1];
      }
    }
    return profit;
  }
}
