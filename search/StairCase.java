package search;

import helper.TestCaseArray;

public class StairCase {

  static TestCaseArray[] TestCases = {
      new TestCaseArray(1, 1),
      new TestCaseArray(2, 1),
      new TestCaseArray(3, 2),

      new TestCaseArray(7, 3),
      new TestCaseArray(10, 4),
      new TestCaseArray(20, 5),

      new TestCaseArray(21, 6),
      new TestCaseArray(28, 7),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = findElement(testCase.N);
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
   * Given N number of Blocks, find count or max height of Staircase.
   * - 1 block, 1 step
   * 
   * -
   * -- 3 block, 2 steps
   * 
   * -
   * --
   * --- 6 block, 3 steps
   * 
   * m block, n steps
   * m = n (n + 1) / 2;
   */
  public static int findElement(int n) {
    int R = 0;
    int low = 0;
    int high = n;
    while (low <= high) {
      int mid = (low + high) / 2;
      int stairs = mid * (mid + 1) / 2; // n(n+1)/2
      if (stairs <= n) {
        R = mid;
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return R;
  }
}
