package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

import helper.TestCaseArray;

public class TopologicalSort {

  static TestCaseArray[] TestCases = {
      new TestCaseArray(3, new int[][] { { 0, 1 }, { 1, 2 }, { 0, 2 } }, new int[] { 0, 1, 2 }),
      new TestCaseArray(3, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 0 } }, new int[] {}),
      new TestCaseArray(4, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } }, new int[] {}),
      new TestCaseArray(4, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 0, 3 } }, new int[] { 0, 1, 2, 3 }),

      new TestCaseArray(4, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 0, 3 }, { 0, 2 } }, new int[] { 0, 1, 2, 3 }),
      new TestCaseArray(4, new int[][] { { 0, 1 }, { 1, 2 }, { 3, 2 }, { 3, 1 } }, new int[] { 0, 3, 1, 2 }),
      new TestCaseArray(4, new int[][] { { 0, 3 }, { 0, 2 }, { 0, 1 } }, new int[] { 0, 1, 2, 3 }),
      new TestCaseArray(5, new int[][] { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 2, 3 }, { 3, 4 } },
          new int[] { 0, 1, 2, 3, 4 }),

  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      int[] result = getTopologicalOrderOfDAG(testCase.N, testCase.A_2Array);
      if (Arrays.equals(result, expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + Arrays.toString(expected) + ", Result: " + Arrays.toString(result) + "\n");
      }
      count++;
    }
  }

  /**
   * Solves the Topological Sort problem for a given directed graph.
   *
   * @param N The number of nodes in the graph, numbered from 1 to N.
   * @param M A matrix of size M x 2 representing the M directed edges.
   * @return A one-dimensional array containing the lexicographically smallest
   *         topological ordering of the graph. Returns an empty array if a cycle
   *         exists.
   */
  static int[] getTopologicalOrderOfDAG(int N, int[][] M) {
    // Step 1: Initialize data structures.
    // Adjacency list to represent the graph.
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      adj.add(new ArrayList<>());
    }

    // In-degree array to store the number of incoming edges for each node.
    int[] inDegree = new int[N];

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
    for (int i = 0; i < N; i++) {
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
