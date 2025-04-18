// Note: Algorithm should run in O(n) time and use constant space.

class TestCase {
  int[] A;
  int R;

  TestCase(int[] A, int R) {
    this.A = A;
    this.R = R;
  }
}

class CustomUtil {
  protected static void printArray(int[] A) {
    System.out.print("A: ");
    for (int i = 0; i < A.length; i++) {
      if (A[i] == 1)
        System.out.print(A[i] + " " + i + " ");
    }
    System.out.println();
  }
}

public class FirstMissingNaturalNumber {
  public static void main(String[] args) {
    System.err.println();
    TestCase[] TestCases = {
        new TestCase(new int[] { 1 }, 2),
        new TestCase(new int[] { 2 }, 1),
        new TestCase(new int[] { 3 }, 1),
        new TestCase(new int[] { -5 }, 1),
        new TestCase(new int[] { 1, 2 }, 3),
        new TestCase(new int[] { 2, 3 }, 1),
        new TestCase(new int[] { 1, 3 }, 2),
        new TestCase(new int[] { 2, 3, 1, 2 }, 4),
        new TestCase(new int[] { 2, 3, 1, 5, 6 }, 4),
        new TestCase(new int[] { 1, 5, 6, 7, 3, 2 }, 4),
        new TestCase(new int[] { 1, 5, 6, 7, 3, 8, 9, 10, 2 }, 4),
    };
    int count = 1;
    for (TestCase testCase : TestCases) {
      int[] A = testCase.A;
      int expected = testCase.R;
      int result = firstMissingNaturalNumber(A);
      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  // Using Swapping Method
  private static int firstMissingNaturalNumber(int[] A) {
    // swapping elements to their correct positions
    int n = A.length;
    for (int i = 0; i < n; i++) {
      // A[i] is in the range [1, n] and A[i] is not in its correct position
      while (A[i] > 0 && A[i] <= n && A[A[i] - 1] != A[i]) {
        int newIndex = A[i] - 1;
        // swap A[i] and A[newIndex]
        int temp = A[i];
        A[i] = A[newIndex];
        A[newIndex] = temp;
      }
    }
    // CustomUtil.printArray(A);
    for (int i = 0; i < n; i++) {
      if (A[i] != i + 1) {
        return i + 1;
      }
    }
    return n + 1;
  }

  static int firstMissingNaturalNumber2(int[] A) {
    int n = A.length;
    for (int i = 0; i < n; i++) {
      if (A[i] <= 0) {
        A[i] = n + 2;
      }
    }
    for (int i = 0; i < n; i++) {
      int e = Math.abs(A[i]);
      int index = e - 1;
      if (e > 0 && e <= n) {
        A[index] = -Math.abs(A[index]);
      }
    }
    for (int i = 0; i < n; i++) {
      if (A[i] > 0) {
        return i + 1;
      }
    }
    return n + 1;
  }
}
