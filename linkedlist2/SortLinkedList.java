package linkedlist2;

import helper.ListNode;

public class SortLinkedList {
  public static void main(String[] args) {

  }

  /**
   * Main function to sort the linked list.
   * 
   * @param head The head of the list to be sorted.
   * @return The head of the sorted list.
   */
  public ListNode sortList(ListNode head) {
    // Base case: A list with 0 or 1 node is already sorted.
    if (head == null || head.next == null) {
      return head;
    }

    // --- 1. Divide ---
    // Find the middle of the list.
    ListNode mid = getMid(head);
    ListNode rightHead = mid.next;
    // Split the list into two halves.
    mid.next = null;
    ListNode leftHead = head;

    // --- 2. Conquer (Recursive Sort) ---
    // Recursively sort the two halves.
    ListNode sortedLeft = sortList(leftHead);
    ListNode sortedRight = sortList(rightHead);

    // --- 3. Merge ---
    // Merge the two sorted halves.
    return merge(sortedLeft, sortedRight);
  }

  /**
   * Merges two sorted linked lists into one sorted list.
   * 
   * @param list1 The head of the first sorted list.
   * @param list2 The head of the second sorted list.
   * @return The head of the merged sorted list.
   */
  private ListNode merge(ListNode list1, ListNode list2) {
    // A dummy node to act as the starting point of the new list.
    ListNode dummyHead = new ListNode(0);
    ListNode tail = dummyHead;

    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        tail.next = list1;
        list1 = list1.next;
      } else {
        tail.next = list2;
        list2 = list2.next;
      }
      tail = tail.next;
    }

    // Attach the remaining nodes from either list1 or list2.
    tail.next = (list1 != null) ? list1 : list2;

    return dummyHead.next;
  }

  /**
   * Finds the middle node of a linked list using the fast/slow pointer technique.
   * 
   * @param head The head of the list.
   * @return The middle node of the list.
   */
  private ListNode getMid(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode slow = head;
    // Start fast pointer one step ahead to handle even/odd lists correctly
    ListNode fast = head.next;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}