package array_2d;

import helper.TestCaseArray;

public class SearchInSortedMatrix {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[][] { new int[] { 1 } }, 0, false),
      new TestCaseArray(new int[][] { new int[] { 1 } }, 1, true),
      new TestCaseArray(new int[][] { new int[] { 1, 2 } }, 1, true),
      new TestCaseArray(new int[][] { new int[] { 1, 2, 3 } }, 1, true),
      new TestCaseArray(new int[][] { new int[] { 1, 2, 3 } }, 2, true),

      new TestCaseArray(new int[][] { new int[] { 1, 2, 3 } }, 3, true),
      new TestCaseArray(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }, 0, false),
      new TestCaseArray(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }, 1, true),
      new TestCaseArray(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }, 2, true),
      new TestCaseArray(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }, 3, true),

      new TestCaseArray(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }, 4, true),
      new TestCaseArray(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }, 5, true),
      new TestCaseArray(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }, 6, true),
      new TestCaseArray(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }, 7, false),

      new TestCaseArray(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, 0, false),
      new TestCaseArray(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, 1, true),
      new TestCaseArray(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, 2, true),
      new TestCaseArray(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, 3, true),

      new TestCaseArray(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, 4, true),
      new TestCaseArray(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, 5, true),
      new TestCaseArray(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, 6, true),
      new TestCaseArray(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, 7, true),
      new TestCaseArray(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, 8, true),

      new TestCaseArray(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, 9, true),
      new TestCaseArray(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, 10, false)
  };

  public static void main(String[] args) {
    System.err.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      boolean expected = testCase.Rb;
      boolean result = searchInRowColWiseSortedMatrix(testCase.A_2Array, testCase.N);
      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  private static boolean searchInRowColWiseSortedMatrix(int[][] M, int K) {
    boolean R = false;
    int rows = M.length;
    if (rows == 0) {
      return R;
    }
    int cols = M[0].length;
    if (cols == 0) {
      return R;
    }
    int i = 0;
    int j = cols - 1; // Start from top-right corner
    while (i < rows && j >= 0) {
      if (M[i][j] == K) {
        R = true;
        break; // Element found
      } else if (M[i][j] > K) {
        j--; // Move left
      } else {
        i++; // Move down
      }
    }
    return R;
  }

}