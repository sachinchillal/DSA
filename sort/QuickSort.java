import java.util.Arrays;

public class QuickSort {
  public static void main(String[] args) {
    int[] A = { 1, 3, 2, 7, 6, 9, 5 };
    // int[] A = { 7, 6, 9, 5, 1, 3, 2, 4 };
    // int[] A = { 5, 11, 10, 20, 9, 16, 23 };
    System.out.println(Arrays.toString(A));
    quickSort(A, 0, A.length - 1);
    System.out.println(Arrays.toString(A));
  }

  static void quickSort(int[] A, int start, int end) {
    if (start < end) {
      int pivot = partition(A, start, end);
      quickSort(A, start, pivot - 1);
      quickSort(A, pivot + 1, end);
    }
  }

  static int partition(int[] A, int start, int end) {
    int i = start, pivot = A[end];
    for (int j = start; j < end; j++) {
      if (A[j] < pivot) {
        swap(A, i, j);
        i++;
      }
    }
    swap(A, i, end);
    return i;
  }

  static void swap(int[] A, int i, int j) {
    int t = A[i];
    A[i] = A[j];
    A[j] = t;
  }

  static int partitionArray(int[] A) {
    int n = A.length;
    int i = 0, j = 0, pivot = A[A.length - 1];

    while (j < n) {
      if (A[j] >= pivot) {
        j++;
      } else {
        swap(A, i, j);
        i++;
        j++;
      }
    }
    swap(A, i, n - 1);

    return pivot;
  }
}