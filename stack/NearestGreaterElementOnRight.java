package stack;

import java.util.Arrays;
import java.util.Stack;
import helper.TestCaseArray;

public class NearestGreaterElementOnRight {

  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {
        new TestCaseArray(new int[] {}, new int[] {}),
        new TestCaseArray(new int[] { 1 }, new int[] { -1 }),
        new TestCaseArray(new int[] { 1, 2 }, new int[] { 2, -1 }),
        new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { 2, 3, -1 }),
        new TestCaseArray(new int[] { 1, 2, 3, 4 }, new int[] { 2, 3, 4, -1 }),
        new TestCaseArray(new int[] { 3, 2, 5, 4, 7, 6, 9, 8, 11, 10 },
            new int[] { 5, 5, 7, 7, 9, 9, 11, 11, -1, -1 }),

        new TestCaseArray(new int[] { 2, 1 }, new int[] { -1, -1 }),
        new TestCaseArray(new int[] { 3, 2, 1 }, new int[] { -1, -1, -1 }),
        new TestCaseArray(new int[] { 4, 3, 2, 1 }, new int[] { -1, -1, -1, -1 }),
    };

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      int[] result = findRightGreaterElement(testCase.A);

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
   * Next Greater Element I
   * Next Greater Element II
   * Daily Temperatures (find next greater temperature)
   * Online Stock Span (find previous greater element)
   */
  public static int[] findRightGreaterElement(int[] A) {
    int n = A.length;
    int[] R = new int[n];
    if (n == 0) {
      return R;
    }
    R[0] = -1;
    Stack<Integer> stack = new Stack<>();
    // Reverse the loop
    for (int i = n - 1; i > -1; i--) {
      while (stack.size() > 0 && stack.peek() <= A[i]) {
        stack.pop();
      }
      if (stack.size() == 0) {
        R[i] = -1;
      } else {
        R[i] = stack.peek();
      }
      stack.push(A[i]);
    }

    return R;
  }

}
