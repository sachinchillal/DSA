package stack;

import java.util.Arrays;
import java.util.Stack;
import helper.TestCaseArray;

public class NearestSmallerElement {

  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {
        new TestCaseArray(new int[] {}, new int[] {}),
        new TestCaseArray(new int[] { 1 }, new int[] { -1 }),
        new TestCaseArray(new int[] { 1, 2 }, new int[] { -1, 1 }),
        new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { -1, 1, 2 }),
        new TestCaseArray(new int[] { 1, 2, 3, 4 }, new int[] { -1, 1, 2, 3 }),
        new TestCaseArray(new int[] { 3, 2, 5, 4, 7, 6, 9, 8, 11, 10 }, new int[] { -1, -1, 2, 2, 4, 4, 6, 6, 8, 8 }),

        new TestCaseArray(new int[] { 2, 1 }, new int[] { -1, -1 }),
        new TestCaseArray(new int[] { 3, 2, 1 }, new int[] { -1, -1, -1 }),
        new TestCaseArray(new int[] { 4, 3, 2, 1 }, new int[] { -1, -1, -1, -1 }),
    };

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      int[] result = findLeftSmallestElement(testCase.A);

      if (Arrays.equals(result, expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + Arrays.toString(expected) + ", Result: " + Arrays.toString(result) + "\n");
      }
      count++;
    }
  }

  public static int[] findLeftSmallestElement(int[] A) {
    int n = A.length;
    int[] R = new int[n];
    if (n == 0) {
      return R;
    }
    R[0] = -1;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
      while (stack.size() > 0 && stack.peek() >= A[i]) {
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

  public static int[] findLeftSmallestElement2(int[] A) {
    int n = A.length;
    int[] R = new int[n];
    if (n == 0) {
      return R;
    }
    R[0] = -1;
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    for (int i = 1; i < n; i++) {
      while (stack.size() > 0 && A[stack.peek()] >= A[i]) {
        stack.pop();
      }
      if (stack.size() == 0) {
        R[i] = -1;
      } else {
        // R[i] = stack.peek(); // to add Element's index
        R[i] = A[stack.peek()]; // to add Element
      }
      stack.push(i);
    }

    return R;
  }

}
