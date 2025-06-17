package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import helper.TestCaseArray;

public class PostOrderTraversal {

  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {
        new TestCaseArray(new int[] {}, new int[] {}),
        new TestCaseArray(new int[] { 1 }, new int[] { 1 }),
        new TestCaseArray(new int[] { 1, 2 }, new int[] { 2, 1 }),
        new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { 2, 3, 1 }),
        new TestCaseArray(new int[] { 1, 2, 3, 4 }, new int[] { 4, 2, 3, 1 }),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 5, 2, 3, 1 }),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, new int[] { 4, 5, 2, 6, 3, 1 }),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, new int[] { 4, 5, 2, 6, 7, 3, 1 })
    };

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      TreeNode root = Tree.arrayToTree(testCase.A);
      int[] result = postOrderTraversal(root);

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
   * Post meaning Node value comes last
   * Right always comes after left, L R
   * L R N
   */
  public static int[] postOrderTraversal(TreeNode root) {
    ArrayList<Integer> R = new ArrayList<>();
    postOrderIterative(root, R);
    // postOrderIterative2(root, R);
    // postOrderRecursive(root, R);
    return R.stream().mapToInt(e -> e).toArray();
  }

  public static void postOrderRecursive(TreeNode n, ArrayList<Integer> R) {
    if (n == null) {
      return;
    }
    postOrderRecursive(n.left, R);
    postOrderRecursive(n.right, R);
    R.add(n.val);
  }

  /*
   * Time Complexity: O(n)
   * Space Complexity: O(h)
   * h : Height of tree
   */
  public static void postOrderIterative(TreeNode root, ArrayList<Integer> R) {
    if (root == null) {
      return;
    }
    Stack<TreeNode> s = new Stack<>();
    Stack<TreeNode> s2 = new Stack<>();
    s.push(root);
    while (s.size() > 0) {
      TreeNode n = s.pop();
      s2.push(n);
      if (n.left != null) {
        s.push(n.left);
      }
      if (n.right != null) {
        s.push(n.right);
      }
    }
    while (s2.size() > 0) {
      TreeNode n = s2.pop();
      R.add(n.val);
    }
  }

  /*
   * Using Pointer Method
   */
  public static void postOrderIterative2(TreeNode root, ArrayList<Integer> R) {
    TreeNode current = root;
    TreeNode lastVisited = null;
    Stack<TreeNode> s = new Stack<>();
    while (s.size() > 0 || current != null) {
      if (current == null) {
        TreeNode peek = s.peek();
        if (peek.right != null && peek.right != lastVisited) {
          current = peek.right;
        } else {
          R.add(peek.val);
          lastVisited = s.pop();
        }
      } else {
        s.push(current);
        current = current.left;
      }
    }
  }
}
