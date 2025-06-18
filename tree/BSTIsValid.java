package tree;

import helper.TestCaseArray;

public class BSTIsValid {
  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {
        new TestCaseArray(new int[] {}, 3, true),
        new TestCaseArray(new int[] { 1 }, 1, true),
        new TestCaseArray(new int[] { 1, 2 }, 2, true),
        new TestCaseArray(new int[] { 1, 2, 3 }, 3, true),
        new TestCaseArray(new int[] { 1, 2, 3, 4 }, 4, true),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 5, true),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 6, true),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 7, true),

        new TestCaseArray(new int[] { 2, 1 }, 2, false),
        new TestCaseArray(new int[] { 1, 3, 2 }, 4, false),
        new TestCaseArray(new int[] { 1, 2, 4, 3 }, 5, false),
    };

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      boolean expected = testCase.Rb;
      TreeNode root = Tree.arrayToBinarySearchTree(testCase.A);
      boolean result = isValidBinarySearchTree(root);

      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + (expected) + ", Result: " + (result) + "\n");
      }
      count++;
    }
  }

  public static boolean isValidBinarySearchTree(TreeNode root) {
    if (root == null) {
      return true;
    }
    return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private static boolean isValid(TreeNode node, int min, int max) {
    if (node == null) {
      return true;
    }
    if (node.val <= min || node.val >= max) {
      return false;
    }
    return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
  }
}
