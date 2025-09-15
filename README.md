# DSA
A collection of solutions to common Data Structures and Algorithms problems

# Java Note:
- To run few of the Java programs, run the Test Case classes first(only once). And then the actual programs.
- TestCaseArray.java is a test case for all the array problems.
- TestCaseMatrix.java is a test case for all the matrix problems.

- Clear the global variables in the functions before running the function again.
- If there is loss of precision in floating point operations, multiply the number by 1000.0 before division and then divide the final result by 10.0 and cast it to int.
```java
  return (int) ((profit * 1000.0) / 10.0);
```
- Best way to apply modulo operation is to apply it at every step of addition or multiplication.
```java
int mod = (int) Math.pow(10, 6) + 15;
result = (result + (someValue % mod)) % mod;
```