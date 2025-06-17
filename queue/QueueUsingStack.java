package queue;

import java.util.Stack;

public class QueueUsingStack {
  static Stack<Integer> s = new Stack<>();

  public static void enqueue(int e) {
    System.out.println("Enqueue: " + e);
    s.push(e);
  }

  public static void dequeue() {
    if (s.size() == 0) {
      return;
    }
    System.out.println("Dequeue: " + s.get(0));
    s.remove(0);

  }

  public static int front() {
    if (s.size() == 0) {
      return -1;
    }
    return s.get(0);
  }

  public static int rear() {
    if (s.size() == 0) {
      return -1;
    }
    // return s.get(s.size() - 1);
    return s.peek();
  }

  public static int size() {
    return s.size();
  }

  public static boolean isEmpty() {
    return s.size() == 0;
  }

  public static int[] getArray() {
    return s.stream().mapToInt(e -> e).toArray();
  }
}
