package dynamic_programming;

import helper.TestCaseArray;

public class XYMovesInMatrixGrid {

  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] { 0, 0 }, new int[][] { { 0 } }, 1),
      new TestCaseArray(new int[] { 0, 0 }, new int[][] { { 1 } }, 0),
      new TestCaseArray(new int[] { 0, 0 }, new int[][] { { 0, 0 } }, 2),
      new TestCaseArray(new int[] { 0, 0 }, new int[][] { { 0, 0, 0 } }, 3),
      new TestCaseArray(new int[] { 0, 0 }, new int[][] { { 0, 0, 1 } }, 2),

      new TestCaseArray(new int[] { 0, 0 }, new int[][] { { 0, 1, 0 } }, 1),
      new TestCaseArray(new int[] { 0, 0 }, new int[][] { { 1, 0, 0 } }, 0),
      new TestCaseArray(new int[] { 0, 1 }, new int[][] { { 0, 0, 0 } }, 3),
      new TestCaseArray(new int[] { 0, 2 }, new int[][] { { 0, 0, 0 } }, 3),
      new TestCaseArray(new int[] { 1, 1 }, new int[][] { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } }, 5),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = maxMoves(testCase.A_2Array, testCase.A[0], testCase.A[1]);
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
   * Find the maximum numbers of move can be made start from X, Y
   * Move only vertically or horizontally from given cell
   * 0 indicates empty space
   * 1 indicates obstacle or wall, can't make a move
   * 
   * @param A
   * @return
   */
  public static int maxMoves(int[][] grid, int x, int y) {
    int rows = grid.length;
    int cols = grid[0].length;

    // If starting cell is an obstacle, no moves possible
    if (grid[x][y] == 1)
      return 0;

    int moves = 1; // Include the starting cell

    // Move Up
    for (int i = x - 1; i >= 0; i--) {
      if (grid[i][y] == 1)
        break;
      moves++;
    }

    // Move Down
    for (int i = x + 1; i < rows; i++) {
      if (grid[i][y] == 1)
        break;
      moves++;
    }

    // Move Left
    for (int j = y - 1; j >= 0; j--) {
      if (grid[x][j] == 1)
        break;
      moves++;
    }

    // Move Right
    for (int j = y + 1; j < cols; j++) {
      if (grid[x][j] == 1)
        break;
      moves++;
    }

    return moves;
  }

}
