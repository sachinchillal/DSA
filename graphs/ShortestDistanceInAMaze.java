package graphs;

import java.util.PriorityQueue;

public class ShortestDistanceInAMaze {

  class State implements Comparable<State> {
    int row;
    int col;
    int distance;

    State(int row, int col, int distance) {
      this.row = row;
      this.col = col;
      this.distance = distance;
    }

    @Override
    public int compareTo(State other) {
      return Integer.compare(this.distance, other.distance);
    }
  }

  public int shortestDistanceInMaze(int[][] M, int[] S, int[] D) {
    int n = M.length;
    int m = M[0].length;

    int[][] dist = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        dist[i][j] = Integer.MAX_VALUE;
      }
    }

    PriorityQueue<State> pq = new PriorityQueue<>();

    int startRow = S[0];
    int startCol = S[1];
    int destRow = D[0];
    int destCol = D[1];

    dist[startRow][startCol] = 0;
    pq.add(new State(startRow, startCol, 0));

    int[] dr = { -1, 1, 0, 0 }; // Directions: Up, Down, Left, Right
    int[] dc = { 0, 0, -1, 1 };

    while (!pq.isEmpty()) {
      State current = pq.poll();
      int r = current.row;
      int c = current.col;
      int d = current.distance;

      if (d > dist[r][c]) {
        continue;
      }

      if (r == destRow && c == destCol) {
        return d;
      }

      for (int i = 0; i < 4; i++) {
        int nextR = r;
        int nextC = c;
        int distanceTraveled = 0;

        while (nextR >= 0 && nextR < n && nextC >= 0 && nextC < m && M[nextR][nextC] == 0) {
          nextR += dr[i];
          nextC += dc[i];
          distanceTraveled++;
        }

        // Step back to the last valid position
        nextR -= dr[i];
        nextC -= dc[i];
        distanceTraveled--;

        if (dist[r][c] + distanceTraveled < dist[nextR][nextC]) {
          dist[nextR][nextC] = dist[r][c] + distanceTraveled;
          pq.add(new State(nextR, nextC, dist[nextR][nextC]));
        }
      }
    }

    return -1;
  }
}