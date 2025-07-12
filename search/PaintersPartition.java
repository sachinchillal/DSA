package search;

import helper.TestCaseArray;

public class PaintersPartition {

  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, 1, 0),
      new TestCaseArray(new int[] { 1 }, 1, 1),
      new TestCaseArray(new int[] { 1, 2 }, 2, 2),
      new TestCaseArray(new int[] { 1, 2, 3 }, 2, 3),
      new TestCaseArray(new int[] { 1, 2, 3, 4 }, 2, 6),

      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 2, 9),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 2, 11),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 2, 15),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, 2, 21),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 2, 24),

      new TestCaseArray(new int[] { 1 }, 3, 1),
      new TestCaseArray(new int[] { 1, 2 }, 3, 2),
      new TestCaseArray(new int[] { 1, 2, 3 }, 3, 3),
      new TestCaseArray(new int[] { 1, 2, 3, 4 }, 3, 4),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 3, 6),

      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 3, 9),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3, 11),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, 3, 15),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 3, 17),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 5, 15),
      // not sorted
      new TestCaseArray(new int[] { 1, 4, 2, 5, 9, 6, 7, 3, 8 }, 3, 18),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = minimumTimRequiredToPaint(testCase.A, testCase.N);
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
   * Similar Problem: Painter's Partition Problem
   * 1. Painters Partition Problem with time
   * 2. Shipping Packages (Ship Packages within D Days)
   * 3. Allocate Books (Allocate Books to students)
   * 4. Allocate Minimum Number of Pages (Allocate pages to students)
   * 5. Allocate Minimum Number of Chocolates (Allocate chocolates to students)
   * 
   * @param A[i] no. of time required to paint i board
   * @param K    no. of painter available
   * @return n minimum time required
   */
  public static int minimumTimRequiredToPaint(int[] A, int K) {
    int n = A.length;
    if (n == 0) {
      return 0;
    }
    // low = minTime = min time required is Max of A[i]
    // high = maxTime = max time required is Sum of A
    long low = A[0];
    long high = 0;
    for (int a : A) {
      low = Math.max(low, a);
      high += a;
    }
    // System.out.println(low + " " + high);

    int R = 0;

    while (low <= high) {
      long mid = low + (high - low) / 2;
      // System.out.println(mid);
      if (isPossible(A, K, mid)) {
        R = (int) mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return R;
  }

  static boolean isPossible(int[] A, int totalPainters, long time) {
    int currentTime = 0;
    int painters = 1;
    for (int a : A) {
      currentTime += a;
      if (currentTime > time) {
        painters++;
        currentTime = a;
      }
      if (painters > totalPainters) {
        return false;
      }
    }
    return true;
  }
}
