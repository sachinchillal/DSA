function SumOfAllThePossibleSubArrays(A) {
  const N = A.length;
  let sum = 0;
  for (let i = 0; i < N; i++) {
    const contribution = A[i] * (i + 1) * (N - i);
    sum = sum + contribution;
  }
  return sum;
}
function main() {
  const DATA = [
    {
      A: [1],
      R: 1,
    },
    {
      A: [1, 2],
      R: 6,
    },
    {
      A: [1, 2, 3],
      R: 20,
    },
    {
      A: [1, 2, 3, 4],
      R: 50,
    },
    {
      A: [2, 3, 2, 1],
      R: 42
    }
  ];
  DATA.forEach(({ A, R }, index) => {
    const start = new Date();
    const Result = SumOfAllThePossibleSubArrays(A);
    const end = new Date();
    const ms = (end - start);
    if (R.toString() == Result.toString()) {
      console.log("Passed", index + 1, `in [${ms} ms]`);
    } else {
      console.log("Wrong Answer..!", index + 1, `in [${ms} ms]`);
      console.log("Expected", R);
      console.log("Result", Result);
    }
  });
}
main();