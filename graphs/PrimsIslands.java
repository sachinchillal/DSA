package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrimsIslands {

  // A simple DSU (Disjoint Set Union) class
  static class DSU {
    int[] parent;
    int[] rank;

    public DSU(int n) {
      parent = new int[n + 1];
      rank = new int[n + 1];
      for (int i = 1; i <= n; i++) {
        parent[i] = i;
        rank[i] = 0;
      }
    }

    public int find(int i) {
      if (parent[i] == i) {
        return i;
      }
      return parent[i] = find(parent[i]);
    }

    public void union(int i, int j) {
      int root_i = find(i);
      int root_j = find(j);
      if (root_i != root_j) {
        if (rank[root_i] > rank[root_j]) {
          parent[root_j] = root_i;
        } else if (rank[root_i] < rank[root_j]) {
          parent[root_i] = root_j;
        } else {
          parent[root_j] = root_i;
          rank[root_i]++;
        }
      }
    }
  }

  // Class to represent a bridge (edge)
  static class Bridge {
    int u, v, cost;

    public Bridge(int u, int v, int cost) {
      this.u = u;
      this.v = v;
      this.cost = cost;
    }
  }

  public int findMinimumSpanningTree(int A, int[][] B) {
    // Create a list of bridges
    ArrayList<Bridge> bridges = new ArrayList<>();
    for (int[] bridgeData : B) {
      bridges.add(new Bridge(bridgeData[0], bridgeData[1], bridgeData[2]));
    }

    // Sort bridges by cost in non-decreasing order
    Collections.sort(bridges, new Comparator<Bridge>() {
      @Override
      public int compare(Bridge b1, Bridge b2) {
        return Integer.compare(b1.cost, b2.cost);
      }
    });

    DSU dsu = new DSU(A);
    long minCost = 0;
    int edgesCount = 0;

    // Iterate through sorted bridges and build the MST
    for (Bridge bridge : bridges) {
      // Check if adding this bridge creates a cycle
      if (dsu.find(bridge.u) != dsu.find(bridge.v)) {
        // If not, add the bridge to the MST and update the cost
        dsu.union(bridge.u, bridge.v);
        minCost += bridge.cost;
        edgesCount++;
      }
      // Optimization: if we have A-1 edges, we're done
      if (edgesCount == A - 1) {
        break;
      }
    }

    return (int) minCost;
  }
}