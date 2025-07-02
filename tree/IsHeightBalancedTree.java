package tree;

import helper.TestCaseArray;

public class IsHeightBalancedTree {

  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {
        new TestCaseArray(new int[] { 1 }, true),
        new TestCaseArray(new int[] { 1, 2 }, true),
        new TestCaseArray(new int[] { 1, 2, 3 }, true),
        new TestCaseArray(new int[] { 1, 2, 3, 4 }, true),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, true),

        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, true),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, true),
        new TestCaseArray(new int[] {}, true),
        new TestCaseArray(new int[] { 1 }, true),
        new TestCaseArray(new int[] { 1, 2 }, true),

        new TestCaseArray(new int[] { 1, 2, 3 }, true),
        new TestCaseArray(new int[] { 1, 2, 3, 4 }, true),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, true),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, true),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, true),
    };

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      boolean expected = testCase.Rb;
      TreeNode root = Tree.arrayToTree(testCase.A);
      boolean result = isHeightBalancedTree(root);

      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + (expected) + ", Result: " + (result) + "\n");
      }
      count++;
    }
  }

  /**
   * Checks if a binary tree is height-balanced.
   *
   * @param root The root of the binary tree.
   * @return True if the tree is height-balanced, false otherwise.
   */
  public static boolean isHeightBalancedTree(TreeNode root) {
    // A tree is balanced if the checkHeight helper function does not return -1.
    return checkHeight(root) != -1;
  }

  /**
   * A private helper function that recursively calculates the height of a subtree
   * and checks for balance simultaneously.
   *
   * @param node The current node.
   * @return The height of the subtree rooted at 'node' if it is balanced,
   *         otherwise -1 to signify an imbalance.
   */
  private static int checkHeight(TreeNode node) {
    // Base case: A null tree is balanced and has a height of 0.
    if (node == null) {
      return 0;
    }

    // Recursively find the height of the left subtree.
    int leftHeight = checkHeight(node.left);
    // If the left subtree is already detected as unbalanced, propagate the failure
    // up.
    if (leftHeight == -1) {
      return -1;
    }

    // Recursively find the height of the right subtree.
    int rightHeight = checkHeight(node.right);
    // If the right subtree is already detected as unbalanced, propagate the failure
    // up.
    if (rightHeight == -1) {
      return -1;
    }

    // Check if the current node is balanced.
    // The absolute difference in heights must not be more than 1.
    if (Math.abs(leftHeight - rightHeight) > 1) {
      return -1; // Signal that the tree is unbalanced.
    }

    // If the node is balanced, return its height.
    return 1 + Math.max(leftHeight, rightHeight);
  }

  static boolean isBalanced = true;

  public static boolean isHeightBalancedTree2(TreeNode root) {
    isBalanced = true; // To run this function again and again
    if (root == null) {
      return true;
    }
    calculateHeight(root);
    return isBalanced;
  }

  public static int calculateHeight(TreeNode node) {
    if (isBalanced == false) {
      return 0;
    }
    if (node == null) {
      return 0;
    }
    int heightLeft = calculateHeight(node.left);
    int heightRight = calculateHeight(node.right);
    if (Math.abs(heightLeft - heightRight) > 1) {
      isBalanced = false;
    }
    return Math.max(heightLeft, heightRight) + 1;
  }
}
