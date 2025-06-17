package linkedlist;

public class All {
    public ListNode reverseLinkedList(ListNode head) {
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

    public ListNode insertNewNodeAtIndex(ListNode head, int val, int index) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            return newNode;
        }
        if (index == 0) {
            newNode.next = head;
            return newNode;
        }
        ListNode n = head;

        ListNode pre = null;
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

        return head;
    }

    public ListNode deleteNodeAt(ListNode head, int index) {
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

    public ListNode deleteNodeAt2(ListNode head, int index) {
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