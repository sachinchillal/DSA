import helper.TestCaseArray;

public class MaximumSubarraySumWithSize {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, 1, 0),
      new TestCaseArray(new int[] { 1 }, 1, 1),
      new TestCaseArray(new int[] { 1, 2 }, 2, 3),
      new TestCaseArray(new int[] { 1, 2, 3 }, 2, 5),
      new TestCaseArray(new int[] { 1, 2, 3, 4 }, 2, 7),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 3, 12),
      new TestCaseArray(new int[] { 5, 4, 3, 2, 1 }, 3, 12),
      new TestCaseArray(new int[] { 1, -2, 3, -4, 5 }, 3, 4),
      new TestCaseArray(new int[] { -1, -2, -3, -4, -5 }, 2, -3),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 5, 40),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = maximumSubarraySumWithSize(testCase.A, testCase.N);
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
   * its related to sliding window technique
   * Time Complexity: O(n) Space Complexity: O(1)
   */
  public static int maximumSubarraySumWithSize(int[] A, int W) {
    int n = A.length;
    if (n == 0) {
      return 0;
    }
    int windowSum = 0;
    // Calculate the sum of the first W elements
    for (int i = 0; i < W; i++) {
      windowSum += A[i];
    }

    int maxSum = windowSum;
    // Sliding the window across the array
    for (int i = W; i < n; i++) {
      // A[i] is current element, A[i - W] is the last element of the previous window
      windowSum = windowSum + A[i] - A[i - W];
      maxSum = Math.max(maxSum, windowSum); // Update max if the new sum is greater
    }
    return maxSum;
  }

}
