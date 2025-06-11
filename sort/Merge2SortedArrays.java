// package sort;

import java.util.Arrays;

import helper.TestCaseArray;

public class Merge2SortedArrays {

  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {
        new TestCaseArray(new int[] { 1, 2 }, new int[] { 3, 4 }, new int[] { 1, 2, 3, 4 }),
        new TestCaseArray(new int[] { 3, 4 }, new int[] { 1, 2 }, new int[] { 1, 2, 3, 4 }),
        new TestCaseArray(new int[] { 1, 3 }, new int[] { 2, 4 }, new int[] { 1, 2, 3, 4 }),
        new TestCaseArray(new int[] { 2, 3, 4 }, new int[] { 1 }, new int[] { 1, 2, 3, 4 }),
        new TestCaseArray(new int[] { 1, 3, 4 }, new int[] { 2 }, new int[] { 1, 2, 3, 4 }),
        new TestCaseArray(new int[] { 1, 2, 4 }, new int[] { 3 }, new int[] { 1, 2, 3, 4 }),
        new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { 4 }, new int[] { 1, 2, 3, 4 }),
        new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { 5, 6, 7 }, new int[] { 1, 2, 3, 5, 6, 7 }),
        new TestCaseArray(new int[] { 1, 3 }, new int[] { 5, 7 }, new int[] { 1, 3, 5, 7 }),
        new TestCaseArray(new int[] { 1, 3, 5 }, new int[] { 7, 9 }, new int[] { 1, 3, 5, 7, 9 }),
        new TestCaseArray(new int[] { 6 }, new int[] { 5, 7 }, new int[] { 5, 6, 7 }),
    };
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] A = testCase.A;
      int[] B = testCase.B;
      int[] expected = testCase.R_Array;
      int[] result = mergeTwoSortedArrays(A, B);
      if (Arrays.equals(expected, result)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + Arrays.toString(expected) + ", Result: " + Arrays.toString(result) + "\n");
      }
      count++;
    }
  }

  private static int[] mergeTwoSortedArrays(int[] A, int[] B) {
    int i = 0, j = 0, k = 0;

    int n = A.length;
    int m = B.length;
    // int[] R = new int[] {};
    int[] R = new int[n + m];
    while (i < n && j < m) {
      if (A[i] < B[j]) {
        R[k] = A[i];
        i++;
        k++;
      } else {
        R[k] = B[j];
        j++;
        k++;
      }
    }
    while (i < n) {
      R[k++] = A[i++];
    }
    while (j < m) {
      R[k++] = B[j++];
    }
    int mid = (m + n) / 2;
    if ((m + n) % 2 == 0) {
      int v = (R[mid] + R[mid - 1]) / 2;
      System.out.println(v);
    } else {
      System.out.println(R[mid]);
    }

    return R;
  }

}