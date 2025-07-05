package bitwise;

import helper.TestCaseArray;

public class CountBits {
  static TestCaseArray[] TestCases = {
      new TestCaseArray(0, 0),
      new TestCaseArray(1, 1),
      new TestCaseArray(2, 1),
      new TestCaseArray(3, 2),
      new TestCaseArray(4, 1),

      new TestCaseArray(5, 2),
      new TestCaseArray(6, 2),
      new TestCaseArray(7, 3),
      new TestCaseArray(8, 1),
      new TestCaseArray(9, 2),

      new TestCaseArray(10, 2),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = countSetBits(testCase.N);
      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  public static int countSetBits(int n) {
    int count = 0;
    while (n > 0) {
      count += (n & 1);
      n = (n >> 1);
    }
    return count;
  }

}
