package stack;

import java.util.Stack;

import helper.TestCaseArray;

public class BallPassingGame {
  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {

        new TestCaseArray(1, new int[] { 1 }, 1, 1),
        new TestCaseArray(1, new int[] { 1, 2 }, 1, 1),
        new TestCaseArray(2, new int[] { 1, 2 }, 2, 1),
        new TestCaseArray(2, new int[] { 1, 2 }, 2, 2),
        new TestCaseArray(30, new int[] { 10, 20, -1, 30 }, 4, 2),

    };

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int[] A = (int[]) testCase.params[0];
      int P = (int) testCase.params[1];
      int C = (int) testCase.params[2];
      int result = whoHoldsBallAtTheEnd(A, P, C);
      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  /*
   * Rules:
   * 1. No. of Passes = P
   * 2. Player Holding Ball = C
   * 3. -1 in A[] indicates ball is back passed
   */
  public static int whoHoldsBallAtTheEnd(int[] A, int P, int C) {
    Stack<Integer> stack = new Stack<>();
    int ballHolder = C;
    for (int i = 0; i < P; i++) {
      if (A[i] == -1) {
        stack.pop();
      } else {
        stack.push(A[i]);
        ballHolder = A[i];
      }
    }

    return ballHolder;
  }

}
