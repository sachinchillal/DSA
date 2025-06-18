package tree;

import helper.TestCaseArray;

public class BSTSearching {
  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {
        new TestCaseArray(new int[] { 1 }, 1, true),
        new TestCaseArray(new int[] { 1, 2 }, 2, true),
        new TestCaseArray(new int[] { 1, 2, 3 }, 3, true),
        new TestCaseArray(new int[] { 1, 2, 3, 4 }, 4, true),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 5, true),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 6, true),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 7, true),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 7 }, 7, true),

        new TestCaseArray(new int[] {}, 3, false),
        new TestCaseArray(new int[] { 1 }, 2, false),
        new TestCaseArray(new int[] { 1, 2 }, 3, false),
        new TestCaseArray(new int[] { 1, 2, 3 }, 4, false),
        new TestCaseArray(new int[] { 1, 2, 3, 4 }, 5, false),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 6, false),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 7, false),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 8, false)
    };

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      boolean expected = testCase.Rb;
      TreeNode root = Tree.arrayToBinarySearchTree(testCase.A);
      boolean result = searchingInBinarySearchTree(root, testCase.Bi);

      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + (expected) + ", Result: " + (result) + "\n");
      }
      count++;
    }
  }

  public static boolean searchingInBinarySearchTree(TreeNode root, int K) {
    if (root == null) {
      return false;
    }
    TreeNode n = root;
    while (n != null) {
      if (n.val == K) {
        return true;
      } else if (n.val > K) {
        n = n.left;
      } else {
        n = n.right;
      }
    }
    return false;
  }
}
