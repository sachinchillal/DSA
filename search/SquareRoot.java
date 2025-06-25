package search;

import helper.TestCaseArray;

public class SquareRoot {

  static TestCaseArray[] TestCases = {
      new TestCaseArray(1, 1),
      new TestCaseArray(2, 1),
      new TestCaseArray(3, 1),

      new TestCaseArray(4, 2),
      new TestCaseArray(5, 2),
      new TestCaseArray(6, 2),
      new TestCaseArray(7, 2),
      new TestCaseArray(8, 2),

      new TestCaseArray(9, 3),
      new TestCaseArray(10, 3),

      new TestCaseArray(15, 3),
      new TestCaseArray(16, 4),
      new TestCaseArray(17, 4),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = findSquareRootOf(testCase.N);
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
   * Given N number find square root of it
   * 16 => 4
   * 17 => 4
   * 9 => 3
   * 15 => 3
   */
  public static int findSquareRootOf(int n) {
    int low = 0;
    int high = n;
    int R = 0;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (mid * mid == n) {
        R = mid;
        return mid;
      } else if (mid * mid > n) {
        high = mid - 1;
      } else {
        R = mid; // Important
        low = mid + 1;
      }
    }
    return R;
  }
}
