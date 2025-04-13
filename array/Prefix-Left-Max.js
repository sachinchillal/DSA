/*
Prefix Left Max
Prefix Left Max is an array where each element at index i represents the maximum value in the subarray from the start of the original array to index i.
In other words, it's the maximum value "to the left" of each index.
*/

function getPrefixLeftMax(array) {
  const prefixArray = Array(array.length).fill(0);
  prefixArray[0] = array[0]; // so index = 1
  for (let index = 1; index < array.length; index++) {
    const element = array[index];
    if (element > prefixArray[index - 1]) {
      prefixArray[index] = element;
    } else {
      prefixArray[index] = prefixArray[index - 1];
    }
    // OR One Liner
    // prefixArray[index] = Math.max(array[index], prefixArray[index - 1]);
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