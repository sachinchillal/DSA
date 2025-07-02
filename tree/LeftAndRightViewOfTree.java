package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

import helper.TestCaseArray;

public class LeftAndRightViewOfTree {

  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {
        new TestCaseArray(new int[] {}, new int[][] {}),
        new TestCaseArray(new int[] { 1 }, new int[][] { { 1 }, { 1 } }),
        new TestCaseArray(new int[] { 1, 2 }, new int[][] { { 1, 2 }, { 1, 2 } }),

        new TestCaseArray(new int[] { 1, 2, 3 }, new int[][] { { 1, 2 }, { 1, 3 } }),
        new TestCaseArray(new int[] { 1, 2, 3, 4 }, new int[][] { { 1, 2, 4 }, { 1, 3, 4 } }),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, new int[][] { { 1, 2, 4 }, { 1, 3, 5 } }),

        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, new int[][] { { 1, 2, 4 }, { 1, 3, 6 } }),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, new int[][] { { 1, 2, 4 }, { 1, 3, 7 } }),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, new int[][] { { 1, 2, 4, 8 }, { 1, 3, 7, 8 } }),
    };

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[][] expected = testCase.R_2Array;
      TreeNode root = Tree.arrayToTree(testCase.A);
      int[][] result = leftAndRightViewOfBinaryTree(root);

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

  public static int[][] leftAndRightViewOfBinaryTree(TreeNode root) {
    ArrayList<ArrayList<Integer>> R = new ArrayList<>();
    if (root == null) {
      return new int[][] {};
    }
    levelOrderIterative(root, R);

    return R.stream()
        .map(row -> row.stream().mapToInt(e -> e).toArray())
        .toArray(int[][]::new);
  }

  public static void levelOrderIterative(TreeNode root, ArrayList<ArrayList<Integer>> R) {
    if (root == null) {
      return;
    }

    Deque<TreeNode> Q = new ArrayDeque<>();
    ArrayList<Integer> LeftView = new ArrayList<>();
    ArrayList<Integer> RightView = new ArrayList<>();

    Q.add(root);
    while (Q.size() > 0) {
      int size = Q.size();
      TreeNode nLeft = null;
      TreeNode nRight = null;

      for (int i = 0; i < size; i++) {
        TreeNode n = Q.poll();
        if (n != null) {
          if (n.left != null) {
            Q.add(n.left);
          }
          if (n.right != null) {
            Q.add(n.right);
          }
          if (i == 0) {
            nLeft = n; // First node in the level
          }
          if (i == size - 1) {
            nRight = n; // Last node in the level
          }
        }
      }
      if (nLeft != null) {
        LeftView.add(nLeft.val);
      }
      if (nRight != null) {
        RightView.add(nRight.val);
      }
    }
    R.add(LeftView);
    R.add(RightView);
  }

}
