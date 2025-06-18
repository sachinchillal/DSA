package tree;

public class TreeNode {
  public int val;
  public TreeNode left = null;
  public TreeNode right = null;

  public TreeNode(int value) {
    val = value;
  }

  public String deepToStringLikeTree() {
    return deepToStringLikeTree(0);
  }

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

  // Helper to append the correct amount of indentation
  private void appendIndentation(StringBuilder sb, int level) {
    for (int i = 0; i < level; i++) {
      sb.append("  -> ");
    }
  }

}
