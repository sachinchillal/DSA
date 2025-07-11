package queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

import helper.TestCaseArray;

public class SlidingWindowMax {

  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {
        new TestCaseArray(new int[] {}, 3, new int[] {}),
        new TestCaseArray(new int[] { 1, 2 }, 2, new int[] { 2 }),
        new TestCaseArray(new int[] { 1, 2, 3 }, 3, new int[] { 3 }),
        new TestCaseArray(new int[] { 1, 2, 3, 4 }, 3, new int[] { 3, 4 }),
        new TestCaseArray(new int[] { 3, 2, 5, 4, 7, 6, 9, 8, 11, 10 }, 4,
            new int[] { 5, 7, 7, 9, 9, 11, 11 }),

        new TestCaseArray(new int[] { 2, 1 }, 1, new int[] { 2, 1 }),
        new TestCaseArray(new int[] { 3, 2, 1 }, 2, new int[] { 3, 2 }),
        new TestCaseArray(new int[] { 4, 3, 2, 1 }, 3, new int[] { 4, 3 }),
    };

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      int[] result = findMaxElementInSlidingWindow(testCase.A, testCase.N);
      if (Arrays.equals(result, expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + Arrays.toString(expected) + ", Result: " + Arrays.toString(result) + "\n");
      }
      count++;
    }
  }

  // Using Java Array
  public static int[] findMaxElementInSlidingWindow(int[] A, int W) {
    int n = A.length;
    if (n == 0) {
      return new int[0];
    }
    if (W <= 0) {
      return new int[0];
    }
    int nn = n - W + 1;
    if (nn > 0) {
    } else {
      nn = n;
    }
    int[] R = new int[nn];
    Deque<Integer> Q = new ArrayDeque<>();
    for (int i = 0; i < W; i++) {
      while (Q.size() > 0 && Q.getLast() < A[i]) {
        Q.removeLast();
      }
      Q.addLast(A[i]);
    }
    int i = 1, j = W;
    int k = 0;
    while (j < n) {
      R[k++] = Q.getFirst();

      // Aquire A[j]
      while (Q.size() > 0 && Q.getLast() < A[j]) {
        Q.removeLast();
      }
      Q.addLast(A[j]);
      // Release A[i-1]
      if (Q.getFirst() == A[i - 1]) {
        Q.removeFirst();
      }
      i++;
      j++;
    }

    // Add last window max
    R[k] = Q.getFirst();
    return R;
  }

  // Using Java ArrayList
  public static int[] findMaxElementInSlidingWindow2(int[] A, int W) {
    int n = A.length;
    if (n == 0) {
      return new int[0];
    }

    ArrayList<Integer> R = new ArrayList<>();
    Deque<Integer> Q = new ArrayDeque<>();
    for (int i = 0; i < W; i++) {
      while (Q.size() > 0 && Q.getLast() < A[i]) {
        Q.removeLast();
      }
      Q.addLast(A[i]);
    }
    int i = 1, j = W;
    // Start from 1st window
    while (j < n) {
      R.add(Q.getFirst());

      // Aquire A[j]
      while (Q.size() > 0 && Q.getLast() < A[j]) {
        Q.removeLast();
      }
      Q.addLast(A[j]);
      // Release A[i-1]
      if (Q.getFirst() == A[i - 1]) {
        Q.removeFirst();
      }
      i++;
      j++;
    }

    // Add last window max
    R.add(Q.getFirst());
    return R.stream().mapToInt(e -> e).toArray();
  }

}
