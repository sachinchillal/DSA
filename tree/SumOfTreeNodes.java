package tree;

import helper.TestCaseArray;

public class SumOfTreeNodes {

  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {
        new TestCaseArray(new int[] {}, 0),
        new TestCaseArray(new int[] { 1 }, 1),
        new TestCaseArray(new int[] { 1, 2 }, 3),
        new TestCaseArray(new int[] { 1, 2, 3 }, 6),
        new TestCaseArray(new int[] { 1, 2, 3, 4 }, 10),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 15),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 21),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 28),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 7 }, 35),

        new TestCaseArray(new int[] { 1, 2, 3, 4, 0 }, 10),
        new TestCaseArray(new int[] { 0, 1, 2, 3, 4 }, 10),
        new TestCaseArray(new int[] { -1, 0, 1, 2, 3, 4 }, 9),
        new TestCaseArray(new int[] { -2, -1, 0, 1, 2, 3, 4 }, 7),
        new TestCaseArray(new int[] { -3, -2, -1, 0, 1, 2, 3, 4 }, 4),
        new TestCaseArray(new int[] { -4, -3, -2, -1, 0, 1, 2, 3, 4 }, 0),

        new TestCaseArray(new int[] { 1, 2, 3, 4, -5 }, 5),
        new TestCaseArray(new int[] { 1, 2, 3, 4, -5, -6 }, -1),
        new TestCaseArray(new int[] { 1, 2, 3, 4, -5, -6, -7 }, -8),
        new TestCaseArray(new int[] { 1, 2, 3, 4, -5, -6, -7, -8 }, -16),
    };

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      TreeNode root = Tree.arrayToBinarySearchTree(testCase.A);
      int result = sumOfAllNodes(root);

      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + (expected) + ", Result: " + (result) +
            "\n");
      }
      count++;
    }
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
