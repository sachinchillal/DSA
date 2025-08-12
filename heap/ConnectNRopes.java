package heap;

import java.util.PriorityQueue;

import helper.TestCaseArray;

public class ConnectNRopes {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, 0),
      new TestCaseArray(new int[] { 1 }, 0),
      new TestCaseArray(new int[] { 1, 2 }, 3),
      new TestCaseArray(new int[] { 1, 2, 3 }, 9),
      new TestCaseArray(new int[] { 1, 2, 3, 4 }, 19),

      new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 33),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 51),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 74),
      new TestCaseArray(new int[] { 1, 3, 5, 7, 9 }, 54),
      new TestCaseArray(new int[] { 12, 2, 10, 6, 8, 4 }, 102),

      new TestCaseArray(new int[] { 15, 6, 3, 4, 8, 7, 5, 14 }, 175),
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = minCostToConnectNRopes(testCase.A);
      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  public static int minCostToConnectNRopes(int[] ropes) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int rope : ropes) {
      pq.add(rope);
    }
    int totalCost = 0;
    while (pq.size() > 1) {
      int first = pq.poll();
      int second = pq.poll();
      int cost = first + second;
      totalCost += cost;
      pq.add(cost);
    }
    return totalCost;
  }

}
