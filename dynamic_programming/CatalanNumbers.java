package dynamic_programming;

import helper.TestCaseArray;

public class CatalanNumbers {

  static TestCaseArray[] TestCases = {
      new TestCaseArray(1, 1),
      new TestCaseArray(2, 2),
      new TestCaseArray(3, 5),
      new TestCaseArray(4, 14),
      new TestCaseArray(5, 42),
      new TestCaseArray(6, 132),
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = numberOfUniqueBSTs(testCase.N);
      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  /**
   * This method calculates the nth Catalan number using dynamic programming.
   * The number of structurally unique BST's for n nodes is the nth Catalan
   * number.
   * C_n = (2n)! / ((n+1)! * n!)
   *
   * @param A The number of nodes (1...N)
   * @return The number of structurally unique BSTs
   */
  static int numberOfUniqueBSTs(int n) {
    if (n <= 0) {
      return 1; // There is one unique BST for 0 nodes (the empty tree).
    }

    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        // The number of unique BSTs with 'i' nodes is the sum of products
        // of unique BSTs for the left and right subtrees.
        // j nodes on the left, (i-1-j) nodes on the right.
        dp[i] += dp[j] * dp[i - 1 - j];
      }
    }
    return dp[n];
  }

}