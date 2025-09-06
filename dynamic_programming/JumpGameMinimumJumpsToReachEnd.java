package dynamic_programming;

import java.util.Arrays;

public class JumpGameMinimumJumpsToReachEnd {
  // Jump Game - Minimum Jumps to Reach End
  // https://www.geeksforgeeks.org/dsa/minimum-number-of-jumps-to-reach-end-of-a-given-array/
  // Java program to find the minimum number of jumps to reach the end of the
  // array

  // Function to return the minimum number
  // of jumps to reach arr end.

  // Using Bottom-Up DP (Tabulation) - O(n^2) Time and O(n) Space
  static int jumpGameMinimumJumpsToReachEnd(int[] A) {
    int n = A.length;

    // array to memoize values
    int[] dp = new int[n];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[n - 1] = 0;

    for (int i = n - 2; i >= 0; i--) {
      for (int j = i + 1; j <= i + A[i] && j < n; j++) {
        if (dp[j] != Integer.MAX_VALUE) {
          dp[i] = Math.min(dp[i], 1 + dp[j]);
        }
      }
    }

    // If end cannot be reached.
    if (dp[0] == Integer.MAX_VALUE)
      return -1;

    return dp[0];
  }
  /*
   * 1 3 5 8 9
   * 0 1 2 3 4
   * Fill dp from right to left
   * Last index is 0 jumps away from itself
   * 1 3 2 1 0 <= dp
   */

  static int minJumpsRecur(int i, int[] arr, int[] memo) {

    // Return 0 when last element is reached.
    if (i == arr.length - 1)
      return 0;

    // If value for current index is memoized,
    // then return it.
    if (memo[i] != -1)
      return memo[i];

    // Traverse through all the points
    // reachable from arr[i].
    // Recursively, get the minimum number
    // of jumps needed to reach array end from
    // these points.
    int ans = Integer.MAX_VALUE;
    for (int j = i + 1; j <= i + arr[i] && j < arr.length; j++) {
      int val = minJumpsRecur(j, arr, memo);
      if (val != Integer.MAX_VALUE)
        ans = Math.min(ans, 1 + val);
    }

    // Memoize the value and
    // return it.
    return memo[i] = ans;
  }

  // Function to return the minimum number
  // of jumps to reach arr[h] from arr[l]
  static int minJumps(int[] arr) {

    // array to memoize values
    int[] memo = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      memo[i] = -1;
    }

    int ans = minJumpsRecur(0, arr, memo);

    // If end cannot be reached.
    if (ans == Integer.MAX_VALUE)
      return -1;

    return ans;
  }
}
