package tree2;

import tree.TreeNode;

public class PathSum {

  // Given a binary tree and a sum, determine if the tree has a root-to-leaf path
  // such that adding up all the values along the path equals the given sum.
  public boolean hasPathSumInBinaryTree(TreeNode n, int sum) {
    // If the tree is empty, there's no path.
    if (n == null) {
      return false;
    }

    // Check if the current node is a leaf node.
    if (n.left == null && n.right == null) {
      // If it's a leaf, check if its value equals the remaining sum.
      return (sum == n.val);
    }

    // Recursively check the left and right subtrees with the updated sum.
    // The updated sum is the target sum minus the current node's value.
    int newSum = sum - n.val;

    // If a valid path is found in either the left OR the right subtree, return 1.
    return hasPathSumInBinaryTree(n.left, newSum) || hasPathSumInBinaryTree(n.right, newSum);

    // If no path was found in either subtree.
    // return false;
  }
}
