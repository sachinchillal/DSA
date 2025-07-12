package queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import helper.TestCaseArray;

public class TaskScheduler {

  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {
        new TestCaseArray(new int[] { 1, 2, 3, 4 }, 1, new int[] { 2, 3, 4 }),
        new TestCaseArray(new int[] { 1, 2, 3, 4 }, 2, new int[] { 3, 4, 2 }),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 5, new int[] { 2, 3, 4, 5 }),
        new TestCaseArray(new int[] { 8, 8, 10 }, 20, new int[] { 3, 1, 2 }),
    };

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      int[] result = findQueueArrangement(testCase.A, testCase.N);
      if (Arrays.equals(result, expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + Arrays.toString(expected) + ", Result: " + Arrays.toString(result) + "\n");
      }
      count++;
    }
  }

  public static int[] findQueueArrangement(int[] assignments, int b) {
    Queue<Integer> studentQueue = new LinkedList<>();
    // Initially, all students are in the queue from 1 to N
    for (int i = 1; i <= assignments.length; i++) {
      studentQueue.add(i);
    }

    int checkedAssignments = 0;
    while (checkedAssignments < b && !studentQueue.isEmpty()) {
      int currentStudentRoll = studentQueue.poll();
      int studentIndex = currentStudentRoll - 1;

      if (assignments[studentIndex] > 0) {
        assignments[studentIndex]--; // Teacher checks one assignment
        checkedAssignments++;

        if (assignments[studentIndex] > 0) {
          studentQueue.add(currentStudentRoll); // Student goes to the end of the queue
        }
      }
    }

    int[] R = new int[studentQueue.size()];
    for (int i = 0; i < R.length; i++) {
      R[i] = studentQueue.poll();
    }
    return R;
  }

}
