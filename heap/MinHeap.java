package heap;

import java.util.Arrays;

import helper.TestCaseArray;

public class MinHeap {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, new int[] {}),
      new TestCaseArray(new int[] { 1 }, new int[] { 1 }),
      new TestCaseArray(new int[] { 1, 2 }, new int[] { 1, 2 }),
      new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4 }, new int[] { 1, 2, 3, 4 }),

      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, new int[] { 1, 2, 3, 4, 5 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, new int[] { 1, 2, 3, 4, 5, 6 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, new int[] { 1, 2, 3, 4, 5, 6, 7 }),
      new TestCaseArray(new int[] { 2, 1 }, new int[] { 1, 2 }),
      new TestCaseArray(new int[] { 3, 2, 1 }, new int[] { 1, 2, 3 }),

      new TestCaseArray(new int[] { 4, 3, 2, 1 }, new int[] { 1, 3, 2, 4 }),
      new TestCaseArray(new int[] { 5, 4, 3, 2, 1 }, new int[] { 1, 2, 3, 5, 4 }),
      new TestCaseArray(new int[] { 6, 5, 4, 3, 2, 1 }, new int[] { 1, 2, 4, 3, 5, 6 }),
      new TestCaseArray(new int[] { 7, 6, 5, 4, 3, 2, 1 }, new int[] { 1, 3, 2, 4, 6, 7, 5 }),
      new TestCaseArray(new int[] { 17, 15, 13, 9, 1, 5, 10, 4, 8, 3, 6 },
          new int[] { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 }),
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      int[] result = buildMinHeap(testCase.A);
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
   * the heapify operation at each step.
   *
   * Time complexity: O(n)
   * 
   * @param A The array to be converted.
   */
  public static int[] buildMinHeap(int[] A) {
    int n = A.length;
    if (n == 0) {
      return new int[] {};
    }
    // Start from the last non-leaf node and heapify each node
    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(A, n, i);
    }
    return A;

  }

  /**
   * Heapifies a subtree rooted at index i in the array A.
   * Time complexity: O(log n)
   *
   * @param A The array representing the min-heap.
   * @param n The size of the heap.
   * @param i The index of the root of the subtree to heapify.
   */
  public static void heapify(int[] A, int n, int i) {
    int smallest = i; // Initialize smallest as root
    int left = 2 * i + 1; // left child index
    int right = 2 * i + 2; // right child index

    // If left child is smaller than root
    if (left < n && A[left] < A[smallest]) {
      smallest = left;
    }

    // If right child is smaller than smallest so far
    if (right < n && A[right] < A[smallest]) {
      smallest = right;
    }

    // If smallest is not root
    if (smallest != i) {
      swap(A, i, smallest);
      heapify(A, n, smallest); // Recursively heapify the affected subtree
    }
  }

  /**
   * Swaps two elements in the array A.
   * 
   * @param A
   * @param i
   * @param j
   */
  public static void swap(int[] A, int i, int j) {
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }
}
