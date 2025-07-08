package maths;

import java.util.Arrays;

import helper.TestCaseArray;

public class CalculateNCR {
  static TestCaseArray[] TestCases = {
      // new TestCaseArray(0, 0, 0, 1),
      // new TestCaseArray(1, 0, 0, 1),
      new TestCaseArray(0, 0, 1, 0),
      new TestCaseArray(0, 0, 1, 0),
      new TestCaseArray(0, 1, 1, 0),
      new TestCaseArray(1, 1, 1, 0),
      new TestCaseArray(1, 1, 2, 1),
      new TestCaseArray(2, 1, 2, 0),
      new TestCaseArray(2, 2, 2, 1),
      new TestCaseArray(21, 7, 2, 0),
      new TestCaseArray(21, 7, 3, 0),
      new TestCaseArray(5, 3, 1000, 10),
      new TestCaseArray(11, 3, 1000, 165),
      new TestCaseArray(21, 3, 1000, 330),
      new TestCaseArray(21, 7, 1000, 280),
      new TestCaseArray(21, 20, 3, 0),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int r = (int) testCase.params[0];
      int m = (int) testCase.params[1];
      int expected = (int) testCase.params[2];
      // int = testCase.R;
      int result = calculateNCR(testCase.R, r, m);

      if ((result == expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + (expected) + ", Result: " + (result) + "\n");
      }
      count++;
    }
  }

  static int calculateNCR1(int n, int r, int m) {
    if (m == 1) {
      return 0;
    }

    if (r > n - r) {
      r = n - r;
    }

    int[] dp = new int[r + 1];
    dp[0] = 1;

    for (int i = 1; i <= n; i++) {
      for (int j = Math.min(i, r); j >= 1; j--) {
        dp[j] = (dp[j] + dp[j - 1]) % m;
        // printArray(i, j, dp);
      }
    }

    return dp[r];
  }

  /**
   * Using recursion
   * 
   * @param N
   * @param R
   * @param m
   * @return
   */
  static int calculateNCRRecur(int N, int R, int m) {
    if (m == 1) {
      return 0;
    }
    if (R > N - R) {
      R = N - R;
    }
    if (R == 0 || R == N) {
      return 1;
    }
    // Using the property nCr = (n - 1)C(r - 1) + (n - 1)Cr
    return (calculateNCRRecur(N - 1, R - 1, m) + calculateNCRRecur(N - 1, R, m)) % m;
  }

  static int calculateNCRUsingFactorial(int N, int R, int m) {
    if (m == 1 || m == 0) {
      return 0;
    }
    if (R > N) {
      return 0;
    }
    return factorial(N) / (factorial(R) * factorial(N - R)) % m;
  }

  static int factorial(int n) {
    int R = 1;
    for (int i = 2; i <= n; i++) {
      R = R * i;
    }
    return R;
  }

  static int calculateNCR(int N, int R, int m) {
    if (N > R) {
      R = Math.min(R, N - R); // nCr = nC(n-r)
    }
    // The C[N][R] stores the value of nCr based on N and R
    int[][] C = new int[N + 1][R + 1];
    for (int i = 0; i <= N; i++) {
      for (int j = 0; j <= Math.min(i, R); j++) {
        if (j == i || j == 0) {
          C[i][j] = 1;
        } else {
          // Formula or Property nCr = (n - 1)C(r - 1) + (n - 1)Cr
          C[i][j] = (C[i - 1][j - 1] % m + C[i - 1][j] % m) % m;
        }
        // printArray(i, j, C);
      }
    }
    return C[N][R] % m;
  }

  static void printArray(int i, int j, int[] A) {
    System.out.print("(" + i + ", " + j + ") ");
    for (int k = 0; k < A.length; k++) {
      System.out.print(A[k] + " ");
    }
    System.out.println();
  }

  static void printArray(int i, int j, int[][] A) {
    System.out.println("(" + i + ", " + j + ")");
    for (int k = 0; k < A.length; k++) {
      System.out.println(Arrays.toString(A[k]) + " ");
    }
    System.out.println();
  }
}
