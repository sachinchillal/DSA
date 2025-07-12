
public class ContainerWater {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] { 1 }, 0),
      new TestCaseArray(new int[] { 2 }, 0),
      new TestCaseArray(new int[] { 3 }, 0),
      new TestCaseArray(new int[] { -5 }, 0),
      new TestCaseArray(new int[] { 1, 2 }, 1),

      new TestCaseArray(new int[] { 2, 3 }, 2),
      new TestCaseArray(new int[] { 1, 3 }, 1),
      new TestCaseArray(new int[] { 2, 3, 1, 2 }, 6),
      new TestCaseArray(new int[] { 2, 3, 1, 5, 6 }, 9),
      new TestCaseArray(new int[] { 1, 5, 6, 7, 3, 2 }, 10),

      new TestCaseArray(new int[] { 1, 5, 6, 7, 3, 8, 9, 10, 2 }, 30),
      new TestCaseArray(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }, 14),
      new TestCaseArray(new int[] { 1, 1, 3, 2, 1, 2, 5, 3, 2, 1, 4, 2 }, 24),
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] A = testCase.A;
      int expected = testCase.R;
      int result = calculateWater(A);
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
   * Find container with most water or max water between wall.
   * Container is partioned and can be treated like wall, and can hold water
   * between it.
   * 
   * @param A
   * @return
   */
  private static int calculateWater(int[] A) {
    int water = 0;
    int n = A.length;
    int left = 0;
    int right = n - 1;

    while (left < right) {
      int minWallHeight = Math.min(A[left], A[right]);
      int width = right - left;
      water = Math.max(water, minWallHeight * width);
      if (A[left] > A[right]) {
        right--;
      } else {
        left++;
      }
    }

    return water;
  }

}