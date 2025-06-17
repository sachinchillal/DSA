package queue;

import java.util.ArrayList;

public class QueueUsingList {
  static ArrayList<Integer> list = new ArrayList<>();

  public static void enqueue(int e) {
    System.out.println("Enqueue: " + e);
    list.add(e);
  }

  public static void dequeue() {
    if (list.size() == 0) {
      return;
    }
    System.out.println("Dequeue: " + list.get(0));
    list.remove(0);

  }

  public static int front() {
    if (list.size() == 0) {
      return -1;
    }
    return list.get(0);
  }

  public static int rear() {
    if (list.size() == 0) {
      return -1;
    }
    return list.get(list.size() - 1);
  }

  public static int size() {
    return list.size();
  }

  public static boolean isEmpty() {
    return list.size() == 0;
  }

  public static int[] getArray() {
    return list.stream().mapToInt(e -> e).toArray();
  }
}
