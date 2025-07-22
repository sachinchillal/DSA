package tree2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import helper.TestCaseArray;
import tree.Tree;
import tree.TreeNode;

/**
 * ____1
 * __2___3
 * 4 _ 56 _ 7
 */

public class VerticalOrderTraversal {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, new int[][] {}),
      new TestCaseArray(new int[] { 1 }, new int[][] { { 1 } }),
      new TestCaseArray(new int[] { 1, 2 }, new int[][] { { 2 }, { 1 } }),
      new TestCaseArray(new int[] { 1, 2, 3 }, new int[][] { { 2 }, { 1 }, { 3 } }),
      new TestCaseArray(new int[] { 1, 2, 3, 4 }, new int[][] { { 4 }, { 2 }, { 1 }, { 3 } }),

      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, new int[][] { { 4 }, { 2 }, { 1, 5 }, { 3 } }),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, new int[][] { { 4 }, { 2 }, { 1, 5, 6 }, { 3 } }),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, new int[][] { { 4 }, { 2 }, { 1, 5, 6 }, { 3 }, { 7 } }),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 },
          new int[][] { { 8 }, { 4 }, { 2 }, { 1, 5, 6 }, { 3 }, { 7 } })
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[][] expected = testCase.R_2Array;
      TreeNode root = Tree.arrayToTree(testCase.A);
      int[][] result = verticalOrderTraversal(root);

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
   * Related Problems:
   * Main: Vertical Order Traversal
   * Top View of Tree: First element of all vertical order list
   * Bottom View of Tree: Last element of all vertical order list
   * 
   * @param root
   * @return
   */
  public static int[][] verticalOrderTraversal(TreeNode root) {
    ArrayList<ArrayList<Integer>> R = new ArrayList<>();
    verticalOrderIterative(root, R);

    return R.stream()
        .map(row -> row.stream().mapToInt(e -> e).toArray())
        .toArray(int[][]::new);
  }

  static class Pair {
    TreeNode node;
    int column = 0; // vertical length

    Pair(TreeNode n, int c) {
      node = n;
      column = c;
    }
  }

  static void verticalOrderIterative(TreeNode root, ArrayList<ArrayList<Integer>> R) {
    if (root == null) {
      return;
    }
    Queue<Pair> Q = new LinkedList<>();
    HashMap<Integer, ArrayList<Integer>> m = new HashMap<>();

    int minL = 0;
    int maxL = 0;

    Pair p = new Pair(root, 0);
    Q.add(p);

    while (Q.size() > 0) {
      // remove
      p = Q.remove();
      int column = p.column;
      TreeNode node = p.node;
      minL = Math.min(column, minL);
      maxL = Math.max(column, maxL);

      // task, append
      m.putIfAbsent(column, new ArrayList<>());
      m.get(column).add(node.val);

      // add children
      if (node.left != null) {
        p = new Pair(node.left, column - 1);
        Q.add(p);
      }
      if (node.right != null) {
        Q.add(new Pair(node.right, column + 1));
      }
    }

    for (int i = minL; i <= maxL; i++) {
      R.add(m.get(i)); // for Vertical Order Traversal
      // R.add(m.get(i).get(0)); // for TOP VIEW
      // R.add(m.get(i).get(m.get(i).size() - 1)); // for BOTTOM VIEW
    }

  }
}
