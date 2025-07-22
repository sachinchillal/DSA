package tree2;

import java.util.HashMap;

class Node {
  int v;
  int k;
  Node p = null;
  Node n = null;

  public Node(int kk, int vv) {
    k = kk;
    v = vv;
  }
}

public class LRU2 {
  int c = 0;
  HashMap<Integer, Node> m = new HashMap<>();
  Node head = null;
  Node tail = null;

  public LRU2(int capacity) {
    c = capacity;
    m = new HashMap<>();
    head = new Node(0, 0);
    tail = new Node(0, 0);
    head.n = tail;
    tail.p = head;

  }

  public int get(int key) {
    if (m.containsKey(key)) {
      Node n = m.get(key);
      remove(n);

      add(n);
      return n.v;
    }
    return -1;
  }

  void remove(Node b) {
    Node a = b.p;
    Node c = b.n;
    a.n = c;
    c.p = a;
    // a b c => a c
  }

  void add(Node b) {
    // add in the 2nd Node
    // a c => a b c
    // a head b c=next
    Node a = head;
    Node cc = head.n;
    b.n = cc;
    b.p = a;

    a.n = b;
    cc.p = b;

    // Node next=head.n;
    // b.n = b;
    // b.p = head;
    // head.n = b;
    // next.p = b;
  }

  public void set(int key, int value) {
    if (m.containsKey(key)) {
      Node old = m.get(key);
      remove(old);
    }
    Node nn = new Node(key, value);
    m.put(key, nn);
    add(nn);

    if (m.size() > c) {
      Node l = tail.p;
      m.remove(l.k);
      remove(l);
    }

  }
}
