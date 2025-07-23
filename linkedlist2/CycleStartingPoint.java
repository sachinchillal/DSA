package linkedlist2;

import helper.ListNode;
import helper.TestCaseArray;

public class CycleStartingPoint {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, -1, -1),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 0, -1),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 6, -1),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 1, 1),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 2, 2),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 3, 3),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 4, 4),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 5, 5),
      new TestCaseArray(new int[] { 20, 40, 100, 60, 80 }, 4, 60),
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] A = testCase.A;
      int expected = testCase.R;
      ListNode head = ListNode.createLinkedListFromArray(A);
      head = ListNode.makeCycleAtNthNode(head, testCase.N);
      // removeCycleInLinkedList(head);
      int result = getStartingPointOfCycle(head);
      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  static int getStartingPointOfCycle(ListNode head) {
    if (head == null || head.next == null) {
      return -1; // No cycle
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
      return -1; // No cycle
    }
    // Find the starting point of the cycle
    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow.val; // This is the starting point of the cycle
  }
}
