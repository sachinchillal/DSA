package heap;

import java.util.ArrayList;
import java.util.Arrays;

import helper.TestCaseArray;

public class MaxActivitySelection {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, new int[] {}, 0),
      new TestCaseArray(new int[] { 1 }, new int[] { 2 }, 1),
      new TestCaseArray(new int[] { 1, 2 }, new int[] { 2, 3 }, 1),
      new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { 2, 3, 4 }, 2),
      new TestCaseArray(new int[] { 1, 2, 3, 4 }, new int[] { 2, 3, 4, 5 }, 2),

      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, new int[] { 2, 3, 4, 5, 6 }, 3),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, new int[] { 2, 3, 4, 5, 6, 7 }, 3),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, new int[] { 2, 3, 4, 5, 6, 7, 8 }, 4),
      new TestCaseArray(new int[] { 1, 3, 5, 7, 9 }, new int[] { 2, 4, 6, 8, 10 }, 5),
      new TestCaseArray(new int[] { 12, 2, 10, 6, 8, 4 }, new int[] { 13, 3, 11, 7, 9, 5 }, 6),

      new TestCaseArray(new int[] { 15, 6, 3, 4, 8, 7, 5, 14 }, new int[] { 16, 7, 4, 5, 9, 8, 6, 15 }, 4),
      new TestCaseArray(new int[] { 1, 3, 0, 5, 8, 5 }, new int[] { 2, 4, 6, 7, 9, 9 }, 4),
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = finishMaximumActivitiesJob(testCase.A, testCase.B);
      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  static int finishMaximumActivitiesJob(int[] start, int[] end) {
    int n = start.length;
    int[][] activities = new int[n][2];
    for (int i = 0; i < n; i++) {
      activities[i][0] = start[i];
      activities[i][1] = end[i];
    }

    // Sort activities based on their finish times
    Arrays.sort(activities, (a, b) -> Integer.compare(a[1], b[1]));

    // Select the maximum number of activities
    int R = 0;
    int lastFinishTime = -1;
    for (int i = 0; i < n; i++) {
      if (activities[i][0] > lastFinishTime) {
        R++;
        lastFinishTime = activities[i][1];
      }
    }
    return R;
  }

  static int selectMaxActivities(ArrayList<Integer> start, ArrayList<Integer> end) {
    int n = start.size();
    int[][] activities = new int[n][2];
    for (int i = 0; i < n; i++) {
      activities[i][0] = start.get(i);
      activities[i][1] = end.get(i);
    }

    // Sort activities based on their finish times
    Arrays.sort(activities, (a, b) -> Integer.compare(a[1], b[1]));

    // Select the maximum number of activities
    int R = 0;
    int lastFinishTime = -1;
    for (int i = 0; i < n; i++) {
      if (activities[i][0] > lastFinishTime) {
        R++;
        lastFinishTime = activities[i][1];
      }
    }
    return R;
  }

}
