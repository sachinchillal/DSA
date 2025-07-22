package tree2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

public class VerticalOrderTraversalDepth {
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
    R = verticalTraversal(root);

    return R.stream()
        .map(row -> row.stream().mapToInt(e -> e).toArray())
        .toArray(int[][]::new);
  }

  static class Pair {
    TreeNode n;
    int c = 0;
    int d = 0;

    public Pair(TreeNode nn, int cc, int dd) {
      n = nn;
      c = cc;
      d = dd;
    }
  }

  static ArrayList<ArrayList<Integer>> verticalTraversal(TreeNode root) {
    Queue<Pair> q = new LinkedList<>();
    // HashMap<Integer, ArrayList<Integer>> m = new HashMap();
    HashMap<Integer, ArrayList<ArrayList<Integer>>> m = new HashMap<>();
    int minL = 0;
    int maxL = 0;
    Pair p = new Pair(root, 0, 0);
    q.add(p);
    while (q.size() > 0) {
      // remove
      p = q.remove();
      TreeNode n = p.n;
      int c = p.c;
      int d = p.d;

      minL = Math.min(minL, c);
      maxL = Math.max(maxL, c);

      // add vals
      m.putIfAbsent(c, new ArrayList<>());
      ArrayList<Integer> L2 = new ArrayList<>();
      L2.add(d);
      L2.add(n.val);
      // m.get(c).add(d, n.val);// depth, data
      m.get(c).add(L2);// depth, data

      // add child
      if (n.left != null) {
        q.add(new Pair(n.left, c - 1, d + 1));
      }
      if (n.right != null) {
        q.add(new Pair(n.right, c + 1, d + 1));
      }
    }
    ArrayList<ArrayList<Integer>> R = new ArrayList<>();
    for (int i = minL; i <= maxL; i++) {
      ArrayList<ArrayList<Integer>> L = m.get(i);
      Collections.sort(L, (a, b) -> {

        if (a.get(0) != b.get(0)) // sort by dept
          return a.get(0) - b.get(0);
        return a.get(1) - b.get(1); // same dept sort by val
      });
      ArrayList<Integer> L2 = new ArrayList<>();
      for (ArrayList<Integer> a : L) {
        L2.add(a.get(1));
      }

      R.add(L2);
    }

    return R;
  }
}