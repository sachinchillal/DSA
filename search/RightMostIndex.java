package search;

import helper.TestCaseArray;

public class RightMostIndex {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(0, new int[] { 1 }, 1),
      new TestCaseArray(1, new int[] { 1, 2 }, 2),
      new TestCaseArray(2, new int[] { 1, 2, 3 }, 3),

      new TestCaseArray(3, new int[] { 1, 2, 3, 4 }, 4),
      new TestCaseArray(2, new int[] { 1, 2, 3, 4, 5 }, 3),
      new TestCaseArray(1, new int[] { 1, 2, 3, 4, 5, 6 }, 2),

      new TestCaseArray(0, new int[] { 1, 2, 3, 4, 5, 6, 7 }, 1),
      // Returns -1
      new TestCaseArray(-1, new int[] {}, 2),
      new TestCaseArray(-1, new int[] { 7, 19, 13, 21 }, 2),

      // Duplicates
      new TestCaseArray(4, new int[] { 1, 2, 3, 4, 4, 5, 6, 7 }, 4),
      new TestCaseArray(4, new int[] { 1, 2, 4, 4, 4, 5, 6, 7 }, 4),
      new TestCaseArray(4, new int[] { 1, 2, 4, 4, 4, 5, 6, 7 }, 4),
      new TestCaseArray(4, new int[] { 1, 4, 4, 4, 4, 5, 6, 7 }, 4),
      new TestCaseArray(4, new int[] { 4, 4, 4, 4, 4, 5, 6, 7 }, 4),

      new TestCaseArray(4, new int[] { 1, 2, 3, 4, 4 }, 4),
      new TestCaseArray(4, new int[] { 1, 2, 4, 4, 4 }, 4),
      new TestCaseArray(4, new int[] { 1, 4, 4, 4, 4 }, 4),
      new TestCaseArray(4, new int[] { 4, 4, 4, 4, 4 }, 4),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int[] A = (int[]) testCase.params[0];
      int B = (int) testCase.params[1];
      int result = findLastElement(A, B);
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
   * Find Light Most Index of a given K
   * OR
   * Find Last occurence of a given K
   */
  public static int findLastElement(int[] A, int k) {
    int n = A.length;
    int low = 0;
    int high = n - 1;

    int R = -1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (A[mid] == k) {
        R = mid;
        low = mid + 1; // Important
      } else if (A[mid] > k) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return R;
  }
}
