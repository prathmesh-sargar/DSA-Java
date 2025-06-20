
# 📚 DSA Topic: **Stacks (including Monotonic Stack)**

A stack is a **LIFO (Last In, First Out)** structure. It's extremely useful in problems where you need to **backtrack**, **track previous elements**, or **reverse processes**.

---

## 🧩 Stack-Based Patterns

---

### 1. ✅ **Basic Stack Operations**

Stack is used to push/pop elements, track last seen item, reverse logic, etc.

🧠 **When to Use:**
→ When the problem needs “undo”, “reverse”, “backtracking” or **nested structure parsing**.

📌 **Questions**:

* [Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)
* [Min Stack](https://leetcode.com/problems/min-stack/)
* [Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/)
* [Implement Stack using Queues](https://leetcode.com/problems/implement-stack-using-queues/)
* [Daily Temperatures](https://leetcode.com/problems/daily-temperatures/)

---

### 2. ✅ **Next Greater / Smaller Element (Monotonic Stack)**

Maintain **increasing or decreasing stacks** to solve comparison problems in `O(n)` time.

🧠 **When to Use:**
→ When asked for **next/previous greater/smaller** elements.

📌 **Questions**:

* [Next Greater Element I](https://leetcode.com/problems/next-greater-element-i/)
* [Next Greater Element II](https://leetcode.com/problems/next-greater-element-ii/)
* [Daily Temperatures](https://leetcode.com/problems/daily-temperatures/)
* [Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/)
* [Sum of Subarray Minimums](https://leetcode.com/problems/sum-of-subarray-minimums/)
* [Maximal Rectangle](https://leetcode.com/problems/maximal-rectangle/)

---

### 3. ✅ **Infix, Prefix, Postfix Expression Evaluation**

Stack is ideal for evaluating or converting mathematical expressions.

📌 **Questions**:

* [Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/)
* [Basic Calculator](https://leetcode.com/problems/basic-calculator/)
* [Basic Calculator II](https://leetcode.com/problems/basic-calculator-ii/)
* [Infix to Postfix Conversion (GFG)](https://www.geeksforgeeks.org/convert-infix-expression-to-postfix-expression/)
* [Postfix Evaluation (GFG)](https://www.geeksforgeeks.org/stack-set-4-evaluation-postfix-expression/)

---

### 4. ✅ **Stack with Auxiliary Structures (Min Stack / Max Stack)**

Stack that supports **extra features like tracking min/max in constant time**.

📌 **Questions**:

* [Min Stack](https://leetcode.com/problems/min-stack/)
* [Max Stack (Leetcode Premium)](https://leetcode.com/problems/max-stack/)
* [Online Stock Span](https://leetcode.com/problems/online-stock-span/)

---

### 5. ✅ **Backtracking Using Stack**

Used in problems like **undo operations**, **DFS**, or **expression building**.

📌 **Questions**:

* [Decode String](https://leetcode.com/problems/decode-string/)
* [Remove All Adjacent Duplicates in String](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/)
* [Simplify Path](https://leetcode.com/problems/simplify-path/)
* [Backspace String Compare](https://leetcode.com/problems/backspace-string-compare/)
* [Text Editor Simulation (GFG)](https://www.geeksforgeeks.org/implement-text-editor/)

---

## 🧠 Tips to Master Stack:

* When you see **nested**, **balanced**, **undo**, **previous/next** → **think stack**.
* Monotonic Stack = increasing/decreasing stack → helps find **next/previous greater/smaller** in O(n).
* Draw how the stack evolves → helps visualize flow.
* When popping from stack, always check conditions (empty, top value).

---

## ✅ Final Thoughts

If you master:

* Bracket and expression problems
* Monotonic stack for range/area/sum
* Prefix/postfix evaluations
* Advanced stack apps like Min Stack and history undo

You’ll dominate problems that require **state tracking and efficient comparisons** — which are **super common in real-world logic problems** and **FAANG rounds**.

