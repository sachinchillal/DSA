package heap;

import java.util.Arrays;

import helper.TestCaseArray;

public class MinHeapPop {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, new int[] {}),
      new TestCaseArray(new int[] { 1 }, new int[] {}),
      new TestCaseArray(new int[] { 1, 2 }, new int[] { 2 }),
      new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { 2, 3 }),
      // new TestCaseArray(new int[] { 1, 2, 3, 4 }, new int[] { 2, 3, 4 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4 }, new int[] { 2, 4, 3 }),
      // new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, new int[] { 2, 3, 4, 5 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, new int[] { 2, 4, 3, 5 }),

      new TestCaseArray(new int[] { -1, 1, 2 }, new int[] { 1, 2 }),
      // new TestCaseArray(new int[] { 0, 1, 3, 2, 4 }, new int[] { 1, 3, 2, 4 }),
      new TestCaseArray(new int[] { 0, 1, 3, 2, 4 }, new int[] { 1, 2, 3, 4 }),
      // new TestCaseArray(new int[] { -2, 1, 3, 2, 4, 5 }, new int[] { 1, 3, 2, 4, 5
      // }),
      new TestCaseArray(new int[] { -2, 1, 3, 2, 4, 5 }, new int[] { 1, 2, 3, 5, 4 }),
      // new TestCaseArray(new int[] { -10, 1, 3, 2, 4, 5, 6 }, new int[] { 1, 3, 2,
      // 4, 5, 6 }),
      new TestCaseArray(new int[] { -10, 1, 3, 2, 4, 5, 6 }, new int[] { 1, 2, 3, 6, 4, 5 }),
      // new TestCaseArray(new int[] { 2, 3, 4, 4, 5, 6, 7 }, new int[] { 3, 4, 4, 5,
      // 6, 7 }),
      new TestCaseArray(new int[] { 2, 3, 4, 4, 5, 6, 7 }, new int[] { 3, 4, 4, 7, 5, 6 }),

      // new TestCaseArray(new int[] { 0, 1, 2, 3, 5, 6, 7, 4 }, new int[] { 1, 2, 3,
      // 5, 6, 7, 4 }),
      new TestCaseArray(new int[] { 0, 1, 2, 3, 5, 6, 7, 4 }, new int[] { 1, 3, 2, 4, 5, 6, 7 }),
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      int[] result = popFromMinHeap(testCase.A);
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

  public static int[] popFromMinHeap(int[] A) {
    if (A.length == 0) {
      return new int[] {}; // Return empty array if heap is empty
    }
    // int poppedElement = A[0]; // The minimum element is at the root
    int[] R = new int[A.length - 1];
    // IMPORTANT: The last element is now at the root, so we need to heapify
    swap(A, 0, A.length - 1);
    for (int i = 0; i < A.length - 1; i++) {
      R[i] = A[i];
    }
    // Heapify the root of the heap, no need process all the elements
    // since we already swapped the last element to the root
    MinHeap.heapify(R, R.length, 0);
    return R;
  }

  /**
   * Removes the minimum value from the min-heap and restores the heap property.
   *
   * @param heap  The array representing the min-heap.
   * @param value The value to be added to the heap.
   */
  public static int[] popFromMinHeap2(int[] A) {
    if (A.length == 0) {
      return new int[] {};
    }
    // The minimum element is at the root of the heap
    // int minElement = A[0]; // to return popped element
    // Create a new array to hold the result
    int[] R = new int[A.length - 1];
    // Copy the elements from the old array to the new array, skipping the root
    for (int i = 1; i < A.length; i++) {
      R[i - 1] = A[i];
    }
    // Restore the heap property
    restoreHeap(R);
    // Return the new array
    return R;
  }

  /**
   * Restores the heap property of the array after removing the root.
   *
   * @param A The array representing the min-heap.
   */
  static void restoreHeap(int[] A) {
    for (int i = A.length / 2 - 1; i >= 0; i--) {
      heapify(A, i, A.length);
    }
  }

  /**
   * Heapifies a subtree rooted at index i in the array A.
   *
   * @param A The array representing the min-heap.
   * @param i The index of the root of the subtree to heapify.
   * @param n The size of the heap.
   */
  static void heapify(int[] A, int i, int n) {
    int smallest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < n && A[left] < A[smallest]) {
      smallest = left;
    }
    if (right < n && A[right] < A[smallest]) {
      smallest = right;
    }
    if (smallest != i) {
      swap(A, i, smallest);
      heapify(A, smallest, n);
    }
  }

  static void swap(int[] A, int i, int j) {
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }

}
