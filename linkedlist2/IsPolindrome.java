package linkedlist2;

import helper.ListNode;
import helper.TestCaseArray;
import linkedlist.LinkedListBuilder;

public class IsPolindrome {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, true),
      new TestCaseArray(new int[] { 1 }, true),
      new TestCaseArray(new int[] { 1, 2 }, false),
      new TestCaseArray(new int[] { 1, 2, 3 }, false),
      new TestCaseArray(new int[] { 1, 2, 3, 1 }, false),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 2, 1 }, false),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 4, 2, 1 }, false),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 3, 5, 1 }, false),

      new TestCaseArray(new int[] { 1, 1 }, true),
      new TestCaseArray(new int[] { 1, 2, 1 }, true),
      new TestCaseArray(new int[] { 1, 2, 2, 1 }, true),
      new TestCaseArray(new int[] { 1, 2, 3, 2, 1 }, true),
      new TestCaseArray(new int[] { 1, 2, 3, 2, 1 }, true),
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] A = testCase.A;
      boolean expected = testCase.Rb;
      boolean result = isPalindromeLinkedList(LinkedListBuilder.createLinkedListFromArray(A));
      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  /**
   * Check Linked List is palindrome or not, without using extra space.
   * 
   * @param head
   * @return
   */
  static boolean isPalindromeLinkedList(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }
    /*
     * 1. Find mid
     * 2. Split at mid
     * 3. reverese 2nd half
     * 4. now validate both half's are the same or not
     */
    ListNode slow = head;
    ListNode fast = head;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next; // on step at a time
      fast = fast.next.next; // two steps at a time
    }
    // slow = is mid now
    // ListNode mid = slow;
    ListNode _2ndHalf = reverseLinkedList(slow.next);
    slow.next = null;

    boolean R = isIdentical(head, _2ndHalf);

    slow.next = reverseLinkedList(_2ndHalf);
    return R;
  }

  static ListNode reverseLinkedList(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode pre = null;
    ListNode n = head;
    ListNode next;

    while (n != null) {
      next = n.next;

      n.next = pre;
      pre = n;

      n = next;
    }

    return pre;
  }

  static boolean isIdentical(ListNode L1, ListNode L2) {
    while (L1 != null && L2 != null) {
      if (L1.val != L2.val) {
        return false;
      }
      L1 = L1.next;
      L2 = L2.next;
    }
    return true;
  }

}
