package stack;

import java.util.Stack;
import helper.TestCaseArray;

public class DuplicateConsecutiveCharacters {

  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {
        new TestCaseArray("abc", "abc"),
        new TestCaseArray("abcc", "ab"),
        new TestCaseArray("abcddc", "ab"),
        new TestCaseArray("xx1yywzzwiwz", "1iwz"),
    };

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      String expected = testCase.Rs;
      String result = removeDuplicateConsecutiveChars(testCase.S);

      if ((result.equals(expected))) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  public static String removeDuplicateConsecutiveChars(String A) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < A.length(); i++) {
      Character c = A.charAt(i);
      if (stack.size() > 0 && stack.peek() == c) {
        stack.pop();
      } else {
        stack.push(c);
      }
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      Character c = stack.pop();
      sb.insert(0, c);
    }
    return sb.toString();
  }
}
