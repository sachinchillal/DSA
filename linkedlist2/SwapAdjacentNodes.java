package linkedlist2;

import java.util.Arrays;

import helper.ListNode;
import helper.TestCaseArray;
import linkedlist.LinkedListBuilder;

public class SwapAdjacentNodes {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, new int[] {}),
      new TestCaseArray(new int[] { 1 }, new int[] { 1 }),
      new TestCaseArray(new int[] { 1, 2 }, new int[] { 2, 1 }),
      new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { 2, 1, 3 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4 }, new int[] { 2, 1, 4, 3 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 10 }, new int[] { 2, 1, 4, 3, 10 }),
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      ListNode L = LinkedListBuilder.createLinkedListFromArray(testCase.A);
      ListNode R = swapAdjacentNodesInLinkedLists(L);
      int[] result = LinkedListBuilder.toArray(R);
      if (Arrays.equals(expected, result)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + Arrays.toString(expected) + ", Result: " +
            Arrays.toString(result) + "\n");
      }
      count++;
    }
  }

  // Swaps every two adjacent nodes in a linked list using an iterative approach.
  static ListNode swapAdjacentNodesInLinkedLists(ListNode head) {
    ListNode R = new ListNode(-1); // to return head
    R.next = head;

    ListNode n = R;

    while (n.next != null && n.next.next != null) {
      ListNode next = n.next;

      // Nodes to be swapped
      ListNode a = n.next;
      ListNode b = n.next.next;

      // Swapping logic
      n.next = b;
      a.next = b.next;
      b.next = a;

      // Move to the next pair
      n = next; // OR
      // n = a;
    }

    return R.next;
  }

  static ListNode swapAdjacentNodesInLinkedLists2(ListNode head) {
    ListNode R = new ListNode(-1); // to return head
    R.next = head;

    ListNode n = R;

    while (n.next != null && n.next.next != null) {
      ListNode first = n.next;
      ListNode second = n.next.next;

      // Swap the nodes
      first.next = second.next;
      second.next = first;
      n.next = second;

      // Move to the next pair
      n = first;
    }

    return R.next;
  }

}
