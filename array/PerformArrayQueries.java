import java.util.Arrays;

import helper.TestCaseArray;

public class PerformArrayQueries {

  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] { 0, 0 }, new int[][] {}, new int[] { 0, 0 }),
      new TestCaseArray(new int[] { 0, 0, 0 }, new int[][] { new int[] { 3, 5 } }, new int[] { 0, 0, 0 }),
      new TestCaseArray(new int[] { 0, 0, 0 }, new int[][] { new int[] { 2, 5 } }, new int[] { 0, 0, 5 }),

      new TestCaseArray(new int[] { 0, 0, 0 }, new int[][] { new int[] { 1, 5 } }, new int[] { 0, 5, 5 }),
      new TestCaseArray(new int[] { 0, 0, 0 }, new int[][] { new int[] { 0, 5 } }, new int[] { 5, 5, 5 }),
      new TestCaseArray(new int[] { 0, 0, 0 }, new int[][] { new int[] { -5, 5 } }, new int[] { 5, 5, 5 }),

      new TestCaseArray(new int[] { 0, 0, 0, 0 }, new int[][] { new int[] { 0, 2 } }, new int[] { 2, 2, 2, 2 })
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      int[] result = addValueKToArrayStartingFromI(testCase.A, testCase.A_2Array);
      if (Arrays.equals(result, expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + Arrays.toString(expected) + ", Result: " + Arrays.toString(result) + "\n");
      }
      count++;
    }
  }

  public static int[] addValueKToArrayStartingFromI(int[] A, int[][] Q) {
    int n = A.length;
    if (n == 0) {
      return A;
    }
    if (Q.length == 0) {
      return A; // If no queries, return the original array
    }
    for (int[] q : Q) {
      int index = q[0];
      /*
       * What if the query is 1-based index?
       * Then decrement index by 1 like below
       */
      // index = index - 1;

      int value = q[1];
      if (index < 0) {
        index = 0; // Adjust index to be non-negative
      } else if (index >= n) {
        continue; // Skip invalid indices
      }
      A[index] = A[index] + value; // Add value to the specified index
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
