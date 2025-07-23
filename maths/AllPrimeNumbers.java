package maths;

import java.util.ArrayList;
import java.util.Arrays;

import helper.TestCaseArray;

public class AllPrimeNumbers {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(0, new int[] {}),
      new TestCaseArray(1, new int[] {}),
      new TestCaseArray(2, new int[] { 2 }),
      new TestCaseArray(3, new int[] { 2, 3 }),
      new TestCaseArray(4, new int[] { 2, 3 }),

      new TestCaseArray(5, new int[] { 2, 3, 5 }),
      new TestCaseArray(6, new int[] { 2, 3, 5 }),
      new TestCaseArray(7, new int[] { 2, 3, 5, 7 }),
      new TestCaseArray(10, new int[] { 2, 3, 5, 7 }),
      new TestCaseArray(14, new int[] { 2, 3, 5, 7, 11, 13 }),
      new TestCaseArray(60, new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59 }),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      int[] result = findAllPrimeNumbers(testCase.N);
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
   * All prime numbers from 1 to N using Sieve of Eratosthenes algorithm.
   * 
   * @param N
   * @return
   */
  public static int[] findAllPrimeNumbers(int N) {
    int[] R = new int[N];
    boolean[] isPrime = new boolean[N + 1];
    Arrays.fill(isPrime, true);

    for (int i = 2; i * i <= N; i++) {
      if (isPrime[i]) {
        for (int j = i * i; j <= N; j += i) {
          isPrime[j] = false;
          // printArray(i, j, isPrime); // for tracing the sieve process
        }
      }
    }

    int index = 0;
    for (int i = 2; i <= N; i++) {
      if (isPrime[i]) {
        R[index++] = i;
      }
    }

    return Arrays.copyOf(R, index);
  }

  public static int[] findAllPrimeNumbers2(int N) {
    int[] R = new int[N];
    boolean[] isPrime = new boolean[N + 1];
    Arrays.fill(isPrime, true);

    for (int i = 2; i <= Math.sqrt(N); i++) {
      if (isPrime[i]) {
        for (int j = i * i; j <= N; j += i) {
          isPrime[j] = false;
          // printArray(i, j, isPrime); // for tracing the sieve process
        }
      }
    }

    int index = 0;
    for (int i = 2; i <= N; i++) {
      if (isPrime[i]) {
        R[index++] = i;
      }
    }

    return Arrays.copyOf(R, index);
  }

  public static int[] findAllPrimeNumbers3(int n) {
    if (n < 2) {
      return new int[] {};
    }
    boolean[] isPrime = new boolean[n + 1];
    isPrime[0] = isPrime[1] = true; // 0 and 1 are not prime
    for (int i = 2; i * i <= n; i++) {
      if (!isPrime[i]) {
        for (int j = i * i; j <= n; j += i) {
          isPrime[j] = true;
          // printArray(i, j, isPrime); // for tracing the sieve process
        }
      }
    }
    ArrayList<Integer> R = new ArrayList<>();
    for (int i = 2; i <= n; i++) {
      if (!isPrime[i]) {
        R.add(i);
      }
    }

    return R.stream().mapToInt(i -> i).toArray();
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
