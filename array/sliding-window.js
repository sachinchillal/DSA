function SlidingWindow(A, W) {
  const N = A.length;
  const pSum = [];
  pSum[0] = A[0];
  for (let i = 1; i < N; i++) {
    pSum[i] = A[i] + pSum[i - 1];
  }
  // console.log(pSum);
  const R = [];
  for (let i = 0; i < N - W + 1; i++) {
    let s = pSum[W - 1 + i] - (pSum[i - 1] || 0);
    R.push(s);
  }
  return R;
}
function main() {
  const DATA = [
    {
      A: [1, 2, 1],
      W: 1,
      R: [1, 2, 1],
    },
    {
      A: [2, 1, 6, 4],
      W: 2,
      R: [3, 7, 10],
    },
    {
      A: [1, 2, 1, 1],
      W: 3,
      R: [4, 4],
    },
    {
      A: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
      W: 5,
      R: [10, 15, 20, 25, 30, 35],
    }
  ];
  DATA.forEach(({ A, W, R }, index) => {
    const start = new Date();
    const Result = SlidingWindow(A, W);
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