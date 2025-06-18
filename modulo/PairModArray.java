package modulo;

import helper.TestCaseArray;

public class PairModArray {

  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {
        new TestCaseArray(0, new int[] { 1 }, 1),
        new TestCaseArray(0, new int[] { 1, 2 }, 2),
        new TestCaseArray(1, new int[] { 1, 2, 3 }, 3),

        new TestCaseArray(1, new int[] { 1, 2, 3, 4 }, 4),
        new TestCaseArray(4, new int[] { 1, 2, 3, 4, 5 }, 3),
        new TestCaseArray(6, new int[] { 1, 2, 3, 4, 5, 6 }, 2),

        new TestCaseArray(21, new int[] { 1, 2, 3, 4, 5, 6, 7 }, 1),
        new TestCaseArray(6, new int[] { 7, 19, 13, 21 }, 2),
    };

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int[] A = (int[]) testCase.params[0];
      int B = (int) testCase.params[1];
      int result = pairMod(A, B);
      // int result = pairMod2(A, B);
      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  private static int pairMod(int A[], int B) {
    double mod = Math.pow(10, 9) + 7;
    long c = 0;
    long[] CNT = new long[B];
    for (int i : A) {
      CNT[(int) (i % B)]++;
    }
    c = (CNT[0] * (CNT[0] - 1)) / 2;
    c = (long) ((c % mod + mod) % mod);
    int i = 1;
    int j = B - 1;
    while (i <= j) {
      if (i == j) {
        c += (CNT[i] * (CNT[j] - 1)) / 2;
      } else {
        c += CNT[i] * CNT[j];
      }

      // c = (long) (c % mod);
      c = (long) ((c % mod + mod) % mod);
      i++;
      j--;
    }
    return (int) c;
    // O(N) + O(B) / O(B)
  }

  public static int pairMod2(int A[], int m) {
    // this solution is not working
    int c = 0;
    int[] f = new int[m];
    for (int i = 0; i < f.length; i++) {
      int v = A[i] % m;
      int reqV = 0;
      if (v == 0) {
        reqV = 0;
      } else {
        reqV = m - v;
      }
      c += f[reqV];
      f[v]++;
    }
    return c;
  }

}