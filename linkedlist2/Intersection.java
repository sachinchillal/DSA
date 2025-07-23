
package linkedlist2;

import helper.ListNode;

public class Intersection {
  /**
   * Finds the node at which the intersection of two singly linked lists begins.
   *
   * This approach uses two pointers, pA and pB, initialized to the heads of lists
   * A and B, respectively.
   * Both pointers traverse the lists. When a pointer reaches the end of its list,
   * it is redirected
   * to the head of the other list.
   *
   * Why this works:
   * Let's say:
   * - List A has a unique part of length 'a' and a common part of length 'c'.
   * - List B has a unique part of length 'b' and the same common part of length
   * 'c'.
   *
   * Pointer pA travels a+c (reaches end of A) and then starts on B, traveling 'b'
   * more nodes to reach the intersection. Total distance: a+c+b.
   * Pointer pB travels b+c (reaches end of B) and then starts on A, traveling 'a'
   * more nodes to reach the intersection. Total distance: b+c+a.
   *
   * Since they travel the same distance, they are guaranteed to meet at the
   * intersection point.
   *
   * If there is no intersection (c=0), pA travels 'a' then 'b'. pB travels 'b'
   * then 'a'. They will both
   * reach the end (null) at the same time after traversing a+b nodes. The loop
   * terminates and returns null.
   *
   * @param headA The head of the first linked list.
   * @param headB The head of the second linked list.
   * @return The intersecting node, or null if there is no intersection.
   */
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    // Edge case: if either list is null, there can be no intersection.
    if (headA == null || headB == null) {
      return null;
    }

    ListNode pA = headA;
    ListNode pB = headB;

    // The loop will terminate because the pointers will either meet at the
    // intersection or both will become null at the same time after traversing
    // both lists (lengthA + lengthB nodes).
    while (pA != pB) {
      System.out.println((pA == null ? "null" : pA.val) + " " + (pB == null ? "null" : pB.val));
      // If pA reaches the end of list A, redirect it to the head of list B.
      // Otherwise, move to the next node.
      pA = (pA == null) ? headB : pA.next;

      // If pB reaches the end of list B, redirect it to the head of list A.
      // Otherwise, move to the next node.
      pB = (pB == null) ? headA : pB.next;
    }

    // At this point, pA and pB are either at the intersection node or both are
    // null.
    return pA;
  }

  ListNode getIntersectionNode2(ListNode L1, ListNode L2) {
    if (L1 == null || L2 == null) {
      return null;
    }

    ListNode x = L1;
    ListNode y = L2;
    while (x != y) {
      if (x == null) {
        x = L2; // Redirect to L2 if reached the end of L1
      } else {
        x = x.next; // Move to the next node in L1
      }
      if (y == null) {
        y = L1; // Redirect to L1 if reached the end of L2
      } else {
        y = y.next; // Move to the next node in L2
      }
    }
    return x; // This will be the intersection node or null if no intersection
  }

  // Main method to test the solution
  public static void main(String[] args) {
    // Create the linked lists from the example:
    // A: a1 -> a2 -> c1 -> c2 -> c3
    // B: b1 -> b2 -> b3 -> c1 -> c2 -> c3

    // Common part
    ListNode c1 = new ListNode(3);
    ListNode c2 = new ListNode(4);
    ListNode c3 = new ListNode(5);
    c1.next = c2;
    c2.next = c3;

    // List A
    ListNode a1 = new ListNode(1);
    ListNode a2 = new ListNode(2);
    a1.next = a2;
    a2.next = c1; // Intersection point

    // List B
    ListNode b1 = new ListNode(10);
    ListNode b2 = new ListNode(20);
    ListNode b3 = new ListNode(30);
    b1.next = b2;
    b2.next = b3;
    b3.next = c1; // Intersection point

    Intersection solution = new Intersection();
    // ListNode intersectionNode = solution.getIntersectionNode(a1, b1);
    ListNode intersectionNode = solution.getIntersectionNode2(a1, b1);

    if (intersectionNode != null) {
      System.out.println("Intersection found at node with value: " + intersectionNode.val);
    } else {
      System.out.println("No intersection found.");
    }

    // Test case with no intersection
    ListNode list1 = new ListNode(2);
    list1.next = new ListNode(6);
    list1.next.next = new ListNode(4);

    ListNode list2 = new ListNode(1);
    list2.next = new ListNode(5);

    ListNode noIntersectionNode = solution.getIntersectionNode2(list1, list2);

    if (noIntersectionNode != null) {
      System.out.println("Intersection found at node with value: " + noIntersectionNode.val);
    } else {
      System.out.println("No intersection found for the second test case.");
    }
  }
}
