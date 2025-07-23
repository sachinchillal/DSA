package maths;

public class IsPairExistsWIthSum {
  /*
   * Given a sorted array A and an integer K, this method checks if there exists
   * Array will be sorted in ascending order.
   * Two-pointer technique to find if a pair exists with a given sum K.
   * 1. Array is sorted.
   * 2. Has distinct elements.
   */
  public static boolean isPairExistsWithSumK(int[] A, int K) {
    int left = 0;
    int right = A.length - 1;

    while (left < right) {
      int currentSum = A[left] + A[right];

      if (currentSum == K) {
        return true;
      } else if (currentSum < K) {
        left++; // Move left pointer to the right to increase the sum
      } else {
        right--;
      }
    }
    return false;
  }

  /*
   * 1. Array is sorted.
   * 2. Has duplicate elements.
   */
  public static int countPairsWithSumK(int[] A, int K) {
    int left = 0;
    int right = A.length - 1;
    int count = 0;
    while (left < right) {
      int currentSum = A[left] + A[right];

      if (currentSum == K) {
        // Count all duplicates
        int leftCount = 1;
        int rightCount = 1;
        // Since A is sorted, duplicate elements will be adjacent.
        while (left + 1 < right && A[left] == A[left + 1]) {
          leftCount++;
          left++;
        }
        while (right - 1 > left && A[right] == A[right - 1]) {
          rightCount++;
          right--;
        }
        count += leftCount * rightCount;
        left++;
        right--;
      } else if (currentSum < K) {
        left++; // Move left pointer to the right to increase the sum
      } else {
        right--; // Move right pointer to the left to decrease the sum
      }
    }
    return count;
  }

  public static boolean isPairExistsWithDifferenceK(int[] A, int K) {
    int left = 0;
    int right = 1;

    while (right < A.length) {
      int currentDiff = A[right] - A[left];
      if (currentDiff == K) {
        return true;
      } else if (currentDiff < K) {
        right++;
      } else {
        left++;
      }
    }
    return false;
  }
}
