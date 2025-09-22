package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import helper.TestCaseArray;

/**
 * Dijkstra's Algorithm for finding the shortest paths from a source node
 * to all other nodes in a weighted graph.
 * 
 * Dijkstra's algorithm is a greedy algorithm that finds the shortest paths from
 * a single source node to all other nodes in a weighted undirected graph with
 * non-negative edge weights. It works by maintaining a set of visited nodes and
 * a set of unvisited nodes. It repeatedly selects the unvisited node with the
 * smallest distance from the source and relaxes its neighbors. The relaxation
 * process updates the distance to a neighbor if a shorter path is found. This
 * process continues until all nodes have been visited.
 * 
 */
public class Dijkstra {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[][] { { 0, 1, 2 }, { 1, 2, 2 }, { 0, 2, 1 } }, 0, 3, new int[] { 0, 2, 1 }),
      new TestCaseArray(new int[][] { { 0, 1, 2 }, { 1, 2, 2 }, { 0, 2, 1 } }, 1, 3, new int[] { 2, 0, 2 }),
      new TestCaseArray(new int[][] { { 0, 1, 1 }, { 1, 2, 1 }, { 2, 3, 2 }, { 3, 0, 2 } }, 0, 4,
          new int[] { 0, 1, 2, 2 }),
      new TestCaseArray(new int[][] { { 0, 1, 1 }, { 1, 2, 1 }, { 2, 3, 2 }, { 3, 0, 2 } }, 1, 4,
          new int[] { 1, 0, 1, 3 }),

      new TestCaseArray(new int[][] { { 0, 1, 1 }, { 1, 2, 2 }, { 2, 3, 1 }, { 3, 0, 2 } }, 0, 4,
          new int[] { 0, 1, 3, 2 }),
      new TestCaseArray(new int[][] { { 0, 1, 1 }, { 1, 2, 2 }, { 2, 3, 1 }, { 3, 0, 2 } }, 1, 4,
          new int[] { 1, 0, 2, 3 }),

      new TestCaseArray(new int[][] { { 0, 1, 1 }, { 1, 2, 2 }, { 2, 3, 1 }, { 3, 0, 2 }, { 1, 3, 1 } }, 0, 4,
          new int[] { 0, 1, 3, 2 }),
      new TestCaseArray(new int[][] { { 0, 1, 1 }, { 1, 2, 2 }, { 2, 3, 1 }, { 3, 0, 2 }, { 1, 3, 1 } }, 1, 4,
          new int[] { 1, 0, 2, 1 }),

      new TestCaseArray(new int[][] { { 0, 1, 4 }, { 0, 2, 8 }, { 1, 4, 6 }, { 2, 3, 2 }, { 3, 4, 10 } }, 0, 5,
          new int[] { 0, 4, 8, 10, 10 }),
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      int[] result = getShortestDistancesFromSource(testCase.M, testCase.A_2Array, testCase.L);
      if (Arrays.equals(result, expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + Arrays.toString(expected) + ", Result: " + Arrays.toString(result) + "\n");
      }
      count++;
    }
  }

  static int[] getShortestDistancesFromSource(int N, int[][] M, int S) {
    int[] dist = new int[N];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[S] = 0;

    ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      graph.add(new ArrayList<>());
    }
    for (int[] edge : M) {
      int u = edge[0];
      int v = edge[1];
      int w = edge[2];
      graph.get(u).add(new int[] { v, w });
      graph.get(v).add(new int[] { u, w });
    }

    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
    minHeap.add(new int[] { S, 0 });

    while (!minHeap.isEmpty()) {
      int[] current = minHeap.poll();
      int currentNode = current[0];
      int currentDist = current[1];

      for (int[] neighbor : graph.get(currentNode)) {
        int neighborNode = neighbor[0];
        int weight = neighbor[1];
        int newDist = currentDist + weight;

        if (newDist < dist[neighborNode]) {
          dist[neighborNode] = newDist;
          minHeap.add(new int[] { neighborNode, newDist });
        }
      }

    }
    for (int i = 0; i < N; i++) {
      if (dist[i] == Integer.MAX_VALUE) {
        dist[i] = -1;
      }
    }
    return dist;
  }

  static class Pair implements Comparable<Pair> {
    int node;
    int distance;

    public Pair(int node, int distance) {
      this.node = node;
      this.distance = distance;
    }

    @Override
    public int compareTo(Pair other) {
      return Integer.compare(this.distance, other.distance);
    }
  }

  static int[] getShortestDistancesFromSource2(int N, int[][] M, int S) {
    // Step 1: Build the adjacency list representation of the graph
    List<List<Pair>> adj = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      adj.add(new ArrayList<>());
    }
    for (int[] edge : M) {
      int u = edge[0];
      int v = edge[1];
      int w = edge[2];
      adj.get(u).add(new Pair(v, w));
      adj.get(v).add(new Pair(u, w)); // Graph is undirected
    }

    // Step 2: Initialize distance array and priority queue
    int[] dist = new int[N];
    Arrays.fill(dist, -1);
    dist[S] = 0;

    PriorityQueue<Pair> pq = new PriorityQueue<>();
    pq.add(new Pair(S, 0));

    // Step 3: Main Dijkstra's algorithm loop
    while (!pq.isEmpty()) {
      Pair current = pq.poll();
      int u = current.node;
      int currentDist = current.distance;

      // Optimization: If the extracted distance is greater than the
      // already calculated distance, skip to avoid redundant processing.
      if (currentDist > dist[u] && dist[u] != -1) {
        continue;
      }

      // Relax edges of the current node
      for (Pair neighbor : adj.get(u)) {
        int v = neighbor.node;
        int weight = neighbor.distance;
        int newDist = currentDist + weight;

        if (dist[v] == -1 || newDist < dist[v]) {
          dist[v] = newDist;
          pq.add(new Pair(v, newDist));
        }
      }
    }
    return dist;
  }
}