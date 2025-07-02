package stack;

import java.util.Arrays;
import java.util.Stack;

import helper.TestCaseArray;

public class LargestRectangleInHistogram {

  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {
        new TestCaseArray(new int[] {}, 0),
        new TestCaseArray(new int[] { 0 }, 0),
        new TestCaseArray(new int[] { -30 }, 0),
        new TestCaseArray(new int[] { 1 }, 1),
        new TestCaseArray(new int[] { 3 }, 3),

        new TestCaseArray(new int[] { 1, 2 }, 2),
        new TestCaseArray(new int[] { 3, 1, 2 }, 3),
        new TestCaseArray(new int[] { 1, 2, 3 }, 4),
        new TestCaseArray(new int[] { 1, 3, 2 }, 4),
        new TestCaseArray(new int[] { 2, 3, 1 }, 4),

        new TestCaseArray(new int[] { 3, 2, 1 }, 4),
        new TestCaseArray(new int[] { 1, 2, 3, 4 }, 6),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 9),
    };

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = largestRectangleAreaInHistogram(testCase.A);
      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  public static int largestRectangleAreaInHistogram(int[] A) {
    int R = 0;
    int n = A.length;
    Stack<Integer> s = new Stack<>();

    for (int i = 0; i <= n; i++) {
      int height = (i == n) ? 0 : A[i];

      if (height == 0) {
        System.out.println(Arrays.toString(new int[] { i, n }));
      }

      while (s.size() > 0 && A[s.peek()] > height) {
        int h = A[s.pop()];
        int width = s.isEmpty() ? i : i - s.peek() - 1;
        R = Math.max(R, h * width);
      }
      s.push(i);
    }

    return R;
  }

}
