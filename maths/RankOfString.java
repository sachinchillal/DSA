package maths;

import helper.TestCaseArray;

public class RankOfString {

  static TestCaseArray[] TestCases = {
      new TestCaseArray("ABC", 1),
      new TestCaseArray("ACB", 2),
      new TestCaseArray("BAC", 3),
      new TestCaseArray("BCA", 4),
      new TestCaseArray("CAB", 5),
      new TestCaseArray("CBA", 6),

      new TestCaseArray("ABDC", 2),
      new TestCaseArray("BCD", 1),
      new TestCaseArray("BDC", 2),
      new TestCaseArray("ZYX", 6),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = (int) findRank(testCase.S);
      if ((result == expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + (expected) + ", Result: " + (result) + "\n");
      }
      count++;
    }
  }

  /**
   * Given a string str, find its rank among all its permutations when sorted
   * lexicographically.
   * 
   * Note: The characters in string are all unique.
   * 
   * Examples:
   * 
   * Input: str = "acb"
   * Output: 2
   * Explanation: If all the permutations of the string are arranged
   * lexicographically they will be "abc", "acb", "bac", "bca", "cab", "cba". From
   * here it can be clearly that the rank of str is 2.
   * 
   * Input: str = "string"
   * Output: 598
   * 
   * Input: str[] = "cba"
   * Output: Rank = 6
   */

  /**
   * Calculates the factorial of a non-negative integer.
   * 
   * @param n The number to calculate the factorial of.
   * @return The factorial of n.
   */
  static long factorial(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }
    long fact = 1;
    for (int i = 2; i <= n; i++) {
      fact = fact * i;
    }
    return fact;
  }

  /**
   * Finds the lexicographical rank of a string among its permutations.
   * Note: The characters in the string are assumed to be unique.
   *
   * @param str The input string.
   * @return The lexicographical rank of the string.
   */
  static public long findRank(String S) {
    int n = S.length();
    long rank = 1; // Initialize rank as 1 (for 1-based ranking)

    for (int i = 0; i < n; i++) {
      // Count characters smaller than str.charAt(i) to the right
      int countSmallerRight = 0;
      for (int j = i + 1; j < n; j++) {
        if (S.charAt(j) < S.charAt(i)) {
          countSmallerRight++;
        }
      }

      // Calculate permutations of remaining characters
      long remainingPermutations = factorial(n - 1 - i);

      // Add the contribution of the current character to the rank
      rank += countSmallerRight * remainingPermutations;
    }

    return rank;
  }

}
