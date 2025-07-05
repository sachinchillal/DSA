import java.util.Arrays;

import helper.TestCaseArray;

public class StringLengthDecreasing {

  static TestCaseArray[] TestCases = {
      new TestCaseArray(new String[] { "aa", "a" }, new String[] { "aa", "a" }),
      new TestCaseArray(new String[] { "aa", "a", "aaa" }, new String[] { "aaa", "aa", "a" }),
      new TestCaseArray(new String[] { "aa", "bb", "a", "aaa" }, new String[] { "aaa", "aa", "bb", "a" }),
      new TestCaseArray(new String[] { "aa", "bb", "a", "aa", "aaa" }, new String[] { "aaa", "aa", "aa", "bb", "a" }),
      new TestCaseArray(new String[] { "JAVA", "PDF", "C", "C++", "PYTHON", "JS", "HTML", "CSS" },
          new String[] { "PYTHON", "HTML", "JAVA", "C++", "CSS", "PDF", "JS", "C" })
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      String[] expected = testCase.Rs_Array;
      String[] result = rearrangeWords(testCase.As);
      if (Arrays.equals(result, expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out
            .println("Expected: " + Arrays.toString(expected) + ", Result: " + Arrays.toString(result) + "\n");
      }
      count++;
    }
  }

  /**
   * Given an array of strings S of size N. Rearrange the words in
   * A such that all words are rearranged in an decreasing order of their lengths.
   * If two words have the same length, arrange them in their original order.
   *
   * @param S An array of strings.
   * @return The rearranged array of strings.
   */
  public static String[] rearrangeWords(String[] S) {
    if (S == null || S.length == 0) {
      return S;
    }

    // Sort the rearranged array based on the length of the words.
    Arrays.sort(S, (a, b) -> {
      int c = b.length() - a.length();
      if (c == 0) {
        return a.compareTo(b);
      }
      return c;
    });

    return S;
  }

  public static String[] rearrangeWords2(String[] S) {
    if (S == null || S.length == 0) {
      return S;
    }

    // Create a copy of the original array to maintain the original order.
    String[] rearranged = Arrays.copyOf(S, S.length);

    // Sort the rearranged array based on the length of the words.
    Arrays.sort(rearranged, (a, b) -> {
      int c = Integer.compare(b.length(), a.length());
      if (c == 0) {
        return a.compareTo(b);
      }
      return c;
    });

    return rearranged;
  }

}