package linkedlist;

import java.util.HashMap;

class RandomListNode {
  int val;
  RandomListNode pre;
  RandomListNode next;
  RandomListNode random;

  RandomListNode(int v) {
    val = v;
  }
};

public class DeepCopyLinkedList {
  public RandomListNode deepCopyLinkedListUsingHashMap(RandomListNode head) {
    if (head == null) {
      return null;
    }
    HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
    RandomListNode n = head;
    while (n != null) {
      map.put(n, new RandomListNode(n.val));
      n = n.next;
    }
    n = head;
    while (n != null) {
      RandomListNode c = map.get(n);
      c.next = map.get(n.next);
      c.random = map.get(n.random);
      n = n.next;
    }
    return map.get(head);
  }

  public RandomListNode deepCopyLinkedListUsing2Iteration(RandomListNode head) {
    if (head == null) {
      return null;
    }
    RandomListNode ptr = head;
    while (ptr != null) {
      RandomListNode newNode = new RandomListNode(ptr.val);
      newNode.next = ptr.next;
      ptr.next = newNode;
      ptr = newNode.next;
    }
    ptr = head;
    while (ptr != null) {
      if (ptr.random != null) {
        ptr.next.random = ptr.random.next;
      }
      ptr = ptr.next.next;
    }

    RandomListNode oldListPtr = head;
    RandomListNode newListPtr = head.next;
    RandomListNode newHead = head.next;

    while (oldListPtr != null) {
      oldListPtr.next = oldListPtr.next.next;

      if (newListPtr.next != null) {
        newListPtr.next = newListPtr.next.next;
      }
      oldListPtr = oldListPtr.next;
      newListPtr = newListPtr.next;
    }

    return newHead;

  }
}
