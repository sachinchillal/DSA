package greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximizeProfitOnExpiringItems {

  class GroceryItem {
    int expirationTime;
    int profit;

    public GroceryItem(int expirationTime, int profit) {
      this.expirationTime = expirationTime;
      this.profit = profit;
    }
  }

  public int getMaxProfitOnExpiringProducts(ArrayList<Integer> A, ArrayList<Integer> B) {
    int n = A.size();
    ArrayList<GroceryItem> items = new ArrayList<>();
    long MOD = 1000000007;

    for (int i = 0; i < n; i++) {
      items.add(new GroceryItem(A.get(i), B.get(i)));
    }

    items.sort(Comparator.comparingInt(item -> item.expirationTime));

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    long totalProfit = 0;
    int currentTime = 0;

    for (GroceryItem item : items) {
      minHeap.add(item.profit);
      totalProfit = (totalProfit + item.profit) % MOD;
      currentTime++;

      if (currentTime > item.expirationTime) {
        int leastProfit = minHeap.poll();
        totalProfit = (totalProfit - leastProfit + MOD) % MOD;
        currentTime--;
      }
    }

    return (int) totalProfit;
  }
}
