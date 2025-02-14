# Q1 Hoisting in JavaScript

Hoisting is a JavaScript mechanism where variables and functions are moved to the top of their containing scope during the compile phase before code execution.

## How Hoisting Works

- **`var` Declarations**: Hoisted and initialized with `undefined`.
- **`let` and `const` Declarations**: Hoisted but remain uninitialized (temporarily in **Temporal Dead Zone (TDZ)**), causing a `ReferenceError` when accessed before declaration.
- **Function Declarations**: Hoisted with their definition, allowing them to be called before their declaration.
- **Function Expressions**: Hoisted without their definition, following variable hoisting rules.


```js
// Example 1: var hoisting
console.log(a); // undefined
var a = 10;

// Example 2: let and const hoisting
console.log(b); // ReferenceError: Cannot access 'b' before initialization
let b = 20;

// Example 3: Function declaration hoisting
greet(); // "Hello!"
function greet() {
    console.log("Hello!");
}

// Example 4: Function expression hoisting
sayHello(); // TypeError: sayHello is not a function
var sayHello = function() {
    console.log("Hi!");
};
```

# Q2 Difference between let and var?
- **var** is function-scoped or globally scoped if declared outside of a function. **let** is block-scoped, meaning it is confined to the block (enclosed by **{}**) it is declared in.
- Variables declared with **var** are hoisted and initialized with **undefined**. **let** variables are hoisted but are not initialized.

# Q3 What is the Event Loop?
The **Event Loop** is a mechanism that allows JavaScript to perform **non-blocking** operations, such as I/O, timers, and API calls, while executing code in a **single-threaded** environment. It continuously checks the **call stack** and **message queue** to process tasks asynchronously.

## How the Event Loop Works

### **Key Components**
1. **Call Stack**
   - JavaScript uses a **call stack** (LIFO – Last In, First Out) to track function execution.
   - Functions are pushed onto the stack when invoked and popped when execution completes.

2. **Web APIs**
   - JavaScript delegates **asynchronous tasks** (e.g., `setTimeout`, `fetch`, DOM events) to **Web APIs**, which handle them separately.

3. **Task Queue (or Callback Queue)**
   - Stores **callbacks** from asynchronous operations like timers and I/O.
   - When the call stack is empty, the event loop picks tasks from this queue.

4. **Microtask Queue**
   - Holds **higher-priority** tasks such as:
     - **Promises (`.then()` callbacks)**
     - **MutationObserver callbacks**
   - Microtasks are executed **before** tasks in the Task Queue.

5. **Event Loop**
   - The event loop continuously **checks** if the **call stack is empty**:
     - If **yes**, it executes **microtasks first**.
     - Then, it moves to the **Task Queue**.
## Event Loop Flow

1. **Execute synchronous code** (functions, loops, etc.).
2. **Encounter an asynchronous operation** (e.g., `setTimeout`, `fetch`).
   - It is sent to **Web APIs** for processing.
   - The main thread continues executing other code.
3. Once the asynchronous operation completes:
   - The callback is placed in the **Task Queue** or **Microtask Queue**.
4. The **Event Loop**:
   - **Executes microtasks first** (Promises).
   - **Then executes tasks from the Task Queue**.
5. The cycle repeats indefinitely.
   


# Q4 Event Loop Precedence: Promise vs setTimeout

## **Which Executes First: Promise or setTimeout?**
In JavaScript’s **Event Loop**, **microtasks** (like `Promise.then()`) have **higher precedence** than **macrotasks** (like `setTimeout()`).

### **Execution Order**
1. **Microtasks (Higher Priority)**
   - **Promise callbacks** (`.then()`, `.catch()`, `.finally()`)
   - `queueMicrotask()`
   - `MutationObserver`
   - `process.nextTick()` (Node.js)

2. **Macrotasks (Lower Priority)**
   - `setTimeout()`
   - `setInterval()`
   - `setImmediate()` (Node.js)
   - I/O operations (e.g., file reading, network requests)
   - UI rendering tasks

### **How It Works**
- The **Event Loop** first executes **all microtasks** before moving to **macrotasks**.
- This ensures **Promise callbacks execute before** `setTimeout()`.

---

## **Example: Microtasks vs Macrotasks**
```js
console.log("Start");

setTimeout(() => {
    console.log("setTimeout callback");
}, 0);

Promise.resolve().then(() => {
    console.log("Promise callback");
});

console.log("End");

Output:
Start
End
Promise callback
setTimeout callback
```


# Q5 Difference between `setTimeout()` and `setInterval()`?

- `setTimeout()` is used to execute a function **once** after a specified delay.
- `setInterval()` is used to execute a function **repeatedly** at a fixed time interval.


# Q6 ES6 Features I Have Used

- **Arrow Functions (`=>`)**: Concise syntax for writing functions.
- **Template Literals**: String interpolation using backticks (`` ` ` `).
- **Destructuring**: Extract values from arrays or objects easily.
- **Classes**: Object-oriented programming with `class` and `constructor`.
- **Promises**: Handle asynchronous operations using `.then()` and `.catch()`.
- **Spread/Rest Operators (`...`)**: Expand or collect elements in arrays and objects.
- **`let` and `const`**: Block-scoped variable declarations.
- **`async/await`**: Simplify asynchronous code with a synchronous-like structure.
- **Default Parameters**: Assign default values to function parameters.
- **Modules (`import`/`export`)**: Modular code structure for better maintainability.

# Q7 Where Do You Mostly Use the Rest Operator?
The rest operator (**...**) is commonly used to collect multiple elements into an array. It is used in function arguments to collect a variable number of arguments into an array, or to copy the remaining properties of an object.

- **Function Arguments**: To collect a variable number of arguments into an array.
- **Object Destructuring**: To copy the remaining properties of an object.
- **Array Destructuring**: To collect remaining elements of an array.

## Examples:

```javascript
// 1. Using Rest Operator in Function Arguments
// The rest operator allows functions to accept an indefinite number of arguments as an array.

function sum(...numbers) {
    return numbers.reduce((acc, num) => acc + num, 0);
}

console.log(sum(1, 2, 3, 4)); // Output: 10

// 2. Using Rest Operator in Object Destructuring
// The rest operator helps extract specific properties while keeping the remaining properties in a separate object.

const person = { name: "John", age: 30, city: "New York", country: "USA" };
const { name, age, ...rest } = person;

console.log(name); // Output: John
console.log(age);  // Output: 30
console.log(rest); // Output: { city: "New York", country: "USA" }

// 3. Using Rest Operator in Array Destructuring
// The rest operator can be used to collect the remaining elements of an array.

const numbers = [1, 2, 3, 4, 5];
const [first, second, ...restNumbers] = numbers;

console.log(first);  // Output: 1
console.log(second); // Output: 2
console.log(restNumbers);   // Output: [3, 4, 5]
```

# Q8 Have You Heard of `array.reverse()`?

The **`array.reverse()`** method reverses the order of elements in an array and **modifies the original array**.


