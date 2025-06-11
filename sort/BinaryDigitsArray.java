import java.util.Arrays;

public class BinaryDigitsArray {
  public static void main(String[] args) {
    int[] A = { 1, 0, 1, 0, 0, 1, 1 };
    int[] R = sortBinaryDigitsArray(A);
    System.out.println(Arrays.toString(R));
  }

  static int[] sortBinaryDigitsArray(int[] A) {
    int i = 0; // To point digit 1
    int j = 0; // To point digit 0
    while (j < A.length) {
      System.out.println(Arrays.toString(A));
      // if (A[j] == 0) { // to sort reverse
      if (A[j] == 1) {
        j++;
      } else {
        swap(A, i, j);
        i++;
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
