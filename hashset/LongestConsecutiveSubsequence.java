package hashset;

import java.util.HashSet;

import helper.TestCaseArray;

public class LongestConsecutiveSubsequence {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, 0),
      new TestCaseArray(new int[] { 3 }, 1),
      new TestCaseArray(new int[] { -5 }, 1),
      new TestCaseArray(new int[] { 1, 2 }, 2),
      new TestCaseArray(new int[] { 2, 1 }, 2),
      new TestCaseArray(new int[] { 1, 3 }, 1),
      new TestCaseArray(new int[] { 3, 1, 3, 3 }, 1),

      new TestCaseArray(new int[] { 2, 3, 1, 2 }, 3),
      new TestCaseArray(new int[] { 2, 3, 1, 5, 6 }, 3),
      new TestCaseArray(new int[] { 1, 5, 6, 7, 3, 2, 8 }, 4),
      new TestCaseArray(new int[] { 1, 5, 6, 7, 3, 8, 9, 10, 2 }, 6),
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = longestConsecutive(testCase.A);
      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  /**
   * Given an unsorted array of integers, find the length of the longest
   * consecutive elements sequence.
   * A = [100, 4, 200, 1, 3, 2]
   * The longest consecutive elements sequence is [1, 2, 3, 4].
   * Return its length: 4.
   * Your algorithm should run in O(n) complexity.
   * 
   * @param A
   * @return
   */
  public static int longestConsecutive(int[] A) {
    HashSet<Integer> s = new HashSet<>();
    for (int num : A) {
      s.add(num);
    }

    int longestStreak = 0;

    for (int num : s) {
      // Check if it's the start of a sequence
      if (!s.contains(num - 1)) {
        int currentNum = num;
        int currentStreak = 1;

        // Count the length of the sequence
        while (s.contains(currentNum + 1)) {
          currentNum++;
          currentStreak++;
        }

        longestStreak = Math.max(longestStreak, currentStreak);
      }
    }

    return longestStreak;
  }
}
