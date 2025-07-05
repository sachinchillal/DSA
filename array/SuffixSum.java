import java.util.Arrays;

import helper.TestCaseArray;

public class SuffixSum {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, new int[] {}),
      new TestCaseArray(new int[] { 1 }, new int[] { 1 }),
      new TestCaseArray(new int[] { 1, 2 }, new int[] { 3, 2 }),
      new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { 6, 5, 3 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4 }, new int[] { 10, 9, 7, 4 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, new int[] { 15, 14, 12, 9, 5 }),
      new TestCaseArray(new int[] { 5, 4, 3, 2, 1 }, new int[] { 15, 10, 6, 3, 1 }),
      new TestCaseArray(new int[] { 1, -2, 3, -4, 5 }, new int[] { 3, 2, 4, 1, 5 }),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      int[] result = prepareSuffixSum(testCase.A);
      if (Arrays.equals(result, expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + Arrays.toString(expected) + ", Result: " + Arrays.toString(result) + "\n");
      }
      count++;
    }
  }

  public static int[] prepareSuffixSum(int[] A) {
    int n = A.length;
    int[] R = new int[n];
    if (n == 0) {
      return R;
    }
    R[n - 1] = A[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      R[i] = A[i] + R[i + 1];
    }
    return R;
  }

}
