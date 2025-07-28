
## 🧩 Problem Name: Valid Parentheses

## 🎯 Problem Statement:

You're given a string containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['`, and `']'`.
Write a function to check if the input string is valid.

✅ A string is valid if:

1. Open brackets are closed by the same type of brackets.
2. Open brackets are closed in the correct order.

---

## 🧠 Approach (Using Stack):

1. Create a stack to keep track of opening brackets.
2. Traverse the string character by character.
3. If you find an **opening bracket** (`(`, `{`, `[`), **push it to the stack**.
4. If you find a **closing bracket** (`)`, `}`, `]`):

   * Check if the stack is not empty and the **top of the stack** is the matching opening bracket.
   * If yes, **pop** it.
   * If no, return **false** immediately.
5. At the end, if the stack is **empty**, return `true`. Else, return `false`.

---

## 🧑‍💻 Code:

```java
import java.util.Stack;

public class Valid_Parentheses {

    public static boolean isvalid(String s) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else if (!st.isEmpty() && ch == ')' && st.peek() == '(') {
                st.pop();
            } else if (!st.isEmpty() && ch == ']' && st.peek() == '[') {
                st.pop();
            } else if (!st.isEmpty() && ch == '}' && st.peek() == '{') {
                st.pop();
            } else {
                return false; // unmatched closing bracket
            }
        }

        return st.isEmpty(); // valid only if all are matched
    }

    public static void main(String[] args) {
        String str = "[{()}]";
        System.out.println("is valid parentheses : " + isvalid(str));
    }
}
```

---

## ⏱️ Time and Space Complexity:

| Complexity | Value  |                                                   |
| ---------- | ------ | ------------------------------------------------- |
| Time       | `O(n)` | (We go through each character once)               |
| Space      | `O(n)` | (In the worst case, all open brackets are stored) |

---



## 🧩 Problem Name: Min Stack

 — Design a stack that supports `push()`, `pop()`, `top()`, and `getMin()` in **O(1)** time.

---

## 🎯 Problem Statement:

Design a stack that, along with normal operations like `push`, `pop`, and `top`, also supports retrieving the **minimum element** in constant time.

### Operations to implement:

* `MinStack()` → Initializes the object.
* `push(int val)` → Pushes an element onto the stack.
* `pop()` → Removes the element on the top.
* `top()` → Returns the top element.
* `getMin()` → Returns the minimum element in the stack.

All operations must be done in **O(1)** time.

---

## 🧠 Approach:

We use **two stacks**:

1. `stack` → to store all values normally.
2. `minStack` → to keep track of the **current minimum** at every point.

### Logic:

* While pushing a value, if the `minStack` is empty or the new value is **less than or equal to** the current min, also push it to `minStack`.
* While popping, if the popped value equals the top of `minStack`, pop from `minStack` too.
* `minStack.peek()` always gives the current **minimum value** in O(1) time.

---

## 👨‍💻 Code:

```java
import java.util.Stack;

