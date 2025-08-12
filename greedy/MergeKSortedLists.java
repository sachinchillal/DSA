package greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;

import helper.ListNode;

public class MergeKSortedLists {
  public ListNode mergeKSortedLinkedLists(ArrayList<ListNode> A) {
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>((x, y) -> x.val - y.val);
    for (ListNode node : A) {
      if (node != null) {
        minHeap.offer(node);
      }
    }
    ListNode head = new ListNode(0);
    ListNode tail = head;
    while (!minHeap.isEmpty()) {
      ListNode node = minHeap.poll();
      tail.next = node;
      tail = tail.next;
      if (node.next != null) {
        minHeap.offer(node.next);
      }
    }
    return head.next;
  }
}
