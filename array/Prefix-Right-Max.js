/*
Prefix Right Max
Prefix Right Max is an array where each element at index i represents the maximum value in the subarray from index i to the end of the original array.
In other words, it's the maximum value "to the right" of each index.
*/

function getPrefixRightMax(array) {
  const N = array.length;
  const prefixArray = Array(N).fill(0);
  prefixArray[N - 1] = array[N - 1]; // so j = N - i - 1

  for (let index = 0; index < N; index++) {
    let j = N - index - 1;
    if ((j + 1) < N) { // to prevent 5 > undefined == false
      if (array[j] >= prefixArray[j + 1]) {
        prefixArray[j] = array[j];
      } else {
        prefixArray[j] = prefixArray[j + 1];
      }
    }
    // OR One Liner
    // prefixArray[N - index - 1] = Math.max(array[N - index - 1], prefixArray[N - index] || 0); //  || 0 is fallback for undefined
  }
  return prefixArray;
}

function main() {
  let array = [1, 2, 3, 4, 5];
  console.log(getPrefixRightMax(array));
  array = [1, 9, 2, 8, 3, 7, 4, 6];
  console.log(getPrefixRightMax(array));
  array = [1, 5, 2, 6, 3, 7, 4, 8];
  console.log(getPrefixRightMax(array));
}
main();