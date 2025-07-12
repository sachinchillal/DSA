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
      boolean result = isPathExistWithSumUtilLeaf(root, testCase.N);
      // boolean result = isPathExistWithSum(root, testCase.N);

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
   * A utility function to find if a path with a given sum exists from the current
   * node to a leaf.
   *
   * @param node The current node in the traversal.
   * @param K    The remaining sum required to find a valid path.
   * @return True if a path from the current node to a leaf with the remaining sum
   *         exists, false otherwise.
   */
  public static boolean isPathExistWithSumUtilLeaf(TreeNode node, int K) {
    // Base case: if the node is null, no path exists.
    if (node == null) {
      return false;
    }

    // Check if the current node is a leaf node.
    if (node.left == null && node.right == null) {
      // If it is a leaf, check if its value equals the remaining sum.
      return (K == node.val);
    }

    // Recursively check the left and right subtrees with the updated sum.
    boolean leftPathExists = isPathExistWithSumUtilLeaf(node.left, K - node.val);
    boolean rightPathExists = isPathExistWithSumUtilLeaf(node.right, K - node.val);

    // Return true if a path exists in either the left or the right subtree.
    return leftPathExists || rightPathExists;
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
