package pair;

import java.util.HashMap;

import helper.TestCaseArray;

public class AllPairs {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, new int[] {}, new int[] {}, 0),
      new TestCaseArray(new int[] { 1, 2 }, new int[] { 1, 1 }, new int[] { 2, 2 }, 2),
      new TestCaseArray(new int[] { 1, 2 }, new int[] { 1, 1 }, new int[] { 2, 2 }, 2),
      new TestCaseArray(new int[] { 1, 2 }, new int[] { 1, 2 }, new int[] { 2, 2 }, 2),
      new TestCaseArray(new int[] { 1, 2 }, new int[] { 2, 1 }, new int[] { 2, 2 }, 2),

      new TestCaseArray(new int[] { 2, 3, 3 }, new int[] { 1, 3, 3 }, new int[] { 1, 1, 1 }, 0),
      new TestCaseArray(new int[] { 6, 5, 10 }, new int[] { 5, 6, 7 }, new int[] { 1, 0, 1 }, 2),
      new TestCaseArray(new int[] { 1, 1, 2, 8 }, new int[] { 3, 2, 1, 4 }, new int[] { 2, 1, 0, 1 }, 1)
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = countAllPairs(testCase.A, testCase.B, testCase.C);
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
   * Finds the count of all pairs of indices (x, y) such that A[x-1] is equal to
   * B[C[y-1]-1].
   * A[x] = B[C[y]]
   * Note: The problem uses 1-based indexing (1<=x, y<=N), which maps to 0-based
   * array indices (0<=i, j<N) in the implementation.
   *
   * @param A An integer array.
   * @param B An integer array.
   * @param C An integer array containing 1-based indices for array B.
   * @return The total count of valid pairs.
   */
  public static int countAllPairs(int[] A, int[] B, int[] C) {
    if (A == null || B == null || C == null) {
      return 0;
    }

    // Use a HashMap to store the frequency of each number in array A.
    // Key: number, Value: count of that number.
    HashMap<Integer, Integer> frequencyOfA = new HashMap<>();
    for (int value : A) {
      frequencyOfA.put(value, frequencyOfA.getOrDefault(value, 0) + 1);
    }

    // Use a long for the count to prevent potential integer overflow if N is large.
    int totalPairs = 0;

    // Iterate through the indices for C (and implicitly B).
    for (int j = 0; j < C.length; j++) {
      // Get the 1-based index from array C.
      int oneBasedIndexForB = C[j];

      // Convert the 1-based index to a 0-based index for array B.
      int zeroBasedIndexForB = oneBasedIndexForB - 1;

      // Ensure the converted 0-based index is valid for array B.
      if (zeroBasedIndexForB >= 0 && zeroBasedIndexForB < B.length) {
        int targetValue = B[zeroBasedIndexForB];
        totalPairs += frequencyOfA.getOrDefault(targetValue, 0);
      }
    }

    return totalPairs;
  }

}
