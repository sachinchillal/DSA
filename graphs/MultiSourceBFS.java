package graphs;

import java.util.*;

public class MultiSourceBFS {

  // A class to represent an edge in the graph
  static class Edge {
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
      this.source = source;
      this.destination = destination;
      this.weight = weight;
    }
  }

  // A class to represent a node in the queue
  static class Node {
    int vertex;
    int distance;

    public Node(int vertex, int distance) {
      this.vertex = vertex;
      this.distance = distance;
    }
  }

  /**
   * Performs a Breadth-First Search from multiple source nodes.
   *
   * @param graph   The adjacency list representation of the graph.
   * @param sources A list of source nodes to start the BFS from.
   * @param V       The number of vertices in the graph.
   * @return An array of distances from the nearest source to each vertex.
   */
  public int[] multiSourceBFS(List<List<Edge>> graph, List<Integer> sources, int V) {
    // Queue for BFS
    Queue<Node> queue = new LinkedList<>();
    // Array to store the shortest distance from the nearest source
    int[] distance = new int[V];
    // Array to keep track of visited nodes
    boolean[] visited = new boolean[V];

    // Initialize distances to infinity and visited to false
    Arrays.fill(distance, Integer.MAX_VALUE);
    Arrays.fill(visited, false);

    // Initialize the queue with all source nodes
    for (int source : sources) {
      queue.add(new Node(source, 0));
      distance[source] = 0;
      visited[source] = true;
    }

    // Standard BFS loop
    while (!queue.isEmpty()) {
      Node currentNode = queue.poll();
      int currentVertex = currentNode.vertex;
      int currentDistance = currentNode.distance;

      // Explore neighbors
      for (Edge edge : graph.get(currentVertex)) {
        int neighbor = edge.destination;

        // If the neighbor hasn't been visited, update its distance and add it to the
        // queue
        if (!visited[neighbor]) {
          visited[neighbor] = true;
          distance[neighbor] = currentDistance + 1;
          queue.add(new Node(neighbor, distance[neighbor]));
        }
      }
    }

    return distance;
  }

  public static void main(String[] args) {
    int V = 7; // Number of vertices
    List<List<Edge>> graph = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      graph.add(new ArrayList<>());
    }

    // Adding edges to the graph
    graph.get(0).add(new Edge(0, 1, 1));
    graph.get(0).add(new Edge(0, 2, 1));
    graph.get(1).add(new Edge(1, 3, 1));
    graph.get(2).add(new Edge(2, 4, 1));
    graph.get(3).add(new Edge(3, 5, 1));
    graph.get(4).add(new Edge(4, 6, 1));

    MultiSourceBFS bfs = new MultiSourceBFS();

    // Define multiple source nodes
    List<Integer> sources = Arrays.asList(0, 5);

    // Run the multi-source BFS
    int[] distances = bfs.multiSourceBFS(graph, sources, V);

    // Print the results
    System.out.println("Shortest distances from the nearest source:");
    for (int i = 0; i < distances.length; i++) {
      System.out.println("Vertex " + i + ": " + distances[i]);
    }
  }
}