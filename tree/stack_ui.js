
function stackInit(stackPlaceholder) {
  document.getElementById(stackPlaceholder).innerHTML = `
    <div class="text-center flex items-center flex-col gap-2">
      <small>Top</small>
      <div id="stackContainer"
        class="min-w-16 w-fit flex flex-col items-center justify-center gap-2 p-2 pt-10 text-2xl font-bold mt-4 border-2 border-t-0 border-gray-300">
        <!--<div class="bg-blue-500 rounded-full p-5 py-3">3</div>
        <div class="bg-blue-500 rounded-full p-5 py-3">2</div>
        <div class="bg-blue-500 rounded-full p-5 py-3">1</div>
        -->
      </div>
      <small>Bottom</small>
      <div class="bg-green-500 rounded p-3 py-1">Stack</div>
    </div>`;
}

function displayStack() {
  const stackContainer = document.getElementById("stackContainer");
  stackContainer.innerHTML = "";
  STACK.forEach((item) => {
    const div = document.createElement("div");
    div.className = "bg-blue-500 rounded-full p-5 py-3";
    // check if item is object or not
    if (typeof item === "object" && item !== null && item) {
      div.textContent = item.val;
    } else {
      div.textContent = item;
    }
    // insert the item at the top of the stack
    stackContainer.prepend(div);
  });
}