package bitwise;

import helper.TestCaseArray;

public class UniqueElement {

  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, -1),
      new TestCaseArray(new int[] { 3 }, 3),
      new TestCaseArray(new int[] { 1, 3, 1 }, 3),
      new TestCaseArray(new int[] { 1, 2, 2 }, 1),
      new TestCaseArray(new int[] { 2, 2, 3 }, 3),

      new TestCaseArray(new int[] { 5, 5, 6, 7, 7 }, 6),
      new TestCaseArray(new int[] { 5, 5, 7, 7, 6, 8, 8 }, 6),
      new TestCaseArray(new int[] { 5, 5, 6, 7, 7, 8, 8 }, 6),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      int expected = testCase.R;
      int result = uniqueElementEveryOtherElementOccursTwice(testCase.A);
      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  /**
   * Find unique element in A where every element repeats twice except one.
   * Use XOR Operation
   * a XOR a = a ^ a = 0
   * use brackets to give them priority
   */
  public static int uniqueElementEveryOtherElementOccursTwice(int[] A) {
    int R = -1;
    int n = A.length;
    if (n == 0) {
      return R;
    }
    R = 0;
    for (int a : A) {
      R = R ^ a;
    }
    return R;
  }

}
