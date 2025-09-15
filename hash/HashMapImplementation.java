package hash;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapImplementation {
  public static void main(String[] args) {
    HashMap<Integer, String> map = new HashMap<>();

    // Adding key-value pairs
    map.put(1, "One");
    map.put(2, "Two");
    map.put(3, "Three");

    // Accessing values
    System.out.println("Key 1: " + map.get(1));
    System.out.println("Key 2: " + map.get(2));
    System.out.println("Key 3: " + map.get(3));

    // Removing a key-value pair
    map.remove(2);
    System.out.println("Key 2 after removal: " + map.get(2));

    // size of the map
    System.out.println("Size of map: " + map.size());

    // Checking if a key exists
    System.out.println("Contains key 1: " + map.containsKey(1));
    System.out.println("Contains key 2: " + map.containsKey(2));
    System.out.println("Contains key 3: " + map.containsKey(3));
    System.out.println("Contains key 30: " + map.containsKey(30));

  }

}

class CustomHashMap {

  static class HashMapNode<K, V> {
    K key;
    V value;

    public HashMapNode(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

  private static final int BUCKET_SIZE = 4;
  private ArrayList<HashMapNode<Object, Object>>[] buckets;
  private int size = 0;

  public CustomHashMap() {
    initHashMap();
    size = 0;
  }

  private void initHashMap() {
    buckets = (ArrayList<HashMapNode<Object, Object>>[]) new ArrayList[BUCKET_SIZE];
    for (int i = 0; i < BUCKET_SIZE; i++) {
      buckets[i] = new ArrayList<>();
    }
  }

  private int getBucketIndex(Object key) {
    return Math.abs(key.hashCode()) % BUCKET_SIZE;
  }

  public void put(Object key, Object value) {
    int bucketIndex = getBucketIndex(key);
    ArrayList<HashMapNode<Object, Object>> bucket = buckets[bucketIndex];
    for (HashMapNode<Object, Object> node : bucket) {
      if (node.key.equals(key)) {
        node.value = value; // Update existing key
        return;
      }
    }
    // Add new key-value pair
    bucket.add(new HashMapNode<>(key, value));
    size++;
  }

  public Object get(Object key) {
    int bucketIndex = getBucketIndex(key);
    ArrayList<HashMapNode<Object, Object>> bucket = buckets[bucketIndex];
    for (HashMapNode<Object, Object> node : bucket) {
      if (node.key.equals(key)) {
        return node.value;
      }
    }
    return null;
  }

  public boolean containsKey(Object key) {
    int bucketIndex = getBucketIndex(key);
    ArrayList<HashMapNode<Object, Object>> bucket = buckets[bucketIndex];
    for (HashMapNode<Object, Object> node : bucket) {
      if (node.key.equals(key)) {
        return true;
      }
    }
    return false;
  }

  public Object remove(Object key) {
    int bucketIndex = getBucketIndex(key);
    ArrayList<HashMapNode<Object, Object>> bucket = buckets[bucketIndex];
    for (int i = 0; i < bucket.size(); i++) {
      HashMapNode<Object, Object> node = bucket.get(i);
      if (node.key.equals(key)) {
        Object value = node.value;
        bucket.remove(i);
        size--;
        return value;
      }
    }
    return null;
  }

  public int size() {
    return size;
  }
}