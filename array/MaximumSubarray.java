public class MaximumSubarray {

  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, 0),
      new TestCaseArray(new int[] { 1 }, 1),
      new TestCaseArray(new int[] { 1, 2 }, 2),
      new TestCaseArray(new int[] { 2, 1 }, 3),
      new TestCaseArray(new int[] { 1, 1 }, 1),

      new TestCaseArray(new int[] { 2, 1, 3 }, 3),
      new TestCaseArray(new int[] { 2, 1, 3, 4 }, 4),
      new TestCaseArray(new int[] { 3, 2, 1, 4 }, 6),
      new TestCaseArray(new int[] { 1 }, 1),
      new TestCaseArray(new int[] { 1, 2, 3 }, 3),

      new TestCaseArray(new int[] { 3, 2, 1 }, 6),
      new TestCaseArray(new int[] { 1, 3, 2 }, 5),
      new TestCaseArray(new int[] { 1, 3, 2, 4 }, 5),
      new TestCaseArray(new int[] { 1, 3, 2, 4, 6, 5 }, 11),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 10 }, 21),

      new TestCaseArray(new int[] { 1, 2, 3, 1, 4, 5, 6, 7, 8, 9, 10, 1, 0 }, 11),
      new TestCaseArray(new int[] { 1, 2, 0, 3, 4, 5, 6, 7, 8, 9, 10, 22, 11 }, 33),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = findMaxSumOfDecreasingSubarray(testCase.A);
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
   * Find the maximum possible sum of a subarray with descreasing values.
   */
  public static int findMaxSumOfDecreasingSubarray(int[] A) {
    int n = A.length;

    if (n == 0) {
      return 0;
    }
    int max = A[0];
    int currentSum = A[0];
    for (int i = 1; i < n; i++) {
      if (A[i - 1] > A[i]) {
        currentSum += A[i];
      } else {
        max = Math.max(max, currentSum);
        currentSum = A[i];
      }
    }
    max = Math.max(max, currentSum); // for the last subarray

    return max;
  }
}
