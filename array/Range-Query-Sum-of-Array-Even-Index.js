

function RangeQuerySumEvenIndex(A, Q) {
  // Prefix sum
  const pSum = [];
  pSum[0] = A[0];
  for (let index = 1; index < A.length; index++) {
    // Changed Here
    if (index % 2 == 0) {
      pSum[index] = A[index] + pSum[index - 1];
    } else {
      pSum[index] = pSum[index - 1];
    }
  }

  const R = [];
  for (let index = 0; index < Q.length; index++) {
    const s = Q[index][0];
    const e = Q[index][1];
    if (s == 0) {
      // because no elements before index-0
      R[index] = pSum[e];
    } else {
      R[index] = pSum[e] - pSum[s - 1];
    }
  }
  return R;
}
function main() {
  const DATA = [
    {
      A: [1, 2, 3, 4, 5, 6, 7],
      Q: [[0, 2], [1, 4], [3, 6]],
      R: [4, 8, 12]
    },
    {
      A: [-2, 7, 1, 4, 7, 3, 5, -6, 2, 1],
      Q: [[0, 0], [0, 4], [6, 6], [8, 9], [9, 9]],
      R: [-2, 6, 5, 2, 0]
    }
  ];
  DATA.forEach(({ A, Q, R }, index) => {
    const Result = RangeQuerySumEvenIndex(A, Q);
    if (R.toString() == Result.toString()) {
      console.log("Passed", index + 1);
    } else {
      console.log("Wrong Answer..!", index + 1);
      console.log("Expected", R);
      console.log("Result", Result);
    }
  });

}

main();