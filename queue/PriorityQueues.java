package queue;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

import helper.TestCaseArray;

public class PriorityQueues {

  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {
        new TestCaseArray(new int[] { 1, 2, 3, 4 }, 1, true),
        new TestCaseArray(new int[] { 1, 2, 3, 4 }, 2, true),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 5, true),
        new TestCaseArray(new int[] { 8, 8, 10 }, 20, false),
    };

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      boolean expected = testCase.Rb;
      boolean result = canFormPerfectLine(testCase.A, testCase.Bi);
      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + (expected) + ", Result: " + (result) + "\n");
      }
      count++;
    }
  }

  public static boolean canFormPerfectLine(int[] A, int B) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    HashSet<Integer> uniqueSizes = new HashSet<>();

    // Add all items to the max heap
    for (int num : A) {
      maxHeap.add(num);
    }

    while (!maxHeap.isEmpty() && uniqueSizes.size() < B) {
      int current = maxHeap.poll();

      // Skip if already in the set
      if (uniqueSizes.contains(current)) {
        continue;
      }

      uniqueSizes.add(current);

      // If we reached B unique sizes, return true
      if (uniqueSizes.size() == B) {
        return true;
      }

      // Break the item if it's greater than 1
      if (current > 1) {
        int part1 = current / 2;
        int part2 = current - part1;

        maxHeap.add(part1);
        maxHeap.add(part2);
      }
    }

    return uniqueSizes.size() == B;
  }

}
