package helper;

public class TestCaseArray {
  public int[] A;
  public String[] As;
  public int[] B;
  public String S;

  public int[] R_Array; // Result
  public int R; // Result
  public String Rs; // String Result
  public Boolean Rb; // Boolean Result

  public TestCaseArray(int[] A, int R) {
    this.A = A;
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

  public TestCaseArray(int[] A, int[] R) {
    this.A = A;
    this.R_Array = R;
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