package stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

import helper.TestCaseArray;

public class MaximumFrequencyStack {

  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {
        new TestCaseArray(new int[] {}, new int[] {}, new int[] {}),
        new TestCaseArray(new int[] { 1 }, new int[] { 30 }, new int[] { -1 }),
        new TestCaseArray(new int[] { 2 }, new int[] { -2 }, new int[] { -1 }),
        new TestCaseArray(new int[] { 1, 2 }, new int[] { 10, -2 }, new int[] { -1, 10 }),
        new TestCaseArray(new int[] { 1, 2, 2 }, new int[] { 10, -2, -2 }, new int[] { -1, 10, -1 }),

        new TestCaseArray(new int[] { 1, 2, 3 }, new int[] { 10, -2, -2 }, new int[] { -1, 10, -1 }),
        new TestCaseArray(new int[] { 1, 1, 2 }, new int[] { 10, 20, -2 }, new int[] { -1, -1, 20 }),
        new TestCaseArray(new int[] { 1, 1, 2 }, new int[] { 30, 30, -2 }, new int[] { -1, -1, 30 }),
        new TestCaseArray(new int[] { 1, 1, 1, 2 }, new int[] { 30, 30, 40, -2 }, new int[] { -1, -1, -1, 30 }),
        new TestCaseArray(
            new int[] { 1, 1, 1, 2, 1, 1, 2 },
            new int[] { 30, 30, 40, -2, 40, 40, -2 },
            new int[] { -1, -1, -1, 30, -1, -1, 40 }),
        new TestCaseArray(
            new int[] { 1, 1, 1, 1, 1, 2, 2 },
            new int[] { 30, 30, 40, 40, 40, -2, -2 },
            new int[] { -1, -1, -1, -1, -1, 40, 40 }),
        new TestCaseArray(
            new int[] { 1, 1, 1, 1, 1, 1, 2, 2, 2, 2 },
            new int[] { 3, 9, 3, 9, 5, 3, -2, -2, -2, -2 },
            new int[] { -1, -1, -1, -1, -1, -1, 3, 9, 3, 5 }),
    };
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      int[] result = maximumFrequencyStack(testCase.A, testCase.B);

      if (Arrays.equals(result, expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + Arrays.toString(expected) + ", Result: " + Arrays.toString(result) + "\n");
      }
      count++;
    }
  }

  /**
   * Finds the maximum frequency stack based on the operations provided in array A
   * and array B.
   * 
   * @param A Operation A[i] = 1 = push , A[i] = 2 = pop from the stack
   * @param B Value array where B[i] is the value to push/pop
   * @return
   */
  public static int[] maximumFrequencyStack(int[] A, int[] B) {
    // re initialize
    frequencyMap = new HashMap<>();
    frequencyStackMap = new HashMap<>();
    maxFrequency = 0;

    int n = A.length;
    int[] R = new int[n];
    if (n == 0) {
      return R;
    }
    for (int i = 0; i < n; i++) {
      if (A[i] == 1) {
        R[i] = push(B[i]);
      } else if (A[i] == 2) {
        R[i] = pop();
      } else {
        R[i] = -1; // Invalid operation
      }
    }
    return R;
  }

  static int maxFrequency = 0;
  static HashMap<Integer, Integer> frequencyMap = new HashMap<>();
  static HashMap<Integer, Stack<Integer>> frequencyStackMap = new HashMap<>();

  static int push(int v) {
    int f = frequencyMap.getOrDefault(v, 0) + 1;
    frequencyMap.put(v, f);
    maxFrequency = Math.max(maxFrequency, f);

    if (!frequencyStackMap.containsKey(f)) {
      frequencyStackMap.put(f, new Stack<>());
    }
    frequencyStackMap.get(f).push(v);

    // return v; // return -1, or the value pushed
    return -1;
  }

  static int pop() {
    if (maxFrequency == 0) {
      return -1; // Stack is empty
    }
    int v = frequencyStackMap.get(maxFrequency).pop();
    frequencyMap.put(v, maxFrequency - 1);
    if (frequencyStackMap.get(maxFrequency).size() == 0) { // or
      // if (frequencyStackMap.get(maxFrequency).isEmpty()) {
      // frequencyStackMap.remove(maxFrequency); // optional, to clean up empty stacks
      maxFrequency--;
    }
    return v;
  }
}
