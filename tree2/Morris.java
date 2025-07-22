package tree2;

import tree.TreeNode;
// import helper.TreeNode;

public class Morris {
  // Function to find kth smallest element in a BST.
  static int kthSmallest(TreeNode root, int k) {
    int cnt = 0;
    TreeNode curr = root;

    while (curr != null) {

      // if left child is null, check
      // curr node and move to right node.
      if (curr.left == null) {
        cnt++;

        // If curr is kth smallest node
        if (cnt == k)
          return curr.val;

        curr = curr.right;
      } else {

        // Find the inorder predecessor of curr
        TreeNode pre = curr.left;
        while (pre.right != null && pre.right != curr)
          pre = pre.right;

        // Make curr as the right child of its
        // inorder predecessor and move to
        // left node.
        if (pre.right == null) {
          pre.right = curr;
          curr = curr.left;
        } else {

          // Revert the changes made in the 'if' part to
          // restore the original tree i.e., fix the right
          // child of predecessor
          pre.right = null;

          cnt++;
          if (cnt == k)
            return curr.val;

          curr = curr.right;
        }
      }
    }

    // If k is greater than size of
    // BST, return -1.
    return -1;
  }
}
