package tree;

import helper.TestCaseArray;

public class BSTDeletion {
  static TestCaseArray[] TestCases = {
      // deleting right node
      new TestCaseArray(new int[] { 1 }, 1, true),
      new TestCaseArray(new int[] { 1, 2 }, 2, true),
      new TestCaseArray(new int[] { 1, 2, 3 }, 3, true),
      new TestCaseArray(new int[] { 1, 2, 3, 4 }, 4, true),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 5, true),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 6, true),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 7, true),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 7 }, 7, true),

      // no deletion
      new TestCaseArray(new int[] {}, 3, false),
      new TestCaseArray(new int[] { 1 }, 2, false),
      new TestCaseArray(new int[] { 1, 2 }, 3, false),
      new TestCaseArray(new int[] { 1, 2, 3 }, 4, false),
      new TestCaseArray(new int[] { 1, 2, 3, 4 }, 5, false),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 6, false),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 7, false),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 8, false),

      // deleting left node
      new TestCaseArray(new int[] { 1, 2, 3 }, 1, true),
      new TestCaseArray(new int[] { 1, 2, 3, 4 }, 2, true),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 2, true),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3, true),

      // node having 2 children
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 2, true),
  };

  public static void main(String[] args) {
    System.out.println();
    // int count = 1;
    for (TestCaseArray testCase : TestCases) {
      TreeNode root = Tree.arrayToBinarySearchTree(testCase.A);
      TreeNode result = deletionInBinarySearchTree(root, testCase.N);
      if (result == null) {
        System.out.println("Result: " + result);
      } else {
        System.out.println(result.deepToStringLikeTree());
      }

      // if (result == expected) {
      // System.out.println(count + " Test case Passed!");
      // } else {
      // System.out.println(count + " Test case failed!");
      // System.out.println("Expected: " + (expected) + ", Result: " + (result) +
      // "\n");
      // }
      // count++;
    }
  }

  public static TreeNode deletionInBinarySearchTree(TreeNode root, int K) {
    if (root == null) {
      return null;
    }
    if (root.val == K) {
      if (root.left == null) {
        return root.right; // can be null or node
      } else if (root.right == null) {
        return root.left; // left child node
      }
      // case2 it has 2 children
      TreeNode nodeMin = findMinimumNode(root.right);
      // Delete: copy that value here
      root.val = nodeMin.val;
      root.right = deletionInBinarySearchTree(root.right, nodeMin.val);
    } else if (root.val > K) {
      root.left = deletionInBinarySearchTree(root.left, K);
    } else {
      root.right = deletionInBinarySearchTree(root.right, K);
    }
    return root;
  }

  private static TreeNode findMinimumNode(TreeNode node) {
    if (node == null) {
      return null;
    }
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }
}
