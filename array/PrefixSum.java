import java.util.Arrays;

import helper.TestCaseArray;

public class PrefixSum {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, new int[] {}),
      new TestCaseArray(new int[] { 1 }, new int[] { 1 }),
      new TestCaseArray(new int[] { 1, 2 }, new int[] { 1, 3 }),
      new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { 1, 3, 6 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4 }, new int[] { 1, 3, 6, 10 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, new int[] { 1, 3, 6, 10, 15 }),
      new TestCaseArray(new int[] { 5, 4, 3, 2, 1 }, new int[] { 5, 9, 12, 14, 15 }),
      new TestCaseArray(new int[] { 1, -2, 3, -4, 5 }, new int[] { 1, -1, 2, -2, 3 }),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      int[] result = preparePrefixSum(testCase.A);
      if (Arrays.equals(result, expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + Arrays.toString(expected) + ", Result: " + Arrays.toString(result) + "\n");
      }
      count++;
    }
  }

  public static int[] preparePrefixSum(int[] A) {
    int n = A.length;
    int[] R = new int[n];
    if (n == 0) {
      return R;
    }

    R[0] = A[0];
    for (int i = 1; i < n; i++) {
      R[i] = A[i] + R[i - 1];
    }
    return R;
  }

}
