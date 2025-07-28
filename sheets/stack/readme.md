
## 📌 STACK DSA CONCEPT SHEET (Java Focused)

### ✅ 1. What is a Stack?

* **LIFO**: Last In, First Out
* Used in:

  * Parentheses Matching
  * Undo operations
  * Backtracking
  * Recursion (Call Stack)
  * Next Greater Element problems
  * Validating expressions

---

### ✅ 2. Java Stack Declaration

```java
Stack<Integer> stack = new Stack<>();
```

---

### ✅ 3. Common Stack Methods (🔥Must Know)

| Method              | Description                                        |
| ------------------- | -------------------------------------------------- |
| `push(x)`           | Add element `x` to the top                         |
| `pop()`             | Remove and return the top element                  |
| `peek()` or `top()` | Return the top element without removing            |
| `isEmpty()`         | Check if the stack is empty                        |
| `size()`            | Returns number of elements                         |
| `search(x)`         | Returns 1-based position from top, -1 if not found |

---

### ✅ 4. Stack with Other Data Structures

```java
Stack<Character> stack = new Stack<>();
Stack<int[]> stack = new Stack<>(); // Store arrays
Stack<Pair<Integer, Integer>> stack = new Stack<>(); // Using Pair (custom class or javafx.util.Pair)
```

---

### ✅ 5. Custom Stack using Array or LinkedList

#### ✅ Using Array

```java
class MyStack {
    int[] arr = new int[1000];
    int top = -1;

    void push(int x) {
        arr[++top] = x;
    }

    int pop() {
        return arr[top--];
    }

    boolean isEmpty() {
        return top == -1;
    }

    int peek() {
        return arr[top];
    }
}
```

#### ✅ Using LinkedList (Manual)

```java
class Node {
    int val;
    Node next;
    Node(int val) { this.val = val; }
}

class StackLL {
    Node top;

    void push(int x) {
        Node node = new Node(x);
        node.next = top;
        top = node;
    }

    int pop() {
        int val = top.val;
        top = top.next;
        return val;
    }

    boolean isEmpty() {
        return top == null;
    }

    int peek() {
        return top.val;
    }
}
```

---

### ✅ 6. Stack Problem Patterns (🔥Leetcode Popular)

| Pattern              | Example                                                         |
| -------------------- | --------------------------------------------------------------- |
| Balanced Parentheses | `20. Valid Parentheses`                                         |
| Next Greater Element | `496. Next Greater Element I`                                   |
| Monotonic Stack      | `739. Daily Temperatures`, `84. Largest Rectangle in Histogram` |
| Infix to Postfix     | Expression evaluation problems                                  |
| Stock Span           | `901. Online Stock Span`                                        |
| Min Stack            | `155. Min Stack`                                                |
| Decode String        | `394. Decode String`                                            |
| Asteroid Collision   | `735. Asteroid Collision`                                       |
| Removing Duplicates  | `1047. Remove All Adjacent Duplicates In String`                |

---

### ✅ 7. Stack with Two Stacks (MinStack Example)

```java
class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek()))
            minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
```

---

### ✅ 8. Tips While Solving Stack Problems

* 💡 Use **dry run** to understand behavior (especially for Next Greater / Monotonic Stack).
* ⚠️ Be careful with **`pop()` when stack is empty** → use `isEmpty()` before popping.
* ⛓ When tracking both value & index, use custom Pair class or `int[]`.

---

### ✅ 9. Stack in Recursion

Every time a function is called, a **call frame is pushed** on the stack.
When it finishes, it's popped off → same LIFO concept.

---

### ✅ 10. Practice First

Start with:

* 🔹 20. Valid Parentheses
* 🔹 155. Min Stack
* 🔹 394. Decode String
* 🔹 496. Next Greater Element
* 🔹 739. Daily Temperatures

