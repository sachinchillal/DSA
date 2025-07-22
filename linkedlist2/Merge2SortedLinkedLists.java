package linkedlist2;

import java.util.Arrays;

import helper.ListNode;
import helper.TestCaseArray;
import linkedlist.LinkedListBuilder;

public class Merge2SortedLinkedLists {

  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, new int[] { 3, 4 }, new int[] { 3, 4 }),
      new TestCaseArray(new int[] { 1, }, new int[] { 3, 4 }, new int[] { 1, 3, 4 }),
      new TestCaseArray(new int[] { 1, 2 }, new int[] { 3, 4 }, new int[] { 1, 2, 3, 4 }),
      new TestCaseArray(new int[] { 3, 4 }, new int[] { 1, 2 }, new int[] { 1, 2, 3, 4 }),
      new TestCaseArray(new int[] { 1, 3 }, new int[] { 2, 4 }, new int[] { 1, 2, 3, 4 }),

      new TestCaseArray(new int[] { 1, 3 }, new int[] { 5, 7, 9 }, new int[] { 1, 3, 5, 7, 9 }),
      new TestCaseArray(new int[] { 1, 10 }, new int[] { 5, 7, 9 }, new int[] { 1, 5, 7, 9, 10 }),
      new TestCaseArray(new int[] { 2, 3, 4 }, new int[] {}, new int[] { 2, 3, 4 }),
      new TestCaseArray(new int[] { 2, 3, 4 }, new int[] { 2 }, new int[] { 2, 2, 3, 4 }),
      new TestCaseArray(new int[] { 2, 3, 4 }, new int[] { 1 }, new int[] { 1, 2, 3, 4 }),

      new TestCaseArray(new int[] { 1, 3, 4 }, new int[] { 2 }, new int[] { 1, 2, 3, 4 }),
      new TestCaseArray(new int[] { 1, 2, 4 }, new int[] { 3 }, new int[] { 1, 2, 3, 4 }),
      new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { 4 }, new int[] { 1, 2, 3, 4 }),
      new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { 5, 6, 7 }, new int[] { 1, 2, 3, 5, 6, 7 }),
      new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { 5, 6, 7 }, new int[] { 1, 2, 3, 5, 6, 7 }),

      new TestCaseArray(new int[] { 1, 3, 5 }, new int[] { 7, 9 }, new int[] { 1, 3, 5, 7, 9 }),
      new TestCaseArray(new int[] { 1, 3, 5 }, new int[] { 7, 9 }, new int[] { 1, 3, 5, 7, 9 }),
      new TestCaseArray(new int[] { 6 }, new int[] { 5, 7 }, new int[] { 5, 6, 7 }),
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      ListNode L1 = LinkedListBuilder.createLinkedListFromArray(testCase.A);
      ListNode L2 = LinkedListBuilder.createLinkedListFromArray(testCase.B);
      ListNode R = mergeTwoSortedLinkedLists(L1, L2);
      // ListNode R = mergeTwoSortedLinkedListsWithNewNodes(L1, L2);
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

  static ListNode mergeTwoSortedLinkedLists(ListNode L1, ListNode L2) {
    if (L1 == null && L2 == null) {
      return null;
    }
    if (L1 == null) {
      return L2;
    }
    if (L2 == null) {
      return L1;
    }

    ListNode head = new ListNode(-1); // to return head
    ListNode n = head; // to update next node

    while (L1 != null && L2 != null) {
      if (L1.val < L2.val) {
        n.next = L1;
        L1 = L1.next;
      } else {
        n.next = L2;
        L2 = L2.next;
      }
      n = n.next;
    }
    if (L1 != null) {
      n.next = L1;
    }
    if (L2 != null) {
      n.next = L2;
    }
    return head.next;
  }

  static ListNode mergeTwoSortedLinkedListsWithNewNodes(ListNode L1, ListNode L2) {
    if (L1 == null && L2 == null) {
      return null;
    }
    if (L1 == null) {
      return L2;
    }
    if (L2 == null) {
      return L1;
    }

    ListNode head = new ListNode(-1); // to return head
    ListNode n = head; // to update next node

    while (L1 != null && L2 != null) {
      if (L1.val < L2.val) {
        n.next = new ListNode(L1.val);
        L1 = L1.next;
      } else {
        n.next = new ListNode(L2.val);
        L2 = L2.next;
      }
      n = n.next;
    }
    while (L1 != null) {
      n.next = new ListNode(L1.val);
      n = n.next;
      L1 = L1.next;
    }
    while (L2 != null) {
      n.next = new ListNode(L2.val);
      n = n.next;
      L2 = L2.next;
    }
    return head.next;
  }

}
