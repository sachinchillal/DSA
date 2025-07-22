package linkedlist;

import java.util.ArrayList;

import helper.ListNode;

public class LinkedListBuilder {
  public static ListNode createLinkedListFromArray(int[] A) {
    if (A.length == 0) {
      return null;
    }
    ListNode head = new ListNode(A[0]); // to return the head
    ListNode n = head; // to update next node
    for (int i = 1; i < A.length; i++) {
      n.next = new ListNode(A[i]);
      n = n.next;
    }
    return head;
  }

  public static int[] toArray(ListNode head) {
    if (head == null) {
      return new int[] {};
    }
    ArrayList<Integer> R = new ArrayList<>();
    while (head != null) {
      R.add(head.val);
      head = head.next;
    }
    return R.stream().mapToInt(Integer::intValue).toArray();
  }
}
