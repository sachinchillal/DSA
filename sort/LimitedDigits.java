import java.util.Arrays;

public class LimitedDigits {

  public static void main(String[] args) {
    int[] A = { 1, 0, 2, 1, 0, 2, 0, 1, 1, 2 };
    int[] R = sort3DigitsArray(A);
    System.out.println(Arrays.toString(R));
  }

  static int[] sort3DigitsArray(int[] A) {
    int i = 0; // To point digit 0
    int j = 0; // To point digit current
    int k = A.length - 1; // To point digit 2

    while (j <= k) {
      if (A[j] == 0) {
        swap(A, i, j);
        i++;
        j++;
      } else if (A[j] == 2) {
        swap(A, j, k);
        k--;
      } else {
        j++;
      }
    }
    return A;
  }

  static void swap(int[] A, int i, int j) {
    int t = A[i];
    A[i] = A[j];
    A[j] = t;
  }

}
