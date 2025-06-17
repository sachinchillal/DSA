package linkedlist;

class CustomStack {

  private ListNode top = null;// new ListNode(0);
  private int count = 0;

  int size() {
    return count;
  }

  int peek() {
    // top element
    if (top != null) {
      return top.val;
    }
    return -1;
  }

  int push(int a) {
    ListNode n = new ListNode(a);
    n.pre = top;
    top = n;
    count++;
    return a;
  }

  int pop() {
    if (count == 0) {
      return -1;
    }
    int v = top.val;
    top = top.pre;
    count--;
    return v;
  }

  boolean isEmpty() {
    return top == null;
  }

  void print() {
    ListNode n = top;
    while (n != null) {
      System.out.print(n.val + " ");
      n = n.pre;
    }
    System.out.println();
  }

}

public class StackImplementation {
  public static void main(String[] args) {
    CustomStack s = new CustomStack();
    System.out.println("isEmpty: " + s.isEmpty());
    s.push(0);
    s.push(1);
    s.push(2);
    s.print();
    System.out.println("Size: " + s.size());
    System.out.println("isEmpty: " + s.isEmpty());
    System.out.println("Peek: " + s.peek());
    System.out.println("Pop: " + s.pop());
    s.print();
    System.out.println("Pop: " + s.pop());
    System.out.println("Pop: " + s.pop());
    System.out.println("Pop: " + s.pop());
    s.print();
  }

}
