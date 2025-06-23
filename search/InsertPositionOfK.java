package search;

import helper.TestCaseArray;

public class InsertPositionOfK {
  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {
        new TestCaseArray(0, new int[] {}, 3),
        new TestCaseArray(1, new int[] { 1 }, 1),
        new TestCaseArray(2, new int[] { 1, 2 }, 2),
        new TestCaseArray(3, new int[] { 1, 2, 3 }, 3),
        new TestCaseArray(4, new int[] { 1, 2, 3, 4 }, 4),

        new TestCaseArray(1, new int[] { 1, 2, 3, 4, 5 }, 1),
        new TestCaseArray(2, new int[] { 1, 2, 3, 4, 5, 6 }, 2),
        new TestCaseArray(1, new int[] { 1, 2, 3, 4, 5, 6, 7 }, 1),
        new TestCaseArray(0, new int[] { 7, 19, 13, 21 }, 2),
        new TestCaseArray(4, new int[] { 7, 19, 13, 21 }, 33),

        // Duplicates
        new TestCaseArray(4, new int[] { 1, 2, 3, 4, 4, 5, 6, 7 }, 4),
        new TestCaseArray(4, new int[] { 1, 2, 4, 4, 4, 5, 6, 7 }, 4),
        new TestCaseArray(4, new int[] { 1, 2, 4, 4, 4, 5, 6, 7 }, 4),
        new TestCaseArray(4, new int[] { 1, 4, 4, 4, 4, 5, 6, 7 }, 4),
        new TestCaseArray(4, new int[] { 4, 4, 4, 4, 4, 5, 6, 7 }, 4),

        new TestCaseArray(4, new int[] { 1, 2, 3, 4, 4 }, 4),
        new TestCaseArray(3, new int[] { 1, 2, 4, 4, 4 }, 4),
        new TestCaseArray(3, new int[] { 1, 4, 4, 4, 4 }, 4),
        new TestCaseArray(3, new int[] { 4, 4, 4, 4, 4 }, 4),
        new TestCaseArray(1, new int[] { 10 }, 20),

        new TestCaseArray(1, new int[] { 20, 40 }, 30),
        new TestCaseArray(1, new int[] { 20, 40, 50 }, 30),
        new TestCaseArray(2, new int[] { 10, 20, 40 }, 30),
        new TestCaseArray(2, new int[] { 10, 20, 40, 50 }, 30),
        new TestCaseArray(2, new int[] { 10, 20, 40, 50, 60 }, 30),
        new TestCaseArray(3, new int[] { 10, 20, 30, 40, 50 }, 30),
    };

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int[] A = (int[]) testCase.params[0];
      int B = (int) testCase.params[1];
      int result = findInsertPositionOfElement(A, B);
      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  /*
   * Array will be sorted
   * Case 0: If Array is empty, Insert at 0
   * Case 1: Insert at 0
   * Case 2: Insert at n-1
   * Case 2: Insert inbetween i & k, so i j k
   */
  public static int findInsertPositionOfElement(int[] A, int k) {
    int n = A.length;
    if (n == 0) {
      return 0;
    } else if (k < A[0]) {
      return 0;
    } else if (k > A[n - 1]) {
      return n;
    }

    int low = 0;
    int high = n - 1;

    int R = -1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (A[mid] == k) {
        return mid + 1;
      } else if (A[mid] > k) {
        high = mid - 1;
      } else {
        low = mid + 1;
        R = low; // Important
      }
    }
    return R;
  }
}
