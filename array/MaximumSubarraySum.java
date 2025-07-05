import helper.TestCaseArray;

public class MaximumSubarraySum {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, 0),
      new TestCaseArray(new int[] { 1 }, 1),
      new TestCaseArray(new int[] { 1, 2 }, 3),
      new TestCaseArray(new int[] { 1, 2, 3 }, 6),
      new TestCaseArray(new int[] { 1, 2, 3, 4 }, 10),

      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 15),
      new TestCaseArray(new int[] { 1, 2, -3, 4, 5 }, 9),
      new TestCaseArray(new int[] { 1, 2, 3, -4, 5 }, 7),
      new TestCaseArray(new int[] { 1, 2, 3, 2, -4, 4 }, 8),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = maxSumOfSubarray(testCase.A);
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
   * Given an array A, calculate the maximum sum of all possible subarray sums.
   * 
   * @param A
   * @return
   */
  public static int maxSumOfSubarray(int[] A) {
    int n = A.length;
    if (n == 0) {
      return 0;
    }
    int sum = 0;
    int maxSum = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      sum = Math.max(A[i], sum + A[i]);
      maxSum = Math.max(maxSum, sum);
    }

    return maxSum;
  }

}
