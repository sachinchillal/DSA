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
 * _____1
 * ___2___3
 * _4 _ 56 _ 7
 * 8 _ 9
 */

public class TopViewOfTree {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, new int[] {}),
      new TestCaseArray(new int[] { 1 }, new int[] { 1 }),
      new TestCaseArray(new int[] { 1, 2 }, new int[] { 2, 1 }),
      new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { 2, 1, 3 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4 }, new int[] { 4, 2, 1, 3 }),

      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 2, 1, 3 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, new int[] { 4, 2, 1, 3 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, new int[] { 4, 2, 1, 3, 7 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, new int[] { 8, 4, 2, 1, 3, 7 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, new int[] { 8, 4, 2, 1, 3, 7 }),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      TreeNode root = Tree.arrayToTree(testCase.A);
      int[] result = topViewOfBinaryTree(root);

      if (Arrays.equals(result, expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out
            .println("Expected: " + Arrays.toString(expected) + ", Result: " + Arrays.toString(result) + "\n");
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
  static int[] topViewOfBinaryTree(TreeNode root) {
    ArrayList<Integer> R = new ArrayList<>();
    buildTopViewOfBinaryTree(root, R);
    return R.stream().mapToInt(e -> e).toArray();
  }

  static class Pair {
    int column; // vertical length also like -2 -1 0 1 2 3 etc
    // c-1 to move left of the tree and
    // c+1 to move right of the tree
    TreeNode node;

    Pair(TreeNode n, int c) {
      node = n;
      column = c;
    }
  }

  static void buildTopViewOfBinaryTree(TreeNode root, ArrayList<Integer> R) {
    if (root == null) {
      return;
    }
    HashMap<Integer, ArrayList<Integer>> m = new HashMap<>();
    Queue<Pair> Q = new LinkedList<>();
    Pair p = new Pair(root, 0);
    Q.add(p);

    int minL = 0;
    int maxL = 0;
    while (Q.size() > 0) {
      // remove
      p = Q.remove();
      TreeNode n = p.node;
      int column = p.column;

      // task:
      m.putIfAbsent(column, new ArrayList<>());
      m.get(column).add(n.val);

      minL = Math.min(minL, column);
      maxL = Math.max(maxL, column);

      // add children
      if (n.left != null) {
        Q.add(new Pair(n.left, column - 1));
      }
      if (n.right != null) {
        Q.add(new Pair(n.right, column + 1));
      }
    }
    for (int i = minL; i <= maxL; i++) {
      // R.add(m.get(i)); // for Vertical Order Traversal
      R.add(m.get(i).get(0)); // for TOP VIEW
      // R.add(m.get(i).get(m.get(i).size() - 1)); // for BOTTOM VIEW
    }

  }
}
