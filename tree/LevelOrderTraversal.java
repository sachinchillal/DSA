package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import helper.TestCaseArray;

public class LevelOrderTraversal {

  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {
        new TestCaseArray(new int[] {}, new int[] {}),
        new TestCaseArray(new int[] { 1 }, new int[] { 1 }),
        new TestCaseArray(new int[] { 1, 2 }, new int[] { 1, 2 }),
        new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 }),
        new TestCaseArray(new int[] { 1, 2, 3, 4 }, new int[] { 1, 2, 3, 4 }),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, new int[] { 1, 2, 3, 4, 5 }),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, new int[] { 1, 2, 3, 4, 5, 6 }),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, new int[] { 1, 2, 3, 4, 5, 6, 7 })
    };

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      TreeNode root = Tree.arrayToTree(testCase.A);
      int[] result = levelOrderTraversal(root);

      if (Arrays.equals(result, expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + Arrays.toString(expected) + ", Result: " + Arrays.toString(result) + "\n");
      }
      count++;
    }
  }

  /*
   * Level meaning each steps from Root to leaf nodes
   * Right always comes after left, L R
   * T
   * L R
   * B
   */
  public static int[] levelOrderTraversal(TreeNode root) {
    ArrayList<ArrayList<Integer>> R = new ArrayList<>();
    // inOrderIterative(root, R);
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

  public static void inOrderIterative(TreeNode root, ArrayList<Integer> R) {
    Stack<TreeNode> s = new Stack<>();
    TreeNode current = root;
    while (current != null || s.size() > 0) {
      while (current != null) {
        s.push(current);
        current = current.left;
      }
      current = s.pop();
      R.add(current.val);
      current = current.right;
    }
  }
}
