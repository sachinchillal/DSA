package tree;

import helper.TestCaseArray;

public class BSTMaximum {
  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {
        new TestCaseArray(new int[] {}, -1),
        new TestCaseArray(new int[] { 1 }, 1),
        new TestCaseArray(new int[] { 1, 2 }, 2),
        new TestCaseArray(new int[] { 1, 2, 3 }, 3),
        new TestCaseArray(new int[] { 1, 2, 3, 4 }, 4),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 5),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 6),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 7),
    };

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      TreeNode root = Tree.arrayToBinarySearchTree(testCase.A);
      int result = findMaximumInBinarySearchTree(root);

      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + (expected) + ", Result: " + (result) + "\n");
      }
      count++;
    }
  }

  public static int findMaximumInBinarySearchTree(TreeNode root) {
    if (root == null) {
      return -1; // Meaningful value indicating the tree is empty
    }
    TreeNode n = root;
    while (n.right != null) {
      n = n.right;
    }
    return n.val;
  }
}
