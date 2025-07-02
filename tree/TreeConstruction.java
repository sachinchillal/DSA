package tree;

import java.util.HashMap;

import helper.TestCaseArray;

public class TreeConstruction {

  public static void main(String[] args) {
    System.out.println();
    fromInOrderAndPreOrder();
    // fromInOrderAndPostOrder();
  }

  public static void fromInOrderAndPreOrder() {
    TestCaseArray[] TestCases = {
        new TestCaseArray(new int[] {}, new int[] {}),
        new TestCaseArray(new int[] { 1 }, new int[] { 1 }),
        new TestCaseArray(new int[] { 1, 2 }, new int[] { 1, 2 }),
        new TestCaseArray(new int[] { 1, 2 }, new int[] { 2, 1 }),

        new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 }),
        new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { 1, 3, 2 }),
        new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { 3, 2, 1 }),

        new TestCaseArray(new int[] { 1, 2, 3, 4 }, new int[] { 1, 2, 4, 3 }),
        new TestCaseArray(new int[] { 4, 2, 5, 1, 6, 3, 7 }, new int[] { 1, 2, 4, 5, 3, 6, 7 }),
    };

    for (TestCaseArray testCase : TestCases) {
      TreeNode result = constructTreeFromInOrderAndPreOrder(testCase.A, testCase.R_Array);
      if (result == null) {
        System.out.println("Result: " + result);
      } else {
        System.out.println(result.deepToStringLikeTree());
      }
    }
  }

  public static TreeNode constructTreeFromInOrderAndPreOrder(int[] A, int[] B) {
    if (A.length == 0) {
      return null;
    }
    int n = A.length; // length is same for both array
    HashMap<Integer, Integer> m = new HashMap<>();
    for (int i = 0; i < n; i++) {
      m.put(A[i], i);
    }
    return treeBuilderInOrderAndPreOrder(A, 0, n - 1, B, 0, n - 1, m);
  }

  public static TreeNode treeBuilderInOrderAndPreOrder(int[] A, int iStart, int iEnd, int[] B, int pStart, int pEnd,
      HashMap<Integer, Integer> m) {
    if (iStart > iEnd || pStart > pEnd) {
      return null;
    }

    int val = B[pStart];
    TreeNode n = new TreeNode(val);

    int inOrderIndex = m.get(val);
    int countOfLeftSubTree = inOrderIndex - iStart;

    n.left = treeBuilderInOrderAndPreOrder(A, iStart, inOrderIndex - 1, B, pStart + 1,
        pStart + countOfLeftSubTree, m);
    n.right = treeBuilderInOrderAndPreOrder(A, inOrderIndex + 1, iEnd,
        B, pStart + countOfLeftSubTree + 1, pEnd, m);

    return n;
  }

  public static void fromInOrderAndPostOrder() {
    TestCaseArray[] TestCases = {
        new TestCaseArray(new int[] {}, new int[] {}),
        new TestCaseArray(new int[] { 1 }, new int[] { 1 }),
        new TestCaseArray(new int[] { 1, 2 }, new int[] { 1, 2 }),
        new TestCaseArray(new int[] { 1, 2 }, new int[] { 2, 1 }),

        new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 }),
        new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { 1, 3, 2 }),
        new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { 3, 2, 1 }),

        new TestCaseArray(new int[] { 1, 2, 3, 4 }, new int[] { 1, 3, 4, 2 }),
        new TestCaseArray(new int[] { 4, 2, 5, 1, 6, 3, 7 }, new int[] { 4, 5, 2, 6,
            7, 3, 1 }),
    };

    // int count = 1;
    for (TestCaseArray testCase : TestCases) {
      TreeNode result = constructTreeFromInOrderAndPostOrder(testCase.A, testCase.R_Array);
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

  /**
   * Constructs a binary tree from its in-order and post-order traversals.
   *
   * @param A The in-order traversal array.
   * @param B The post-order traversal array.
   * @return The root of the constructed binary tree.
   */
  public static TreeNode constructTreeFromInOrderAndPostOrder(int[] A, int[] B) {
    if (A.length == 0) {
      return null;
    }
    int n = A.length; // length is same for both array
    HashMap<Integer, Integer> m = new HashMap<>();
    for (int i = 0; i < n; i++) {
      m.put(A[i], i);
    }
    return treeBuilderInOrderAndPostOrder(A, 0, n - 1, B, 0, n - 1, m);
  }

  public static TreeNode treeBuilderInOrderAndPostOrder(int[] A, int iStart, int iEnd, int[] B, int pStart, int pEnd,
      HashMap<Integer, Integer> m) {
    if (iStart > iEnd || pStart > pEnd) {
      return null;
    }

    int val = B[pEnd];
    TreeNode n = new TreeNode(val);

    int inOrderIndex = m.get(val);
    int countOfLeftSubTree = inOrderIndex - iStart;
    /*
     * // InOrder
     * 1 2 (3) 4 5 => 3 is target then select the left and right array
     * // left sub tree
     * iStart to inOrderIndex -1
     * // right sub tree
     * inOrderIndex +1 to iEnd
     */

    /*
     * // PostOrder
     * 1 2 4 5 (3) => 3 is target and find left and right array
     * do -1 to exclude last val as root or node
     * 
     * // left sub tree
     * pStart TO pEnd + countOfLeftSubTree -1
     * // right sub tree
     * pStart + countOfLeftSubTree TO pEnd -1
     */

    n.left = treeBuilderInOrderAndPostOrder(A, iStart, inOrderIndex - 1, B, pStart, pStart + countOfLeftSubTree - 1, m);
    n.right = treeBuilderInOrderAndPostOrder(A, inOrderIndex + 1, iEnd, B, pStart + countOfLeftSubTree, pEnd - 1, m);

    return n;
  }

}
