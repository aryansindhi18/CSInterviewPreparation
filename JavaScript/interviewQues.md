- What is hoisting in JS? How does it work? Does hoisting work with all variables, and why?

Hoisting is a JavaScript mechanism where variables and functions are moved to the top of their containing scope during the compile phase before code execution. 
Var declarations are hoisted and initialized with undefined, whereas let and const declarations are hoisted but remain uninitialized (temporarily in a "temporal dead zone").
Hoisting works differently with functions as well—function declarations are hoisted with their definition, while function expressions are hoisted without their definition.
Key Takeaways:
    - var is hoisted but initialized as undefined.
    - let and const are hoisted but remain in the Temporal Dead Zone (TDZ), causing a ReferenceError when accessed before declaration.
    - Function declarations are fully hoisted, allowing them to be called before their definition.
    - Function expressions (assigned to var, let, or const) follow variable hoisting rules and are not hoisted as functions.


