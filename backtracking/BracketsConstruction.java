package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

import helper.TestCaseArray;

public class BracketsConstruction {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(0, new String[] {}),
      new TestCaseArray(1, new String[] { "()" }),
      new TestCaseArray(2, new String[] { "(())", "()()" }),
      new TestCaseArray(3, new String[] { "((()))", "(()())", "(())()", "()(())", "()()()" }),
      new TestCaseArray(4, new String[] { "(((())))", "((()()))", "((())())", "((()))()",
          "(()(()))", "(()()())", "(()())()", "(())(())", "(())()()", "()((()))", "()(()())",
          "()(())()", "()()(())", "()()()()" })
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      String[] expected = testCase.Rs_Array;
      String[] result = prepareValidBracketsStrings(testCase.N);
      if (Arrays.equals(result, expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + Arrays.toString(expected) + ", Result: " + Arrays.toString(result) + "\n");
      }
      count++;
    }
  }

  static String[] prepareValidBracketsStrings(int N) {
    if (N < 1) {
      return new String[] {};
    }
    ArrayList<String> R = new ArrayList<>();
    prepareCombinations(N, "", 0, 0, R);
    return R.toArray(new String[0]);
  }

  static void prepareCombinations(int N, String S, int opening, int closing, ArrayList<String> R) {
    if (S.length() == 2 * N) {
      // System.out.println(S);
      R.add(S);
      return;
    }
    // System.out.println("[" + opening + ", " + closing + "] " + S);
    if (opening < N) {
      prepareCombinations(N, S + '(', opening + 1, closing, R);
    }
    if (closing < opening) {
      prepareCombinations(N, S + ')', opening, closing + 1, R);
    }
    // System.out.println("[" + opening + ", " + closing + "] " + S);
  }

}
