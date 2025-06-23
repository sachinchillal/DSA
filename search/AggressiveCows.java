package search;

import java.util.Arrays;

import helper.TestCaseArray;

public class AggressiveCows {

  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, 1, 0),
      new TestCaseArray(new int[] { 1 }, 1, 0),
      new TestCaseArray(new int[] { 1, 2 }, 2, 1),
      new TestCaseArray(new int[] { 1, 2, 3 }, 3, 1),
      new TestCaseArray(new int[] { 1, 2, 3, 4 }, 4, 1),

      new TestCaseArray(new int[] { 1, 3 }, 2, 2),
      new TestCaseArray(new int[] { 1, 4 }, 2, 3),
      new TestCaseArray(new int[] { 1, 11 }, 2, 10),
      new TestCaseArray(new int[] { 2, 7 }, 2, 5),
      new TestCaseArray(new int[] { 2, 7, 9 }, 2, 7),

      new TestCaseArray(new int[] { 2, 4, 6 }, 3, 2),
      new TestCaseArray(new int[] { 2, 6, 9 }, 3, 3),
      new TestCaseArray(new int[] { 2, 6, 9, 1 }, 3, 3),
      new TestCaseArray(new int[] { 2, 6, 9, 11 }, 3, 4),
      new TestCaseArray(new int[] { 2, 6, 9, 11, 1 }, 3, 5),

      new TestCaseArray(new int[] { 2, 5, 8, 11, 13, 14 }, 5, 3),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = minimumDistanceBetweenEachCow(testCase.A, testCase.Bi);
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
   * @param A[i] distance between each stall
   * @param K    no. of cows available
   * @return n minimum distance between each cow
   */
  public static int minimumDistanceBetweenEachCow(int[] A, int K) {
    int n = A.length;
    if (n == 0) {
      return 0;
    }
    // Sort it
    Arrays.sort(A);
    // low = minDistance = min distance is Max of A[i]
    // high = maxDistance = max distance is = (Max of A[i] - Min of A[i])
    long low = 0;
    long high = A[n - 1] - A[0];

    int R = 0;

    while (low <= high) {
      long mid = low + (high - low) / 2;
      // System.out.println(mid);
      if (isPossible(A, K, mid)) {
        R = (int) mid;
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return R;
  }

  static boolean isPossible(int[] A, int totalCows, long estimatedDistance) {
    int cows = 1;
    int lastLocation = 0;

    for (int i = 1; i < A.length; i++) {
      if ((A[i] - A[lastLocation]) >= estimatedDistance) {
        cows++;
        lastLocation = i;
      }
      if (cows == totalCows) {
        return true;
      }
    }
    return false;
  }
}
