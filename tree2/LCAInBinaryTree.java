package tree2;

import tree.TreeNode;

public class LCAInBinaryTree {
  /**
   * 
   * Function to find LCA of two keys.
   * 
   * For unordered Binary Tree, special logic
   * 1. findLCAInBinaryTree: Assuming both X and Y exists
   * 2. findLCAInBinaryTree2: Assuming may not X or Y exists
   * 
   * @param root
   * @param n1
   * @param n2
   * @return
   */
  static TreeNode findLCAInBinaryTree(TreeNode n, int x, int y) {

    if (n == null)
      return null;

    // If either key matches with root data, return root
    if (n.val == x || n.val == y) {
      return n;
    }

    // Look for datas in left and right subtrees
    TreeNode leftLCA = findLCAInBinaryTree(n.left, x, y);
    TreeNode rightLCA = findLCAInBinaryTree(n.right, x, y);

    // If both of the above calls return Non-NULL, then one
    // data is present in one subtree and the other is present
    // in the other, so this node is the LCA
    if (leftLCA != null && rightLCA != null) {
      return n;
    }

    // Otherwise check if left subtree or right subtree is
    // LCA
    return (leftLCA != null) ? leftLCA : rightLCA;
  }

  static TreeNode findLCAInBinaryTree2(TreeNode n, int x, int y) {
    // If both value exist then only go for finding LCA
    if (isValueExist(n, x) && isValueExist(n, y)) {
      return findLCAInBinaryTree(n, x, y);
    } else {
      return null;
    }
  }

  /**
   * Search for given value X
   * 
   * @param n
   * @param x
   * @return
   */
  static boolean isValueExist(TreeNode n, int x) {
    if (n == null) {
      return false;
    }
    if (n.val == x) {
      return true;
    }

    return isValueExist(n.left, x) || isValueExist(n.right, x);
  }
}
