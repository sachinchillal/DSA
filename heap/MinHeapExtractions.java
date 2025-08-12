package heap;

import java.util.ArrayList;
import java.util.Arrays;

import helper.TestCaseArray;

public class MinHeapExtractions {
  // 0 = Pop , 1 = Push
  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[][] { { 0, 0 }, { 0, 0 } }, new int[] { -1, -1 }),
      new TestCaseArray(new int[][] { { 1, 2 }, { 0, 0 } }, new int[] { 2 }),
      new TestCaseArray(new int[][] { { 1, 3 }, { 1, 5 } }, new int[] {}),
      new TestCaseArray(new int[][] { { 1, 3 }, { 1, 5 }, { 0, 0 } }, new int[] { 3 }),
      new TestCaseArray(new int[][] { { 1, 3 }, { 1, 5 }, { 0, 0 }, { 0, 0 } }, new int[] { 3, 5 }),

      new TestCaseArray(new int[][] { { 1, 8 }, { 1, 6 }, { 0, 0 }, { 1, 5 }, { 0, 0 }, { 1, 9 } }, new int[] { 6, 5 }),
      new TestCaseArray(new int[][] { { 1, 7 }, { 1, 5 }, { 0, 0 } }, new int[] { 5 }),
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int[] expected = testCase.R_Array;
      int[][] Qr = testCase.A_2Array;
      ArrayList<ArrayList<Integer>> Q = new ArrayList<>();

      for (int[] q : Qr) {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(q[0]);
        l.add(q[1]);
        Q.add(l);
      }

      int[] result = minHeapOperation(Q);
      if (Arrays.equals(result, expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println(Arrays.toString(expected) + " Expected");
        System.out.println(Arrays.toString(result) + " Result\n");
      }
      count++;
    }
  }

  /**
   * Given an array A consisting of N queries, where each query is represented as
   * an array of two integers [Operation, Value], where Operation can be
   * either 0 or 1:
   * 0 = Extract the minimum value from the min heap and return it.
   * 1 = Insert Value into the min heap.
   * 
   * @param Q
   * @return
   */
  static int[] minHeapOperation(ArrayList<ArrayList<Integer>> Q) {
    ArrayList<Integer> heap = new ArrayList<>();
    ArrayList<Integer> R = new ArrayList<>();
    for (ArrayList<Integer> q : Q) {
      if (q.get(0) == 0) { // Extract minimum
        int k = pop(heap);
        R.add(k);
      } else if (q.get(0) == 1) { // Insert into heap
        push(heap, q.get(1));
      }
    }
    return R.stream().mapToInt(e -> e).toArray();
  }

  static void heapify(ArrayList<Integer> A, int n, int i) {
    int s = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;
    if (l < n && A.get(l) < A.get(s)) {
      s = l;
    }
    if (r < n && A.get(r) < A.get(s)) {
      s = r;
    }
    if (s != i) {
      swap(A, i, s);
      heapify(A, n, s);
    }
  }

  static void swap(ArrayList<Integer> heap, int i, int j) {
    int temp = heap.get(i);
    heap.set(i, heap.get(j));
    heap.set(j, temp);
  }

  static void push(ArrayList<Integer> A, int v) {
    A.add(v);
    int i = A.size() - 1;
    while (i > 0) {
      int parent = (i - 1) / 2;
      if (A.get(parent) > A.get(i)) {
        swap(A, parent, i);
        i = parent;
      } else {
        break;
      }
    }
  }

  static int pop(ArrayList<Integer> A) {
    int n = A.size();
    if (n < 1) {
      return -1;
    }
    int R = A.get(0);
    swap(A, 0, n - 1);
    A.remove(n - 1);
    if (A.size() > 0) {
      heapify(A, A.size(), 0);
    }
    return R;
  }
}
