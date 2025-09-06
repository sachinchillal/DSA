package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

  /**
   * Solves the Rotten Oranges problem using Breadth-First Search (BFS).
   *
   * @param A The N x M matrix representing the grid of oranges.
   * @return The minimum number of minutes for all fresh oranges to rot.
   *         Returns -1 if some fresh oranges can never rot.
   */
  public int getMinimumNumberOfMinutesForExpireFruits(int[][] A) {
    if (A == null || A.length == 0) {
      return 0;
    }

    int rows = A.length;
    int cols = A[0].length;
    Queue<int[]> queue = new LinkedList<>();
    int freshOranges = 0;

    // Step 1: Initialize the queue with all initially rotten oranges
    // and count the total number of fresh oranges.
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (A[i][j] == 2) {
          queue.add(new int[] { i, j });
        } else if (A[i][j] == 1) {
          freshOranges++;
        }
      }
    }

    // Edge case: If there are no fresh oranges, the time taken is 0.
    if (freshOranges == 0) {
      return 0;
    }

    int minutes = 0;
    // Directions for moving to adjacent cells (up, down, left, right).
    int[] dr = { -1, 1, 0, 0 };
    int[] dc = { 0, 0, -1, 1 };

    // Step 2: Start the BFS simulation.
    while (!queue.isEmpty() && freshOranges > 0) {
      // Get the number of rotten oranges at the current minute.
      int size = queue.size();
      minutes++;

      // Process all oranges that rotted in the previous minute.
      for (int i = 0; i < size; i++) {
        int[] current = queue.poll();
        int r = current[0];
        int c = current[1];

        // Check all four adjacent cells.
        for (int j = 0; j < 4; j++) {
          int newR = r + dr[j];
          int newC = c + dc[j];

          // Check if the new position is within the grid bounds.
          if (newR >= 0 && newR < rows && newC >= 0 && newC < cols) {
            // Check if the adjacent cell contains a fresh orange.
            if (A[newR][newC] == 1) {
              // The fresh orange becomes rotten.
              A[newR][newC] = 2;
              // Decrement the count of fresh oranges.
              freshOranges--;
              // Add the newly rotten orange to the queue for the next minute's simulation.
              queue.add(new int[] { newR, newC });
            }
          }
        }
      }
    }

    // Step 3: Check if all fresh oranges have rotted.
    // If freshOranges is 0, all oranges have rotted, so return the total minutes.
    // Otherwise, some fresh oranges were unreachable, so return -1.
    return freshOranges == 0 ? minutes : -1;
  }

  // Check if i, j is within the array
  // limits of row and column
  static boolean isSafe(int i, int j, int n, int m) {
    return (i >= 0 && i < n && j >= 0 && j < m);
  }

  static int orangesRotting(int[][] mat) {
    int n = mat.length;
    int m = mat[0].length;

    // all four directions
    int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    // queue to store cell position
    Queue<int[]> q = new LinkedList<>();

    // find all rotten oranges
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (mat[i][j] == 2) {
          q.add(new int[] { i, j });
        }
      }
    }

    // counter of elapsed time
    int elapsedTime = 0;

    while (!q.isEmpty()) {

      // increase time by 1
      elapsedTime++;

      int len = q.size();
      while (len-- > 0) {
        int[] cur = q.poll();
        int i = cur[0];
        int j = cur[1];

        // change 4-directionally connected cells
        for (int[] dir : directions) {
          int x = i + dir[0];
          int y = j + dir[1];

          // if cell is in the matrix and
          // the orange is fresh
          if (isSafe(x, y, n, m)
              && mat[x][y] == 1) {
            mat[x][y] = 2;
            q.add(new int[] { x, y });
          }
        }
      }
    }

    // check if any fresh orange is remaining
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (mat[i][j] == 1) {
          return -1;
        }
      }
    }

    return Math.max(0, elapsedTime - 1);
  }

}
