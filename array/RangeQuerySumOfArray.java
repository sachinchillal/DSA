import java.util.Arrays;

import helper.TestCaseArray;

public class RangeQuerySumOfArray {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] { 1, 2, 3, 4 }, new int[][] { { 0, 2 }, { 1, 2 }, { 1, 4 } }, new int[] { 6, 5, 9 }),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      int[] result = rangeQuerySumOfArray(testCase.A, testCase.A_2Array);
      if (Arrays.equals(result, expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out
            .println("Expected: " + Arrays.toString(expected) + ", Result: " + Arrays.toString(result) + "\n");
      }
      count++;
    }
  }

  /**
   * Give an A[n] find the sum between given range Q[s, e]
   * 
   * @param A
   * @return
   */
  public static int[] rangeQuerySumOfArray(int[] A, int[][] Q) {
    int n = A.length;
    // int q = Q.length;
    int[] R = new int[Q.length];

    // prefix sum
    int[] pSum = new int[n];
    pSum[0] = A[0];
    for (int i = 1; i < n; i++) {
      pSum[i] = A[i] + pSum[i - 1];
    }
    for (int i = 0; i < Q.length; i++) {
      int s = Q[i][0];
      int e = Q[i][1];
      if (s < 1) {
        s = 0; // to start from 0
      }
      if (e >= n) {
        e = n - 1; // to end upto n-1
      }
      if (s == 0) {
        R[i] = pSum[e];
      } else {
        R[i] = pSum[e] - pSum[s - 1];
      }
      // OR one liner
      // R[i] = pSum[e] - ((s == 0) ? 0 : pSum[s - 1]);
    }

    return R;
  }

}
