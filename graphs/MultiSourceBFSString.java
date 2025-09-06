package graphs;

import java.util.*;

public class MultiSourceBFSString {
  public static Map<String, Integer> bfs(Map<String, List<String>> graph, List<String> sources) {
    Map<String, Integer> distance = new HashMap<>();
    Set<String> visited = new HashSet<>();
    Queue<String> queue = new LinkedList<>();

    for (String src : sources) {
      queue.offer(src);
      visited.add(src);
      distance.put(src, 0);
    }

    while (!queue.isEmpty()) {
      String node = queue.poll();
      for (String neighbor : graph.getOrDefault(node, new ArrayList<>())) {
        if (!visited.contains(neighbor)) {
          visited.add(neighbor);
          distance.put(neighbor, distance.get(node) + 1);
          queue.offer(neighbor);
        }
      }
    }

    return distance;
  }

  public static void main(String[] args) {
    Map<String, List<String>> graph = new HashMap<>();
    graph.put("A", Arrays.asList("B", "C"));
    graph.put("B", Arrays.asList("A", "D"));
    graph.put("C", Arrays.asList("A", "D"));
    graph.put("D", Arrays.asList("B", "C", "E"));
    graph.put("E", Arrays.asList("D"));

    List<String> sources = Arrays.asList("A", "E");
    Map<String, Integer> result = bfs(graph, sources);

    for (Map.Entry<String, Integer> entry : result.entrySet()) {
      System.out.println("Node " + entry.getKey() + " is at distance " + entry.getValue());
    }
  }
}
