/*
Special-Index-After-Removing-an-Element, sum of all EVEN indexed elements is equals to sum of all the ODD indexed elements.
*/

function OddIndecesSumAfterRemovingAnElement(A) {
  // Prefix sum
  const pSumE = [], pSumO = [];
  pSumE[0] = A[0]; pSumO[0] = 0;

  for (let index = 1; index < A.length; index++) {
    const element = A[index];
    if (index % 2 == 0) {
      pSumE[index] = element + pSumE[index - 1];

      pSumO[index] = pSumO[index - 1];
    } else {
      pSumE[index] = pSumE[index - 1];

      pSumO[index] = element + pSumO[index - 1];
    }
  }
  // console.log(pSumE);
  // console.log(pSumO);

  const R = [];
  const N = A.length;
  for (let index = 0; index < N; index++) {
    const sumOfOddIndeces = (pSumO[index - 1] || 0) + pSumE[N - 1] - pSumE[index];
    // console.log({ index, sumOfOddIndeces });
    R.push(sumOfOddIndeces);
  }
  return R;
}

function main() {
  const DATA = [
    {
      A: [2, 1, 6, 4],
      R: [6, 6, 1, 1]
    },
    {
      A: [1, 2, 1],
      R: [1, 1, 2]
    },
    {
      A: [1, 2, 1, 1],
      R: [1, 1, 2, 2]
    },
    {
      A: [1, 1, 2, 1],
      R: [2, 2, 1, 1]
    }
  ];
  DATA.forEach(({ A, R }, index) => {
    const start = new Date();
    const Result = OddIndecesSumAfterRemovingAnElement(A);
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