package search;

import helper.TestCaseArray;

public class StairCase {

  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {
        new TestCaseArray(1, new int[] { 1 }, 1),
        new TestCaseArray(1, new int[] { 1, 2 }, 2),
        new TestCaseArray(2, new int[] { 1, 2, 3 }, 3),

        new TestCaseArray(3, new int[] { 1, 2, 3, 4 }, 7),

        new TestCaseArray(4, new int[] { 1, 2, 3, 4, 5 }, 10),
        new TestCaseArray(5, new int[] { 1, 2, 3, 4, 5, 6 }, 20),

        new TestCaseArray(6, new int[] { 1, 2, 3, 4, 5, 6, 7 }, 21),
        new TestCaseArray(7, new int[] { 7, 19, 13, 21 }, 28),
    };

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int[] A = (int[]) testCase.params[0];
      int B = (int) testCase.params[1];
      int result = findElement(B);
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
