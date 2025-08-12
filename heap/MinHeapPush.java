package heap;

import java.util.Arrays;

import helper.TestCaseArray;

public class MinHeapPush {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, 3, new int[] { 3 }),
      new TestCaseArray(new int[] { 1 }, 2, new int[] { 1, 2 }),
      new TestCaseArray(new int[] { 3 }, 1, new int[] { 1, 3 }),
      new TestCaseArray(new int[] { 1, 2 }, 3, new int[] { 1, 2, 3 }),
      new TestCaseArray(new int[] { 1, 2, 3 }, 4, new int[] { 1, 2, 3, 4 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4 }, 5, new int[] { 1, 2, 3, 4, 5 }),

      new TestCaseArray(new int[] { 2 }, 1, new int[] { 1, 2 }),
      new TestCaseArray(new int[] { 1, 2 }, 4, new int[] { 1, 2, 4 }),
      new TestCaseArray(new int[] { 1, 3, 2, 4 }, 5, new int[] { 1, 3, 2, 4, 5 }),
      new TestCaseArray(new int[] { 1, 3, 2, 4, 5 }, 6, new int[] { 1, 3, 2, 4, 5, 6 }),
      new TestCaseArray(new int[] { 1, 3, 2, 4, 5, 6 }, 7, new int[] { 1, 3, 2, 4, 5, 6, 7 }),

      new TestCaseArray(new int[] { 1, 3, 2, 4, 5, 6, 7 }, 0, new int[] { 0, 1, 2, 3, 5, 6, 7, 4 }),
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      int[] result = pushToMinHeap2(testCase.A, testCase.N);
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

  public static int[] pushToMinHeap(int[] A, int value) {
    int[] heap = Arrays.copyOf(A, A.length + 1);
    heap[heap.length - 1] = value; // Add the new value at the end
    int n = heap.length;
    int i = n - 1; // Start from the last element
    MinHeap.heapify(heap, n, i); // Restore the heap property
    return heap;
  }

  /**
   * Pushes a new value into the min-heap and restores the heap property.
   *
   * @param heap  The array representing the min-heap.
   * @param value The value to be added to the heap.
   */
  public static int[] pushToMinHeap2(int[] A, int value) {

    // increase the size of the heap by one
    int[] heap = Arrays.copyOf(A, A.length + 1);

    // Add the new value at the end of the heap
    heap[heap.length - 1] = value;
    // If the heap is empty, just return
    if (heap.length == 1) {
      return heap;
    }

    // Restore the heap property by moving the new value up
    int index = heap.length - 1;
    while (index > 0) {
      int parentIndex = (index - 1) / 2;
      // if (heap[index] > heap[parentIndex]) {
      // // Swap with parent if the new value is greater
      if (heap[index] < heap[parentIndex]) {
        // Swap with parent if the new value is less
        swap(heap, index, parentIndex);
        index = parentIndex; // Move up to the parent's index
      } else {
        break; // The heap property is satisfied
      }
    }
    return heap;
  }

  static void swap(int[] A, int i, int j) {
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }

  public static int[] pushToMinHeap3(int[] A, int value) {
    int[] heap = Arrays.copyOf(A, A.length + 1);
    heap[heap.length - 1] = value;
    int i = heap.length - 1;
    while (i > 0) {
      int parentIndex = (i - 1) / 2;
      if (heap[i] < heap[parentIndex]) {
        swap(heap, i, parentIndex);
        i = parentIndex; // Move up to the parent's index
      } else {
        break; // The heap property is satisfied
      }
    }
    return heap;
  }

}
