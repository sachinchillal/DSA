package search;

import helper.TestCaseArray;

public class PeakElement {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, -1),
      new TestCaseArray(new int[] { 1 }, 0),
      new TestCaseArray(new int[] { 1, 2 }, 1),
      new TestCaseArray(new int[] { 2, 1 }, 0),
      new TestCaseArray(new int[] { 1, 1 }, -1),

      new TestCaseArray(new int[] { 2, 1, 3 }, 0),
      new TestCaseArray(new int[] { 2, 1, 3, 4 }, 0),
      new TestCaseArray(new int[] { 3, 2, 1, 4 }, 0),
      new TestCaseArray(new int[] { 1 }, 0),
      new TestCaseArray(new int[] { 1, 2, 3 }, 2),

      new TestCaseArray(new int[] { 3, 2, 1 }, 0),
      new TestCaseArray(new int[] { 1, 3, 2 }, 1),
      new TestCaseArray(new int[] { 1, 3, 2, 4 }, 3),
      new TestCaseArray(new int[] { 1, 3, 2, 4, 6, 5 }, 1),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 10 }, 9),
      new TestCaseArray(new int[] { 1, 2, 3, 1, 4, 5, 6, 7, 8, 9, 10, 1, 0 }, 10),
      new TestCaseArray(new int[] { 1, 2, 0, 3, 4, 5, 6, 7, 8, 9, 10, 22, 11 }, 11),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = findLocalMaxima(testCase.A);
      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  /**
   * Find element k where each neighbours are greater than it
   * __________+ m => This peek / max element
   * ______ + ___ +
   * (m-1) + _____ + (m+1)
   * 1. Case 1: can be at the start
   * 2. Case 2: can be at the end
   * 3. Case 3: can be in between
   * ___a. if found return
   * ___b. if lesser, move right
   * ___c. else move left
   */
  public static int findLocalMaxima(int[] A) {
    int R = -1;
    int n = A.length;
    if (n == 0) {
      return R;
    }
    if (n == 1) {
      return 0;
    }
    if (A[0] > A[1]) {
      return 0;
    }
    if (A[n - 1] > A[n - 2]) {
      return n - 1;
    }
    int low = 1;
    int high = n - 2;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      int m0 = A[mid - 1];
      int m = A[mid];
      int m1 = A[mid + 1];
      if (m >= m0 && m >= m1) {
        return mid;
      } else if (m > m0) {
        // } else if (m > m0 && m < m1) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return R;
  }
}
