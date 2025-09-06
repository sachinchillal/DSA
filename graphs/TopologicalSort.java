package graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class TopologicalSort {
  /**
   * Solves the Topological Sort problem for a given directed graph.
   *
   * @param N The number of nodes in the graph, numbered from 1 to N.
   * @param M A matrix of size M x 2 representing the M directed edges.
   * @return A one-dimensional array containing the lexicographically smallest
   *         topological ordering of the graph. Returns an empty array if a cycle
   *         exists.
   */
  public int[] getTopologicalOrderOfDAG(int N, int[][] M) {
    // Step 1: Initialize data structures.
    // Adjacency list to represent the graph.
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      adj.add(new ArrayList<>());
    }

    // In-degree array to store the number of incoming edges for each node.
    int[] inDegree = new int[N + 1];

    // Step 2: Build the graph and calculate in-degrees.
    // The problem uses 1-based indexing for nodes, so we use arrays of size N+1.
    for (int[] edge : M) {
      int u = edge[0];
      int v = edge[1];
      adj.get(u).add(v);
      inDegree[v]++;
    }

    // Step 3: Find starting nodes with an in-degree of 0.
    // We use a min-priority queue to ensure the lexicographically smallest result.
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int i = 1; i <= N; i++) {
      if (inDegree[i] == 0) {
        minHeap.add(i);
      }
    }

    // List to store the topological ordering.
    ArrayList<Integer> R = new ArrayList<>();

    // Step 4: Kahn's Algorithm using the min-heap.
    // Process nodes until the min-heap is empty.
    while (!minHeap.isEmpty()) {
      // Get the node with the smallest value from the heap.
      int u = minHeap.poll();
      R.add(u);

      // For each neighbor v of the current node u...
      for (int v : adj.get(u)) {
        // Decrement the in-degree of the neighbor.
        inDegree[v]--;
        // If the in-degree becomes 0, add it to the min-heap.
        if (inDegree[v] == 0) {
          minHeap.add(v);
        }
      }
    }

    // Step 5: Check for a cycle.
    // If the size of the result list is not equal to the number of nodes A,
    // it means there was a cycle in the graph, and a topological ordering
    // is not possible.
    if (R.size() != N) {
      return new int[0]; // Return an empty array.
    }

    return R.stream().mapToInt(i -> i).toArray();
  }
}
