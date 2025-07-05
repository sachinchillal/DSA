import java.util.Arrays;

import helper.TestCaseArray;

public class PerformArrayQueriesRange {

  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] { 0, 0 }, new int[][] {}, new int[] { 0, 0 }),
      new TestCaseArray(new int[] { 0, 0, 0 }, new int[][] { new int[] { 3, 4, 5 } }, new int[] { 0, 0, 0 }),
      new TestCaseArray(new int[] { 0, 0, 0 }, new int[][] { new int[] { -1, 2, 5 } }, new int[] { 5, 5, 5 }),

      new TestCaseArray(new int[] { 0, 0, 0 }, new int[][] { new int[] { 0, 2, 5 } }, new int[] { 5, 5, 5 }),
      new TestCaseArray(new int[] { 0, 0, 0 }, new int[][] { new int[] { 1, 2, 5 } }, new int[] { 0, 5, 5 }),
      new TestCaseArray(new int[] { 0, 0, 0 }, new int[][] { new int[] { 2, 2, 5 } }, new int[] { 0, 0, 5 }),

      new TestCaseArray(new int[] { 0, 0, 0 }, new int[][] { new int[] { 2, 1, 5 } }, new int[] { 0, 0, 0 }),
      new TestCaseArray(new int[] { 0, 0, 0 }, new int[][] { new int[] { 0, 1, 5 } }, new int[] { 5, 5, 0 }),
      new TestCaseArray(new int[] { 0, 0, 0 }, new int[][] { new int[] { 0, 0, 5 } }, new int[] { 5, 0, 0 }),
      new TestCaseArray(new int[] { 0, 0, 0 }, new int[][] { new int[] { -1, 0, 5 } }, new int[] { 5, 0, 0 }),

  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      int[] result = addValueKToArrayForRange(testCase.A, testCase.A_2Array);
      if (Arrays.equals(result, expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + Arrays.toString(expected) + ", Result: " + Arrays.toString(result) + "\n");
      }
      count++;
    }
  }

  public static int[] addValueKToArrayForRange(int[] A, int[][] Q) {
    int n = A.length;
    if (n == 0) {
      return A;
    }
    if (Q.length == 0) {
      return A; // If no queries, return the original array
    }
    for (int[] q : Q) {
      int start = q[0];
      int end = q[1];
      /*
       * What if the query is 1-based index?
       * Then decrement index by 1 like below
       * //
       */
      // start = start - 1;
      // end = end - 1;

      int value = q[2];
      if (start > end) {
        continue;
      }
      if (start < 0) {
        start = 0;
      } else if (start >= n) {
        continue;
      }
      if (end >= n) {
        end = n - 1;
      }

      A[start] = A[start] + value; // Add value to the specified index
      // we need to add value upto given `end`
      // so if next element exist then do minus value, `- value`
      if (end + 1 < n) {
        A[end + 1] = A[end + 1] - value;
      }
    }

    // Calculate the prefix sum
    int[] prefixSum = new int[n];
    prefixSum[0] = A[0];
    for (int i = 1; i < n; i++) {
      prefixSum[i] = prefixSum[i - 1] + A[i];
    }

    return prefixSum;
  }

}
