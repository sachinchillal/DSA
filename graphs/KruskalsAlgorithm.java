package graphs;

import java.util.Arrays;
import java.util.Comparator;

public class KruskalsAlgorithm {
  private int[] parent;

  private int find(int i) {
    if (parent[i] == i) {
      return i;
    }
    return parent[i] = find(parent[i]);
  }

  private boolean union(int i, int j) {
    int rootI = find(i);
    int rootJ = find(j);
    if (rootI != rootJ) {
      parent[rootI] = rootJ;
      return true;
    }
    return false;
  }

  public int solve(int A, int[][] B) {
    long totalCost = 0;
    int edgesCount = 0;

    // Sort edges by weight
    Arrays.sort(B, Comparator.comparingInt(a -> a[2]));

    // Initialize DSU
    parent = new int[A + 1];
    for (int i = 1; i <= A; i++) {
      parent[i] = i;
    }

    // Iterate through sorted edges
    for (int[] edge : B) {
      int u = edge[0];
      int v = edge[1];
      long cost = edge[2];

      if (union(u, v)) {
        totalCost = (totalCost + cost);
        edgesCount++;
      }

      // Optimization: stop if MST is complete
      if (edgesCount == A - 1) {
        break;
      }
    }
    return (int) totalCost;
  }
}