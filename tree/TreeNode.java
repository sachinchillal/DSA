package tree;

public class TreeNode {
  public int val;
  public TreeNode left = null;
  public TreeNode right = null;
  // Next Pointer / Right Pointer
  public TreeNode next = null;

  public TreeNode(int value) {
    val = value;
  }

  public String deepToStringLikeTree() {
    return deepToStringLikeTree(0);
  }

  public String deepToStringLikeTreeWithNext() {
    return deepToStringLikeTreeWithNext(0);
  }

  public static String deepToStringNext(TreeNode n) {
    StringBuilder sb = new StringBuilder();

    if (n == null) {
      sb.append("null -> ");
    } else {
      sb.append(n.val + "-> ");
      sb.append(deepToStringNext(n.next));
    }
    return sb.toString();
  }

  // PRIVATE

  private String deepToStringLikeTree(int level) {
    StringBuilder sb = new StringBuilder();
    // appendIndentation(sb, level); // Indent the current node

    sb.append(val);

    if (left != null || right != null) { // Only append branches if there are children
      sb.append("\n");
      appendIndentation(sb, level + 1); // Indent for left child
      sb.append("L: ");
      if (left != null) {
        sb.append(left.deepToStringLikeTree(level + 1));
      } else {
        sb.append("null");
      }

      sb.append("\n");
      appendIndentation(sb, level + 1); // Indent for right child
      sb.append("R: ");
      if (right != null) {
        sb.append(right.deepToStringLikeTree(level + 1));
      } else {
        sb.append("null");
      }
    }
    return sb.toString();
  }

  private String deepToStringLikeTreeWithNext(int level) {
    StringBuilder sb = new StringBuilder();
    // appendIndentation(sb, level); // Indent the current node

    sb.append(val);
    // NEXT
    sb.append(" | N: ");
    if (next == null) {
      sb.append("null");
    } else {
      sb.append(next.val);
    }

    if (left != null || right != null) { // Only append branches if there are children
      sb.append("\n");
      appendIndentation(sb, level + 1); // Indent for left child
      sb.append("L: ");
      if (left != null) {
        sb.append(left.deepToStringLikeTreeWithNext(level + 1));
      } else {
        sb.append("null");
      }

      sb.append("\n");
      appendIndentation(sb, level + 1); // Indent for right child
      sb.append("R: ");
      if (right != null) {
        sb.append(right.deepToStringLikeTreeWithNext(level + 1));
      } else {
        sb.append("null");
      }
    }
    return sb.toString();
  }

  // Helper to append the correct amount of indentation
  private void appendIndentation(StringBuilder sb, int level) {
    for (int i = 0; i < level; i++) {
      sb.append("  -> ");
    }
  }

}
