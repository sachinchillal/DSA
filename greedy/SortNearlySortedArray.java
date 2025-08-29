package greedy;

import java.util.PriorityQueue;

public class SortNearlySortedArray {
  /**
   * Sorts a nearly sorted array using a min-heap.
   * A nearly sorted array is one where each element is at most B places away from
   * its sorted position.
   * The time complexity of this approach is O(N log B) because we perform N
   * insertions/extractions on a heap of size B+1.
   * The space complexity is O(B) for storing the heap.
   *
   * @param A The input integer array representing the priorities of people in a
   *          queue.
   * @param B The maximum distance an element is from its sorted position.
   * @return An integer array representing the sorted queue.
   */
  public int[] solve(int[] A, int B) {
    int N = A.length;
    if (N <= 1) {
      return A;
    }

    // A min-heap to store B+1 elements.
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    // Initially, populate the heap with the first B+1 elements.
    for (int i = 0; i <= B && i < N; i++) {
      minHeap.add(A[i]);
    }

    int[] sortedArray = new int[N];
    int sortedIndex = 0;

    // Iterate through the rest of the array.
    for (int i = B + 1; i < N; i++) {
      // The smallest element in the current window is at the top of the heap.
      // This is the correct element for the current position in the sorted array.
      sortedArray[sortedIndex++] = minHeap.poll();

      // Add the next element from the original array into the heap.
      minHeap.add(A[i]);
    }

    // After the loop, the remaining elements in the heap are the last B+1 elements
    // from the array.
    // We poll them out to complete the sorted array.
    while (!minHeap.isEmpty()) {
      sortedArray[sortedIndex++] = minHeap.poll();
    }

    return sortedArray;
  }
}