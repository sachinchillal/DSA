package search;

import helper.TestCaseArray;

public class BinarySearchAndMissingValue {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(0, new int[] { 1 }, 1),
      new TestCaseArray(1, new int[] { 1, 2 }, 2),
      new TestCaseArray(2, new int[] { 1, 2, 3 }, 3),

      new TestCaseArray(3, new int[] { 1, 2, 3, 4 }, 4),
      new TestCaseArray(2, new int[] { 1, 2, 3, 4, 5 }, 3),
      new TestCaseArray(1, new int[] { 1, 2, 3, 4, 5, 6 }, 2),

      new TestCaseArray(0, new int[] { 1, 2, 3, 4, 5, 6, 7 }, 1),
      new TestCaseArray(2, new int[] { 1, 3, 5, 7, 9, 11 }, 5),
      // Returns -1
      // Next Position
      new TestCaseArray(0, new int[] { 7, 19, 13, 21 }, 2),
      new TestCaseArray(2, new int[] { 1, 3, 7, 9 }, 5),
      new TestCaseArray(3, new int[] { 1, 3, 4 }, 5),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int[] A = (int[]) testCase.params[0];
      int B = (int) testCase.params[1];
      int result = findElement(A, B);
      // int result = pairMod2(A, B);
      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  public static int findElement(int[] A, int k) {
    int R = -1;
    // int R = A.length;
    int n = A.length;
    int low = 0;
    int high = n - 1;
    if (k > A[high]) {
      return n;
    }
    while (low <= high) {
      int mid = (low + high) / 2;
      if (A[mid] == k - 1) {
        System.out.println("R= " + R);
        // high = mid - 1;
      }
      if (A[mid] == k) {
        return mid;
      } else if (A[mid] > k) {
        R = mid;
        high = mid - 1;
      } else {
        R = mid;
        low = mid + 1;
      }
    }
    return R;
  }
}
