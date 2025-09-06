package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class IsPathExistsInDirectedGraph {

  public boolean isPathReachable(int n, int[][] edges) {

    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];
      adj.get(u).add(v);
    }

    Queue<Integer> q = new LinkedList<>();
    boolean[] visited = new boolean[n + 1];

    q.add(1); // source is 1
    visited[1] = true;

    while (!q.isEmpty()) {
      int currentNode = q.poll();

      if (currentNode == n) {
        return true;
      }

      for (int neighbor : adj.get(currentNode)) {

        if (!visited[neighbor]) {
          visited[neighbor] = true;
          q.add(neighbor);
        }
      }
    }

    return false;
  }

  public boolean isPathReachable(int n, int s, int d, int[][] edges) {

    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];
      adj.get(u).add(v);
    }

    Queue<Integer> q = new LinkedList<>();
    boolean[] visited = new boolean[n + 1];

    q.add(s);
    visited[s] = true;

    while (!q.isEmpty()) {
      int currentNode = q.poll();

      if (currentNode == d) {
        return true;
      }

      for (int neighbor : adj.get(currentNode)) {

        if (!visited[neighbor]) {
          visited[neighbor] = true;
          q.add(neighbor);
        }
      }
    }

    return false;
  }

}
