package greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {
  /**
   * Using Min Heap
   * 
   * @param A
   * @return
   */
  public int minMeetingRoomsRequired(int[][] A) {

    // return endTimes.size();
    if (A == null || A.length == 0) {
      return 0;
    }

    // Sort the based on start time
    Arrays.sort(A, (x, y) -> x[0] - y[0]);

    // Min-heap to track the earliest ending meeting
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // endTimes
    // PriorityQueue<Integer> endTimes = new PriorityQueue<>();

    // Add the end time of the first meeting
    minHeap.add(A[0][1]);

    for (int i = 1; i < A.length; i++) {
      // If the current meeting starts after the earliest ending meeting,
      // then reuse that room
      if (A[i][0] >= minHeap.peek()) {
        minHeap.poll();
      }

      // Add the current meeting's end time to the heap
      minHeap.add(A[i][1]);
    }

    // The size of the heap is the number of rooms required
    return minHeap.size();
  }

  /**
   * Using Two Pointers Approach
   * Function to find the minimum number of rooms required
   */
  static int minMeetingRoomsRequired2(int[] start, int[] end) {
    int R = 0; // no. of rooms required
    int c = 0; // currently engaged rooms
    int n = start.length;

    Arrays.sort(start);
    Arrays.sort(end);

    // pointing to the current index of the start and end array
    int i = 0, j = 0;
    while (i < n) {
      if (start[i] < end[j]) {
        c++;
        i++;
      } else {
        c--;
        j++;
      }
      R = Math.max(R, c);
    }
    return R;
  }
}
