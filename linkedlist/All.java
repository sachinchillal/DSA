package linkedlist;

import java.util.ArrayList;

public class All {
    public static void main(String[] args) {
        int[] A = new int[] { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 };

        ListNode head = constructLinkedListFromArray(A);
        print(head);
        // ListNode tail = reverseLinkedList(head);
        // print(tail);
        ListNode copied = deepCopy(head);
        print(copied);

        // copied = deepCopy(head);
        // ListNode updated = getKthNode(copied, 0);
        // print(updated);

        // copied = deepCopy(head);
        // updated = getKthNode(copied, 1);
        // print(updated);

        // copied = deepCopy(head);
        // updated = getKthNode(copied, 5);
        // print(updated);

        // copied = deepCopy(head);
        // updated = getKthNode(copied, 10);
        // print(updated);

        // copied = deepCopy(head);
        // updated = getKthNode(copied, 11);
        // print(updated);

        // updated = insertNewNodeAtIndex(head, 1001, 0);
        // print(updated);
        // updated = insertNewNodeAtIndex(head, 1002, 5);
        // print(updated);
        // updated = insertNewNodeAtIndex(head, 1003, 10);
        // print(updated);
        // updated = insertNewNodeAtIndex(head, 1004, 30);
        // print(updated);

        // updated = deleteNodeAt(head, 30);
        // print(updated);
        // updated = deleteNodeAt(head, 12);
        // print(updated);
        // updated = deleteNodeAt(head, 10);
        // print(updated);
        // updated = deleteNodeAt(head, 5);
        // print(updated);

    }

    public static ListNode constructLinkedListFromArray(int[] A) {
        if (A.length < 1) {
            return null;
        }
        ListNode head = null;
        ListNode tail = null;

        for (int a : A) {
            if (head == null) {
                head = new ListNode(a);
                tail = head;
            } else {
                tail.next = new ListNode(a);
                tail = tail.next;
            }
        }
        return head;
    }

    public static int[] linkedListToArray(ListNode head) {
        if (head == null) {
            return new int[] {};
        }
        ArrayList<Integer> R = new ArrayList<>();
        ListNode n = head;
        while (n != null) {
            R.add(n.val);
            n = n.next;
        }
        return R.stream().mapToInt(e -> e).toArray();
    }

    public static void print(ListNode head) {
        ListNode n = head;

        while (n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
        System.out.println(head == null ? null : "");
    }

    public static ListNode deepCopy(ListNode head) {
        ListNode newNode = null;
        ListNode nnTail = null;

        ListNode n = head;
        while (n != null) {
            if (newNode == null) {
                newNode = new ListNode(n.val);
                nnTail = newNode;
            } else {
                nnTail.next = new ListNode(n.val);
                nnTail = nnTail.next;
            }
            n = n.next;
        }

        return newNode;
    }

    public static ListNode getKthNode(ListNode head, int K) {
        ListNode kThNode = null;
        if (head == null || K < 1) {
            return null;
        }
        ListNode n = head;
        int i = 1; // count the nodes
        while (n != null && i < K) {
            n = n.next;
            i++;
        }
        kThNode = n;
        if (kThNode != null) {
            kThNode.next = null; // to remove next values
        }
        return kThNode;
    }

    public static ListNode getKthNode2(ListNode head, int K) {
        ListNode kThNode = null;
        if (head == null || K < 1) {
            return null;
        }
        ListNode n = head;
        int i = 0;
        while (n != null && i < K - 1) {
            n = n.next;
            i++;
        }
        kThNode = n;
        if (kThNode != null) {
            kThNode.next = null; // to remove next values
        }
        return kThNode;
    }

    public static ListNode reverseLinkedList(ListNode head) {
        ListNode pre = null;

        ListNode n = head;
        while (n != null) {
            ListNode next = n.next;

            ListNode preNext = pre; // Next of the pre
            pre = n;
            pre.next = preNext;

            n = next;
        }

        return pre;
    }

    public static ListNode reverseLinkedList2(ListNode head) {
        ListNode pre = null;

        ListNode n = head;
        while (n != null) {
            ListNode next = n.next;

            n.next = pre;
            pre = n;

            n = next;
        }

        return pre;
    }

    public static ListNode insertNewNodeAtIndex(ListNode head, int val, int index) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            return newNode;
        }
        if (index == 0) {
            newNode.next = head;
            return newNode;
            // It doesn't modifies/update the given head/linked list
        }
        ListNode n = head;

        ListNode pre = null;
        // index - 1 is because need to find the previous node and attach at its next
        for (int i = 0; i < index - 1 && n != null; i++) {
            pre = n;
            n = n.next;
        }
        if (n == null) {
            // insert at the end
            pre.next = newNode;
            return head;
        }

        newNode.next = n.next;
        n.next = newNode;
        // These operations modifies/update the given head/linked list

        return head;
    }

    public static ListNode deleteNodeAt(ListNode head, int index) {
        if (index == 0) {
            return head.next;
        }
        ListNode n = head;
        int i = 0;
        for (i = 0; i < index - 1 && n != null; i++) {
            n = n.next;
        }
        if (n == null || n.next == null) {
            return head;
        }
        n.next = n.next.next;
        return head;
    }

    public static ListNode deleteNodeAt2(ListNode head, int index) {
        if (index == 0) {
            return head.next;
        }
        ListNode pre = null;
        ListNode n = head;
        int idx = 0;
        while (n != null && idx < index) {
            pre = n;
            n = n.next;
            idx++;
        }
        if (n == null) {
            return head;
        }

        pre.next = n.next;

        return head;
    }
}