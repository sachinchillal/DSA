package hash;

import java.util.HashSet;

import helper.TestCaseArray;

public class LongestSubString {

  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {
        new TestCaseArray("a", "aaa"),
        new TestCaseArray("abc", "abc"),
        new TestCaseArray("ab", "ababab"),
        new TestCaseArray("abcd", "abcabcdabc"),
    };

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      String expected = testCase.Rs;
      String S = (String) testCase.params[0];
      String result = longestSubStringNonRepeatingChars(S);
      // String result = longestSubStringNonRepeatingChars2(S);
      if (result.equals(expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  public static String longestSubStringNonRepeatingChars(String S) {
    String R = "";
    // HashSet for Uniqueness
    HashSet<Character> set = new HashSet<>();
    // Two pointers approach
    int start = 0;
    int c = 0; // chars count
    for (int end = 0; end < S.length(); end++) {
      if (set.contains(S.charAt(end))) {
        start = end;
        set.clear();
      }
      set.add(S.charAt(end));
      int cc = end - start + 1;// current count
      c = Math.max(c, end - start + 1);
      if (cc >= c) {
        // if (cc >= c) { // overrides all matching lengths
        R = S.substring(start, end + 1);
      }
    }
    return R;
  }

  public static String longestSubStringNonRepeatingChars2(String S) {
    String R = "";
    // HashSet for Uniqueness
    HashSet<Character> set = new HashSet<>();
    // Two pointers approach
    int start = 0;
    int c = 0; // chars count
    for (int end = 0; end < S.length(); end++) {
      while (set.contains(S.charAt(end))) {
        set.remove(S.charAt(end));
        start++;
      }

      set.add(S.charAt(end));
      int cc = end - start + 1;// current count
      c = Math.max(c, end - start + 1);
      if (cc > c) {
        // if (cc >= c) { // overrides all matching lengths
        R = S.substring(start, end + 1);
      }
    }
    return R;
  }
}
