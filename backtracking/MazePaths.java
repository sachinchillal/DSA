package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
// import java.util.Collection;
// import java.util.Collections;
// import java.util.List;

import helper.TestCaseArray;

public class MazePaths {

    /**
     * A recursive helper function to find paths.
     *
     * @param m           Total rows.
     * @param n           Total columns.
     * @param currentRow  The current row we are on.
     * @param currentCol  The current column we are on.
     * @param currentPath The path string built so far.
     * @param allPaths    The list to store all complete paths.
     */
    static void findPathsRecursive(int m, int n, int currentRow, int currentCol,
            String currentPath, ArrayList<String> allPaths) {

        // Base Case: If we have reached the destination cell (m, n)
        if (currentRow == m && currentCol == n) {
            allPaths.add(currentPath);
            return;
        }

        // Recursive Step: Explore possible moves

        // 2. Move Down
        // If we are not in the last row, we can move down.
        if (currentRow < m) {
            findPathsRecursive(m, n, currentRow + 1, currentCol, currentPath + "D", allPaths);
        }
        // 1. Move Right
        // If we are not in the last column, we can move right.
        if (currentCol < n) {
            findPathsRecursive(m, n, currentRow, currentCol + 1, currentPath + "R", allPaths);
        }
    }

    /**
     * Finds all paths from the top-left (1,1) to the bottom-right (m,n) of a grid.
     *
     * @param m The number of rows.
     * @param n The number of columns.
     * @return A list of strings, where each string represents a unique path.
     */
    static String[] getAllPaths(int m, int n) {
        ArrayList<String> allPaths = new ArrayList<>();
        // Start the recursive backtracking from the starting position (1, 1)
        findPathsRecursive(m, n, 1, 1, "", allPaths);
        return allPaths.toArray(new String[0]);
    }

    static TestCaseArray[] TestCases = {
            new TestCaseArray(0, 0, new String[] {}),
            new TestCaseArray(0, 1, new String[] {}),
            new TestCaseArray(1, 0, new String[] {}),
            new TestCaseArray(1, 1, new String[] { "" }),
            new TestCaseArray(1, 2, new String[] { "R" }),

            new TestCaseArray(1, 3, new String[] { "RR" }),
            new TestCaseArray(1, 4, new String[] { "RRR" }),
            new TestCaseArray(1, 5, new String[] { "RRRR" }),

            new TestCaseArray(2, 2, new String[] { "DR", "RD" }),
            new TestCaseArray(2, 3, new String[] { "DRR", "RDR", "RRD" }),
            new TestCaseArray(2, 4, new String[] { "DRRR", "RDRR", "RRDR", "RRRD" }),

            new TestCaseArray(3, 1, new String[] { "DD" }),
            new TestCaseArray(3, 2, new String[] { "DDR", "DRD", "RDD" }),
            new TestCaseArray(3, 3, new String[] { "DDRR", "DRDR", "DRRD", "RDDR", "RDRD", "RRDD" }),
    };

    public static void main(String[] args) {
        System.out.println();

        int count = 1;
        for (TestCaseArray testCase : TestCases) {
            String[] expected = testCase.Rs_Array;
            String[] result = getAllPaths(testCase.N, testCase.M);
            if (Arrays.equals(result, expected)) {
                System.out.println(count + " Test case Passed!");
            } else {
                System.out.println(count + " Test case failed!");
                System.out.println(
                        "Expected: " + Arrays.toString(expected) + ", Result: " + Arrays.toString(result) + "\n");
            }
            count++;
        }
    }

}