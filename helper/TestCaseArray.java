package helper;

public class TestCaseArray {
  public int[] A; // Array A
  public int[] A2; // Array 2

  public int[][] A_2Array; // 2D array
  public int[][] Matrix; // 2D array

  public String[] As;
  public int N;
  public int M;

  public int[] B;

  public int[] C;
  public int Ci;

  public String S;

  public String[] Rs_Array;
  public int[] R_Array; // Result
  public int[][] R_2Array; // Result 2 D array
  public int R; // Result
  public String Rs; // String Result
  public Boolean Rb; // Boolean Result

  public TestCaseArray(int[] A, int R) {
    this.A = A;
    this.R = R;
  }

  public TestCaseArray(int N, int R) {
    this.N = N;
    this.R = R;
  }

  public TestCaseArray(String[] As, int R) {
    this.As = As;
    this.R = R;
  }

  public TestCaseArray(String[] As, String[] Rs_Array) {
    this.As = As;
    this.Rs_Array = Rs_Array;
  }

  public TestCaseArray(int N, String[] Rs_Array) {
    this.N = N;
    this.Rs_Array = Rs_Array;
  }

  public TestCaseArray(int N, int M, String[] Rs_Array) {
    this.N = N;
    this.M = M;
    this.Rs_Array = Rs_Array;
  }

  public TestCaseArray(int[] A, int[] B, int R) {
    this.A = A;
    this.B = B;
    this.R = R;
  }

  public TestCaseArray(int[] A, int[] B, int[] C, int R) {
    this.A = A;
    this.B = B;
    this.C = C;
    this.R = R;
  }

  public TestCaseArray(int[] A, int N, int[] R_Array) {
    this.A = A;
    this.N = N;
    this.R_Array = R_Array;
  }

  public TestCaseArray(int[] A, int[] B, int[] R_Array) {
    this.A = A;
    this.B = B;
    this.R_Array = R_Array;
  }

  public TestCaseArray(int N, int[] R) {
    this.N = N;
    this.R_Array = R;
  }

  public TestCaseArray(int N, int[] B, int[] R) {
    this.N = N;
    this.B = B;
    this.R_Array = R;
  }

  public TestCaseArray(int[] A, int N, Boolean Rb) {
    this.A = A;
    this.N = N;
    this.Rb = Rb;
  }

  public TestCaseArray(int[] A, int N, int R) {
    this.A = A;
    this.N = N;
    this.R = R;
  }

  public TestCaseArray(int[] A, int N, int Ci, int R) {
    this.A = A;
    this.N = N;
    this.Ci = Ci;
    this.R = R;
  }

  public TestCaseArray(int[] A, Boolean Rb) {
    this.A = A;
    this.Rb = Rb;
  }

  public TestCaseArray(int[] A, int[] R_Array) {
    this.A = A;
    this.R_Array = R_Array;
  }

  public TestCaseArray(int N, int[][] R_2Array) {
    this.N = N;
    this.R_2Array = R_2Array;
  }

  public TestCaseArray(int[] A, int[][] R_2Array) {
    this.A = A;
    this.R_2Array = R_2Array;
  }

  public TestCaseArray(int[] A, int[][] A_2Array, int[] R_Array) {
    this.A = A;
    this.A_2Array = A_2Array;
    this.R_Array = R_Array;
  }

  public TestCaseArray(int[][] A_2Array, int[][] R_2Array) {
    this.A_2Array = A_2Array;
    this.R_2Array = R_2Array;
  }

  public TestCaseArray(int[][] A_2Array, int R) {
    this.A_2Array = A_2Array;
    this.R = R;
  }

  public TestCaseArray(int[][] Matrix, int[] A, int[] A2, int R) {
    this.Matrix = Matrix;
    this.A = A;
    this.A2 = A2;
    this.R = R;
  }

  public TestCaseArray(int[][] A_2Array, int N, boolean Rb) {
    this.A_2Array = A_2Array;
    this.N = N;
    this.Rb = Rb;
  }

  public Object[] params; // n no. of function params

  public TestCaseArray(int R, Object... params) {
    this.R = R;
    this.params = params;
  }

  // String
  public TestCaseArray(String S, int R) {
    this.S = S;
    this.R = R;
  }

  public TestCaseArray(int N, String Rs) {
    this.N = N;
    this.Rs = Rs;
  }

  public TestCaseArray(String s, Object... p) {
    this.Rs = s;
    params = p;
  }

  public TestCaseArray(String s, Boolean R) {
    Rs = s;
    Rb = R;
  }

  public TestCaseArray(String s, String R) {
    S = s;
    Rs = R;
  }
}