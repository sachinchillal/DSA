package maths;

import helper.TestCaseArray;

public class FactorsCount {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(0, 0),
      new TestCaseArray(1, 1),
      new TestCaseArray(2, 2),
      new TestCaseArray(3, 2),
      new TestCaseArray(4, 3),

      new TestCaseArray(5, 2),
      new TestCaseArray(6, 4),
      new TestCaseArray(7, 2),
      new TestCaseArray(8, 4),
      new TestCaseArray(9, 3),

      new TestCaseArray(10, 4),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = factorsCountOf(testCase.N);
      if ((result == expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + (expected) + ", Result: " + (result) + "\n");
      }
      count++;
    }
  }

  /**
   * Count the Factors of N
   * T C O(N ^(1/2)) = O(Root N)
   * 
   * @param N
   * @return
   */
  public static int factorsCountOf(int N) {
    int c = 0;

    for (int i = 1; i * i <= N; i++) {

      if (N % i == 0) {
        if (i == N / i) {
          c += 1;
        } else {
          c += 2;
        }
      }
    }

    // System.out.println(c);

    return c;
  }

}
