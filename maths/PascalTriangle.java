package maths;

import java.util.Arrays;

import helper.TestCaseArray;

public class PascalTriangle {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(0, new int[][] { { 1 } }),
      new TestCaseArray(1, new int[][] { { 1, 0 }, { 1, 1 } }),
      new TestCaseArray(2, new int[][] { { 1, 0, 0 }, { 1, 1, 0 }, { 1, 2, 1 } }),
      new TestCaseArray(3, new int[][] { { 1, 0, 0, 0 }, { 1, 1, 0, 0 }, { 1, 2, 1, 0 }, { 1, 3, 3, 1 } }),
      new TestCaseArray(4,
          new int[][] { { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 1, 2, 1, 0, 0 }, { 1, 3, 3, 1, 0 },
              { 1, 4, 6, 4, 1 } }),
      new TestCaseArray(5,
          new int[][] { { 1, 0, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0, 0 }, { 1, 2, 1, 0, 0, 0 }, { 1, 3, 3, 1, 0, 0 },
              { 1, 4, 6, 4, 1, 0 }, { 1, 5, 10, 10, 5, 1 } })
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[][] expected = testCase.R_2Array;
      int[][] result = pascalTriangle(testCase.N);

      if (Arrays.deepEquals(result, expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out
            .println("Expected: " + Arrays.deepToString(expected) + ", Result: " + Arrays.deepToString(result) + "\n");
      }
      count++;
    }
  }

  static int[][] pascalTriangle(int N) {
    if (N < 0) {
      return new int[][] {};
    }
    // The C[N][R] stores the value of nCr based on N and R
    int[][] C = new int[N + 1][N + 1];
    for (int i = 0; i <= N; i++) {
      for (int j = 0; j <= Math.min(i, N); j++) {
        if (j == i || j == 0) {
          C[i][j] = 1;
        } else {
          // Formula or Property nCr = (n - 1)C(r - 1) + (n - 1)Cr
          C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]);
        }
        // printArray(i, j, C);
      }
    }
    return C;
  }

  static int[][] pascalTriangle2(int n) {
    if (n < 0) {
      return new int[][] {};
    }
    int[][] R = new int[n + 1][n + 1];
    R[0][0] = 1;
    for (int i = 0; i <= n; i++) {
      R[i][0] = 1; // first and last values are 1
      R[i][i] = 1;
      for (int j = 1; j < i; j++) {
        R[i][j] = R[i - 1][j] + R[i - 1][j - 1];
      }
    }
    return R;
  }

  static void printArray(int i, int j, int[][] A) {
    System.out.println("(" + i + ", " + j + ")");
    for (int k = 0; k < A.length; k++) {
      System.out.println(Arrays.toString(A[k]) + " ");
    }
    System.out.println();
  }
}
