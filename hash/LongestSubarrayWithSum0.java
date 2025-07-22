package hash;

import java.util.HashMap;

import helper.TestCaseArray;

public class LongestSubarrayWithSum0 {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, 0),
      new TestCaseArray(new int[] { 1 }, 0),
      new TestCaseArray(new int[] { -1 }, 0),
      new TestCaseArray(new int[] { 1, -1 }, 2),
      new TestCaseArray(new int[] { 1, 2, -3, 3 }, 3),
      new TestCaseArray(new int[] { 1, 2, -3, 3, 4, -4 }, 4),

      new TestCaseArray(new int[] { 1, -1, 2, -2, 3, -3 }, 6),
      new TestCaseArray(new int[] { 4, -2, -2, 4 }, 3),
      new TestCaseArray(new int[] { -1, -1, -1, -1 }, 0),
      new TestCaseArray(new int[] { 0, 0, 0 }, 3),
      new TestCaseArray(new int[] { 5, -5, 10, -10 }, 4),
      new TestCaseArray(new int[] { 1, 2, 3, 5, 4 }, 0),
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = longestSubarrayWithSum0(testCase.A);
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
   * Given an array of integers, find the length of the longest subarray
   * with a sum of 0.
   * 
   * @param A
   * @return
   */
  public static int longestSubarrayWithSum0(int[] A) {
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, -1); // Handle case when subarray starts from index 0
    int maxLength = 0;
    int currentSum = 0;

    for (int i = 0; i < A.length; i++) {
      currentSum += A[i];

      if (map.containsKey(currentSum)) {
        int length = i - map.get(currentSum);
        maxLength = Math.max(maxLength, length);
      } else {
        map.put(currentSum, i);
      }
    }

    return maxLength;
  }
}
