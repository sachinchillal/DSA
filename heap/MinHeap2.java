package heap;

import java.util.Arrays;

import helper.TestCaseArray;

public class MinHeap2 {
  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : MinHeap.TestCases) {
      int[] expected = testCase.R_Array;
      int[] result = buildMinHeap(testCase.A);
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

  public static int[] buildMinHeap(int[] A) {
    int n = A.length;
    if (n == 0) {
      return new int[] {};
    }
    int pi = n / 2 - 1;
    while (pi >= 0) {
      int i = pi;
      while (2 * i + 1 < A.length) {
        int leftChildIndex = 2 * i + 1;
        int rightChildIndex = 2 * i + 2;
        int leftChild = A[leftChildIndex];
        int rightChild = Integer.MAX_VALUE;
        if (rightChildIndex < A.length) {
          rightChild = A[rightChildIndex];
        }
        // int min_ele =Math.min(A[i], leftChild, rightChild);
        int min_ele = Math.min(A[i], leftChild);
        min_ele = Math.min(min_ele, rightChild);

        if (A[i] == min_ele) {
          break;
        } else if (leftChild == min_ele) {
          swap(A, i, leftChildIndex);
          i = leftChildIndex;
        } else {
          swap(A, i, rightChildIndex);
          i = rightChildIndex;
        }

      }
      pi = pi - 1;
    }
    return A;
  }

  /**
   * Swaps two elements in the array A.
   * 
   * @param A
   * @param i
   * @param j
   */
  public static void swap(int[] A, int i, int j) {
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }
}
