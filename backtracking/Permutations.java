package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import helper.TestCaseArray;

public class Permutations {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, new int[][] {}),
      new TestCaseArray(new int[] { 1 }, new int[][] { { 1 } }),
      new TestCaseArray(new int[] { 1, 2 }, new int[][] { { 1, 2 }, { 2, 1 } }),
      new TestCaseArray(new int[] { 1, 2, 3 }, new int[][] {
          { 1, 2, 3 }, { 1, 3, 2 },
          { 2, 1, 3 }, { 2, 3, 1 },
          { 3, 1, 2 }, { 3, 2, 1 }
      }),
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[][] expected = testCase.R_2Array;
      int[][] result = prepareAllPermutations(testCase.A);
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
   * Generating Permutations of an Array
   * 
   * @param A
   * @return
   */
  private static int[][] prepareAllPermutations(int[] A) {
    if (A.length == 0) {
      return new int[][] {};
    }
    // n! = number of permutations
    ArrayList<ArrayList<Integer>> R = new ArrayList<>();

    // Generate all permutations
    boolean[] used = new boolean[A.length];
    generatePermutations(A, used, new int[A.length], 0, R);

    // HashSet<Integer> S = new HashSet<>();
    // generatePermutations2(A, 0, new ArrayList<>(), S, R);

    return R.stream()
        .map(list -> list.stream().mapToInt(Integer::intValue).toArray())
        .toArray(int[][]::new);
  }

  static void generatePermutations(int[] A, boolean[] used, int[] current, int depth,
      ArrayList<ArrayList<Integer>> R) {
    if (depth == A.length) {
      ArrayList<Integer> permutation = new ArrayList<>();
      for (int num : current) {
        permutation.add(num);
      }
      R.add(permutation);
      return;
    }
    for (int i = 0; i < A.length; i++) {
      if (!used[i]) {
        used[i] = true;
        current[depth] = A[i];
        generatePermutations(A, used, current, depth + 1, R);
        used[i] = false;
      }
    }
  }

  static void generatePermutations2(int[] A, int index, ArrayList<Integer> L, HashSet<Integer> S,
      ArrayList<ArrayList<Integer>> R) {
    if (index == A.length) {
      R.add(new ArrayList<>(L));
      return;
    }
    for (int i = 0; i < A.length; i++) {
      if (!S.contains(A[i])) {
        S.add(A[i]);
        L.add(A[i]);
        generatePermutations2(A, index + 1, L, S, R);
        S.remove(A[i]);
        L.remove(L.size() - 1);
      }
    }
  }
}