public class Min_Stack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    // Constructor
    Min_Stack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int val = stack.pop();
        if (val == minStack.peek()) {
            minStack.pop();
        }
    }

    public int peek() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Min_Stack obj = new Min_Stack();
        obj.push(12);
        obj.push(-2);
        obj.push(10);
        obj.push(-3);
        obj.push(0);

        System.out.println("getMin value: " + obj.getMin()); // Output: -3
        obj.pop(); // remove 0
        obj.pop(); // remove -3
        System.out.println("Top value: " + obj.peek());      // Output: 10
        System.out.println("New getMin: " + obj.getMin());   // Output: -2
    }
}
```

---

## ⏱ Time & Space Complexity:

| Operation  | Time Complexity | Space Complexity |
| ---------- | --------------- | ---------------- |
| `push()`   | O(1)            | O(1) per call    |
| `pop()`    | O(1)            | O(1)             |
| `peek()`   | O(1)            | O(1)             |
| `getMin()` | O(1)            | O(1)             |

> ⚠️ Worst-case space = O(n) for both stacks.

---


## 🧩 Problem Name: Implement Stack using Queues

---

## 🎯 Problem Statement:

Design a **Stack** (LIFO) using only **Queue** operations (FIFO).

You need to implement the following methods:

* `push(int val)` → Push an element onto the stack.
* `pop()` → Removes and returns the top element of the stack.
* `peek()` → Returns the top element without removing it.

---

## 🧠 Approach (Using Two Queues):

We use two queues:

* `main` → This queue always holds the elements in **correct stack order**, i.e., newest at the front.
* `helper` → Temporary queue used during the `push()` operation to reorder elements.

---

### ✅ Logic:

* **Push (val)**:

  1. First, move all elements from `main` to `helper`.
  2. Then, add the new value to `main`.
  3. Move everything back from `helper` to `main`.

  * After this, `main` will always have the **top of the stack at the front**.

* **Pop()**: Just remove from the front of `main`.

* **Peek()**: Just return the front of `main`.

---

## 👨‍💻 Code:

```java
import java.util.ArrayDeque;
import java.util.Queue;

public class Implement_Stack_using_Queues {

    private Queue<Integer> main;
    private Queue<Integer> helper;

    Implement_Stack_using_Queues() {
        main = new ArrayDeque<>();
        helper = new ArrayDeque<>();
    }

    public void push(int val) {
        // Step 1: Move all elements to helper
        while (!main.isEmpty()) {
            helper.add(main.remove());
        }

        // Step 2: Add new element to main
        main.add(val);

        // Step 3: Move everything back to main
        while (!helper.isEmpty()) {
            main.add(helper.remove());
        }
    }

    public int pop() {
        return main.remove();
    }

    public int peek() {
        return main.peek();
    }

    public static void main(String[] args) {
        Implement_Stack_using_Queues obj = new Implement_Stack_using_Queues();
        obj.push(12);
        obj.push(10);
        obj.push(30);

        System.out.println(obj.pop());  // Output: 30
        System.out.println(obj.peek()); // Output: 10
    }
}
```

---

## ⏱️ Time & Space Complexity:

| Operation | Time Complexity | Space Complexity |
| --------- | --------------- | ---------------- |
| `push()`  | O(n)            | O(n)             |
| `pop()`   | O(1)            | O(1)             |
| `peek()`  | O(1)            | O(1)             |

---

## 🧩 Problem Name: Evaluate Reverse Polish Notation (Postfix Expression) 


## 🎯 Problem Statement:

You're given an array of strings `tokens`, where each element is either:

* an **integer** (like `"2"`, `"10"`, `"-5"`)
* or an **operator**: `"+"`, `"-"`, `"*"`, `"/"`

You need to **evaluate the expression** and return the result as an integer.

📌 The input is a valid postfix (RPN) expression.
**RPN Rule**: Operators come **after** their operands.

---

## 🧠 Approach (Using Stack):

1. Create an empty **stack** of integers.
2. Traverse the `tokens` array:

   * If it's a **number**, push it onto the stack.
   * If it's an **operator**:

     * Pop the top **two numbers** from the stack.
     * Apply the operation: `num2 (op) num1` → Note: second popped is first operand!
     * Push the result back onto the stack.
3. At the end, the **top of the stack** is the final result.

---

## 👨‍💻 Code:

```java
import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {

    // Helper method to perform arithmetic operations
    public static int operation(int a, int b, String token) {
        switch (token) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
        }
        return -1; // Just in case
    }

    // Main evaluator
    public static int answer(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int result = operation(num2, num1, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token)); // Convert string to int
            }
        }

        return stack.pop(); // Final result
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        int calculation = answer(tokens);
        System.out.println("calculation is : " + calculation); // Output: 9
    }
}
```

---

## ⏱️ Time & Space Complexity:

| Type      | Complexity |
| --------- | ---------- |
| **Time**  | O(n)       |
| **Space** | O(n)       |




