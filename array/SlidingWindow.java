import java.util.Arrays;

import helper.TestCaseArray;

public class SlidingWindow {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, 1, new int[] {}),
      new TestCaseArray(new int[] { 1 }, 1, new int[] { 1 }),
      new TestCaseArray(new int[] { 1, 2 }, 2, new int[] { 3 }),
      new TestCaseArray(new int[] { 1, 2, 3 }, 2, new int[] { 3, 5 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4 }, 2, new int[] { 3, 5, 7 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 3, new int[] { 6, 9, 12, 15 }),
      new TestCaseArray(new int[] { 5, 4, 3, 2, 1 }, 3, new int[] { 12, 9, 6 }),
      new TestCaseArray(new int[] { 1, -2, 3, -4, 5 }, 3, new int[] { 2, -3, 4 }),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      int[] result = slidingWindow(testCase.A, testCase.N);
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
   * Using sliding window technique to calculate the sliding window sums.
   * 
   * @param A
   * @param W
   * @return
   */
  public static int[] slidingWindow(int[] A, int W) {
    int n = A.length;
    if (n == 0) {
      return new int[] {};
    }
    if (W > n) {
      W = n; // Adjust window size if it exceeds array length
    }
    int iterations = n - W + 1;
    int[] R = new int[iterations];
    int windowSum = 0;
    // Calculate the sum of the first W elements
    for (int i = 0; i < W; i++) {
      windowSum += A[i];
    }
    R[0] = windowSum;

    int k = 1;
    // Sliding the window across the array
    for (int i = W; i < n; i++) {
      windowSum = windowSum + A[i] - A[i - W];
      R[k] = windowSum;
      k++;
    }
    return R;

  }

  /**
   * Using prefix sum to calculate the sliding window sums.
   * 
   * @param A
   * @param W
   * @return
   */
  public static int[] slidingWindow2(int[] A, int W) {
    int n = A.length;
    if (n == 0) {
      return new int[] {};
    }
    if (W > n) {
      W = n; // Adjust window size if it exceeds array length
    }
    int[] prefixSum = new int[n];
    prefixSum[0] = A[0];
    for (int i = 1; i < n; i++) {
      prefixSum[i] = A[i] + prefixSum[i - 1];
    }
    int Rsize = n - W + 1;
    int[] R = new int[Rsize];
    R[0] = prefixSum[W - 1]; // First window sum
    for (int i = 1; i < Rsize; i++) {
      R[i] = prefixSum[i + W - 1] - prefixSum[i - 1];
    }
    return R;
  }

}
