package greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class DistributeJobsBasedOnRating {
  public static int jobDistributionBasedOnRating(int[] A) {
    int R = 0;
    if (A == null || A.length == 0) {
      return R;
    }
    int n = A.length;
    int[] jobs = new int[n];
    // Step 1: Initialize each job with one unit.
    Arrays.fill(jobs, 1);
    // Step 2: Left-to-right pass.
    for (int i = 1; i < n; i++) {
      if (A[i] > A[i - 1]) {
        jobs[i] = jobs[i - 1] + 1;
      }
    }
    // Step 3: Right-to-left pass.
    for (int i = n - 2; i >= 0; i--) {
      if (A[i] > A[i + 1]) {
        jobs[i] = Math.max(jobs[i], jobs[i + 1] + 1);
      }
    }
    // Step 4: Sum up the jobs.
    for (int jobCount : jobs) {
      R += jobCount;
    }
    // Return the total number of jobs distributed.
    return R;
  }

  /**
   * Two-pass algorithm to distribute jobs based on ratings.
   * TC: O(N) SC: O(N)
   * Calculates the minimum number of Jobs/candies to give to stores based on
   * their ratings.
   *
   * @param A An ArrayList of integers representing the ratings of N stores.
   * @return An integer representing the minimum total number of Jobs/candies
   *         required.
   */
  public int candyDistributionBasedOnHeight(ArrayList<Integer> A) {
    // Handle edge cases: null or empty list.
    if (A == null || A.isEmpty()) {
      return 0;
    }

    int n = A.size();
    int[] candies = new int[n];

    // Step 1: Initialize each child with one candy.
    // This satisfies the "Each child must have at least one candy" rule.
    Arrays.fill(candies, 1);

    // Step 2: Left-to-right pass.
    // If a child has a higher rating than their left neighbor, they get one more
    // job
    // than their left neighbor.
    for (int i = 1; i < n; i++) {
      if (A.get(i) > A.get(i - 1)) {
        candies[i] = candies[i - 1] + 1;
      }
    }

    // Step 3: Right-to-left pass.
    // If a child has a higher rating than their right neighbor, their candy count
    // should be the maximum of its current value and one more than their right
    // neighbor's.
    // This ensures both left and right neighbor conditions are met with the minimum
    // candies.
    for (int i = n - 2; i >= 0; i--) {
      if (A.get(i) > A.get(i + 1)) {
        candies[i] = Math.max(candies[i], candies[i + 1] + 1);
      }
    }

    // Step 4: Sum up the candies.
    // Use a long for the sum to prevent potential integer overflow for large N,
    // although the problem asks for an int return type.
    int totalCandies = 0;
    for (int candyCount : candies) {
      totalCandies += candyCount;
    }

    return totalCandies;
  }
}
