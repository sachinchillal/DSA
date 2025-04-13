/**
 * O(n)
 * @param {*} array 
 */
function forLoop(array) {
  for (let i = 0; i < array.length; i++) {
    console.log(array[i]);
  }
}
/**
 * O(n/2)
 * @param {*} array 
 */
function forLoopHalf(array) {
  for (let i = 0; i < array.length; i += 2) {
    if (i + 1 < array.length) {
      console.log(array[i], array[i + 1]);
    } else {
      console.log(array[i]);
    }
    // OR

    /*
    if (array[i + 1] != undefined) {
      console.log(array[i], array[i + 1]);
    } else {
      console.log(array[i]);
    }
    */
  }
}
function forLoopByThird(array) {
  for (let i = 0; i < array.length; i += 3) {
    if (i + 2 < array.length) {
      console.log(array[i], array[i + 1], array[i + 2]);
    } else if (i + 1 < array.length) {
      console.log(array[i], array[i + 1]);
    } else {
      console.log(array[i]);
    }
  }
}
function forLoopByQuarter(array) {
  for (let i = 0; i < array.length; i += 4) {
    if (i + 3 < array.length) {
      console.log(array[i], array[i + 1], array[i + 2], array[i + 3]);
    } else if (i + 2 < array.length) {
      console.log(array[i], array[i + 1], array[i + 2]);
    } else if (i + 1 < array.length) {
      console.log(array[i], array[i + 1]);
    } else {
      console.log(array[i]);
    }
  }
}
function forLoopByFifth(array) {
  for (let i = 0; i < array.length; i += 5) {
    console.log(...array.slice(i, i + 5));
  }
}
function forLoopByMth(array, m) {
  for (let i = 0; i < array.length; i += m) {
    console.log(...array.slice(i, i + m));
  }
}


function main() {

  // const array = [1, 2, 3, 4, 5];
  const array = [1, 2, 3, 4, 5, 6, 7];
  // forLoop(array);
  // forLoopHalf(array); // reduces iteration by half
  // forLoopByThird(array); // reduces iteration by 3
  // forLoopByQuarter(array); // reduces iteration by 4
  // forLoopByFifth(array); // reduces iteration by 5
  const m = 3;
  forLoopByMth(array, m); // reduces iteration by m
}

main();