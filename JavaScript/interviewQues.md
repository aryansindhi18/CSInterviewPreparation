# Hoisting in JavaScript

Hoisting is a JavaScript mechanism where variables and functions are moved to the top of their containing scope during the compile phase before code execution.

## How Hoisting Works

- **`var` Declarations**: Hoisted and initialized with `undefined`.
- **`let` and `const` Declarations**: Hoisted but remain uninitialized (temporarily in a "Temporal Dead Zone" or TDZ).
- **Function Declarations**: Hoisted with their definition, allowing them to be called before their declaration.
- **Function Expressions**: Hoisted without their definition, following variable hoisting rules.

## Key Takeaways

- `var` is hoisted but initialized as `undefined`.
- `let` and `const` are hoisted but remain in the **Temporal Dead Zone (TDZ)**, causing a `ReferenceError` when accessed before declaration.
- Function declarations are fully hoisted, meaning they can be called before their definition.
- Function expressions (assigned to `var`, `let`, or `const`) follow variable hoisting rules and are not hoisted as functions.

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
