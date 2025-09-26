package helper;

import java.util.Arrays;

public class Logger {
  public static void log(int[][] grid) {
    for (int[] row : grid) {
      System.out.println(Arrays.toString(row));
    }
    System.out.println();
  }
}
