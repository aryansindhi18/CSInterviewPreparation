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

# Q9 Explain the Difference Between `==` and `===` in JavaScript

- **`==` (Loose Equality)**: Compares two values for equality **after converting them** to a common type (type coercion).
- **`===` (Strict Equality)**: Compares both **value and type**, without performing type coercion.

# Q10 Shallow Copy vs. Deep Copy in JavaScript

### Shallow Copy
A **shallow copy** creates a new object, but it does not clone nested objects; instead, it copies references to them. This means changes to nested objects in the copied object will also affect the original object.

#### Example:
```javascript
const original = {
  name: "John",
  address: {
    city: "New York",
    zip: 10001
  }
};

const shallowCopy = { ...original }; // Shallow copy using spread operator
shallowCopy.address.city = "Los Angeles";

console.log(original.address.city); // Output: "Los Angeles" (modified in original object)
```

### Deep Copy
A **deep copy** creates a completely independent copy of the object, including all nested objects. Changes in the copied object do not affect the original object.

#### Example:
```javascript
const original = {
  name: "John",
  address: {
    city: "New York",
    zip: 10001
  }
};

// Deep copy using JSON methods (works only for JSON-compatible structures)
const deepCopy = JSON.parse(JSON.stringify(original));
deepCopy.address.city = "Los Angeles";

console.log(original.address.city); // Output: "New York" (original object remains unchanged)
```

### Alternative Methods for Deep Copy:
#### Using `structuredClone()` (Modern Approach)
```javascript
const deepCopy = structuredClone(original);
```

#### Using Lodash
```javascript
const _ = require("lodash");
const deepCopy = _.cloneDeep(original);
```

### Summary Table:
| Type         | Copies Nested Objects? | Independent Copy? |
|-------------|---------------------|-----------------|
| Shallow Copy | ❌ (references copied) | ❌ (modifications affect original) |
| Deep Copy    | ✅ (nested objects cloned) | ✅ (fully independent copy) |

# Q11 Closures in JavaScript
A **closure** is a function that retains access to variables from its lexical scope, even after the function in which it was declared has finished executing.

### Example:
```javascript
function outerFunction(outerVariable) {
  return function innerFunction(innerVariable) {
    console.log(`Outer: ${outerVariable}, Inner: ${innerVariable}`);
  };
}

const closureFunction = outerFunction("Hello");
closureFunction("World"); // Output: Outer: Hello, Inner: World
```

### Why Use Closures?
- **Encapsulation**: Closures help in creating private variables.
- **State Persistence**: Retains state even after outer function execution.
- **Callbacks & Event Handling**: Frequently used in asynchronous operations.

### Common Use Cases:
1. **Data Hiding and Encapsulation**
```javascript
function counter() {
  let count = 0;
  return function () {
    return ++count;
  };
}

const increment = counter();
console.log(increment()); // Output: 1
console.log(increment()); // Output: 2
```

2. **Creating Function Factories**
```javascript
function multiplier(factor) {
  return function (number) {
    return number * factor;
  };
}

const double = multiplier(2);
console.log(double(5)); // Output: 10
```

# Q12 The `reduce()` Function in JavaScript
The `reduce()` method is used to **reduce an array to a single value** by applying a callback function that iterates through the array.

### Syntax:
```javascript
array.reduce(callback(accumulator, currentValue), initialValue);
```
- `callback`: A function executed on each element, taking `accumulator` and `currentValue` as arguments.
- `initialValue` (optional): The starting value of the accumulator.

### Example:
#### Summing Numbers in an Array
```javascript
const numbers = [1, 2, 3, 4, 5];
const sum = numbers.reduce((acc, num) => acc + num, 0);

console.log(sum); // Output: 15
```

#### Flattening an Array
```javascript
const nestedArray = [[1, 2], [3, 4], [5, 6]];
const flatArray = nestedArray.reduce((acc, val) => acc.concat(val), []);

console.log(flatArray); // Output: [1, 2, 3, 4, 5, 6]
```

#### Counting Occurrences
```javascript
const words = ["apple", "banana", "apple", "orange", "banana", "apple"];
const wordCount = words.reduce((acc, word) => {
  acc[word] = (acc[word] || 0) + 1;
  return acc;
}, {});

console.log(wordCount); 
// Output: { apple: 3, banana: 2, orange: 1 }
```

### When to Use `reduce()`?
- Summing or accumulating values.
- Transforming data (e.g., flattening arrays, counting occurrences).
- Implementing custom aggregation logic.

# Q13 `map()` vs `reduce()` in JavaScript

| Function | Purpose |
|----------|---------|
| `map()` | Used to create a new array by applying a function to each element. |
| `reduce()` | Used to accumulate a single result from an array (e.g., summing numbers). |

### Example of `map()`:
```javascript
const numbers = [1, 2, 3, 4];
const doubled = numbers.map(num => num * 2);
console.log(doubled); // Output: [2, 4, 6, 8]
```

### Example of `reduce()`:
```javascript
const sum = numbers.reduce((acc, num) => acc + num, 0);
console.log(sum); // Output: 10
```
# Q14 Parameters Accepted by `map()` Function
The `map()` function accepts a **callback function** with three parameters:

```javascript
array.map((currentElement, index, array) => { 
  // function body
});
```
- `currentElement`: The current element being processed.
- `index`: The index of the current element.
- `array`: The array `map()` was called upon.

### Example:
```javascript
const numbers = [1, 2, 3, 4];
const result = numbers.map((num, idx, arr) => {
  console.log(`Processing ${num} at index ${idx} in`, arr);
  return num * 2;
});
console.log(result); // Output: [2, 4, 6, 8]
```

# Q15 Promises vs Callbacks in JavaScript
### Callbacks
Callbacks are functions passed as arguments to other functions and executed once the task is completed. Callbacks can lead to **callback hell** if nested too deeply.

#### Example:
```javascript
function fetchData(callback) {
  setTimeout(() => {
    callback("Data received");
  }, 1000);
}

fetchData((message) => {
  console.log(message); // Output: Data received
});
```

### Promises
Promises provide a cleaner way to handle asynchronous operations and can be chained for better readability and error handling.

#### Example:
```javascript
function fetchData() {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve("Data received");
    }, 1000);
  });
}

fetchData().then((message) => {
  console.log(message); // Output: Data received
});
```

### Differences Between Callbacks and Promises
| Feature     | Callbacks | Promises |
|------------|----------|---------|
| Readability | Can lead to callback hell | More readable with `.then()` chaining |
| Error Handling | Must handle errors manually | Uses `.catch()` for error handling |
| Flexibility | Limited reusability | Can be chained and reused efficiently |

Promises make asynchronous code more structured and maintainable, reducing issues related to deeply nested callbacks.


