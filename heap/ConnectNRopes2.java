package heap;

import java.util.ArrayList;

import helper.TestCaseArray;

public class ConnectNRopes2 {

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : ConnectNRopes.TestCases) {
      int expected = testCase.R;
      int result = minCostToConnectNRopes(testCase.A);
      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  public static int minCostToConnectNRopes(int[] ropes) {
    ArrayList<Integer> heap = new ArrayList<>();
    for (int rope : ropes) {
      heap.add(rope);
    }
    int totalCost = 0;
    buildMinHeap(heap);
    while (heap.size() > 1) {
      int first = pop(heap);
      int second = pop(heap);
      int cost = first + second;
      // System.out.println(first + " + " + second + " = " + cost + " (Total: " +
      // totalCost + ")");
      totalCost += cost;
      push(heap, cost);
    }
    return totalCost;
  }

  static void buildMinHeap(ArrayList<Integer> heap) {
    int n = heap.size();
    if (n < 2) {
      return;
    }
    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(heap, n, i);
    }
  }

  static void heapify(ArrayList<Integer> heap, int n, int i) {
    int minimumIndex = i;
    int leftChildIndex = 2 * i + 1;
    int rightChildIndex = 2 * i + 2;
    if (leftChildIndex < n && heap.get(leftChildIndex) < heap.get(minimumIndex)) {
      minimumIndex = leftChildIndex;
    }
    if (rightChildIndex < n && heap.get(rightChildIndex) < heap.get(minimumIndex)) {
      minimumIndex = rightChildIndex;
    }
    if (minimumIndex != i) {
      swap(heap, i, minimumIndex);
      heapify(heap, n, minimumIndex);
    }
  }

  static void swap(ArrayList<Integer> heap, int i, int j) {
    int temp = heap.get(i);
    heap.set(i, heap.get(j));
    heap.set(j, temp);
  }

  static void push(ArrayList<Integer> heap, int value) {
    heap.add(value);
    // buildMinHeap(heap); // This gives Time Limit Exceeded for large inputs
    heapify(heap, heap.size(), heap.size() - 1); // This works fine
  }

  static int pop(ArrayList<Integer> heap) {
    if (heap.size() == 0) {
      return -1;
    }
    int root = heap.get(0);
    swap(heap, 0, heap.size() - 1);
    heap.remove(heap.size() - 1);
    heapify(heap, heap.size(), 0); // IMPORTANT: updated heap.size() is used here
    return root;
  }
}
