package tree;

import java.util.Arrays;

import helper.TestCaseArray;

public class BSTConstruction {
  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {
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

        new TestCaseArray(new int[] { 8, 0, 1, 5, 6, 7, 2, 3, 4 }, -5),
    };

    // int count = 1;
    for (TestCaseArray testCase : TestCases) {
      // TreeNode root = Tree.arrayToBinarySearchTree(testCase.A);
      TreeNode result = constructBinarySearchTree(testCase.A);
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

  public static TreeNode constructBinarySearchTree(int[] A) {
    if (A.length == 0) {
      return null;
    }
    Arrays.sort(A);
    return builderBST(A, 0, A.length - 1);
  }

  private static TreeNode builderBST(int[] A, int low, int high) {
    if (low > high) {
      return null;
    }
    int mid = low + (high - low) / 2;
    TreeNode n = new TreeNode(A[mid]);
    n.left = builderBST(A, low, mid - 1);
    n.right = builderBST(A, mid + 1, high);
    return n;
  }
}
