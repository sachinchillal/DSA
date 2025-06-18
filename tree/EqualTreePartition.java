package tree;

import helper.TestCaseArray;

public class EqualTreePartition {

  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {
        new TestCaseArray(new int[] { 1 }, false),
        new TestCaseArray(new int[] { 1, 2 }, false),
        new TestCaseArray(new int[] { 1, 2, 3 }, true),
        new TestCaseArray(new int[] { 1, 2, 3, 4 }, true),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, false),

        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, false),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, true),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 7 }, false),
        new TestCaseArray(new int[] {}, false),
        new TestCaseArray(new int[] { 1, 1 }, true),

        new TestCaseArray(new int[] { 1, 2, 1 }, true),
        new TestCaseArray(new int[] { 1, 2, 3, 2, 1 }, false),
        new TestCaseArray(new int[] { 1, 2, 3, 4 }, true),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, false),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, false),

        new TestCaseArray(new int[] { -1, 0, 1, 2, 3, 4, 5, 6, 7 }, false),
        new TestCaseArray(new int[] { -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7 }, true)
    };

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      boolean expected = testCase.Rb;
      TreeNode root = Tree.arrayToBinarySearchTree(testCase.A);
      boolean result = isEqualPartitionPossible(root);

      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + (expected) + ", Result: " + (result) + "\n");
      }
      count++;
    }
  }

  static boolean isPossible = false;

  public static boolean isEqualPartitionPossible(TreeNode root) {
    if (root == null) {
      return false;
    }
    int totalSum = sumOfAllNodes(root);
    if (totalSum % 2 == 0) {
      // if even then only partition will be equal, if not
      isPossible(root, totalSum / 2);
    } else {
      return false;
    }
    return isPossible;
  }

  public static int isPossible(TreeNode root, int requiredSum) {
    if (root == null) {
      return 0;
    }
    int sumLeft = isPossible(root.left, requiredSum);
    int sumRight = isPossible(root.right, requiredSum);
    if (sumLeft == requiredSum || sumRight == requiredSum) {
      isPossible = true;
      // return 0; // This is also fine
    }
    return sumLeft + root.val + sumRight;
  }

  public static int sumOfAllNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int sumLeft = sumOfAllNodes(root.left);
    int sumRight = sumOfAllNodes(root.right);
    return sumLeft + root.val + sumRight;
  }
}
