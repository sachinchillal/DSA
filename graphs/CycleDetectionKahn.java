package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionKahn {
  /**
   * To determine whether it's possible to finish all courses given the
   * prerequisites. This problem is essentially about detecting cycles in a
   * directed graph — if there's a cycle, it's impossible to finish all courses.
   * 
   * Used Kahn's Algorithm (BFS-based topological sort) to solve this:
   * 
   * Explanation:
   * - We build a graph using adjacency lists.
   * - We track the in-degree of each node.
   * - We perform a BFS starting from nodes with in-degree 0.
   * - If we can process all nodes, it means there's no cycle.
   */

  public boolean canFinish(int N, int[][] A) {
    // Create adjacency list and in-degree array
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      adj.add(new ArrayList<>());
    }

    int[] inDegree = new int[N];

    // Build the graph
    for (int i = 0; i < A.length; i++) {
      adj.get(A[i][0]).add(A[i][1]);
      inDegree[A[i][1]]++;
    }

    // Queue for BFS
    Queue<Integer> queue = new LinkedList<>();

    // Add all nodes with in-degree 0
    for (int i = 0; i < N; i++) {
      if (inDegree[i] == 0) {
        queue.offer(i);
      }
    }

    int count = 0;

    // Process nodes
    while (!queue.isEmpty()) {
      int course = queue.poll();
      count++;

      for (int neighbor : adj.get(course)) {
        inDegree[neighbor]--;
        if (inDegree[neighbor] == 0) {
          queue.offer(neighbor);
        }
      }
    }

    // If all courses are processed, return true
    return count == N ? true : false;
  }

}
