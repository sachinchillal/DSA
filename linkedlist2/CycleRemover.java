package linkedlist2;

import helper.ListNode;

public class CycleRemover {

  static void removeCycleInLinkedList(ListNode head) {
    if (head == null || head.next == null) {
      System.out.println("No cycle found as list is too short.");
      return; // No cycle
    }

    ListNode slow = head;
    ListNode fast = head;

    // Detect cycle using Floyd's Tortoise and Hare algorithm
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        break; // Cycle detected
      }
    }
    // If fast pointer reaches null, there is no cycle
    if (fast != slow) {
      System.out.println("No cycle found in the linked list.");
      return; // No cycle
    }
    // Find the starting point of the cycle
    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    // return slow; // This is the starting point of the cycle

    // remove the cycle
    ListNode current = slow;
    while (current.next != slow) {
      current = current.next;
    }
    current.next = null;

    System.out.println(head.deepToString());
  }
}
