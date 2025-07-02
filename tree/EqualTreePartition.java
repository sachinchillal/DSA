package tree;

import java.util.HashMap;
import java.util.HashSet;

import helper.TestCaseArray;

public class EqualTreePartition {

  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {
        new TestCaseArray(new int[] {}, false),
        new TestCaseArray(new int[] { 1 }, false),
        new TestCaseArray(new int[] { 1, 2 }, false),
        new TestCaseArray(new int[] { 1, 2, 3 }, true),
        new TestCaseArray(new int[] { 1, 2, 3, 4 }, false),

        new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, false),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, false),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, false),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 7 }, false),
        new TestCaseArray(new int[] { 1, -1 }, false),

        new TestCaseArray(new int[] { 1, 2, 2 - 1 }, true),
        new TestCaseArray(new int[] { 1, -2, 2, -1 }, false),

        new TestCaseArray(new int[] { 1, 1 }, true),
        new TestCaseArray(new int[] { 1, 2, 1 }, true),
        new TestCaseArray(new int[] { 1, 2, 3, 2, 1 }, false),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, false),

        new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, false),
        new TestCaseArray(new int[] { -1, 0, 1, 2, 3, 4, 5, 6, 7 }, false),
        new TestCaseArray(new int[] { -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7 }, false)
    };

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      boolean expected = testCase.Rb;
      TreeNode root = Tree.arrayToTree(testCase.A);
      boolean result = isEqualPartitionPossible(root);
      // boolean result = isEqualPartitionPossible2(root);

      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + (expected) + ", Result: " + (result) + "\n");
      }
      count++;
    }
  }

  // Approach 1: Using HashSet to store all the sums of subtrees
  // Time Complexity: O(N)
  // Space Complexity: O(N)

  static public boolean isEqualPartitionPossible(TreeNode node) {
    HashSet<Long> set = new HashSet<>();
    long totalSum = sumOfAllNodes(node, set);
    if (totalSum == 0) {
      return false;
    }
    return totalSum % 2 == 0 && set.contains(totalSum / 2);
  }

  static public long sumOfAllNodes(TreeNode node, HashSet<Long> set) {
    if (node == null)
      return 0;
    long sum = node.val + sumOfAllNodes(node.left, set) + sumOfAllNodes(node.right, set);
    set.add(sum);
    return sum;
  }

  // Approach 2: Using HashMap to store the frequency of sums
  static public boolean isEqualPartitionPossible2(TreeNode node) {
    HashMap<Long, Integer> map = new HashMap<>();
    long totalSum = sumOfAllNodes(node, map);
    // since total sum can also be zero
    if (totalSum == 0)
      return map.getOrDefault(totalSum, 0) > 1;
    return totalSum % 2 == 0 && map.containsKey(totalSum / 2);
  }

  static public long sumOfAllNodes(TreeNode node, HashMap<Long, Integer> map) {
    if (node == null)
      return 0;
    long sum = node.val + sumOfAllNodes(node.left, map) + sumOfAllNodes(node.right, map);
    map.put(sum, map.getOrDefault(sum, 0) + 1);
    return sum;
  }

}
