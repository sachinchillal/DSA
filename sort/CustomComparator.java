import java.util.Arrays;
import java.util.Comparator;

public class CustomComparator {
  public static void main(String[] args) {
    // int[] A = { 1, 2, 3, 4, 5, 6 };
    int[] A = { 6, 5, 4, 3, 2, 1, 0 };

    Integer[] R = sortBasedOnFactorsCountOfElement(A);
    System.out.println(Arrays.toString(R));

    // Integer[] R = sortBasedOnFibonacciOfElement(A);
    // System.out.println(Arrays.toString(R));

  }

  public static Integer[] sortBasedOnFibonacciOfElement(int[] A) {
    Integer[] R = new Integer[A.length];
    for (int i = 0; i < R.length; i++) {
      R[i] = A[i];
    }
    Arrays.sort(R, new Comparator<Integer>() {
      @Override
      public int compare(Integer a, Integer b) {
        int x = fibonacciOf(a);
        int y = fibonacciOf(b);
        return x - y;
      }
    });
    return R;
  }

  public static Integer[] sortBasedOnFactorsCountOfElement(int[] A) {
    Integer[] R = new Integer[A.length];
    for (int i = 0; i < A.length; i++) {
      R[i] = A[i];
    }
    Arrays.sort(R, new Comparator<Integer>() {
      @Override
      public int compare(Integer a, Integer b) {
        int x = factorsCountOfNumber(a);
        int y = factorsCountOfNumber(b);
        // System.out.println(x + " " + y + "=" + a + " " + b);
        // System.out.println(Arrays.toString(R));
        return x - y;
      }
    });
    return R;
  }

  public static int factorsCountOfNumber(int n) {
    int c = 0;
    for (int i = 1; i <= n; i++) {
      if (n % i == 0) {
        c++;
      }
    }
    return c;
  }

  public static int fibonacciOf(int n) {
    if (n < 2) {
      return n;
    }
    return n + (n - 1);
  }

}