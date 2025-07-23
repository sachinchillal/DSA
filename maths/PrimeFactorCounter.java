package maths;

import java.util.Arrays;

import helper.TestCaseArray;

public class PrimeFactorCounter {
  static TestCaseArray[] testCases = {
      new TestCaseArray(1, new int[] { 0 }),
      new TestCaseArray(2, new int[] { 0, 1 }),
      new TestCaseArray(3, new int[] { 0, 1, 1 }),
      new TestCaseArray(4, new int[] { 0, 1, 1, 2 }),
      new TestCaseArray(5, new int[] { 0, 1, 1, 2, 1 }),

      new TestCaseArray(6, new int[] { 0, 1, 1, 2, 1, 2 }),
      new TestCaseArray(7, new int[] { 0, 1, 1, 2, 1, 2, 1 }),
      new TestCaseArray(8, new int[] { 0, 1, 1, 2, 1, 2, 1, 3 }),
      new TestCaseArray(9, new int[] { 0, 1, 1, 2, 1, 2, 1, 3, 2 }),
      new TestCaseArray(10, new int[] { 0, 1, 1, 2, 1, 2, 1, 3, 2, 2 }),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : testCases) {
      int[] expected = testCase.R_Array;
      int[] result = countPrimeFactorsWithDuplicates(testCase.N);
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
   * Calculates the count of distinct prime factors for each number from 1 to n.
   * This method uses an efficient sieve-based algorithm.
   *
   * @param n The upper limit (inclusive) for the count.
   * @return An integer array `arr` of size n + 1, where `arr[i]` stores the
   *         number of distinct prime factors for the integer `i`.
   *         Note: `arr[0]` and `arr[1]` will be 0.
   */
  public static int[] primeFactorsCount(int n) {
    // Array to store the count of distinct prime factors.
    // Size is n + 1 for 1-based indexing (arr[i] corresponds to number i).
    int[] counts = new int[n + 1];

    // Iterate from 2 up to n.
    for (int i = 2; i <= n; i++) {
      // If counts[i] is 0, it means 'i' is a prime number.
      // A composite number would have been marked by its smaller prime factors.
      if (counts[i] == 0) {
        // Since 'i' is prime, iterate through all its multiples up to n.
        for (int j = i; j <= n; j += i) {
          // Increment the prime factor count for each multiple.
          counts[j]++;
        }
      }
    }
    return Arrays.copyOfRange(counts, 1, n + 1);
  }

  /**
   * Calculates the total count of prime factors (including duplicates) for each
   * number from 1 to n. This is also known as the Omega function, Ω(n).
   *
   * For example, for n = 12 (since 12 = 2 * 2 * 3), the count is 3.
   *
   * @param n The upper limit (inclusive) for the count.
   * @return An integer array `arr` of size n + 1, where `arr[i]` stores the
   *         total number of prime factors for the integer `i`.
   */
  public static int[] countPrimeFactorsWithDuplicates(int n) {
    // Step 1: Create a 'smallest prime factor' (spf) array using a sieve.
    int[] spf = new int[n + 1];
    // Initialize each number's smallest prime factor as the number itself.
    for (int i = 1; i <= n; i++) {
      spf[i] = i;
    }

    // The sieve runs up to sqrt(n) to mark the smallest prime factors.
    for (int i = 2; i * i <= n; i++) {
      // If 'i' is still its own smallest prime factor, it's a prime number.
      if (spf[i] == i) {
        // Mark 'i' as the smallest prime factor for all its multiples.
        for (int j = i * i; j <= n; j += i) {
          // Only update if it hasn't been marked by a smaller prime.
          if (spf[j] == j) {
            spf[j] = i;
          }
        }
      }
    }

    // Step 2: Calculate the total prime factors using the spf array.
    int[] counts = new int[n + 1];
    // counts[1] is 0 as 1 has no prime factors.
    counts[1] = 0;

    // Use the relationship: count(i) = 1 + count(i / spf[i])
    /*
     * Because 25 = 5 * 5 = 5^2, it has 2 prime factors (5, 5).
     * (2+1) = 3 (no. of divisors, 5, 5, 1), which is the count of prime factors
     * including duplicates.
     * For 12 = 2 * 2 * 3, it has 3 prime factors (2, 2, 3).
     * 
     * n=24 = 2 * 2 * 2 * 3, it has 4 prime factors (2, 2, 2, 3).
     * =2^3 * 3^1
     * no. of divisors = (3+1)(1+1) = 8 (1,2,3,4,6,8,12,24)
     * n=30 = 2 * 3 * 5, it has 3 prime factors (2, 3, 5).
     * =2^1 * 3^1 * 5^1
     * no. of divisors = (1+1)(1+1)(1+1) = 8 (1,2,3,5,6,10,15,30)
     * prime factor count = 3
     */
    for (int i = 2; i <= n; i++) {
      counts[i] = 1 + counts[i / spf[i]];
    }

    return Arrays.copyOfRange(counts, 1, n + 1);
  }

}
