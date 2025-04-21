import java.util.ArrayList;
import java.util.Arrays;

public class SpiralMatrixLawnMowing {
  public static void main(String[] args) {
    System.err.println();
    TestCaseMatrix[] TestCases = {
        new TestCaseMatrix(new int[][] { { 1 } }, new int[] { 1 }),
        new TestCaseMatrix(new int[][] { { 1, 2 }, { 4, 5 } }, new int[] { 1, 2, 5, 4 }),
        new TestCaseMatrix(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } },
            new int[] { 1, 2, 3, 6, 9, 8, 7, 4, 5 }),
        new TestCaseMatrix(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 },
            { 9, 10, 11, 12 }, { 13, 14, 15, 16 } },
            new int[] { 1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10 }),
    };
    int count = 1;
    for (TestCaseMatrix testCase : TestCases) {
      int[] expected = testCase.R;
      int[] result = printSpiralMatrixLawnMowing(testCase.A);
      if (Arrays.equals(result, expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println(Arrays.deepToString(testCase.A).replace("], ", "],\n"));
        System.out.println("Expected: " + Arrays.toString(expected) + ", Result: " + Arrays.toString(result) + "\n");
      }
      count++;
    }
  }

  private static int[] printSpiralMatrixLawnMowing(int[][] A) {
    int n = A.length;
    ArrayList<Integer> R = new ArrayList<>();
    int i = 0;
    int j = 0;
    while (n > 1) {
      for (int c = 1; c < n; c++) {
        R.add(A[i][j]); // Top row
        j++;
      }
      for (int c = 1; c < n; c++) {
        R.add(A[i][j]);
        i++;
      }
      for (int c = 1; c < n; c++) {
        R.add(A[i][j]);
        j--;
      }
      for (int c = 1; c < n; c++) {
        R.add(A[i][j]);
        i--;
      }
      // increase row and column
      i++;
      j++;
      n = n - 2; // Important
      /*
       * n = 4 Boundary
       * row 0 n - 1
       * row 1 n - 3
       * row 2 n - 5
       */
    }
    if (n == 1) {
      R.add(A[i][j]);
    }
    return R.stream().mapToInt(e -> e).toArray();
  }

}