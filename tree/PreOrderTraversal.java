package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import helper.TestCaseArray;

public class PreOrderTraversal {

  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {
        new TestCaseArray(new int[] {}, new int[] {}),
        new TestCaseArray(new int[] { 1 }, new int[] { 1 }),
        new TestCaseArray(new int[] { 1, 2 }, new int[] { 1, 2 }),
        new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 }),
        new TestCaseArray(new int[] { 1, 2, 3, 4 }, new int[] { 1, 2, 4, 3 }),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, new int[] { 1, 2, 4, 5, 3 }),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, new int[] { 1, 2, 4, 5, 3, 6 }),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, new int[] { 1, 2, 4, 5, 3, 6, 7 })
    };

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      TreeNode root = Tree.arrayToTree(testCase.A);
      int[] result = preOrderTraversal(root);

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
   * Pre meaning Node value comes first/pre
   * Right always comes after left, L R
   * N L R
   */
  public static int[] preOrderTraversal(TreeNode root) {
    ArrayList<Integer> R = new ArrayList<>();
    preOrderIterative(root, R);
    // preOrderRecursive(root, R);
    return R.stream().mapToInt(e -> e).toArray();
  }

  public static void preOrderRecursive(TreeNode n, ArrayList<Integer> R) {
    if (n == null) {
      return;
    }
    R.add(n.val);
    preOrderRecursive(n.left, R);
    preOrderRecursive(n.right, R);
  }

  public static void preOrderIterative(TreeNode root, ArrayList<Integer> R) {
    if (root == null) {
      return;
    }
    Stack<TreeNode> s = new Stack<>();
    s.push(root);
    while (s.size() > 0) {
      TreeNode n = s.pop();
      R.add(n.val);
      if (n.right != null) {
        s.push(n.right);
      }
      if (n.left != null) {
        s.push(n.left);
      }
    }
  }

}
