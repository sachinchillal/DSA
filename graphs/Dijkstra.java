package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

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

  static int[] getShortestDistancesFromSource(int N, int[][] M, int S) {
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