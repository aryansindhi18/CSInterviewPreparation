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
