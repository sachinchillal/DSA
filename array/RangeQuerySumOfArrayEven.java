import java.util.Arrays;

import helper.TestCaseArray;

public class RangeQuerySumOfArrayEven {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] { 1, 2, 3, 4 }, new int[][] { { 0, 2 }, { 1, 2 }, { 1, 4 } }, new int[] { 4, 3, 3 }),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      int[] result = rangeQuerySumOfArrayEvenIndices(testCase.A, testCase.A_2Array);
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
   * Hint: Need to find the Prefix sum of even indices only
   * 
   * @param A
   * @return
   */
  public static int[] rangeQuerySumOfArrayEvenIndices(int[] A, int[][] Q) {
    int n = A.length;
    // int q = Q.length;
    int[] R = new int[Q.length];

    // prefix sum Even indices
    int[] pSumEven = new int[n];
    pSumEven[0] = A[0];
    for (int i = 1; i < n; i++) {
      if (i % 2 == 0) { // only for even indices
        pSumEven[i] = A[i] + pSumEven[i - 1];
      } else {
        pSumEven[i] = pSumEven[i - 1]; // carry forward the previous sum
      }
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
        R[i] = pSumEven[e];
      } else {
        R[i] = pSumEven[e] - pSumEven[s - 1];
      }

    }

    return R;
  }

}
