
import helper.TestCaseArray;

public class OverlappingIntervals {

  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[][] { { 0, 1 }, { 2, 3 } }, 0),
      new TestCaseArray(new int[][] { { 1, 5 }, { 3, 7 }, { 6, 10 }, { 9, 12 } }, 3),
      new TestCaseArray(new int[][] { { 0, 10 }, { 1, 5 }, { 2, 6 } }, 3),
      new TestCaseArray(new int[][] { { 0, 1 }, { 2, 3 }, { 4, 5 } }, 0),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = countOverlappingPairs(testCase.R_2Array);
      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out
            .println("Expected: " + (expected) + ", Result: " + (result) + "\n");
      }
      count++;
    }
  }

  /**
   * Given a set of intervals, this method finds the total number of pairs of
   * intervals that overlap.
   * The time complexity of this approach is O(n^2), where n is the number of
   * intervals.
   *
   * @param intervals A 2D array where each inner array represents an interval,
   *                  e.g., [[start1, end1], [start2, end2]].
   * @return The total count of overlapping interval pairs.
   */
  public static int countOverlappingPairs(int[][] intervals) {
    // If there are less than two intervals, no pairs can be formed.
    if (intervals == null || intervals.length < 2) {
      return 0;
    }

    int n = intervals.length;
    int overlapCount = 0;

    // Iterate through each interval with the first loop.
    for (int i = 0; i < n; i++) {
      // The second loop iterates through the subsequent intervals to form unique
      // pairs.
      for (int j = i + 1; j < n; j++) {
        int[] interval1 = intervals[i];
        int[] interval2 = intervals[j];

        // An overlap exists if the maximum start time is less than or equal to the
        // minimum end time.
        // max(start1, start2) <= min(end1, end2)
        if (Math.max(interval1[0], interval2[0]) <= Math.min(interval1[1], interval2[1])) {
          overlapCount++;
        }
      }
    }

    return overlapCount;
  }

}