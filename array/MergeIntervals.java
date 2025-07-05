
import java.util.ArrayList;
import java.util.Arrays;

import helper.TestCaseArray;

public class MergeIntervals {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[][] { new int[] { 1, 2 }, new int[] { 1, 4 } }, new int[][] { { 1, 4 } }),
      new TestCaseArray(new int[][] { new int[] { 1, 2 }, new int[] { 2, 4 } }, new int[][] { { 1, 4 } }),
      new TestCaseArray(new int[][] { new int[] { 1, 2 }, new int[] { 3, 4 } }, new int[][] { { 1, 2 }, { 3, 4 } }),

      new TestCaseArray(new int[][] { { 1, 3 }, { 2, 4 }, { 5, 6 } }, new int[][] { { 1, 4 }, { 5, 6 } }),
      new TestCaseArray(new int[][] { { 1, 3 }, { 2, 4 }, { 5, 7 }, { 6, 8 } }, new int[][] { { 1, 4 }, { 5, 8 } }),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[][] expected = testCase.R_2Array;
      int[][] result = mergeIntervals(testCase.A_2Array);
      if (Arrays.deepEquals(result, expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out
            .println("Expected: " + Arrays.deepToString(expected) + ", Result: " + Arrays.deepToString(result) + "\n");
      }
      count++;
    }
  }

  public static int[][] mergeIntervals(int[][] A) {
    Arrays.sort(A, (a, b) -> Integer.compare(a[0], b[0]));
    ArrayList<int[]> R = new ArrayList<>();
    int cs = A[0][0];
    int ce = A[0][1];

    for (int i = 0; i < A.length; i++) {
      if (ce >= A[i][0]) {
        ce = Math.max(ce, A[i][1]);
      } else {
        int[] aa = new int[2];
        aa[0] = cs;
        aa[1] = ce;
        R.add(aa);
        cs = A[i][0];
        ce = A[i][1];
      }
    }
    int[] aa = new int[2];
    aa[0] = cs;
    aa[1] = ce;
    R.add(aa);
    return R.toArray(new int[R.size()][]);
  }

  public static int[][] mergeIntervals2(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return new int[0][0];
    }

    // Sort intervals by their start time
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    ArrayList<int[]> merged = new ArrayList<>();
    int[] currentInterval = intervals[0];

    for (int i = 1; i < intervals.length; i++) {
      if (currentInterval[1] >= intervals[i][0]) {
        // Overlapping intervals, merge them
        currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
      } else {
        // No overlap, add the current interval to the list
        merged.add(currentInterval);
        currentInterval = intervals[i];
      }
    }
    // Add the last interval
    merged.add(currentInterval);

    // Convert List to array
    return merged.toArray(new int[merged.size()][]);
  }

}
