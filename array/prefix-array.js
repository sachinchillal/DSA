/*
Prefix Array

A prefix array (also known as a cumulative sum array) is a data structure that stores the cumulative sums of a given array.
It's a fundamental tool in computer science, particularly useful for efficiently computing sums of subarrays.

OR

A prefix array, also known as a cumulative sum array, is an array where each element is the sum of all elements up to that index in the original array.
The prefix sum is the sum of all elements up to a given index in the original array.
*/
function getPrefixArray(array) {
  const prefixArray = Array(array.length).fill(0);
  prefixArray[0] = array[0]; // so index = 1
  for (let index = 1; index < array.length; index++) {
    const element = array[index];
    prefixArray[index] = prefixArray[index - 1] + element;
  }
  return prefixArray;
}

function main() {
  let array = [1, 2, 3, 4, 5];
  console.log(getPrefixArray(array));
  array = [1, 9, 2, 8, 3, 7, 4, 6];
  console.log(getPrefixArray(array));
}
main();