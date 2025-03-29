class Node {
  constructor(data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}

function createPreOrderTree(array) {
  if (array.length === 0) {
    return null;
  }
  const Root = new Node(array[0]);
  // console.log(Root);
  const Queue = [Root];
  let index = 1; // because index 0 is already used above

  while (index < array.length) {
    const currentNode = Queue.shift(); // first node
    // console.log(currentNode);

    if (index < array.length) {
      if (array[index] != null) {
        currentNode.left = new Node(array[index]);
        Queue.push(currentNode.left);
      }
      index++;
    }
    if (index < array.length) {
      if (array[index] != null) {
        currentNode.right = new Node(array[index]);
        Queue.push(currentNode.right);
      }
      index++;
    }
  }
  return Root;
}

function printTree(root, indent = "", last = true) {
  if (!root) {
    return;
  }

  const marker = last ? "└── " : "├── ";

  console.log(indent + marker + root.data);

  indent += last ? "    " : "│   ";

  printTree(root.left, indent, !root.right);
  printTree(root.right, indent, true);
}

/**
 *    1
 *  2   3
 * 4 5 6 7
*/
function example1() {
  const array = [1, 2, 3, 4, 5, 6, 7];
  return array;
}
/**
 *    1
 *  2   4
 * _ _ 5 _
 *    _ 3 _ _
 */
function example2() {
  return [1, 2, 4, null, null, 5, null, null, 3, null, null];
}

function main() {
  // const array = example1();
  const array = example2();
  const root = createPreOrderTree(array);
  console.log(root);
  printTree(root);
}

main();

/**
node tree/binary-tree-construction-from-array.js
*/