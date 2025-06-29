package helper;

public class TestCaseArray {
  public int[] A;
  public String[] As;
  public int N;

  public int[] B;
  public int Bi;

  public int[] C;
  public int Ci;

  public String S;

  public int[] R_Array; // Result
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

  public TestCaseArray(int[] A, int[] B, int R) {
    this.A = A;
    this.B = B;
    this.R = R;
  }

  public TestCaseArray(int[] A, int[] B, int[] R) {
    this.A = A;
    this.B = B;
    this.R_Array = R;
  }

  public TestCaseArray(int[] A, int Bi, Boolean Rb) {
    this.A = A;
    this.Bi = Bi;
    this.Rb = Rb;
  }

  public TestCaseArray(int[] A, int Bi, int R) {
    this.A = A;
    this.Bi = Bi;
    this.R = R;
  }

  public TestCaseArray(int[] A, int Bi, int Ci, int R) {
    this.A = A;
    this.Bi = Bi;
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

  public Object[] params; // n no. of function params

  public TestCaseArray(int R, Object... p) {
    this.R = R;
    params = p;
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