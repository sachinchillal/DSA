package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

import helper.TestCaseArray;

public class LevelOrderTraversal {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, new int[][] {}),
      new TestCaseArray(new int[] { 1 }, new int[][] { { 1 } }),
      new TestCaseArray(new int[] { 1, 2 }, new int[][] { { 1 }, { 2 } }),
      new TestCaseArray(new int[] { 1, 2, 3 }, new int[][] { { 1 }, { 2, 3 } }),
      new TestCaseArray(new int[] { 1, 2, 3, 4 }, new int[][] { { 1 }, { 2, 3 }, { 4 } }),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, new int[][] { { 1 }, { 2, 3 }, { 4, 5 } }),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, new int[][] { { 1 }, { 2, 3 }, { 4, 5, 6 } }),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, new int[][] { { 1 }, { 2, 3 }, { 4, 5, 6, 7 } }),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, new int[][] { { 1 }, { 2, 3 }, { 4, 5, 6, 7 }, { 8 } }),

      // Might not expect the output in 1-D array so commenting it out
      // new TestCaseArray(new int[] {}, new int[] {}),
      // new TestCaseArray(new int[] { 1 }, new int[] { 1 }),
      // new TestCaseArray(new int[] { 1, 2 }, new int[] { 1, 2 }),
      // new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 }),
      // new TestCaseArray(new int[] { 1, 2, 3, 4 }, new int[] { 1, 2, 3, 4 }),
      // new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, new int[] { 1, 2, 3, 4, 5 }),
      // new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, new int[] { 1, 2, 3, 4, 5,
      // 6 }),
      // new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, new int[] { 1, 2, 3, 4,
      // 5, 6, 7 })
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[][] expected = testCase.R_2Array;
      TreeNode root = Tree.arrayToTree(testCase.A);
      int[][] result = levelOrderTraversal(root);

      if (Arrays.deepEquals(result, expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out
            .println("Expected: " + Arrays.deepToString(expected) + ", Result: " + Arrays.deepToString(result) + "\n");
      }
      count++;
    }
    // for 1-D Array
    // for (TestCaseArray testCase : TestCases) {
    // int[] expected = testCase.R_Array;
    // TreeNode root = Tree.arrayToTree(testCase.A);
    // int[] result = levelOrderTraversal(root);

    // if (Arrays.equals(result, expected)) {
    // System.out.println(count + " Test case Passed!");
    // } else {
    // System.out.println(count + " Test case failed!");
    // System.out.println("Expected: " + Arrays.toString(expected) + ", Result: " +
    // Arrays.toString(result) + "\n");
    // }
    // count++;
    // }
  }

  /*
   * Level meaning each steps from Root to leaf nodes
   * Right always comes after left, L R
   * T
   * L R
   * B
   */
  public static int[][] levelOrderTraversal(TreeNode root) {
    ArrayList<ArrayList<Integer>> R = new ArrayList<>();
    levelOrderIterative(root, R);
    // levelOrderRecursive(root, 0, R);

    return R.stream()
        .map(row -> row.stream().mapToInt(e -> e).toArray())
        .toArray(int[][]::new);
  }

  public static int[] levelOrderTraversal1DArray(TreeNode root) {
    ArrayList<ArrayList<Integer>> R = new ArrayList<>();
    // levelOrderIterative1DArray(root, R);
    levelOrderRecursive(root, 0, R);
    return R.stream().flatMapToInt(row -> row.stream().mapToInt(Integer::intValue)).toArray();
    // return R.stream().mapToInt(e -> e).toArray();
  }

  /*
   * Using Recursion
   * Limitation: Might not work when data is Huge
   * Might give Maximum call stack exceeded or Call Stack overflow
   * Best approach is to use Iterative
   */
  public static void levelOrderRecursive(TreeNode n, int level, ArrayList<ArrayList<Integer>> R) {
    if (n == null) {
      return;
    }
    if (R.size() <= level) {
      R.add(new ArrayList<>());
    }
    R.get(level).add(n.val);
    // System.out.println(R.toString());
    levelOrderRecursive(n.left, level + 1, R);
    levelOrderRecursive(n.right, level + 1, R);
  }

  public static void levelOrderIterative(TreeNode root, ArrayList<ArrayList<Integer>> R) {
    Deque<TreeNode> Q = new ArrayDeque<>();
    if (root == null) {
      return;
    }
    Q.add(root);
    while (Q.size() > 0) {
      ArrayList<Integer> level = new ArrayList<>();
      int size = Q.size();
      for (int i = 0; i < size; i++) {
        TreeNode n = Q.poll();
        if (n != null) {
          level.add(n.val);
          if (n.left != null) {
            Q.add(n.left);
          }
          if (n.right != null) {
            Q.add(n.right);
          }
        }
      }
      if (level.size() > 0) {
        R.add(level);
      }
    }
  }

  public static void levelOrderIterative1DArray(TreeNode root, ArrayList<Integer> R) {
    Stack<TreeNode> s = new Stack<>();
    TreeNode n = root;
    while (n != null || s.size() > 0) {
      while (n != null) {
        s.push(n);
        n = n.left;
      }
      n = s.pop();
      R.add(n.val);
      n = n.right;
    }
  }
}
