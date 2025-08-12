package greedy;

import java.util.PriorityQueue;

public class KthLargestInAllWindow {

  static int[] getKthLargestWithinAllWindowFromZero(int[] A, int K) {
    int[] R = new int[A.length];

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int i = 0; i < A.length; i++) {
      minHeap.offer(A[i]);
      if (minHeap.size() > K) {
        minHeap.poll();
      }
      R[i] = minHeap.peek();
    }

    return R;
  }
}