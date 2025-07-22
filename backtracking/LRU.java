package backtracking;

import java.util.HashMap;

// Inner class to represent a node in the doubly linked list
class Node {
  int key;
  int value;
  Node prev;
  Node next;

  Node(int key, int value) {
    this.key = key;
    this.value = value;
  }
}

public class LRU {
  public static void main(String[] args) {
    implementLRU(3);
    System.out.println(get(2));
    System.out.println(get(4));
    System.out.println(get(6));
    set(2, 20);
    set(4, 40);
    set(6, 60);

    System.out.println(get(2));
    System.out.println(get(4));
    System.out.println(get(6));

    // set(4, 40);
    set(4, 44);
    set(6, 60 + 60);
    set(6, 60 + 60 + 60);
    set(7, 70);
    set(8, 70);

    System.out.println(get(6));
    System.out.println(map);
  }

  static int capacity;
  static HashMap<Integer, Node> map;
  // Dummy head and tail nodes to simplify list operations
  static Node head;
  static Node tail;

  /**
   * Initializes the LRUCache with a given capacity.
   * 
   * @param capacity The maximum number of items the cache can hold.
   */
  static void implementLRU(int c) {
    capacity = c;
    map = new HashMap<>();
    // Initialize dummy head and tail
    head = new Node(0, 0);
    tail = new Node(0, 0);
    head.next = tail;
    tail.prev = head;
  }

  /**
   * Retrieves the value of a key from the cache.
   * If the key exists, it's marked as recently used.
   * 
   * @param key The key to retrieve.
   * @return The value of the key, or -1 if the key is not found.
   */
  static int get(int key) {
    if (map.containsKey(key)) {
      Node node = map.get(key);
      // Move the accessed node to the front of the list
      remove(node);
      add(node);
      return node.value;
    }
    return -1;
  }

  /**
   * Sets or inserts a key-value pair into the cache.
   * If the key is new and the cache is full, the least recently used item is
   * removed.
   * 
   * @param key   The key to set.
   * @param value The value to associate with the key.
   */
  static void set(int key, int value) {
    // If key already exists, update its value and move it to the front
    if (map.containsKey(key)) {
      Node oldNode = map.get(key);
      remove(oldNode);
    }

    Node newNode = new Node(key, value);
    map.put(key, newNode);
    add(newNode);

    // If capacity is exceeded, remove the least recently used item (from the tail)
    if (map.size() > capacity) {
      Node nodeToDelete = tail.prev;
      remove(nodeToDelete);
      map.remove(nodeToDelete.key);
    }
  }

  /**
   * Adds a node right after the head (making it the most recently used).
   * 
   * @param node The node to add.
   */
  static void add(Node node) {
    Node headNext = head.next;
    head.next = node;
    node.prev = head;
    node.next = headNext;
    headNext.prev = node;
  }

  /**
   * Removes a node from its current position in the list.
   * 
   * @param node The node to remove.
   */
  static void remove(Node node) {
    Node nextNode = node.next;
    Node prevNode = node.prev;
    prevNode.next = nextNode;
    nextNode.prev = prevNode;
  }
}