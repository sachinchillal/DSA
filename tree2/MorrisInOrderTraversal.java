package tree2;

import java.util.ArrayList;
import java.util.Arrays;

import helper.TestCaseArray;
import tree.Tree;
import tree.TreeNode;

public class MorrisInOrderTraversal {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, new int[] {}),
      new TestCaseArray(new int[] { 1 }, new int[] { 1 }),
      new TestCaseArray(new int[] { 1, 2 }, new int[] { 2, 1 }),
      new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { 2, 1, 3 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4 }, new int[] { 4, 2, 1, 3 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 2, 5, 1, 3 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, new int[] { 4, 2, 5, 1, 6, 3 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, new int[] { 4, 2, 5, 1, 6, 3, 7 })
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      TreeNode root = Tree.arrayToTree(testCase.A);
      int[] result = morrisInOrderTraversal(root);

      if (Arrays.equals(result, expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + Arrays.toString(expected) + ", Result: " + Arrays.toString(result) + "\n");
      }
      count++;
    }
  }

  public static int[] morrisInOrderTraversal(TreeNode root) {
    ArrayList<Integer> R = new ArrayList<>();
    morrisInOrderTraversal(root, R);
    return R.stream().mapToInt(e -> e).toArray();
  }

  static void morrisInOrderTraversal(TreeNode root, ArrayList<Integer> R) {
    TreeNode n = root;
    while (n != null) {
      print("N: " + n.val);
      if (n.left == null) {
        R.add(n.val);
        print("R: " + R);
        n = n.right;
      } else {
        TreeNode pre = n.left; // one step left and then right, right, right
        while (pre.right != null && pre.right != n) {
          pre = pre.right;
        }

        if (pre.right == null) {
          pre.right = n;
          print("N: " + pre.val + " R: " + n.val);
          n = n.left;
        } else {
          pre.right = null;
          R.add(n.val);
          print("--->" + R);
          n = n.right;
        }
      }
    }
  }

  static void print(Object x) {
    // System.out.println(x);
  }

}
