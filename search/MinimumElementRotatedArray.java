package search;

import helper.TestCaseArray;

public class MinimumElementRotatedArray {

  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, -1),
      new TestCaseArray(new int[] { 1 }, 1),
      new TestCaseArray(new int[] { 1, 2 }, 1),
      new TestCaseArray(new int[] { 2, 1 }, 1),
      new TestCaseArray(new int[] { 1, 2, 3 }, 1),
      new TestCaseArray(new int[] { 2, 4, 6 }, 2),

      new TestCaseArray(new int[] { 3, 5, 7 }, 3),
      new TestCaseArray(new int[] { 2, 3, 1 }, 1),
      new TestCaseArray(new int[] { 6, 8, 2, 4 }, 2),
      new TestCaseArray(new int[] { 12, 3, 6, 9 }, 3),
      new TestCaseArray(new int[] { 12, 15, 3, 6, 9 }, 3),

      new TestCaseArray(new int[] { 12, 15, 18, 3, 6, 9 }, 3),
      new TestCaseArray(new int[] { 12, 15, 18, 3 }, 3)
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = findSmallestInSortedRotatedArray(testCase.A);
      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  public static int findSmallestInSortedRotatedArray(int[] A) {
    int R = Integer.MAX_VALUE;
    int n = A.length;
    if (n == 0) {
      return -1;
    }
    if (n == 1) {
      return A[0];
    }
    int low = 0;
    int high = n - 1;

    // If the array is not rotated at all, the first element is the minimum.
    if (A[high] > A[low]) {
      return A[low];
    }

    while (low <= high) {
      int mid = low + (high - low) / 2;
      // System.out.println(A[mid]);
      if (A[mid] < R) {
        R = A[mid];
      }
      if (A[mid] > A[high]) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return R;
  }
}
