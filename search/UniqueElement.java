package search;

import helper.TestCaseArray;

public class UniqueElement {

  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, -1),
      new TestCaseArray(new int[] { 3 }, 3),
      new TestCaseArray(new int[] { 1, 1 }, -1),
      new TestCaseArray(new int[] { 1, 2, 2 }, 1),
      new TestCaseArray(new int[] { 2, 2, 3 }, 3),

      new TestCaseArray(new int[] { 5, 5, 6, 7, 7 }, 6),
      new TestCaseArray(new int[] { 5, 5, 7, 7, 6, 8, 8 }, 6),
      new TestCaseArray(new int[] { 5, 5, 6, 7, 7, 8, 8 }, 6),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = uniqueElementEveryOtherElementOccursTwice(testCase.A);
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
   * Find element k where each neighbours have duplicate values
   * (m-1) m (m+1)
   * 1. Case 1: can be at the start
   * 2. Case 2: can be at the end
   * 3. Case 3: can be in between
   */
  public static int uniqueElementEveryOtherElementOccursTwice(int[] A) {
    int R = -1;
    int n = A.length;
    if (n == 0) {
      return R;
    }
    if (n == 1) {
      return A[0];
    }
    if (A[0] != A[1]) {
      return A[0];
    }
    if (A[n - 2] != A[n - 1]) {
      return A[n - 1];
    }
    if (n == 2) {
      // on Case 1 fails, do this because A[0] == A[1]
      return -1;
    }
    int low = 0;
    int high = n - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      int m0 = A[mid - 1];
      int m = A[mid];
      int m1 = A[mid + 1];
      if (m != m0 && m != m1) {
        return A[mid];
      } else {
        int i = findFirstIndexOfDuplicate(A, mid);
        if (i % 2 == 0) {
          // if Even Unique element is on right
          low = mid + 1;
        } else {
          // if index is Odd, Unique element is on left
          high = mid - 1;
        }
      }
    }

    return R;
  }

  private static int findFirstIndexOfDuplicate(int[] A, int mid) {
    // -1 , 3, 3
    // m-1, m, m+1
    if (A[mid] == A[mid + 1]) {
      return mid;
    } else {
      // 4 , 4 , -1
      // m-1, m, m+1
      return mid - 1;
    }
  }
}
