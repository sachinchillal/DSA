/*
Prefix Left Max
Prefix Left Max is an array where each element at index i represents the maximum value in the subarray from the start of the original array to index i.
In other words, it's the maximum value "to the left" of each index.
*/

function getPrefixLeftMax(array) {
  const N = array.length;
  let prefixArray = Array(N).fill(0).map(() => ({ left: 0, right: 0 }));
  for (let index = 0; index < N; index++) {
    prefixArray[index].left = Math.max(array[index], prefixArray[index - 1]?.left || 0);
    const j = N - index - 1;
    prefixArray[j].right = Math.max(prefixArray[j + 1]?.right || 0, array[j]);
  }
  return prefixArray;
}

function main() {
  let array = [1, 2, 3, 4, 5];
  console.log(getPrefixLeftMax(array));
  array = [1, 9, 2, 8, 3, 7, 4, 6];
  console.log(getPrefixLeftMax(array));
  array = [1, 5, 2, 6, 3, 7, 4, 8];
  console.log(getPrefixLeftMax(array));
}
main();