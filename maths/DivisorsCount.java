package maths;

import java.util.Arrays;

import helper.TestCaseArray;

public class DivisorsCount {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(0, new int[] {}),
      new TestCaseArray(1, new int[] { 1 }),
      new TestCaseArray(2, new int[] { 1, 2 }),
      new TestCaseArray(3, new int[] { 1, 2, 2 }),
      new TestCaseArray(4, new int[] { 1, 2, 2, 3 }),

      new TestCaseArray(5, new int[] { 1, 2, 2, 3, 2 }),
      new TestCaseArray(6, new int[] { 1, 2, 2, 3, 2, 4 }),
      new TestCaseArray(7, new int[] { 1, 2, 2, 3, 2, 4, 2 }),
      new TestCaseArray(8, new int[] { 1, 2, 2, 3, 2, 4, 2, 4 }),
      new TestCaseArray(9, new int[] { 1, 2, 2, 3, 2, 4, 2, 4, 3 }),
      new TestCaseArray(10, new int[] { 1, 2, 2, 3, 2, 4, 2, 4, 3, 4 }),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      int[] result = noOfDivisorsFrom1ToN(testCase.N);
      if (Arrays.equals(result, expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + Arrays.toString(expected) + ", Result: " + Arrays.toString(result) + "\n");
      }
      count++;
    }
  }

  public static int[] noOfDivisorsFrom1ToN(int N) {
    if (N < 1) {
      return new int[] {};
    }
    int[] R = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      for (int j = i; j <= N; j += i) {
        R[j]++;
      }
    }
    return Arrays.copyOfRange(R, 1, N + 1);
  }

}
