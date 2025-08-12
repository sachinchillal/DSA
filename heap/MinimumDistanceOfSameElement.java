package heap;

import helper.TestCaseArray;

public class MinimumDistanceOfSameElement {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, -1),
      new TestCaseArray(new int[] { 1 }, -1),
      new TestCaseArray(new int[] { 1, 1 }, 1),

      new TestCaseArray(new int[] { 1, 1, 2 }, new int[] { 1 }),
      new TestCaseArray(new int[] { 1, 2, 1 }, new int[] { 2 }),
      new TestCaseArray(new int[] { 2, 1, 1 }, new int[] { 1 }),

      new TestCaseArray(new int[] { 2, 1, 1, 2 }, new int[] { 1 }),
      new TestCaseArray(new int[] { 2, 1, 2, 1 }, new int[] { 1 }),
      new TestCaseArray(new int[] { 1, 2, 2, 1 }, new int[] { 1 }),
      new TestCaseArray(new int[] { 1, 2, 1, 1 }, new int[] { 1 }),

      new TestCaseArray(new int[] { 1, 2, 1, 1, 2 }, new int[] { 1 }),
      new TestCaseArray(new int[] { 1, 2, 1, 1, 2, 3 }, new int[] { 1 }),
      new TestCaseArray(new int[] { 1, 2, 1, 3, 2, 3 }, new int[] { 1 }),
      new TestCaseArray(new int[] { 1, 2, 1, 3, 2, 3, 2 }, new int[] { 1 }),
      new TestCaseArray(new int[] { 1, 2, 1, 3, 2, 3, 3 }, new int[] { 1 }),
      new TestCaseArray(new int[] { 1, 2, 1, 3, 2, 3, 2, 3, 4 }, new int[] { 1 }),
      new TestCaseArray(new int[] { 1, 2, 1, 3, 2, 3, 2, 3, 4, 5 }, new int[] { 1 }),
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = mindistancesOfEqualElements(testCase.A);
      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println(expected + " Expected");
        System.out.println(result + " Result\n");
      }
      count++;
    }
  }

  static int mindistancesOfEqualElements(int[] A) {
    int R = -1;
    if (A.length < 2) {
      return R;
    }

    return R;
  }
}
