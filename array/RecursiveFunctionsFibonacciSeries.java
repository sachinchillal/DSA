import java.util.HashMap;
import java.util.Map;

public class RecursiveFunctionsFibonacciSeries {
  static int functionRunCount = 0;

  public static void main(String[] args) {
    int N = 6;
    Map<String, Integer> R = fibWithLevelAndCount(N, 0, 0);
    System.out.println();
    System.out.println("Fib(" + N + ") => " + R);
  }

  static int fib(int N) {
    if (N < 2) {
      return N;
    }
    return fib(N - 1) + fib(N - 2);
  }

  static Map<String, Integer> fibWithLevelAndCount(int N, int level, int count) {
    Map<String, Integer> R = new HashMap<>(Map.of("N", N, "level", level, "count", count, "NthFibonacci", 0));
    level++;
    count++;
    functionRunCount++;
    System.out.println(functionRunCount);
    if (N < 2) {
      // return N;
      R.put("NthFibonacci", N);
      System.out.println(R);
      return R;
    }
    // return fib(N - 1) + fib(N - 2);
    Map<String, Integer> F1 = fibWithLevelAndCount(N - 1, level, count);
    Map<String, Integer> F2 = fibWithLevelAndCount(N - 2, level, count);
    int NthFibonacci = F1.get("NthFibonacci") + F2.get("NthFibonacci");
    R.put("NthFibonacci", NthFibonacci);

    System.out.println(R);
    return R;
  }

}

/*
Fibonacci(6) = Fib(6) = 0,1,1,2,3,5,8 => 8

Number of function calls = 25

**Using Pen Paper:**

| Column 1                 | Column 2          | Column 3    | Column 4   | Comment                                     |
|--------------------------|-------------------|-------------|------------|----------------------------------------------|
| Fib(6) = Fib(5) + Fib(4) | => 5 + 3 = 8     | => 0 + 5 = 5 | 1 call     |                                              |
| Fib(5) = Fib(4) + Fib(3) | => 3 + 2 = 5     | => 5 + 3 = 8  | 1 call     |                                              |
| Fib(4) = Fib(3) + Fib(2) | => 2 + 1 = 3     | => 3 + 2 = 5  | 2 calls    | from Fib(6) and Fib(5)                     |
| Fib(3) = Fib(2) + Fib(1) | => 1 + 1 = 2     | => 2 + 1 = 3  | 3 calls    | from Fib(5), Fib(4) (twice)                |
| Fib(2) = Fib(1) + Fib(0) | => 1 + 0 = 1     | => 1 + 1 = 2  | 5 calls    | from Fib(4) (twice), Fib(3) (thrice)       |
| Fib(1) = 1               | => 1              | => 1        | 8 calls    | from Fib(3) (thrice), Fib(2) (five times) |
| Fib(0) = 0               | => 0              | => 1        | 5 calls    | from Fib(2) (five times)                   |
| | |Total: 25 | Total: 25 | |

- Column 1: Go from Top to Bottom
- Column 2: Go from Bottom to Top
- Column 3: Go from Bottom to Top
  - Why 0 in the first row? Because no. of calls for Fib(5) already counted in next row
- Column 4: Is number of time the function running


**Algorithm:**
```py
int Fib(N):
	if (N < 2):
		return N
	return Fib(N - 1) + Fib(N - 2)
```

**By drawing Tree:**

```md
                                          Fib(6)
                                    /                  \
                              Fib(5)                          Fib(4)
                        /             \                     /         \
                  Fib(4)                Fib(3)              Fib(3)        Fib(2)
                /       \               /       \          /      \          /    \
          Fib(3)        Fib(2)          Fib(2)   Fib(1)  Fib(2)   Fib(1)   Fib(1) Fib(0)
          /    \       /     \        /       \          /    \
      Fib(2)  Fib(1)  Fib(1)  Fib(0)  Fib(1)  Fib(0)  Fib(1)  Fib(0)
    /   \
Fib(1) Fib(0)
```

*/