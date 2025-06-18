package tree;

import helper.TestCaseArray;

public class BSTInsertion {
  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {
        new TestCaseArray(new int[] { 1 }, 1),
        new TestCaseArray(new int[] { 1, 2 }, 2),
        new TestCaseArray(new int[] { 1, 2, 3 }, 3),
        new TestCaseArray(new int[] { 1, 2, 3, 4 }, 4),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 5),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 6),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 7),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 7 }, 7),

        new TestCaseArray(new int[] {}, 3),
        new TestCaseArray(new int[] { 1 }, 2),
        new TestCaseArray(new int[] { 1, 2 }, 3),
        new TestCaseArray(new int[] { 1, 2, 3 }, 4),
        new TestCaseArray(new int[] { 1, 2, 3, 4 }, 5),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 6),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 7),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 8),

        new TestCaseArray(new int[] { 1, 2, 3, 4 }, -1),
        new TestCaseArray(new int[] { 0, 1, 2, 3, 4 }, -1),
        new TestCaseArray(new int[] { -1, 0, 1, 2, 3, 4 }, -2),
        new TestCaseArray(new int[] { -2, -1, 0, 1, 2, 3, 4 }, -3),
        new TestCaseArray(new int[] { -3, -2, -1, 0, 1, 2, 3, 4 }, -4),
        new TestCaseArray(new int[] { -4, -3, -2, -1, 0, 1, 2, 3, 4 }, -5),
    };

    // int count = 1;
    for (TestCaseArray testCase : TestCases) {
      TreeNode root = Tree.arrayToBinarySearchTree(testCase.A);
      TreeNode result = insertionInBinarySearchTree(root, testCase.Bi);
      System.out.println(result.deepToStringLikeTree());

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

  public static TreeNode insertionInBinarySearchTree(TreeNode root, int K) {
    if (root == null) {
      TreeNode n = new TreeNode(K);
      return n;
    }
    if (root.val >= K) {
      root.left = insertionInBinarySearchTree(root.left, K);
    } else {
      root.right = insertionInBinarySearchTree(root.right, K);

    }
    return root;
  }
}
