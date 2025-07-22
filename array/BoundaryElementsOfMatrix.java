import java.util.ArrayList;
import java.util.Arrays;

public class BoundaryElementsOfMatrix {
  static TestCaseMatrix[] TestCases = {
      new TestCaseMatrix(new int[][] { { 1 } }, new int[] { 1 }),
      new TestCaseMatrix(new int[][] { { 1, 2 }, { 4, 5 } }, new int[] { 1, 2, 5, 4 }),
      new TestCaseMatrix(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, new int[] { 1, 2, 3, 6, 9, 8, 7, 4 }),
      new TestCaseMatrix(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 },
          { 9, 10, 11, 12 }, { 13, 14, 15, 16 } },
          new int[] { 1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5 }),
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseMatrix testCase : TestCases) {
      int[] expected = testCase.R;
      int[] result = printBoundaryElementsOfMatrix(testCase.A);
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

  private static int[] printBoundaryElementsOfMatrix(int[][] A) {
    int n = A.length;
    ArrayList<Integer> R = new ArrayList<>();
    int i = 0;
    int j = 0;
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
    if (n == 1) {
      R.add(A[0][0]);
    }
    return R.stream().mapToInt(e -> e).toArray();
  }

}