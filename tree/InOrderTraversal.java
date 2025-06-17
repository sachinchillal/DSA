package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import helper.TestCaseArray;

public class InOrderTraversal {

  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {
        new TestCaseArray(new int[] {}, new int[] {}),
        new TestCaseArray(new int[] { 1 }, new int[] { 1 }),
        new TestCaseArray(new int[] { 1, 2 }, new int[] { 2, 1 }),
        new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { 2, 1, 3 }),
        new TestCaseArray(new int[] { 1, 2, 3, 4 }, new int[] { 4, 2, 1, 3 }),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 2, 5, 1, 3 }),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, new int[] { 4, 2, 5, 1, 6, 3 }),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, new int[] { 4, 2, 5, 1, 6, 3, 7 })
    };

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      TreeNode root = Tree.arrayToTree(testCase.A);
      int[] result = inOrderTraversal(root);

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
   * In meaning Node value comes middle/in between
   * Right always comes after left, L R
   * L N R
   */
  public static int[] inOrderTraversal(TreeNode root) {
    ArrayList<Integer> R = new ArrayList<>();
    inOrderIterative(root, R);
    // inOrderRecursive(root, R);
    return R.stream().mapToInt(e -> e).toArray();
  }

  /*
   * Using Recursion
   * Limitation: Might not work when data is Huge
   * Might give Maximum call stack exceeded or Call Stack overflow
   * Best approach is to use Iterative
   */
  public static void inOrderRecursive(TreeNode n, ArrayList<Integer> R) {
    if (n == null) {
      return;
    }
    inOrderRecursive(n.left, R);
    R.add(n.val);
    inOrderRecursive(n.right, R);
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
