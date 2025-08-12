package queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueues {

  public static void main(String[] args) {
    System.out.println("Ascending Priority Queue:");
    // ascendingPriorityQueue();

    System.out.println("\nDescending Priority Queue:");
    descendingPriorityQueue();
  }

  static void ascendingPriorityQueue() {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    System.out.println(pq);
    pq.add(5);
    pq.add(1);
    pq.add(3);
    System.out.println(pq);
    pq.add(4);
    pq.add(2);
    System.out.println(pq);
    System.out.println("Peek: " + pq.peek());
    System.out.println("Poll: " + pq.poll());
    System.out.println("Remove: " + pq.remove());
    System.out.println("After Poll: " + pq);
    pq.add(6);
    pq.add(7);
    pq.add(1);
    System.out.println(pq);
    pq.remove(7);
    System.out.println(pq);
  }

  static void descendingPriorityQueue() {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    System.out.println(pq);
    pq.add(5);
    pq.add(1);
    pq.add(3);
    System.out.println(pq);
    pq.add(4);
    pq.add(2);
    System.out.println(pq);
    System.out.println("Peek: " + pq.peek());
    System.out.println("Poll: " + pq.poll());
    System.out.println("Remove: " + pq.remove());
    System.out.println("After Poll: " + pq);
    pq.add(6);
    pq.add(7);
    pq.add(1);
    System.out.println(pq);
    pq.remove(2);
    System.out.println(pq);
  }

}
