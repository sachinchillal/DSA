package graphs;

class NumberOfIslands {
  // [Approach 2] Using Space Optimized DFS - O(n*m) Time and O(1) Space

  // A utility function to do DFS for a
  // 2D matrix. It only considers
  // the 8 neighbors as adjacent vertices
  static void dfs(char[][] grid, int r, int c) {

    // These arrays are used to get
    // r and c numbers of 8
    // neighbours of a given cell
    int row = grid.length;
    int col = grid[0].length;

    if (r < 0 || c < 0 || r >= row || c >= col
        || grid[r][c] != 'L') {
      return;
    }
    // row and col numbers of 8 neighbours
    int[] rNbr = { -1, -1, -1, 0, 0, 1, 1, 1 };
    int[] cNbr = { -1, 0, 1, -1, 1, -1, 0, 1 };

    // Mark this cell as visited by setting it to 'W'
    grid[r][c] = 'W';

    // Recur for all connected neighbours
    for (int k = 0; k < 8; ++k) {
      int newR = r + rNbr[k];
      int newC = c + cNbr[k];

      dfs(grid, newR, newC);
    }
  }

  // The main function that returns
  // count of islands in a given matrix
  static int countNumberOfIslands(char[][] grid) {
    int row = grid.length;
    int col = grid[0].length;

    // Initialize count as 0 and traverse through
    // all cells of the given matrix
    int count = 0;
    for (int r = 0; r < row; ++r) {
      for (int c = 0; c < col; ++c) {

        // If a cell with value 'L' (land) is found,
        // then a new island is found
        if (grid[r][c] == 'L') {

          // Visit all cells in this island.
          dfs(grid, r, c);

          // Increment the island count
          ++count;
        }
      }
    }
    return count;
  }

  // [Approach 2] Using DFS and Additional Matrix - O(n*m) Time and O(n*m) Space

  // A function to check if a given
  // cell (r, c) can be included in DFS
  static boolean isSafe(char[][] grid, int r, int c, boolean[][] visited) {
    int row = grid.length;
    int col = grid[0].length;

    // r is in range, c is in range, value
    // is 'L' (land) and not yet visited
    return (r >= 0) && (r < row) && (c >= 0) &&
        (c < col) && (grid[r][c] == 'L' && !visited[r][c]);
  }

  // A utility function to do DFS for a
  // 2D boolean matrix. It only considers
  // the 8 neighbours as adjacent vertices
  static void dfs(char[][] grid, int r, int c, boolean[][] visited) {
    // These arrays are used to get
    // r and c numbers of 8
    // neighbours of a given cell
    int[] rNbr = { -1, -1, -1, 0, 0, 1, 1, 1 };
    int[] cNbr = { -1, 0, 1, -1, 1, -1, 0, 1 };

    // Mark this cell as visited
    visited[r][c] = true;

    // Recur for all connected neighbours
    for (int k = 0; k < 8; ++k) {
      int newR = r + rNbr[k];
      int newC = c + cNbr[k];
      if (isSafe(grid, newR, newC, visited)) {
        dfs(grid, newR, newC, visited);
      }
    }
  }

  // The main function that returns
  // count of islands in a given boolean
  // 2D matrix
  static int countIslands(char[][] grid) {
    int row = grid.length;
    int col = grid[0].length;

    // Make a bool array to mark visited cells.
    // Initially all cells are unvisited
    boolean[][] visited = new boolean[row][col];

    // Initialize count as 0 and traverse through
    // all cells of the given matrix
    int count = 0;
    for (int r = 0; r < row; ++r) {
      for (int c = 0; c < col; ++c) {
        // If a cell with value 'L' (land) is not visited yet,
        // then a new island is found
        if (grid[r][c] == 'L' && !visited[r][c]) {
          // Visit all cells in this island.
          dfs(grid, r, c, visited);

          // Increment the island count
          ++count;
        }
      }
    }
    return count;
  }

}