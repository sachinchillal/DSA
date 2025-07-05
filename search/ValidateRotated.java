package search;

import helper.TestCaseArray;

public class ValidateRotated {

  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] { 1, 2 }, true), // sorted array
      new TestCaseArray(new int[] { 2, 1 }, true), // rotated array
      new TestCaseArray(new int[] { 2, 2 }, true),
      new TestCaseArray(new int[] { 1, 2, 3 }, true),
      new TestCaseArray(new int[] { 2, 3, 1 }, true),
      new TestCaseArray(new int[] { 3, 1, 2 }, true),
      new TestCaseArray(new int[] { 1, 3, 2 }, false),
      new TestCaseArray(new int[] { 3, 2, 1 }, false),
      new TestCaseArray(new int[] { 3, 2, 1, 0, 4, 4 }, false),
      new TestCaseArray(new int[] { 3, 4, 5, 6, 0, 1, 2 }, true),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      boolean expected = testCase.Rb;
      boolean result = isRotatedSortedArray(testCase.A);
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
   * Checks if an array could be a rotated version of a non-decreasingly sorted
   * array.
   *
   * An array A is a rotated version of a sorted array if there is at most one
   * "inversion" or "break point" where an element is greater than the one
   * following it. If there is one inversion, the last element must also be
   * less than or equal to the first element to maintain the cyclic sorted order.
   *
   * @param A The input array of integers.
   * @return 1 if the array is a valid rotated sorted array, 0 otherwise.
   */
  public static boolean isRotatedSortedArray(int[] A) {

    // Handle edge cases: An array with 0 or 1 elements is always considered sorted.
    if (A == null || A.length <= 1) {
      return true;
    }

    int n = A.length;
    int inversions = 0; // Counter for the number of times A[i] > A[i+1]

    // Iterate through the array to find the number of inversions.
    // We go up to the second to last element.
    for (int i = 0; i < n - 1; i++) {
      if (A[i] > A[i + 1]) {
        inversions++;
      }
    }

    // A valid rotated sorted array can have at most one inversion.
    // Case 1: inversions == 0
    // This means the array is already sorted in non-decreasing order (e.g., [1, 2,
    // 3, 4]).
    // This is a valid case (rotation by 0).
    if (inversions == 0) {
      return true;
    }

    // Case 2: inversions == 1
    // This means there is one break point (e.g., [3, 4, 1, 2], the break is at 4 >
    // 1).
    // For this to be a valid rotation, the "wrap-around" element (last element)
    // must be less than or equal to the first element.
    if (inversions == 1) {
      // Check if the last element is less than or equal to the first element.
      if (A[n - 1] <= A[0]) {
        return true;
      }
    }

    // Case 3: inversions > 1
    // If there is more than one inversion, the array cannot be a rotated version
    // of a sorted array (e.g., [1, 5, 2, 6, 3]).
    // The function will fall through to here and return 0.

    return false;
  }
}
