
public class TrappingRainWater {
  public static void main(String[] args) {
    System.err.println();
    TestCaseArray[] TestCases = {
        new TestCaseArray(new int[] { 1 }, 0),
        new TestCaseArray(new int[] { 2 }, 0),
        new TestCaseArray(new int[] { 3 }, 0),
        new TestCaseArray(new int[] { -5 }, 0),
        new TestCaseArray(new int[] { 1, 2 }, 0),
        new TestCaseArray(new int[] { 2, 3 }, 0),
        new TestCaseArray(new int[] { 1, 3 }, 0),
        new TestCaseArray(new int[] { 2, 3, 1, 2 }, 1),
        new TestCaseArray(new int[] { 2, 3, 1, 5, 6 }, 2),
        new TestCaseArray(new int[] { 1, 5, 6, 7, 3, 2 }, 0),
        new TestCaseArray(new int[] { 1, 5, 6, 7, 3, 8, 9, 10, 2 }, 4),
        new TestCaseArray(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }, 6),
        new TestCaseArray(new int[] { 1, 1, 3, 2, 1, 2, 5, 3, 2, 1, 4, 2 }, 10),
    };
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

  private static int calculateWater(int[] A) {
    int water = 0;
    int n = A.length;
    int left = 0;
    int right = n - 1;
    int leftMax = 0;
    int rightMax = 0;
    while (left < right) {
      leftMax = Math.max(A[left], leftMax);
      rightMax = Math.max(A[right], rightMax);
      if (leftMax < rightMax) {
        water += leftMax - A[left];
        left++;
      } else {
        water += rightMax - A[right];
        right--;
      }
    }
    return water;
  }

}