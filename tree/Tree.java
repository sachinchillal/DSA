package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Tree {
  /*
   * Level Order Array to Normal Tree Construction
   */
  public static TreeNode arrayToTree(int[] A) {
    if (A.length == 0) {
      return null;
    }
    TreeNode root = new TreeNode(A[0]);
    ArrayDeque<TreeNode> Q = new ArrayDeque<>();
    Q.add(root);
    int i = 1;
    while (Q.size() > 0 && i < A.length) {
      TreeNode n = Q.removeFirst();
      if (i < A.length) {
        n.left = new TreeNode(A[i]);
        Q.add(n.left);
        i++;
      }
      if (i < A.length) {
        n.right = new TreeNode(A[i]);
        Q.add(n.right);
        i++;
      }
    }

    return root;
  }

  /*
   * Binary Search Trees (BST) Construction by Sorting Array
   */
  public static TreeNode arrayToBinarySearchTree(int[] A) {
    if (A.length == 0) {
      return null;
    }
    return constructorBST(A, 0, A.length - 1);
  }

  private static TreeNode constructorBST(int[] A, int low, int high) {
    if (low > high) {
      return null;
    }
    int mid = low + (high - low) / 2;
    TreeNode n = new TreeNode(A[mid]);
    n.left = constructorBST(A, low, mid - 1);
    n.right = constructorBST(A, mid + 1, high);
    return n;
  }

  public static int[] treeToArray(TreeNode root) {
    ArrayList<Integer> A = new ArrayList<>();
    if (root == null) {
      return new int[0];
    }
    return A.stream().mapToInt(v -> v).toArray();
  }
}
