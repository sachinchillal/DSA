package two_pointers;

import helper.TestCaseArray;

public class SubarrayWithSumExists {

  static TestCaseArray[] TestCases = {
      new TestCaseArray(new int[] {}, 2, false),
      new TestCaseArray(new int[] { 1, 2, 3 }, 1, true),
      new TestCaseArray(new int[] { 1, 2, 3 }, 2, true),
      new TestCaseArray(new int[] { 1, 2, 3 }, 3, true),
      new TestCaseArray(new int[] { 1, 2, 3 }, 4, false),

      new TestCaseArray(new int[] { 1, 2, 3 }, 5, true),
      new TestCaseArray(new int[] { 1, 2, 3 }, 6, true),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 6, true),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 7, true),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 8, false),

      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 9, true),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 10, true),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 11, true),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 12, true),
      new TestCaseArray(new int[] { 1, 2, 3, 4, 5, 6 }, 15, true)
  };

  public static void main(String[] args) {
    System.out.println();
    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      boolean expected = testCase.Rb;
      boolean result = isSubarrayExistWithSumK(testCase.A, testCase.N);
      if (result == expected) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + expected + ", Result: " + result + "\n");
      }
      count++;
    }
  }

  static boolean isSubarrayExistWithSumK(int[] A, int K) {
    int n = A.length;
    if (n == 0) {
      return false;
    }
    int i = 0;
    int j = 0;
    int sum = A[0];

    while (j < n) {
      // System.out.println(Arrays.toString(new int[] { i, j, sum, A[j] }));
      if (sum == K) {
        return true;
      } else if (sum < K) {
        j++; // add some more elements
        if (j == n) {
          break;
        }
        sum += A[j];
      } else {
        sum = sum - A[i]; // reduce first element
        i++; // move pointer to next
        if (sum == K) {
          return true;
        }
        if (i > j) {
          j++;
          sum += A[j];
        }
      }
    }
    return false;
  }

}
