import java.util.ArrayList;
import java.util.Arrays;

public class TowerOfHanoi {
  public static void main(String[] args) {
    // moverString(2, "A", "B", "C");
    // moverString(3, "A", "B", "C");

    // moverInteger(2, 1, 2, 3);
    // moverInteger(2, 10, 20, 30);
    // moverInteger(3, 10, 20, 30);

    int[][] RA = new int[1][3];
    int[][] R = moverIntegerArray(3, 10, 20, 30, RA);
    System.out.println(Arrays.deepToString(R));
    // int[] a = { 3, 2, 4 };
    // System.out.println(Arrays.toString(a));

    // ArrayList<ArrayList<String>> R = new ArrayList<>();
    // moverStringList(3, "A", "B", "C", R);
    // System.out.println(R.toString());
  }

  private static void moverStringList(int n, String A, String B, String C, ArrayList<ArrayList<String>> R) {
    if (n > 0) {
      moverStringList(n - 1, A, C, B, R);

      ArrayList<String> b = new ArrayList<>();
      b.add(Integer.toString(n));
      b.add(A);
      b.add(C);
      R.add(b);

      moverStringList(n - 1, B, A, C, R);
    }
  }

  private static void moverString(int n, String A, String B, String C) {
    if (n > 0) {
      moverString(n - 1, A, C, B);
      System.out.println(n + ", " + A + " to " + C);
      moverString(n - 1, B, A, C);
    }
  }

  private static void moverInteger(int n, int A, int B, int C) {
    if (n > 0) {
      moverInteger(n - 1, A, C, B);
      System.out.println(n + ", " + A + " to " + C);
      moverInteger(n - 1, B, A, C);
    }
  }

  private static int[][] moverIntegerArray(int n, int A, int B, int C, int[][] R) {
    if (n > 0) {
      R = moverIntegerArray(n - 1, A, C, B, R);
      int[] r = { n, A, C };
      int[][] newR = new int[R.length + 1][];
      System.arraycopy(R, 0, newR, 0, R.length);
      newR[R.length] = r;
      R = newR;
      R = moverIntegerArray(n - 1, B, A, C, R);
    }
    return R;
  }

}
