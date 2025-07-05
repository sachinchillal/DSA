import java.util.ArrayList;
import java.util.Arrays;

import helper.TestCaseArray;

public class SpecialIndexAfterRemovingAnElement {

  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] { 1, 2 }, new int[] {}),
      new TestCaseArray(new int[] { 1, 2, 3 }, new int[] {}),
      new TestCaseArray(new int[] { 1, 2, 4, 6 }, new int[] {}),
      new TestCaseArray(new int[] { 2, 1, 4, 6 }, new int[] {}),
      new TestCaseArray(new int[] { 2, 1, 6, 4 }, new int[] { 1 }),
      new TestCaseArray(new int[] { 1, 2, 2 }, new int[] { 0 }),
      new TestCaseArray(new int[] { 2, 2, 1 }, new int[] { 2 }),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      int[] result = specialIndicesAfterRemovingAnElement(testCase.A);
      if (Arrays.equals(result, expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + Arrays.toString(expected) + ", Result: " + Arrays.toString(result) + "\n");
      }
      count++;
    }
  }

  /**
   * Calculate special indices after removing an element.
   * Sum of Even Indices == Sum of Odd Indices
   * 
   * @param A
   * @return
   */
  public static int[] specialIndicesAfterRemovingAnElement(int[] A) {
    int n = A.length;
    if (n == 0) {
      return new int[] {};
    }
    ArrayList<Integer> R = new ArrayList<>();
    int[] pSumEven = new int[n];
    int[] pSumOdd = new int[n];
    pSumEven[0] = A[0];
    pSumOdd[0] = 0;
    for (int i = 1; i < n; i++) {
      if (i % 2 == 0) {
        pSumEven[i] = A[i] + pSumEven[i - 1];
        pSumOdd[i] = pSumOdd[i - 1];
      } else {
        pSumOdd[i] = A[i] + pSumOdd[i - 1];
        pSumEven[i] = pSumEven[i - 1];
      }
    }
    for (int i = 0; i < n; i++) {
      int evenSum = 0;
      int oddSum = 0;
      if (i == 0) {
        evenSum = (pSumOdd[n - 1] - pSumOdd[i]);
        oddSum = (pSumEven[n - 1] - pSumEven[i]);
      } else {
        // Sum of even indices excluding i
        evenSum = pSumEven[i - 1] + (pSumOdd[n - 1] - pSumOdd[i]);
        oddSum = pSumOdd[i - 1] + (pSumEven[n - 1] - pSumEven[i]);
      }
      if (evenSum == oddSum) {
        R.add(i);
      }
    }

    return R.stream().mapToInt(i -> i).toArray();
  }

}
