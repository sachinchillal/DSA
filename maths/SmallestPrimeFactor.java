package maths;

import java.util.Arrays;

import helper.TestCaseArray;

public class SmallestPrimeFactor {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(0, new int[] {}),
      new TestCaseArray(1, new int[] { 1 }),
      new TestCaseArray(2, new int[] { 1, 2 }),
      new TestCaseArray(3, new int[] { 1, 2, 3 }),
      new TestCaseArray(4, new int[] { 1, 2, 3, 2 }),
      new TestCaseArray(5, new int[] { 1, 2, 3, 2, 5 }),
      new TestCaseArray(6, new int[] { 1, 2, 3, 2, 5, 2 }),
      new TestCaseArray(7, new int[] { 1, 2, 3, 2, 5, 2, 7 }),
      new TestCaseArray(8, new int[] { 1, 2, 3, 2, 5, 2, 7, 2 }),
      new TestCaseArray(9, new int[] { 1, 2, 3, 2, 5, 2, 7, 2, 3 }),
      new TestCaseArray(10, new int[] { 1, 2, 3, 2, 5, 2, 7, 2, 3, 2 }),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      int[] result = smallestPrimeFactorsFrom1ToN(testCase.N);
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
   * To find smallest prime factors from 1 to N using Sieve of Eratosthenes
   * algorithm.
   * Example: N = 10
   * [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
   * [0, 1, 2, 3, 2, 5, 6, 7, 8, 9, 10]
   * [0, 1, 2, 3, 2, 5, 2, 7, 8, 9, 10]
   * [0, 1, 2, 3, 2, 5, 2, 7, 2, 9, 10]
   * [0, 1, 2, 3, 2, 5, 2, 7, 2, 9, 2]
   * [0, 1, 2, 3, 2, 5, 2, 7, 2, 3, 2]
   * 
   * @param N
   * @return
   */
  public static int[] smallestPrimeFactorsFrom1ToN(int n) {
    int[] spf = new int[n + 1];
    // Initialize spf array
    for (int i = 0; i <= n; i++) {
      spf[i] = i;
    }
    // System.out.println(Arrays.toString(spf));

    // Iterate from 2 to sqrt(n)
    for (int i = 2; i * i <= n; i++) {
      // If i is prime (spf[i] == i)
      if (spf[i] == i) {
        // Update spf for multiples of i
        for (int j = i * i; j <= n; j += i) {
          if (spf[j] == j) {
            spf[j] = i;
            // System.out.println(Arrays.toString(spf));
          }
        }
      }
    }

    // return spf;
    return Arrays.copyOfRange(spf, 1, n + 1);
  }

  static void printArray(int i, int j, boolean[] A) {
    System.out.print("(" + i + ", " + j + ") ");
    for (int k = 0; k < A.length; k++) {
      if (A[k]) {
        System.out.print(k + " ");
      } else {
        System.out.print("X ");
      }
    }
    System.out.println();
  }

}
