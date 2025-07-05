import helper.TestCaseArray;

public class RunsInOver {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, 0, 0),
      new TestCaseArray(new int[] { 1 }, 0, 1),
      new TestCaseArray(new int[] { 1, 2 }, 1, 1),
      new TestCaseArray(new int[] { 1, 2, 3 }, 2, 1),
      new TestCaseArray(new int[] { 1, 2, 3, 4 }, 3, 1),

      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 4, 1),
      new TestCaseArray(new int[] { 10, 22, 35, 44, 65 }, -2, 0),
      new TestCaseArray(new int[] { 10, 22, 35, 44, 65 }, 0, 10),
      new TestCaseArray(new int[] { 10, 22, 35, 44, 65 }, 1, 12),
      new TestCaseArray(new int[] { 10, 22, 35, 44, 65 }, 2, 13),
      new TestCaseArray(new int[] { 10, 22, 35, 44, 65 }, 3, 9),

      new TestCaseArray(new int[] { 10, 22, 35, 44, 65 }, 4, 21),
      new TestCaseArray(new int[] { 10, 22, 35, 44, 65 }, 5, 0),
      new TestCaseArray(new int[] { 10, 22, 35, 44, 65 }, 6, 0),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = scoreInParticularOver(testCase.A, testCase.Bi);
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
   * Given an array A, find the runs scored in just ith over
   * 
   * Similar to:
   * 1. RangeQuerySumOfArray
   * 
   * @param A
   * @return
   */
  public static int scoreInParticularOver(int[] A, int i) {
    int n = A.length;
    if (n == 0) {
      return 0;
    }
    if (i < 0 || i >= n) {
      return 0; // Invalid over index
    }
    int runs = 0;
    runs = A[i] - (i > 0 ? A[i - 1] : 0);

    return runs;
  }

}
