package tree2;

import helper.TestCaseArray;
import tree.Tree;
import tree.TreeNode;

public class KthSmallestInBST {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 }, 10, 10),

      new TestCaseArray(new int[] {}, 1, -1),
      new TestCaseArray(new int[] { 1 }, 1, 1),
      new TestCaseArray(new int[] { 1, 2 }, 2, 2),
      new TestCaseArray(new int[] { 1, 2, 3 }, 3, 3),
      new TestCaseArray(new int[] { 1, 2, 3, 4 }, 4, 4),

      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 5, 5),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 6, 6),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 7 }, 7, 7),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 0, -1),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 1, 1),

      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 2, 2),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3, 3),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 4, 4),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5, 5),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 6, 6),

      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 7, 7)
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      TreeNode root = Tree.arrayToBinarySearchTree(testCase.A);
      if (root != null) {

        System.out.println(root.deepToStringLikeTree());
      }
      int result = findKthSmallestElementInBST(root, testCase.N);
      // int result = findKthSmallestElementInBST2(root, testCase.N);
      int expected = testCase.R;
      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + (expected) + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  public static int findKthSmallestElementInBST(TreeNode r, int k) {
    if (r == null || k < 1) {
      return -1;
    }
    int[] c = { 0 };
    return findKth(r, k, c);
  }

  static int findKth(TreeNode n, int k, int[] c) {
    if (n == null) {
      return -1;
    }
    // System.out.println(n.val);
    int left = findKth(n.left, k, c);
    if (left == -1) {
      c[0]++;
      if (c[0] == k) {
        return n.val;
      }
      int right = findKth(n.right, k, c);
      return right;
    } else {
      return left;
    }
  }

  public static int findKthSmallestElementInBST2(TreeNode root, int K) {
    if (root == null || K <= 0) {
      return -1; // Invalid case
    }
    int[] count = { 0 };
    return findKthSmallestHelper(root, K, count);
  }

  private static int findKthSmallestHelper(TreeNode node, int K, int[] count) {
    if (node == null) {
      return -1; // Not found
    }

    // Search in left subtree
    int leftResult = findKthSmallestHelper(node.left, K, count);
    if (leftResult != -1) {
      return leftResult; // Found in left subtree
    }

    // Increment count for current node
    count[0]++;
    if (count[0] == K) {
      return node.val; // Found the Kth smallest element
    }

    // Search in right subtree
    return findKthSmallestHelper(node.right, K, count);
  }
}
