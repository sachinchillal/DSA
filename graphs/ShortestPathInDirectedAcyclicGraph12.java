package graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import helper.TestCaseArray;

public class ShortestPathInDirectedAcyclicGraph12 {

  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[][] { { 0, 1, 2 }, { 1, 2, 2 }, { 0, 2, 1 } }, 0, 2, 3, 1),
      new TestCaseArray(new int[][] { { 0, 1, 2 }, { 1, 2, 2 }, { 0, 2, 1 } }, 1, 2, 3, 2),
      new TestCaseArray(new int[][] { { 0, 1, 1 }, { 1, 2, 1 }, { 2, 3, 2 }, { 3, 0, 2 } }, 0, 3, 4, 2),
      new TestCaseArray(new int[][] { { 0, 1, 1 }, { 1, 2, 1 }, { 2, 3, 2 }, { 3, 0, 2 } }, 1, 3, 4, 3),

      new TestCaseArray(new int[][] { { 0, 1, 1 }, { 1, 2, 2 }, { 2, 3, 1 }, { 3, 0, 2 } }, 0, 3, 4, 2),
      new TestCaseArray(new int[][] { { 0, 1, 1 }, { 1, 2, 2 }, { 2, 3, 1 }, { 3, 0, 2 } }, 1, 3, 4, 3),

      new TestCaseArray(new int[][] { { 0, 1, 1 }, { 1, 2, 2 }, { 2, 3, 1 }, { 3, 0, 2 }, { 1, 3, 1 } }, 0, 2, 4, 3),
      new TestCaseArray(new int[][] { { 0, 1, 1 }, { 1, 2, 2 }, { 2, 3, 1 }, { 3, 0, 2 }, { 1, 3, 1 } }, 1, 3, 4, 1),
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = getShortestPathInDAG(testCase.N, testCase.A_2Array, testCase.L, testCase.M);
      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  // Given a Directed Acyclic Graph of V vertices from 0 to n-1 and a 2D Integer
  // array(or vector) edges[ ][ ] of length E, where there is a directed edge from
  // edge[i][0] to edge[i][1] with a distance of edge[i][2] for all i.

  // Find the shortest path from src(0) vertex to all the vertices and if it is
  // impossible to reach any vertex, then return -1 for that vertex.

  // https://www.geeksforgeeks.org/dsa/shortest-path-weighted-graph-weight-edge-1-2/
  // O(V + E) O(V)

  static class Edge {
    int to;
    int weight;

    Edge(int to, int weight) {
      this.to = to;
      this.weight = weight;
    }
  }

  public static int getShortestPathInDAG(int N, int[][] M, int S, int D) {
    // Build Vertex to Edges Map
    ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      adj.add(new ArrayList<>());
    }

    for (int[] edge : M) {
      int u = edge[0];
      int v = edge[1];
      int w = edge[2];
      adj.get(u).add(new Edge(v, w));
      adj.get(v).add(new Edge(u, w));
    }

    int[] dist = new int[N];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[S] = 0;

    Deque<Integer> dq = new LinkedList<>();
    dq.addFirst(S);

    while (!dq.isEmpty()) {
      int u = dq.pollFirst();
      for (Edge edge : adj.get(u)) {
        int v = edge.to;
        int w = edge.weight;

        if (dist[u] + w < dist[v]) {
          dist[v] = dist[u] + w;
          if (w == 1) {
            dq.addFirst(v);
          } else {
            dq.addLast(v);
          }
        }
      }
    }

    if (dist[D] == Integer.MAX_VALUE) {
      return -1;
    }
    // System.out.println(Arrays.toString(dist));

    return dist[D];
  }

  public int getShortestPathInDAG2(int N, int[][] M, int S, int D) {
    // Create adjacency list
    ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      graph.add(new ArrayList<>());
    }

    for (int[] edge : M) {
      int u = edge[0], v = edge[1], w = edge[2];
      graph.get(u).add(new int[] { v, w });
      graph.get(v).add(new int[] { u, w });
    }

    // Distance array
    int[] dist = new int[N];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[S] = 0;

    // 0-1 BFS using deque
    Deque<Integer> deque = new ArrayDeque<>();
    deque.add(S);

    while (!deque.isEmpty()) {
      int node = deque.poll();

      for (int[] neighbor : graph.get(node)) {
        int adj = neighbor[0];
        int weight = neighbor[1];

        if (dist[node] + weight < dist[adj]) {
          dist[adj] = dist[node] + weight;
          if (weight == 1) {
            deque.addFirst(adj);
          } else {
            deque.addLast(adj);
          }
        }
      }
    }

    return dist[D] == Integer.MAX_VALUE ? -1 : dist[D];
  }

}
/*
 * 
 * A breadth-first search (BFS) algorithm is the most efficient way to find the
 * shortest path in an unweighted graph, with a time complexity of O(V + E).
 * However, this problem involves a weighted graph, which typically requires
 * Dijkstra's algorithm. But since the edge weights are limited to only 1 and 2,
 * a modified 0-1 BFS can achieve the desired O(A + M) time complexity. This is
 * significantly faster than Dijkstra's, which would have a time complexity of
 * O(M log A) using a min-priority queue.
 * 
 * The 0-1 BFS uses a double-ended queue (Deque) instead of a standard queue.
 * When exploring a node, if the edge weight is 1, the neighbor is added to the
 * front of the deque. If the edge weight is 2, the neighbor is added to the
 * back. This ensures that nodes reachable via a weight 1 edge are processed
 * before nodes reachable via a weight 2 edge, effectively simulating a shortest
 * path search in terms of distance.
 * 
 */
