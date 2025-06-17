package stack;

import java.util.Stack;

import helper.TestCaseArray;

public class SumOfMaxMin {

  public static void main(String[] args) {
    System.out.println();
    TestCaseArray[] TestCases = {
        new TestCaseArray(new int[] { 1, 2 }, 1),
        new TestCaseArray(new int[] { 1, 2, 3 }, 4),
        new TestCaseArray(new int[] { 1, 2, 3, 4 }, 10),
        new TestCaseArray(new int[] { 1, 2, 3, 4, 5 }, 20),
        new TestCaseArray(new int[] { 1, 3, 2 }, 5),
        new TestCaseArray(new int[] { 3, 1, 2 }, 5),
        new TestCaseArray(new int[] { 2, 3, 1 }, 5),
        new TestCaseArray(new int[] { 3, 2, 1 }, 4),
    };

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = sumOfMax_MinInAllSubarray(testCase.A);
      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  public static int[] nextSmallerOnLeft(int[] A) {
    int n = A.length;
    int[] R = new int[n];
    if (n == 0) {
      return R;
    }
    Stack<Integer> s = new Stack<>();

    for (int i = 0; i < n; i++) {
      while (s.size() > 0 && A[s.peek()] >= A[i]) {
        s.pop();
      }
      if (s.size() == 0) {
        R[i] = -1;
      } else {
        R[i] = s.peek();
      }
      s.push(i);
    }

    return R;
  }

  public static int[] nextSmallerOnRight(int[] A) {
    int n = A.length;
    int[] R = new int[n];
    if (n == 0) {
      return R;
    }
    Stack<Integer> s = new Stack<>();
    for (int i = n - 1; i >= 0; i--) {
      while (s.size() > 0 && A[s.peek()] >= A[i]) {
        s.pop();
      }
      if (s.size() == 0) {
        R[i] = n;
      } else {
        R[i] = s.peek();
      }
      s.push(i);
    }

    return R;
  }

  public static int[] nextGreaterOnLeft(int[] A) {
    int n = A.length;
    int[] R = new int[n];
    if (n == 0) {
      return R;
    }
    Stack<Integer> s = new Stack<>();
    for (int i = 0; i < n; i++) {
      while (s.size() > 0 && A[s.peek()] <= A[i]) {
        s.pop();
      }
      if (s.size() == 0) {
        R[i] = -1;
      } else {
        R[i] = s.peek();
      }
      s.push(i);
    }

    return R;
  }

  public static int[] nextGreaterOnRight(int[] A) {
    int n = A.length;
    int[] R = new int[n];
    if (n == 0) {
      return R;
    }
    Stack<Integer> s = new Stack<>();
    for (int i = n - 1; i > -1; i--) {
      while (s.size() > 0 && A[s.peek()] <= A[i]) {
        s.pop();
      }
      if (s.size() == 0) {
        R[i] = n;
      } else {
        R[i] = s.peek();
      }
      s.push(i);
    }

    return R;
  }

  public static int sumOfMax_MinInAllSubarray(int[] A) {
    int[] SL = nextSmallerOnLeft(A);
    int[] SR = nextSmallerOnRight(A);
    int[] GL = nextGreaterOnLeft(A);
    int[] GR = nextGreaterOnRight(A);
    int sum = 0;
    for (int i = 0; i < A.length; i++) {
      int minCont = (SR[i] - i) * (i - SL[i]);
      int maxCont = (GR[i] - i) * (i - GL[i]);
      // System.out.println(minCont + " " + maxCont);
      sum += (maxCont - minCont) * A[i];
    }
    return sum;
  }

}
