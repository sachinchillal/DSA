package bitwise;

import java.util.Arrays;

import helper.TestCaseArray;

public interface PairOperations {

  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { 0 }, new int[] { 2 }),
      new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { 0, 1 }, new int[] { 2, 2 }),
      new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { 0, 1, 2 }, new int[] { 2, 2, 0 }),
      new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { 0, 1, 2, 3 }, new int[] { 2, 2, 0, 0 }),

      new TestCaseArray(new int[] { 2, 4, 6, 8 }, new int[] { 1 }, new int[] { 4 }),
      new TestCaseArray(new int[] { 2, 4, 6, 8 }, new int[] { 2 }, new int[] { 4 }),
      new TestCaseArray(new int[] { 2, 4, 6, 8 }, new int[] { 3 }, new int[] { 3 }),
      new TestCaseArray(new int[] { 2, 4, 6, 8 }, new int[] { 4 }, new int[] { 0 }),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      int[] result = countXorPairs(testCase.A, testCase.B);
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
   * Benjamin and XOR
   * Counts the number of pairs in an array for which the XOR of a specific bit is
   * one.
   *
   * @param A The input array of integers.
   * @param Q An array of bit indices to be queried.
   * @return A list of long integers containing the count for each query.
   */
  public static int[] countXorPairs(int[] A, int[] Q) {
    int[] R = new int[Q.length];

    int i = 0;
    for (int bitIndex : Q) {
      long countOfZeros = 0;
      long countOfOnes = 0;

      for (int num : A) {
        // Check the value of the bit at the given index
        if (((num >> bitIndex) & 1) == 1) {
          countOfOnes++;
        } else {
          countOfZeros++;
        }
      }

      // The number of pairs with differing bits is the product of the counts
      long pairsCount = countOfZeros * countOfOnes;
      R[i++] = (int) pairsCount;
    }

    return R;
  }

}
