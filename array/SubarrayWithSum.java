import java.util.Arrays;

import helper.TestCaseArray;

public class SubarrayWithSum {

  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, 2, new int[] {}),
      new TestCaseArray(new int[] { 1, 2, 3 }, 1, new int[] { 1 }),
      new TestCaseArray(new int[] { 1, 2, 3 }, 2, new int[] { 2 }),
      new TestCaseArray(new int[] { 1, 2, 3 }, 3, new int[] { 1, 2 }),

      new TestCaseArray(new int[] { 1, 2, 3 }, 4, new int[] {}),
      new TestCaseArray(new int[] { 1, 2, 3 }, 5, new int[] { 2, 3 }),
      new TestCaseArray(new int[] { 1, 2, 3 }, 6, new int[] { 1, 2, 3 }),

      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 6, new int[] { 1, 2, 3 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 7, new int[] { 3, 4 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 8, new int[] {}),

      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 9, new int[] { 2, 3, 4 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 10, new int[] { 1, 2, 3, 4 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 12, new int[] { 3, 4, 5 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 15, new int[] { 1, 2, 3, 4, 5 })
  };

  public static void main(String[] args) {
    System.err.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      int[] result = getSubarrayWithGivenSum(testCase.A, testCase.N);
      if (Arrays.equals(result, expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + Arrays.toString(expected) + ", Result: " + Arrays.toString(result) + "\n");
      }
      count++;
    }
  }

  static int[] getSubarrayWithGivenSum(int[] A, int B) {
    long n = A.length;

    if (n == 0) {
      return new int[] {};
    }

    int left = 0, right = 0;
    long sum = A[left];

    while (right < n) {
      if (sum == B) {
        // current window sum = B
        int[] R = new int[right - left + 1];
        int k = 0;
        for (int i = left; i <= right; i++) {
          R[k++] = A[i];
        }
        return R;
      } else if (sum < B) {
        // current window sum < B
        right++;
        if (right < n)
          sum += A[right];
      } else {
        // current window sum > B
        sum -= A[left];
        left++;
        if (left > right && left < n - 1) {
          right++;
          sum += A[right];
        }
      }
    }
    return new int[] {};
  }
}
