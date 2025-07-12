package maths;

import helper.TestCaseArray;

public class ExcelColumnName {

  static TestCaseArray[] TestCases = {
      new TestCaseArray(1, "A"),
      new TestCaseArray(2, "B"),
      new TestCaseArray(3, "C"),
      new TestCaseArray(5, "E"),
      new TestCaseArray(10, "J"),

      new TestCaseArray(11, "K"),
      new TestCaseArray(20, "T"),
      new TestCaseArray(25, "Y"),
      new TestCaseArray(26, "Z"),
      new TestCaseArray(27, "AA"),

      new TestCaseArray(28, "AB"),
      new TestCaseArray(29, "AC"),
      new TestCaseArray(30, "AD"),
      new TestCaseArray(31, "AE"),
      new TestCaseArray(51, "AY"),

      new TestCaseArray(52, "AZ"),
      new TestCaseArray(53, "BA"),
      new TestCaseArray(54, "BB"),
      new TestCaseArray(60, "BH"),

      new TestCaseArray(78, "BZ"),
      new TestCaseArray(79, "CA"),
      new TestCaseArray(104, "CZ"),
      new TestCaseArray(105, "DA"),
  };

  public static void main(String[] args) {
    System.out.println();

    int count = 1;
    for (TestCaseArray testCase : TestCases) {
      String expected = testCase.Rs;
      String result = findExcelColumnTitleFor(testCase.N);
      if (result.equals(expected)) {
        System.out.println(count + " Test case Passed!");
      } else {
        System.out.println(count + " Test case failed!");
        System.out.println("Expected: " + (expected) + ", Result: " + (result) + "\n");
      }
      count++;
    }
  }

  static String findExcelColumnTitleFor(int n) {
    if (n <= 0) {
      return "";
    }
    StringBuilder S = new StringBuilder();
    while (n > 0) {
      int r = (n - 1) % 26;
      S.insert(0, (char) ('A' + r));
      n = (n - 1) / 26;
    }
    return S.toString();
  }

}
