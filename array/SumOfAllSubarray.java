import helper.TestCaseArray;

public class SumOfAllSubarray {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, 0),
      new TestCaseArray(new int[] { 1 }, 1),
      new TestCaseArray(new int[] { 1, 2 }, 6),
      new TestCaseArray(new int[] { 1, 2, 3 }, 20),
      new TestCaseArray(new int[] { 1, 2, 3, 4 }, 50),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 105),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = sumOfAllPossibleSubarraySums(testCase.A);
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
   * Given an array A, this function calculates the sum of all possible subarray
   * sums.
   * Each element A[i] contributes to several subarrays, and its contribution is
   * determined by how many subarrays it is part of.
   * 
   * Formula:
   * contribution of A[i] = A[i] * (i + 1) * (n - i)
   *
   * How to remember the formula?
   * - (i + 1) is the number of ways to choose a starting point for the subarray
   * - (n - i) is the number of ways to choose an ending point for the subarray
   * Thus, the total number of subarrays that include A[i] is (i + 1) * (n - i).
   * 
   * OR
   * 1 * 4 * A[i]
   * 2 * 3 * A[i]
   * 3 * 2 * A[i]
   * 4 * 1 * A[i]
   * (i+1) * (n-i) * A[i]
   * 
   * @param A
   * @return
   */
  public static int sumOfAllPossibleSubarraySums(int[] A) {
    int n = A.length;
    if (n == 0) {
      return 0;
    }
    int sum = 0;

    for (int i = 0; i < n; i++) {
      // System.out.println((i + 1) + " * " + (n - i) + " * " + A[i]);
      int contribution = A[i] * (i + 1) * (n - i);
      sum += contribution;
    }

    return sum;
  }

}
