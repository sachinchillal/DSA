package graphs;

import java.util.*;

public class TraversalBFS {

  // Using Queue
  public static ArrayList<Integer> getBFSOfGraph(ArrayList<ArrayList<Integer>> adj, int s) {
    boolean[] visited = new boolean[adj.size()];
    ArrayList<Integer> R = new ArrayList<>();
    Queue<Integer> queue = new LinkedList<>();

    queue.add(s);
    visited[s] = true;

    while (!queue.isEmpty()) {
      int node = queue.poll();
      R.add(node);

      for (int neighbor : adj.get(node)) {
        if (!visited[neighbor]) {
          queue.add(neighbor);
          visited[neighbor] = true;
        }
      }
    }

    return R;
  }

  // Function to add an edge to the adjacency list
  public static void addEdge(ArrayList<ArrayList<Integer>> adj, int s, int t) {
    adj.get(s).add(t);
    adj.get(t).add(s);
  }

  // Main DFS function to perform DFS for the entire graph
  public static ArrayList<Integer> getBFSOfGraph2(ArrayList<ArrayList<Integer>> adj) {
    boolean[] visited = new boolean[adj.size()];
    ArrayList<Integer> R = new ArrayList<>();
    Queue<Integer> queue = new LinkedList<>();

    // Loop through all vertices to handle disconnected
    // graphs
    for (int i = 0; i < adj.size(); i++) {
      if (!visited[i]) {
        queue.add(i);
        visited[i] = true;

        while (!queue.isEmpty()) {
          int node = queue.poll();
          R.add(node);

          for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
              queue.add(neighbor);
              visited[neighbor] = true;
            }
          }
        }
      }
    }

    return R;
  }

  public static void main(String[] args) {
    int V = 6;
    // Create an adjacency list for the graph
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    // Initialize adjacency list
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }

    // Define the edges of the graph
    int[][] edges = { { 1, 2 }, { 2, 0 }, { 0, 3 }, { 4, 5 } };

    // Populate the adjacency list with edges
    for (int[] e : edges) {
      addEdge(adj, e[0], e[1]);
    }

    // Perform BFS
    ArrayList<Integer> res = getBFSOfGraph(adj, 0);

    // Print the BFS traversal result
    for (int num : res) {
      System.out.print(num + " ");
    }
  }
}