const STACK = [];
const ARRAY = [1, 2, 3, 4, 5, 6, 7];
const STATES = [];
let currentStateIndex = 0;

async function mainStackUIUX(type) {
  const root = arrayToTree(ARRAY);
  // console.log(root);
  stackInit("stackPlaceholder");
  inputPlaceholder.innerHTML = ARRAY.join(', ');

  let R = [];
  if (type == "inOrderTraversal") {
    R = inOrderTraversal(root);
  } else if (type == "preOrderTraversal") {
    R = preOrderTraversal(root);
  } else if (type == "postOrderTraversal") {
    R = postOrderTraversal(root);
  }
  resultPlaceholder.innerHTML = R.join(', ');
  displayValues();
  const btnPrev = document.getElementById('btnPrev');
  const btnNext = document.getElementById('btnNext');

  btnFirst.addEventListener('click', () => {
    if (STATES.length > 0) {
      currentStateIndex = 0;
      displayValues();
    }
  });
  btnPrev.addEventListener('click', () => {
    if (STATES.length > 0 && currentStateIndex > 0) {
      currentStateIndex--;
      displayValues();
    }
  });
  btnNext.addEventListener('click', () => {
    if (STATES.length > 0 && currentStateIndex < STATES.length - 1) {
      currentStateIndex++;
      displayValues();
    }
  });
  btnLast.addEventListener('click', () => {
    if (STATES.length > 0) {
      currentStateIndex = STATES.length - 1;
      displayValues();
    }
  });
}
function displayValues() {
  stateIndex.innerHTML = `${currentStateIndex + 1} / ${STATES.length}`;
  const o = STATES[currentStateIndex];
  currentPlaceholder.innerHTML = o.current ? o.current.val : 'null';
  if (o.lastVisited) {
    if (lastVisitedPlaceholder) {
      lastVisitedPlaceholder.innerHTML = o.lastVisited.val;
    }
  }
  STACK.length = 0; // Clear the stack
  STACK.push(...o.stack);
  displayStack();
  resultPlaceholder.innerHTML = o.result.join(', ');
}

function arrayToTree(array) {
  // level order array to BST
  if (array.length === 0) return null;

  const root = { val: array[0], left: null, right: null };
  const queue = [root];
  let i = 1;
  while (i < array.length) {
    const current = queue.shift();
    if (current) {
      if (i < array.length) {
        current.left = { val: array[i], left: null, right: null };
        queue.push(current.left);
        i++;
      }
      if (i < array.length) {
        current.right = { val: array[i], left: null, right: null };
        queue.push(current.right);
        i++;
      }
    }
  }

  return root;
}
function state(o) {
  STATES.push(o);
  // displayValues();
}
function inOrderTraversal(root) {
  const result = [];
  STACK.length = 0; // Clear the stack
  let current = root;
  STATES.length = 0; // Clear the states

  while (current !== null || STACK.length > 0) {
    state({ current, stack: [...STACK], result: [...result] });
    while (current !== null) {
      STACK.push(current);
      current = current.left;
      state({ current, stack: [...STACK], result: [...result] });
    }
    current = STACK.pop();
    result.push(current.val);
    // state({ current, stack: [...STACK], result: [...result] });
    current = current.right;
  }
  state({ current, stack: [...STACK], result: [...result] });
  return result;
}
function preOrderTraversal(root) {
  const R = [];
  STACK.length = 0; // Clear the stack
  STATES.length = 0; // Clear the states
  STACK.push(root);
  state({ current: null, stack: [...STACK], result: [...R] });
  while (STACK.length > 0) {
    const current = STACK.pop();
    if (current) {
      R.push(current.val);
      state({ current, stack: [...STACK], result: [...R] });
      // Push right first so that left is processed first
      if (current.right) STACK.push(current.right);
      if (current.left) STACK.push(current.left);
    }
  }
  return R;
}
function postOrderTraversal(root) {
  const R = [];
  STACK.length = 0; // Clear the stack
  STATES.length = 0; // Clear the states
  let current = root;
  let lastVisited = null;

  while (current !== null || STACK.length > 0) {
    state({ lastVisited, current, stack: [...STACK], result: [...R] });
    while (current !== null) {
      STACK.push(current);
      current = current.left;
      state({ lastVisited, current, stack: [...STACK], result: [...R] });
    }
    const peekNode = STACK[STACK.length - 1];
    if (peekNode.right && lastVisited !== peekNode.right) {
      current = peekNode.right;
    } else {
      lastVisited = STACK.pop();
      R.push(lastVisited.val);
    }
    state({ lastVisited, current: null, stack: [...STACK], result: [...R] });
  }
  return R;
}
