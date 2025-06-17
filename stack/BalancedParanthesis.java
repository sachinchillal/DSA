package stack;

import java.util.Stack;
import helper.TestCaseArray;

public class BalancedParanthesis {

  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {
        new TestCaseArray("{}", true),
        new TestCaseArray("[]{}", true),
        new TestCaseArray("{[]}", true),
        new TestCaseArray("{[()]}", true),

        new TestCaseArray("{]", false),
        new TestCaseArray("}()", false),
    };

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      boolean expected = testCase.Rb;
      boolean result = isBalanced(testCase.Rs);

      if ((result == expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  public static boolean isBalanced(String A) {
    int n = A.length();
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
      Character c = A.charAt(i);
      if (c == '{' || c == '[' || c == '(') {
        stack.push(c);
      } else if (c == '}' || c == ']' || c == ')') {
        if (stack.isEmpty()) {
          return false;
        }
        Character top = stack.pop();
        if (c == '}' && top != '{' || c == ')' && top != '(' || c == ']' && top != '[') {
          return false;
        }
      }
    }

    return stack.isEmpty();
  }
}
