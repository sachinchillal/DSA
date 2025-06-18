package tree;

import helper.TestCaseArray;

public class IsHeightBalancedTree {

  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {
        new TestCaseArray(new int[] { 1 }, 1, true),
        new TestCaseArray(new int[] { 1, 2 }, 3, true),
        new TestCaseArray(new int[] { 1, 2, 3 }, 4, true),
        new TestCaseArray(new int[] { 1, 2, 3, 4 }, 7, true),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 8, true),

        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 10, true),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 11, true),
        new TestCaseArray(new int[] {}, 3, true),
        new TestCaseArray(new int[] { 1 }, 2, true),
        new TestCaseArray(new int[] { 1, 2 }, 4, true),

        new TestCaseArray(new int[] { 1, 2, 3 }, 5, true),
        new TestCaseArray(new int[] { 1, 2, 3, 4 }, 6, true),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 3, true),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 9, true),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 9, true),
    };

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      boolean expected = testCase.Rb;
      TreeNode root = Tree.arrayToTree(testCase.A);
      boolean result = isHeightBalancedTree(root, testCase.Bi);

      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + (expected) + ", Result: " + (result) + "\n");
      }
      count++;
    }
  }

  static boolean isBalanced = true;

  public static boolean isHeightBalancedTree(TreeNode root, int K) {
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
