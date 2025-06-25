package search;

import helper.TestCaseArray;

public class MedianOfTwoSortedArrays {

  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, new int[] {}, 0),
      new TestCaseArray(new int[] { 1 }, new int[] { 2 }, 1),
      new TestCaseArray(new int[] { 1 }, new int[] { 2, 3 }, 2),
      new TestCaseArray(new int[] { 2 }, new int[] { 1, 5 }, 2),
      new TestCaseArray(new int[] { 2 }, new int[] { 1, 3, 5 }, 2),
      new TestCaseArray(new int[] { 1, 2 }, new int[] { 3, 4 }, 2),

      // Case 1
      new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 }, 3),

      new TestCaseArray(new int[] { 4, 5, 6 }, new int[] { 1, 2, 3 }, 3),

      new TestCaseArray(new int[] { 1, 3, 5 }, new int[] { 2, 4, 6 }, 3),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, new int[] { 10 }, 4),
      new TestCaseArray(new int[] { 1, 3, 5 }, new int[] { 1, 3, 5 }, 3),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = medianOf2SortedArrays(testCase.A, testCase.B);
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
   * @param A
   * @param B
   * @return median
   */
  public static int medianOf2SortedArrays(int[] A, int[] B) {
    int n = A.length;
    int m = B.length;
    if (n > m) {
      return medianOf2SortedArrays(B, A);
    }
    int low = 0, high = n;
    long L = n + m;
    while (low <= high) {
      int midA = low + (high - low) / 2;
      int midB = (int) (((L + 1) / 2) - midA);

      // because mid = n, its out of bound
      int a = midA == n ? Integer.MAX_VALUE : A[midA];
      // because mid=0, mid=0-1 is out of bound
      int a_1 = midA == 0 ? Integer.MIN_VALUE : A[midA - 1];

      int b = midB == m ? Integer.MAX_VALUE : B[midB];
      int b_1 = midB == 0 ? Integer.MIN_VALUE : B[midB - 1];

      if (a_1 <= b && b_1 <= a) {
        double median = 0.0;
        if (L % 2 == 0) {
          int leftMax = Math.max(a_1, b_1);
          int rightMin = Math.min(a, b);
          median = (leftMax + rightMin) / 2.0;
        } else {
          median = Math.max(a_1, b_1);
        }
        return (int) median;
      } else if (b_1 > a) {
        low = midA + 1;
      } else if (a_1 > b) {
        high = midA - 1;
      }
    }
    return 0;
  }

}
