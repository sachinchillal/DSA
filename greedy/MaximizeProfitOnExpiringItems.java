package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximizeProfitOnExpiringItems {

  public int getMaxProfitOnExpiringProducts(int[] P, int[] E) {
    int n = P.length;
    int[][] items = new int[n][2];
    for (int i = 0; i < n; i++) {
      items[i][0] = E[i];
      items[i][1] = P[i];
    }

    Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int totalProfit = 0;
    int currentTime = 0;

    for (int[] item : items) {
      minHeap.add(item[1]);
      totalProfit += item[1];
      currentTime++;

      if (currentTime > item[0]) {
        int leastProfit = minHeap.poll();
        totalProfit -= leastProfit;
        currentTime--;
      }
    }

    return totalProfit;
  }

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

    for (int i = 0; i < n; i++) {
      items.add(new GroceryItem(A.get(i), B.get(i)));
    }

    items.sort(Comparator.comparingInt(item -> item.expirationTime));

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int totalProfit = 0;
    int currentTime = 0;

    for (GroceryItem item : items) {
      minHeap.add(item.profit);
      totalProfit = (totalProfit + item.profit);
      currentTime++;

      if (currentTime > item.expirationTime) {
        int leastProfit = minHeap.poll();
        totalProfit = totalProfit - leastProfit;
        currentTime--;
      }
    }

    return totalProfit;
  }

}
