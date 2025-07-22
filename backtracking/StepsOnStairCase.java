package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

import helper.TestCaseArray;

public class StepsOnStairCase {

  static TestCaseArray[] TestCases = {
      new TestCaseArray(0, new int[][] {}),
      new TestCaseArray(1, new int[][] { { 1 } }),
      new TestCaseArray(2, new int[][] { { 1, 1 }, { 2 } }),
      new TestCaseArray(3, new int[][] { { 1, 1, 1 }, { 1, 2 }, { 2, 1 } }),
      new TestCaseArray(4, new int[][] { { 1, 1, 1, 1 }, { 1, 1, 2 }, { 1, 2, 1 }, { 2, 1, 1 }, { 2, 2 } })
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[][] expected = testCase.R_2Array;
      int[][] result = findWaysStepUpOnStairCase(testCase.N);
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

  /**
   * Given a number of steps in a staircase, find all the possible ways to climb
   * the stairs.
   * You can take either 1 or 2 steps at a time.
   * 
   * @param n
   * @return
   */
  static int[][] findWaysStepUpOnStairCase(int n) {
    if (n < 1) {
      return new int[][] {}; // Placeholder return
    }
    // Assuming it should return all possible ways to climb n steps.
    ArrayList<Integer> currentPath = new ArrayList<>();
    ArrayList<ArrayList<Integer>> allPaths = new ArrayList<>();

    waysStepUp(n, currentPath, allPaths);
    // waysStepUpVisual(n, currentPath, allPaths);

    return allPaths.stream()
        .map(path -> path.stream().mapToInt(Integer::intValue).toArray())
        .toArray(int[][]::new);
  }

  static void waysStepUp(int n, ArrayList<Integer> currentPath,
      ArrayList<ArrayList<Integer>> allPaths) {
    if (n == 0) {
      System.out.println(currentPath);
      allPaths.add(new ArrayList<>(currentPath));
      return;
    }
    if (n >= 1) {
      currentPath.add(1);
      waysStepUp(n - 1, currentPath, allPaths);
      currentPath.remove(currentPath.size() - 1);
    }
    if (n >= 2) {
      currentPath.add(2);
      waysStepUp(n - 2, currentPath, allPaths);
      currentPath.remove(currentPath.size() - 1);
    }
  }

  static void waysStepUpVisual(int n, ArrayList<Integer> currentPath,
      ArrayList<ArrayList<Integer>> allPaths) {
    printer(n, currentPath, allPaths);
    if (n == 0) {
      allPaths.add(new ArrayList<>(currentPath));
      return;
    }
    if (n >= 1) {
      currentPath.add(1);
      waysStepUpVisual(n - 1, currentPath, allPaths);
      currentPath.remove(currentPath.size() - 1);
    }
    if (n >= 2) {
      currentPath.add(2);
      waysStepUpVisual(n - 2, currentPath, allPaths);
      currentPath.remove(currentPath.size() - 1);
    }
  }

  static void printer(int N, ArrayList<Integer> L, ArrayList<ArrayList<Integer>> R) {
    System.out.println("N: " + N + ", Current Path: " + L);
  }
}
