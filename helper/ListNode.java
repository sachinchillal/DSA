package helper;

public class ListNode {
  public int val;
  public ListNode next = null;
  public ListNode pre = null;

  public ListNode(int x) {
    val = x;
  }

  @Override
  public String toString() {
    String S = "val: " + val + "\t";
    if (next != null) {
      S += "next: " + next.val + "\t";
    } else {
      S += "next: null\t";
    }
    if (pre != null) {
      S += "pre: " + pre.val + "\t";
    } else {
      S += "pre: null\t";
    }

    return S;
  }

  public String deepToString() {
    StringBuilder sb = new StringBuilder();
    ListNode current = this;
    while (current != null) {
      sb.append(current.val);
      if (current.next != null) {
        sb.append(" -> ");
      }
      current = current.next;
    }
    return sb.toString();
  }

  public static ListNode createLinkedListFromArray(int[] A) {
    if (A == null || A.length == 0) {
      return null;
    }
    ListNode head = new ListNode(A[0]);
    ListNode current = head;
    for (int i = 1; i < A.length; i++) {
      current.next = new ListNode(A[i]);
      current = current.next;
    }
    return head;
  }

  public static ListNode makeCycleAtNthNode(ListNode head, int n) {
    if (head == null || n < 0) {
      return head; // No cycle
    }
    ListNode cycleStart = null;
    ListNode tail = head;
    ListNode current = head;
    int count = 1;
    while (current != null) {
      if (count == n) {
        cycleStart = current;
      }
      tail = current;
      current = current.next;
      count++;
    }
    if (cycleStart != null) {
      tail.next = cycleStart; // Create cycle
      // System.out.println("Cycle created at node with value: " + cycleStart.val);
      // System.out.println("Cycle created in the linked list at node with value: " +
      // tail.val);
    }

    return head;
  }

  public void show() {
    System.out.println("val: " + val);
  }
}
