# Q1 What are the Hooks you have used?
Common React hooks include `useState()`, `useEffect()`, `useContext()`, `useReducer()`, `useCallback()`, `useMemo()`, and `useRef()`.

# Q2 What is the purpose of useCallback?
`useCallback` is used to memoize a function, preventing its re-creation on every render unless its dependencies change.

# Q3 What are Class-based Lifecycle methods?
Lifecycle methods in class components include `componentDidMount()`, `componentDidUpdate()`, `componentWillUnmount()`, `shouldComponentUpdate()`, and `getDerivedStateFromProps()`.

# Q4 How would you achieve componentDidMount, componentDidUpdate, and componentWillUnmount in functional components?
`useEffect()` can be used in functional components to mimic these lifecycle methods. `useEffect()` with an empty dependency array behaves like `componentDidMount()`, and with specific dependencies, it can act like `componentDidUpdate()` and `componentWillUnmount()`.

# Q5 What are Pure Components and their purpose?
Pure components are components that only re-render when their props or state change. This helps optimize performance by preventing unnecessary re-renders.

#### Example of a Pure Component:
```javascript
import React, { PureComponent } from "react";

class MyComponent extends PureComponent {
  render() {
    console.log("Rendering MyComponent");
    return <div>{this.props.message}</div>;
  }
}

export default MyComponent;
```

#### Functional Component Equivalent with `React.memo()`:
```javascript
import React from "react";

const MyComponent = React.memo(({ message }) => {
  console.log("Rendering MyComponent");
  return <div>{message}</div>;
});

export default MyComponent;
```

In both cases, the component will only re-render if the `message` prop changes, optimizing performance by avoiding unnecessary renders.


# Q6 What are Higher Order Components (HOCs)?
HOCs are functions that take a component and return a new component with additional props or behavior.

#### Example of a Higher Order Component:
```javascript
import React from "react";

const withLogging = (WrappedComponent) => {
  return (props) => {
    console.log("Component Mounted:", WrappedComponent.name);
    return <WrappedComponent {...props} />;
  };
};

const HelloWorld = ({ message }) => <h1>{message}</h1>;
const EnhancedHelloWorld = withLogging(HelloWorld);

export default EnhancedHelloWorld;
```

In this example, `withLogging` is a HOC that logs when the component is mounted. It takes `HelloWorld` as an argument and returns an enhanced version of it using a functional component approach.

