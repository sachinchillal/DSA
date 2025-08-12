package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import helper.TestCaseArray;

public class MinHeap1 {
  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : MinHeap.TestCases) {
      int[] expected = testCase.R_Array;
      ArrayList<Integer> A = new ArrayList<>();
      for (int num : testCase.A) {
        A.add(num);
      }
      int[] result = buildMinHeap(A);
      if (Arrays.equals(result, expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println(Arrays.toString(expected) + " Expected");
        System.out.println(Arrays.toString(result) + " Result\n");
      }
      count++;
    }
  }

  /**
   * Converts an array into a min heap using the bottom-up approach.
   * It iterates from the last non-leaf node up to the root and applies
   * the minHeapify operation at each step.
   *
   * @param A The list to be converted.
   */
  static int[] buildMinHeap(ArrayList<Integer> A) {
    int n = A.size();
    // The index of the last non-leaf node is (n/2) - 1.
    // We start from this node and go up to the root (index 0).
    for (int i = (n / 2) - 1; i >= 0; i--) {
      minHeapify(A, n, i);
    }

    return A.stream().mapToInt(Integer::intValue).toArray();
  }

  /**
   * Ensures that the subtree rooted at index 'i' is a min heap.
   * This method assumes that the subtrees of 'i' are already min heaps.
   * It is also known as sift-down or bubble-down.
   *
   * @param A The heap.
   * @param n The size of the heap.
   * @param i The index of the root of the subtree to heapify.
   */
  static void minHeapify(ArrayList<Integer> A, int n, int i) {
    int smallest = i; // Initialize smallest as the root of the subtree
    int left = 2 * i + 1; // Index of the left child
    int right = 2 * i + 2; // Index of the right child

    // If the left child exists and is smaller than the current smallest element
    if (left < n && A.get(left) < A.get(smallest)) {
      smallest = left;
    }

    // If the right child exists and is smaller than the current smallest element
    if (right < n && A.get(right) < A.get(smallest)) {
      smallest = right;
    }

    // If the smallest element is not the root, swap them
    if (smallest != i) {
      Collections.swap(A, i, smallest);

      // Recursively call minHeapify on the affected subtree to fix
      // any violations caused by the swap.
      minHeapify(A, n, smallest);
    }
  }

}
