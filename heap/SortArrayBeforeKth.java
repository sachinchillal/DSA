package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

import helper.TestCaseArray;

public class SortArrayBeforeKth {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, 0, new int[] {}),
      new TestCaseArray(new int[] { 1 }, 0, new int[] { 1 }),
      new TestCaseArray(new int[] { 1 }, 1, new int[] { 1 }),

      new TestCaseArray(new int[] { 1, 2 }, 0, new int[] { 1, 2 }),
      new TestCaseArray(new int[] { 2, 1 }, 1, new int[] { 1, 2 }),
      new TestCaseArray(new int[] { 1, 2 }, 2, new int[] { 1, 2 }),

      new TestCaseArray(new int[] { 1, 2, 3 }, 0, new int[] { 1, 2, 3 }),
      new TestCaseArray(new int[] { 2, 1, 3 }, 1, new int[] { 1, 2, 3 }),
      new TestCaseArray(new int[] { 3, 1, 2 }, 2, new int[] { 1, 2, 3 }),

      new TestCaseArray(new int[] { 1, 2, 3, 4 }, 0, new int[] { 1, 2, 3, 4 }),
      new TestCaseArray(new int[] { 2, 1, 3, 4 }, 1, new int[] { 1, 2, 3, 4 }),
      new TestCaseArray(new int[] { 3, 1, 2, 4 }, 2, new int[] { 1, 2, 3, 4 }),
      new TestCaseArray(new int[] { 4, 1, 2, 3 }, 3, new int[] { 1, 2, 3, 4 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 0, new int[] { 1, 2, 3, 4, 5 }),
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      int[] result = sortArrayWhichIsSortedAfterKth(testCase.A, testCase.N);
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
   * Given an array A of size N, where elements are sorted
   * after Kth index, this function sorts the entire array.
   * Time Complexity: O(N log K)
   * Space Complexity: O(N)
   */
  static int[] sortArrayWhichIsSortedAfterKth(int[] A, int K) {
    int n = A.length;
    int[] R = new int[n];
    if (n == 0 || K >= n) {
      return Arrays.copyOf(A, n);
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i <= K; i++) {
      pq.add(A[i]);
    }
    R[0] = pq.remove();
    int j = 1;
    for (int i = K + 1; i < n; i++) {
      pq.add(A[i]);
      R[j++] = pq.remove();
    }
    while (pq.size() > 0) {
      R[j++] = pq.remove();
    }
    return R;
  }

  /**
   * Sorts a nearly sorted array where each element is at most B places away
   * from its sorted position.
   *
   * @param A The input integer array representing the priorities.
   * @param B The maximum number of places an element can be from its sorted
   *          position.
   * @return A new integer array representing the sorted queue.
   */
  public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
    // Use a min-heap to keep track of the smallest B+1 elements.
    // PriorityQueue in Java is a min-heap by default.
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    ArrayList<Integer> result = new ArrayList<>();
    int n = A.size();

    // Populate the heap with the first B+1 elements.
    for (int i = 0; i <= B && i < n; i++) {
      minHeap.add(A.get(i));
    }

    // Iterate through the rest of the array.
    // At each step, we extract the minimum and add the next element.
    for (int i = B + 1; i < n; i++) {
      result.add(minHeap.poll());
      minHeap.add(A.get(i));
    }

    // After the loop, the heap still contains the remaining elements.
    // Extract all of them to complete the sorted array.
    while (!minHeap.isEmpty()) {
      result.add(minHeap.poll());
    }

    return result;
  }

}