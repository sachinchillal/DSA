package greedy;

import java.util.HashMap;

import helper.TestCaseArray;

public class MinimumWindowSubstring {
  static TestCaseArray[] TestCases = {
      new TestCaseArray("KKKKKK", "KK", "KK"),
      new TestCaseArray("ABC", "B", "B"),
      new TestCaseArray("A_C--A", "AC", "A_C"),
      new TestCaseArray("ABCDEAXYZE", "AE", "EA"),
      new TestCaseArray("ABCDE_AXYZE", "AE", "E_A"),
      new TestCaseArray("ABCDE_0_AXYZE", "AE", "ABCDE"),
      new TestCaseArray("AB_CDE_0_AXYZE", "AE", "E_0_A"),
      new TestCaseArray("AB_CDE_10_AXYZE", "AE", "AXYZE"),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      String expected = testCase.Rs;
      String result = minWindow(testCase.S, testCase.S2);
      if (result.equals(expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  /**
   * Finds the minimum window substring of A that contains all characters of B.
   * TC: O(M+N) SP: O(M+N)
   * 
   * @param A The main string.
   * @param B The string of characters to find in the window.
   * @return The minimum window substring, or "-1" if no such substring exists.
   */
  static String minWindow(String A, String B) {
    if (B.length() == 0 || A.length() == 0 || A.length() < B.length()) {
      return "-1";
    }

    HashMap<Character, Integer> targetMap = new HashMap<>();
    for (char c : B.toCharArray()) {
      targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
    }

    int required = targetMap.size();
    int left = 0, right = 0;
    int formed = 0;
    int minLength = Integer.MAX_VALUE;
    String result = "-1";
    int start = 0;

    HashMap<Character, Integer> windowMap = new HashMap<>();

    while (right < A.length()) {
      // Expand the window by moving the right pointer
      char c = A.charAt(right);
      windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

      if (targetMap.containsKey(c) && windowMap.get(c).intValue() == targetMap.get(c).intValue()) {
        formed++;
      }

      while (left <= right && formed == required) {
        // System.out.println(formed);
        // System.out.println(windowMap);
        if (right - left + 1 < minLength) {
          minLength = right - left + 1;
          start = left;
          result = A.substring(start, start + minLength);
        }
        // Remove characters from the left side of the window
        char leftChar = A.charAt(left);
        windowMap.put(leftChar, windowMap.get(leftChar) - 1);

        if (targetMap.containsKey(leftChar)
            && windowMap.get(leftChar).intValue() < targetMap.get(leftChar).intValue()) {
          formed--;
        }
        left++;
      }
      // System.out.println("left: " + left + ", right: " + right);
      // System.out.println("Result: " + result);
      right++;
    }
    return result;
  }
}