package linkedlist2;

import helper.ListNode;
import helper.TestCaseArray;
import linkedlist.LinkedListBuilder;

public class FindMiddle {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, -1),
      new TestCaseArray(new int[] { 1 }, 1),
      new TestCaseArray(new int[] { 1, 2 }, 1),
      new TestCaseArray(new int[] { 1, 2, 3 }, 2),
      new TestCaseArray(new int[] { 1, 2, 3, 4 }, 2),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 3),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 3),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7, }, 4),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, 4),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 5),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 5),
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] A = testCase.A;
      int expected = testCase.R;
      int result = findMiddleElementInLinkedList(LinkedListBuilder.createLinkedListFromArray(A));
      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  static int findMiddleElementInLinkedList(ListNode head) {
    if (head == null) {
      return -1;
    }
    ListNode slow = head;
    ListNode fast = head;

    while (fast.next != null && fast.next.next != null) {

      // while (fast != null && fast.next != null) { // This is also VALID,
      // gives proper middle, like n/2 = mid+1

      slow = slow.next; // on step at a time
      fast = fast.next.next; // two steps at a time
    }
    return slow.val;
  }

}
