package tree2;

import java.util.Arrays;

import helper.TestCaseArray;
import tree.Tree;
import tree.TreeNode;

public class NextPointerInPBT {
  static TestCaseArray[] TestCases = {
      // new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 }),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, new int[] { 1, 2, 3, 4, 5, 6, 7 }),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      TreeNode root = Tree.arrayToTree(testCase.A);
      TreeNode res = doConnectPointerInPerfectBinaryTree(root);
      System.out.println(res);
      System.out.println(res.deepToStringLikeTreeWithNext());
      int[] result = new int[] {};

      if (Arrays.equals(result, expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + Arrays.toString(expected) + ", Result: " + Arrays.toString(result) + "\n");
      }
      count++;
    }

  }

  public static TreeNode doConnectPointerInPerfectBinaryTree(TreeNode root) {
    // TreeNode head = root;
    TreeNode n = root;
    TreeNode dummyHead = new TreeNode(-1);
    TreeNode tail = dummyHead;
    while (n != null) {
      print("==> ");
      print(n.val
          + " | " + TreeNode.deepToStringNext(dummyHead)
          + " | " + TreeNode.deepToStringNext(tail)
          + " | " + (n.next == null ? "null" : n.next.val));

      if (n.left != null) {
        tail.next = n.left;
        tail = tail.next;
      }
      if (n.right != null) {
        tail.next = n.right;
        tail = tail.next;
      }
      n = n.next;
      if (n == null) {
        print((n == null ? "null" : n.val)
            + " | " + TreeNode.deepToStringNext(dummyHead)
            + " | " + TreeNode.deepToStringNext(tail)
            + " | " + ((n == null || n.next == null) ? "null" : n.next.val));
        n = dummyHead.next;
        dummyHead.next = null;
        tail = dummyHead;
      }
    }
    return root;
  }

  static void print(Object x) {
    // System.out.println(x);
  }
}
