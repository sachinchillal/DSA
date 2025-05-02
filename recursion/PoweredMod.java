package recursion;

public class PoweredMod {
  public static void main(String[] args) {
    System.out.println(pow(37, 103, 12));
    System.out.println(pow(7, 2, 3));
    System.out.println(pow(3, 2, 2));
    System.out.println(pow(2, 3, 3));
    System.out.println(pow(3, 3, 1));
    System.out.println(pow(0, 0, 1));
    System.out.println(pow(-1, 1, 33));

    int a = 95;
    int n = 31;
    int c = 82;
    int R = pow(a, n, c);
    System.out.println(R);
  }

  public static int pow(int A, int N, int C) {
    int R = (int) pow2(A, N, C);
    if (R < 0) {
      // C - R
      return C + R;
    }
    return R;
  }

  public static long pow2(int A, int N, int C) {
    if (A == 0) {
      return 0;
    }
    if (N == 0) {
      return 1;
    }
    long half = pow2(A, N / 2, C) % C;
    long v = (half * half) % C;
    if (N % 2 == 0) {
      return v;
    } else {
      return ((v * A) % C);
    }
  }
}
