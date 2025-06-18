package tree;

import java.util.Arrays;

import helper.TestCaseArray;

public class TreeConstruction {

  public static void main(String[] args) {
    System.out.println();
    fromInOrderAndPostOrder();
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

  public static TreeNode constructTreeFromInOrderAndPostOrder(int[] A, int[] B) {
    if (A.length == 0) {
      return null;
    }
    int n = A.length; // length is same for both array
    return treeBuilderInOrderAndPostOrder(A, 0, n - 1, B, 0, n - 1);
  }

  public static TreeNode treeBuilderInOrderAndPostOrder(int[] A, int iStart, int iEnd, int[] B, int pStart, int pEnd) {
    if (iStart > iEnd || pStart > pEnd) {
      return null;
    }
    int val = B[pEnd];
    TreeNode n = new TreeNode(val);
    int inOrderIndex = Arrays.binarySearch(A, val);
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

    n.left = treeBuilderInOrderAndPostOrder(A, iStart, inOrderIndex - 1, B, pStart, pStart + countOfLeftSubTree - 1);
    n.right = treeBuilderInOrderAndPostOrder(A, inOrderIndex + 1, iEnd, B, pStart + countOfLeftSubTree, pEnd - 1);

    return n;
  }

}
