package tree;

import helper.TestCaseArray;

public class PathWIthSum {

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
        new TestCaseArray(new int[] {}, 3, false),
        new TestCaseArray(new int[] { 1 }, 2, false),
        new TestCaseArray(new int[] { 1, 2 }, 4, false),

        new TestCaseArray(new int[] { 1, 2, 3 }, 5, false),
        new TestCaseArray(new int[] { 1, 2, 3, 4 }, 6, false),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 3, false),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 9, false),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 9, false)
    };

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      boolean expected = testCase.Rb;
      TreeNode root = Tree.arrayToTree(testCase.A);
      boolean result = isPathExistWithSum(root, testCase.Bi);

      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + (expected) + ", Result: " + (result) + "\n");
      }
      count++;
    }
  }

  static boolean isExist = false;

  public static boolean isPathExistWithSum(TreeNode root, int K) {
    isExist = false; // To run this function again and again
    if (root == null) {
      return false;
    }
    isPathExistWithSumUtilLeaf(root, K, root.val);
    return isExist;
  }

  public static void isPathExistWithSumUtilLeaf(TreeNode node, int K, int currentSum) {
    if (isExist == true) {
      return;
    }
    if (node.right == null && node.left == null) {
      if (currentSum == K) {
        isExist = true;
        // System.out.println(isExist);
        return;
      }
    } else if (node.right == null) {
      // node has left child only
      isPathExistWithSumUtilLeaf(node.left, K, currentSum + node.left.val);
    } else if (node.left == null) {
      // node has right child only
      isPathExistWithSumUtilLeaf(node.right, K, currentSum + node.right.val);
    } else {
      // node has both left and right child
      isPathExistWithSumUtilLeaf(node.left, K, currentSum + node.left.val);
      isPathExistWithSumUtilLeaf(node.right, K, currentSum + node.right.val);
    }
  }
}
