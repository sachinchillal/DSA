package search;

import helper.TestCaseArray;

public class SearchInRotatedSorted {

  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, 0, -1),
      new TestCaseArray(new int[] { 1 }, 0, -1),
      new TestCaseArray(new int[] { 0 }, 0, 0),
      new TestCaseArray(new int[] { 0, 1 }, 0, 0),
      new TestCaseArray(new int[] { 3, 4 }, 4, 1),

      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 1, 0),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 2, 1),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 3, 2),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 4, 3),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 5, 4),

      new TestCaseArray(new int[] { 2, 3, 4, 5, 1 }, 1, 4),
      new TestCaseArray(new int[] { 3, 4, 5, 1, 2 }, 1, 3),
      new TestCaseArray(new int[] { 4, 5, 1, 2, 3 }, 1, 2),
      new TestCaseArray(new int[] { 5, 1, 2, 3, 4 }, 1, 1),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = searchInRotatedSortedArray(testCase.A, testCase.N);
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
   * At lease one part is sorted in rotated sorted array
   * like low to mid or mid to high
   * 
   * @param A
   * @param K
   * @return
   */
  public static int searchInRotatedSortedArray(int[] A, int K) {
    int R = -1;
    int n = A.length;
    if (n == 0) {
      return -1;
    }
    if (n == 1) {
      return A[0] == K ? 0 : R;
    }
    int low = 0;
    int high = n - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (A[mid] == K) {
        return mid;
      }
      // If left part is sorted
      if (A[low] <= A[mid]) { // Important <=
        if (K >= A[low] && K < A[mid]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      } else { // Right part is sorted
        if (K > A[mid] && K <= A[high]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
    }

    return R;
  }
}
