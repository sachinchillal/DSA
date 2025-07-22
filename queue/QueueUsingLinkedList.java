package queue;

import helper.ListNode;

public class QueueUsingLinkedList {
  static ListNode head = null;
  static ListNode tail = null;
  static int count = 0;

  public static void enqueue(int e) {
    System.out.println("Enqueue: " + e);
    ListNode n = new ListNode(e);
    if (head == null) {
      head = n;
      tail = head;
    } else {
      tail.next = n;
      tail = n;
    }
    count++;
  }

  public static void dequeue() {
    if (count == 0 || head == null) {
      return;
    }
    int v = head.val;
    head = head.next;
    System.out.println("Dequeue: " + v);
    count--;
  }

  public static int front() {
    if (head == null) {
      return -1;
    }
    return head.val;
  }

  public static int rear() {
    if (tail == null) {
      return -1;
    }
    return tail.val;
  }

  public static int size() {
    return count;
  }

  public static boolean isEmpty() {
    return count == 0;
  }

  public static int[] getArray() {
    int[] R = new int[count];
    int i = 0;
    ListNode n = head;
    while (n != null) {
      R[i++] = n.val;
      n = n.next;
    }
    return R;
  }
}
