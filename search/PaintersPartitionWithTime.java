package search;

import helper.TestCaseArray;

public class PaintersPartitionWithTime {

  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, 1, 2, 0),
      new TestCaseArray(new int[] { 1 }, 1, 2, 2),
      new TestCaseArray(new int[] { 1, 2 }, 2, 2, 4),
      new TestCaseArray(new int[] { 1, 2, 3 }, 2, 2, 6),
      new TestCaseArray(new int[] { 1, 2, 3, 4 }, 2, 2, 12),

      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 2, 3, 27),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 2, 3, 33),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 2, 3, 45),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, 2, 3, 63),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 2, 3, 72),

      new TestCaseArray(new int[] { 1 }, 3, 4, 4),
      new TestCaseArray(new int[] { 1, 2 }, 3, 4, 8),
      new TestCaseArray(new int[] { 1, 2, 3 }, 3, 4, 12),
      new TestCaseArray(new int[] { 1, 2, 3, 4 }, 3, 5, 20),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 3, 5, 30),

      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 3, 6, 54),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3, 6, 66),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, 3, 7, 105),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 3, 7, 119),
      // not sorted
      new TestCaseArray(new int[] { 1, 4, 2, 5, 9, 6, 7, 3, 8 }, 3, 8, 144),
  };

  public static void main(String[] args) {
    // To test cases from the PaintersPartition.java
    // TestCases = PaintersPartition.TestCases;

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;

      int result = minimumTimRequiredToPaintWithTime(testCase.A, testCase.Bi, (testCase.Ci == 0) ? 1 : testCase.Ci);
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
   * 
   * @param A[i] no. of time required to paint i board
   * @param K    no. of painter available
   * @param T    time required to paint one board
   * @return n minimum time required
   */
  public static int minimumTimRequiredToPaintWithTime(int[] A, int K, int T) {
    int n = A.length;
    if (n == 0) {
      return 0;
    }
    // low = minTime = min time required is Max of A[i] and * T
    // high = maxTime = max time required is Sum of A
    long low = A[0] * T;
    long high = 0;
    for (int a : A) {
      low = Math.max(low, a * T);
      high += a * T;
    }
    // System.out.println(low + " " + high);

    int R = 0;

    while (low <= high) {
      long mid = low + (high - low) / 2;
      if (isPossible(A, K, T, mid)) {
        R = (int) mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return R;
  }

  static boolean isPossible(int[] A, int totalPainters, int T, long time) {
    int currentTime = 0;
    int painters = 1;
    for (int a : A) {
      currentTime += a * T;
      if (currentTime > time) {
        painters++;
        currentTime = a * T;
      }
      if (painters > totalPainters) {
        return false;
      }
    }
    return true;
  }
}