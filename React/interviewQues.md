# Q1 What are the Hooks you have used?
Common React hooks include `useState()`, `useEffect()`, `useContext()`, `useReducer()`, `useCallback()`, `useMemo()`, and `useRef()`.

# Q2 What is the purpose of useCallback?
`useCallback` is used to memoize a function, preventing its re-creation on every render unless its dependencies change.

# Q3 What are Class-based Lifecycle methods?
Lifecycle methods in class components include `componentDidMount()`, `componentDidUpdate()`, `componentWillUnmount()`, `shouldComponentUpdate()`, and `getDerivedStateFromProps()`.

# Q4 How would you achieve componentDidMount, componentDidUpdate, and componentWillUnmount in functional components?
`useEffect()` can be used in functional components to mimic these lifecycle methods. `useEffect()` with an empty dependency array behaves like `componentDidMount()`, and with specific dependencies, it can act like `componentDidUpdate()` and `componentWillUnmount()`.
