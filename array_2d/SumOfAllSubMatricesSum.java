package array_2d;

import helper.TestCaseArray;

public class SumOfAllSubMatricesSum {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[][] { {} }, 0),
      new TestCaseArray(new int[][] { { 1 } }, 1),
      new TestCaseArray(new int[][] { { 1 }, { 2 } }, 6),
      new TestCaseArray(new int[][] { { 1, 2 } }, 6),
      new TestCaseArray(new int[][] { { 1, 2, 3 } }, 20),

      new TestCaseArray(new int[][] { { 1, 2 }, { 3, 4 } }, 40),
      new TestCaseArray(new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 } }, 140),
      new TestCaseArray(new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 } }, 360),
      new TestCaseArray(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }, 140),
      new TestCaseArray(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, 500),
  };

  public static void main(String[] args) {
    System.err.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = searchInRowColWiseSortedMatrix(testCase.A_2Array);
      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  private static int searchInRowColWiseSortedMatrix(int[][] M) {
    int rows = M.length;
    if (rows == 0) {
      return 0;
    }
    int cols = M[0].length;
    if (cols == 0) {
      return 0;
    }

    int sum = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        int topLeftRow = (i + 1) * (j + 1);
        int bottomRightRow = (rows - i) * (cols - j);
        int contribution = topLeftRow * bottomRightRow * M[i][j];
        sum += contribution;
      }
    }

    return sum;
  }

}