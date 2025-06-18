package tree;

import helper.TestCaseArray;

public class BSTMinimum {
  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {
        new TestCaseArray(new int[] {}, -1),
        new TestCaseArray(new int[] { 1 }, 1),
        new TestCaseArray(new int[] { 1, 2 }, 1),
        new TestCaseArray(new int[] { 1, 2, 3 }, 1),
        new TestCaseArray(new int[] { 1, 2, 3, 4 }, 1),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 1),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 1),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 1),
    };

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      TreeNode root = Tree.arrayToBinarySearchTree(testCase.A);
      int result = findMinimumInBinarySearchTree(root);

      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + (expected) + ", Result: " + (result) + "\n");
      }
      count++;
    }
  }

  public static int findMinimumInBinarySearchTree(TreeNode root) {
    if (root == null) {
      return -1; // Meaningful value indicating the tree is empty
    }
    TreeNode n = root;
    while (n.left != null) {
      n = n.left;
    }
    return n.val;
  }
}
