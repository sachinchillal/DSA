package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import helper.TestCaseArray;

public class Subsets {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, new int[][] { {} }),
      new TestCaseArray(new int[] { 1 }, new int[][] { {}, { 1 } }),
      new TestCaseArray(new int[] { 1, 2 }, new int[][] {
          {}, { 1 }, { 2 },
          { 1, 2 }
      }),
      new TestCaseArray(new int[] { 1, 2, 3 }, new int[][] {
          {},
          { 1 }, { 2 }, { 3 },
          { 1, 2 }, { 1, 3 }, { 2, 3 },
          { 1, 2, 3 }
      }),
      new TestCaseArray(new int[] { 1, 2, 3, 4 }, new int[][] {
          {},
          { 1 }, { 2 }, { 3 }, { 4 },
          { 1, 2 }, { 1, 3 }, { 1, 4 },
          { 2, 3 }, { 2, 4 }, { 3, 4 },
          { 1, 2, 3 }, { 1, 2, 4 }, { 1, 3, 4 }, { 2, 3, 4 },
          { 1, 2, 3, 4 }
      })
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[][] expected = testCase.R_2Array;
      int[][] result = prepareAllSubsetsFromArray(testCase.A);
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
   * Generating Subsets of an Array
   * 
   * @param A
   * @return
   */
  private static int[][] prepareAllSubsetsFromArray(int[] A) {
    ArrayList<ArrayList<Integer>> R = new ArrayList<>();
    ArrayList<Integer> L = new ArrayList<>();

    // Approach I
    findAllSubsets(A, 0, L, R);

    // // Approach II
    // findAllSubsets2(A, 0, L, R);

    // for only desired output format
    Collections.sort(R, (a, b) -> Integer.compare(a.size(), b.size()));

    return R.stream()
        .map(list -> list.stream().mapToInt(Integer::intValue).toArray())
        .toArray(int[][]::new);
  }

  static void findAllSubsets(int[] A, int index, ArrayList<Integer> L, ArrayList<ArrayList<Integer>> R) {
    if (index == A.length) {
      R.add(new ArrayList<>(L));
      System.out.println(R + " , " + index);
      return;
    }
    // Include the current element
    L.add(A[index]);
    findAllSubsets(A, index + 1, L, R);
    // System.out.println(R + " | " + index);
    // Exclude the current element
    L.remove(L.size() - 1);
    findAllSubsets(A, index + 1, L, R);
    System.out.println(R + " > " + index);
  }

  /**
   * A recursive helper function that generates all subsets.
   *
   * @param A       The original array of numbers.
   * @param index   The current index in the nums array to consider.
   * @param current The current subset being built.
   * @param result  The list to store all the generated subsets.
   */
  static void findAllSubsets2(int[] A, int index, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> R) {
    // 1. Add the current subset to the result list.
    // A new ArrayList is created to avoid modification by reference.
    R.add(new ArrayList<>(current));

    // 2. Iterate through the array starting from the current index.
    for (int i = index; i < A.length; i++) {
      // 2a. Include the element at index 'i' in the current subset.
      current.add(A[i]);

      // 2b. Recursively call the function for the next index.
      findAllSubsets(A, i + 1, current, R);

      // 2c. Backtrack: Remove the element to explore subsets without it.
      current.remove(current.size() - 1);
    }
  }

}