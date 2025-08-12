package heap;

import java.util.Arrays;

import helper.TestCaseArray;

public class MinHeapDeleteValue {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, 3, new int[] {}),
      new TestCaseArray(new int[] { 1 }, 1, new int[] {}),
      new TestCaseArray(new int[] { 1, 2 }, 2, new int[] { 1 }),
      new TestCaseArray(new int[] { 1, 2, 3 }, 2, new int[] { 1, 3 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4 }, 3, new int[] { 1, 2, 4 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 4, new int[] { 1, 2, 3, 5 }),

      new TestCaseArray(new int[] { -1, 1, 2 }, 1, new int[] { -1, 2 }),
      new TestCaseArray(new int[] { 0, 1, 3, 2, 4 }, 3, new int[] { 0, 1, 2, 4 }),
      new TestCaseArray(new int[] { -2, 1, 3, 2, 4, 5 }, 2, new int[] { -2, 1, 3, 4, 5 }),
      new TestCaseArray(new int[] { -10, 1, 3, 2, 4, 5, 6 }, 5, new int[] { -10, 1, 3, 2, 4, 6 }),
      new TestCaseArray(new int[] { 2, 3, 4, 4, 5, 6, 7 }, 4, new int[] { 2, 3, 4, 5, 6, 7 }),

      new TestCaseArray(new int[] { 0, 1, 2, 3, 5, 6, 7, 4 }, 4, new int[] { 0, 1, 2, 3, 5, 6, 7 }),
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      int[] result = deleteValueFromMinHeap(testCase.A, testCase.N);
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
   * Removes the given value from the min-heap and restores the heap property.
   *
   * @param heap  The array representing the min-heap.
   * @param value The value to be deleted from the heap.
   */
  public static int[] deleteValueFromMinHeap(int[] A, int value) {
    if (A.length == 0) {
      return new int[] {};
    }
    // Find the index of the value to be deleted
    int index = -1;
    for (int i = 0; i < A.length; i++) {
      if (A[i] == value) {
        index = i;
        break;
      }
    }
    // If the value was not found, return the original array
    if (index == -1) {
      return A;
    }
    // Create a new array to hold the result
    int[] R = new int[A.length - 1];
    // Copy the elements from the old array to the new array, skipping the deleted
    // element
    for (int i = 0, j = 0; i < A.length; i++) {
      if (i != index) {
        R[j++] = A[i];
      }
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
