package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

import helper.TestCaseArray;

public class MedianFromRunningDataStream2 {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] { 5, 4, 3, 2, 1 }, new int[] { 5, 4, 4, 3, 3 }),
      new TestCaseArray(new int[] { 1, 5, 4, 3, 2 }, new int[] { 1, 1, 4, 3, 3 }),
      new TestCaseArray(new int[] { 1, 2, 5, 4, 3 }, new int[] { 1, 1, 2, 2, 3 }),
      new TestCaseArray(new int[] { 1, 2, 3, 5, 4 }, new int[] { 1, 1, 2, 2, 3 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, new int[] { 1, 1, 2, 2, 3 }),

      new TestCaseArray(new int[] { 5, 10, 15, 20, 25 }, new int[] { 5, 5, 10, 10, 15 }),
      new TestCaseArray(new int[] { 5, 15, 20, 25, 10 }, new int[] { 5, 5, 15, 15, 15 }),
      new TestCaseArray(new int[] { 5, 10, 15, 25, 20 }, new int[] { 5, 5, 10, 10, 15 }),
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      int[] result = medianFromRunningDataStream(testCase.A);
      if (Arrays.equals(result, expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + Arrays.toString(expected) + ", Result: " + Arrays.toString(result) + "\n");
      }
      count++;
    }
  }

  /**
   * Calculates the median from a running data stream.
   * This method maintains two heaps: a max heap for the left half of the data
   * and a min heap for the right half.
   * If the number of elements is even,
   * the median is the first element of the two middle elements.
   * If the number of elements is odd,
   * the median is the middle element.
   * 
   * A B C => B is the median
   * A B C D => B is the median
   * 
   * @param A
   * @return
   */
  public static int[] medianFromRunningDataStream(int[] A) {
    int n = A.length;
    int[] R = new int[n];
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); // Max heap for left half
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Min heap for right half
    for (int i = 0; i < n; i++) {
      if (maxHeap.isEmpty() || A[i] <= maxHeap.peek()) {
        maxHeap.offer(A[i]);
      } else {
        minHeap.offer(A[i]);
      }

      // Balance the heaps
      if (maxHeap.size() > minHeap.size() + 1) {
        minHeap.offer(maxHeap.poll());
      } else if (minHeap.size() > maxHeap.size()) {
        maxHeap.offer(minHeap.poll());
      }

      // Calculate median
      if (maxHeap.size() == minHeap.size()) {
        // R[i] = (maxHeap.peek() + minHeap.peek()) / 2;
        R[i] = maxHeap.peek();
      } else {
        R[i] = maxHeap.peek();
      }
    }
    return R;
  }

}
