package stack;

import java.util.Arrays;
import java.util.Stack;
import helper.TestCaseArray;

public class NearestSmallElement {

  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {
        new TestCaseArray(new int[] { 1, 2 }, new int[] { -1, 0 }),
        new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { -1, 0, 1 }),
        new TestCaseArray(new int[] { 1, 2, 3, 4 }, new int[] { -1, 0, 1, 2 }),
    };

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      int[] result = calculateLeftSmallElement(testCase.A);

      if (Arrays.equals(result, expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + Arrays.toString(result) + "\n");
      }
      count++;
    }
  }

  public static int[] calculateLeftSmallElement(int[] A) {
    int n = A.length;
    int[] R = new int[n];
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
        R[i] = stack.peek(); // to add Element's index
        // R[i] = A[stack.peek()]; // to add Element
      }
      stack.push(i);
    }

    return R;
  }
}
