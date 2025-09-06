package graphs;

import java.util.ArrayList;

public class DetectCycleInDirectedGraph {
  public boolean isCycleExist(int nodes, int[][] edges) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i <= nodes; i++) {
      adj.add(new ArrayList<>());
    }

    for (int[] edge : edges) {
      adj.get(edge[0]).add(edge[1]);
    }

    boolean[] visited = new boolean[nodes + 1];
    boolean[] recursionStack = new boolean[nodes + 1];

    for (int i = 1; i <= nodes; i++) {
      if (!visited[i]) {
        if (isCyclic(i, adj, visited, recursionStack)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean isCyclic(int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] recursionStack) {
    visited[u] = true;
    recursionStack[u] = true;

    for (int v : adj.get(u)) {
      if (!visited[v]) {
        if (isCyclic(v, adj, visited, recursionStack)) {
          return true;
        }
      } else if (recursionStack[v]) {
        return true;
      }
    }

    recursionStack[u] = false;
    return false;
  }
}
