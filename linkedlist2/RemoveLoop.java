package linkedlist2;

import java.util.HashSet;

import helper.ListNode;

public class RemoveLoop {
  // Represents a node in the linked list
  static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  // Head of the list
  Node head;

  /**
   * Detects and removes a loop in the linked list using Floyd's algorithm.
   */
  public void detectAndRemoveLoop(Node node) {
    if (node == null || node.next == null) {
      System.out.println("No loop found as list is too short.");
      return;
    }

    Node slow = node;
    Node fast = node;

    // 1. Detect the loop
    // Move slow by 1 and fast by 2. If they meet, a loop exists.
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        break; // Loop detected
      }
    }

    // 2. If a loop was found, find its starting point and remove it
    if (slow == fast) {
      System.out.println("Loop detected!");
      slow = node; // Reset slow pointer to the head

      // If the loop starts at the head itself
      if (slow == fast) {
        while (fast.next != slow) {
          fast = fast.next;
        }
      } else {
        // Move both pointers one step at a time until they meet again.
        // The meeting point is the start of the loop.
        while (slow.next != fast.next) {
          slow = slow.next;
          fast = fast.next;
        }
      }

      System.out.println("Loop starts at node with value: " + fast.next.data);

      // 3. Remove the loop
      // `fast.next` is the start of the loop. We set the previous node's `next` to
      // null.
      fast.next = null;
      System.out.println("Loop removed successfully.");

    } else {
      System.out.println("No loop found in the list.");
    }
  }

  /**
   * Utility function to print the linked list.
   */
  public void printList(Node node) {
    System.out.print("List: ");
    while (node != null) {
      System.out.print(node.data + " -> ");
      node = node.next;
    }
    System.out.println("NULL");
  }

  public static void main(String[] args) {
    RemoveLoop list = new RemoveLoop();

    // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
    list.head = new Node(1);
    list.head.next = new Node(2);
    Node loopStartNode = new Node(3);
    list.head.next.next = loopStartNode;
    list.head.next.next.next = new Node(4);
    list.head.next.next.next.next = new Node(5);

    // Create a loop for testing: 5 points back to 3
    list.head.next.next.next.next.next = loopStartNode;

    // This will print an infinite list if you try it before removing the loop.
    // list.printList(list.head);

    // Detect and remove the loop
    list.detectAndRemoveLoop(list.head);

    // Print the list after removing the loop
    System.out.println("List after removing the loop:");
    list.printList(list.head);
  }

  /**
   * Function to detect and remove loop in a linked list
   * O(n) and O(n)
   */
  static void removeLoopUsingHashSet(ListNode head) {

    // hash set to hash addresses of
    // the linked list nodes
    HashSet<ListNode> s = new HashSet<>();

    // pointer to prev node
    ListNode prev = null;
    while (head != null) {

      // if node not present in the map,
      // insert it in the map
      if (!s.contains(head)) {
        s.add(head);
        prev = head;
        head = head.next;
      }

      // if present, it is a cycle, make
      // last node's next pointer NULL
      else {
        prev.next = null;
        break;
      }
    }
  }

  /**
   * The main method to coordinate loop detection and removal.
   * With functions
   */
  public void detectAndRemoveLoop2() {
    // Step 1: Detect if a loop exists and get the meeting point.
    Node meetingNode = getMeetingNode(head);

    if (meetingNode == null) {
      System.out.println("No loop found.");
      return;
    }

    System.out.println("Loop detected!");

    // Step 2: Find the start of the loop and remove it.
    removeLoop(meetingNode, head);
    System.out.println("Loop removed successfully.");
  }

  /**
   * Detects a loop using Floyd's algorithm.
   * 
   * @return The node where slow and fast pointers meet, or null if no loop
   *         exists.
   */
  private Node getMeetingNode(Node node) {
    if (node == null || node.next == null) {
      return null;
    }
    Node slow = node;
    Node fast = node;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return slow; // Loop detected, return the meeting point.
      }
    }
    return null; // No loop found.
  }

  /**
   * Finds the starting node of the loop and removes it.
   * 
   * @param meetingNode The node where slow and fast pointers met.
   * @param head        The head of the linked list.
   */
  private void removeLoop(Node meetingNode, Node head) {
    Node ptr1 = head;
    Node ptr2 = meetingNode;

    // Move ptr1 to the head and keep ptr2 at the meeting point.
    // The node where they meet now is the start of the loop.
    while (ptr1.next != ptr2.next) {
      ptr1 = ptr1.next;
      ptr2 = ptr2.next;
    }

    // At this point, ptr2.next is the start of the loop.
    System.out.println("Loop starts at node with value: " + ptr2.next.data);

    // ptr2 is now pointing to the last node of the loop.
    // Set its 'next' to null to break the cycle.
    ptr2.next = null;
  }

}