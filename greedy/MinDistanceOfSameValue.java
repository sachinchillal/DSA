package greedy;

import java.util.HashMap;

public class MinDistanceOfSameValue {

  public int minimumDistanceOfSameElements(int[] A) {
    HashMap<Integer, Integer> m = new HashMap<>();
    int minDistance = Integer.MAX_VALUE;
    for (int i = 0; i < A.length; i++) {
      if (m.get(A[i]) != null) {
        int currentDistance = i - m.get(A[i]);
        minDistance = Math.min(minDistance, currentDistance);
        m.put(A[i], i);
      } else {
        m.put(A[i], i);
      }

    }
    return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
  }

  public int minimumDistanceOfSameElements2(int[] A) {
    if (A == null || A.length < 2) {
      return -1;
    }

    HashMap<Integer, Integer> lastSeenIndex = new HashMap<>();
    int minDistance = Integer.MAX_VALUE;
    boolean foundSpecialPair = false;

    for (int i = 0; i < A.length; i++) {
      int currentElement = A[i];

      if (lastSeenIndex.containsKey(currentElement)) {
        foundSpecialPair = true;
        int distance = i - lastSeenIndex.get(currentElement);
        minDistance = Math.min(minDistance, distance);
      }

      lastSeenIndex.put(currentElement, i);
    }

    return foundSpecialPair ? minDistance : -1;
  }

  public int minimumDistanceOfSameElements3(int[] A) {
    if (A == null || A.length < 2) {
      return -1;
    }
    HashMap<Integer, Integer> m = new HashMap<>();
    int R = A.length;
    for (int i = 0; i < A.length; i++) {
      // checks if A[i] has occurred previously
      if (m.containsKey(A[i])) {
        R = Math.min(R, i - m.get(A[i]));
      }
      m.put(A[i], i);
    }
    return (R == A.length) ? -1 : R;
  }

}
