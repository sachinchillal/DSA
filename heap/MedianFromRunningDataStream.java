package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

import helper.TestCaseArray;

public class MedianFromRunningDataStream {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, new int[] {}),
      new TestCaseArray(new int[] { 1 }, new int[] { 1 }),
      new TestCaseArray(new int[] { 1, 2 }, new int[] { 1, 1 }),
      new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { 1, 1, 2 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4 }, new int[] { 1, 1, 2, 2 }),

      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, new int[] { 1, 1, 2, 2, 3 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, new int[] { 1, 1, 2, 2, 3, 3 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, new int[] { 1, 1, 2, 2, 3, 3, 4 }),
      new TestCaseArray(new int[] { 1, 3, 5, 7, 9 }, new int[] { 1, 2, 3, 4, 5 }),
      new TestCaseArray(new int[] { 12, 2, 10, 6, 8, 4 }, new int[] { 12, 7, 10, 8, 8, 7 }),

      new TestCaseArray(new int[] { 15, 6, 3, 4, 8, 7, 5, 14 }, new int[] { 15, 10, 6, 5, 6, 6, 6, 6 })
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
   * the median is the average of the two middle elements.
   * If the number of elements is odd,
   * the median is the middle element.
   * 
   * A B C => B is the median
   * A B C D => (B+C) / 2 is the median
   * https://www.geeksforgeeks.org/dsa/activity-selection-problem-greedy-algo-1/
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
      // System.out.println("Max Heap: " + maxHeap + ", Min Heap: " + minHeap);

      // Balance the heaps
      if (maxHeap.size() > minHeap.size() + 1) {
        minHeap.offer(maxHeap.poll());
      } else if (minHeap.size() > maxHeap.size()) {
        maxHeap.offer(minHeap.poll());
      }
      // System.out.println("Max Heap: " + maxHeap + ", Min Heap: " + minHeap + "\n");

      // Calculate median
      if (maxHeap.size() == minHeap.size()) {
        R[i] = (maxHeap.peek() + minHeap.peek()) / 2;
      } else {
        R[i] = maxHeap.peek();
      }
    }
    return R;
  }
  /**
   * 1st item: Push to max
   * item if less than peek: Push to max
   * else push to min
   */

}
