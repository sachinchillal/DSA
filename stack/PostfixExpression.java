package stack;

import java.util.Stack;

import helper.TestCaseArray;

public class PostfixExpression {
  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {
        new TestCaseArray(new String[] { "1", "2", "+" }, 3),
        new TestCaseArray(new String[] { "1", "2", "-" }, -1), // * 1-2
        new TestCaseArray(new String[] { "1", "2", "*" }, 2),
        new TestCaseArray(new String[] { "1", "2", "/" }, 0), // * 1/2
        new TestCaseArray(new String[] { "1", "2", "5", "*", "+" }, 11), // 1 + 2 * 5
        new TestCaseArray(new String[] { "2", "5", "*", "3", "-" }, 7), // 2 * 5 - 3
        new TestCaseArray(new String[] { "2", "5", "*", "3", "-", "4", "+" }, 11), // 2 * 5 - 3 + 4
        new TestCaseArray(new String[] { "2", "5", "*", "3", "-", "4", "6", "+", "*" }, 70), // (2 * 5 - 3) * (4 + 6)
    };

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = calculatePostExpression(testCase.As);
      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  public static int calculatePostExpression(String[] A) {
    if (A.length == 0) {
      return 0;
    }
    Stack<Integer> stack = new Stack<>();
    for (String t : A) {
      int a = 0;
      int b = 0;
      switch (t) {
        case "+":
          a = stack.pop();
          b = stack.pop();
          stack.push(a + b);
          break;
        case "-":
          a = stack.pop();
          b = stack.pop();
          stack.push(b - a);
          break;
        case "*":
          a = stack.pop();
          b = stack.pop();
          stack.push(a * b);
          break;
        case "/":
          a = stack.pop();
          b = stack.pop();
          stack.push(b / a);
          break;

        default:
          a = Integer.valueOf(t);
          stack.push(a);
          break;
      }
    }
    if (stack.size() == 1) {
      return stack.pop();
    }

    return 0;
  }
}
