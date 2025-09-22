package greedy;

public class BestTimeToBuyAndSellStocks {

  public static int maxProfit(int[] prices) {
    if (prices == null || prices.length < 2)
      return 0;

    int minPrice = prices[0];
    int maxProfit = 0;

    for (int i = 1; i < prices.length; i++) {
      // Update minPrice if current price is lower
      if (prices[i] < minPrice) {
        minPrice = prices[i];
      } else {
        // Calculate profit if sold today
        int profit = prices[i] - minPrice;
        maxProfit = Math.max(maxProfit, profit);
      }
    }

    return maxProfit;
  }

}
