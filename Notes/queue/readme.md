
# 📚 DSA Topic: **Queue**

A **Queue** is a First-In-First-Out (FIFO) data structure. It's widely used in **BFS traversal, scheduling systems**, and **real-time processing**.

This topic appears in **system design-based logic, recursion + BFS problems**, and **sliding window-style algorithms**.

---

## 🧩 Queue Patterns

---

### 1. ✅ **Basic Queue Operations**

Understand how to use **enqueue, dequeue**, and queue traversal.

🧠 **When to Use:**
→ When order matters and tasks must be processed in the same sequence they arrive.

📌 **Questions**:

* [Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/)
* [Design Circular Queue](https://leetcode.com/problems/design-circular-queue/)
* [Number of Recent Calls](https://leetcode.com/problems/number-of-recent-calls/)
* [Moving Average from Data Stream](https://leetcode.com/problems/moving-average-from-data-stream/)

---

### 2. ✅ **Queue using Stack (and vice versa)**

Important for **design rounds** and **system implementation questions**.

📌 **Questions**:

* [Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/)
* [Implement Stack using Queues](https://leetcode.com/problems/implement-stack-using-queues/)

---

### 3. ✅ **Sliding Window with Queue**

Optimize real-time data analysis using **double-ended queues (deque)**.

🧠 **When to Use:**
→ When you need to keep track of max/min in a **sliding range**.

📌 **Questions**:

* [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)
* [First Negative Integer in Every Window of Size K (GFG)](https://www.geeksforgeeks.org/first-negative-integer-every-window-size-k/)
* [Maximum of All Subarrays of Size K](https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/)

---

### 4. ✅ **Binary Tree Level Order Traversal (BFS)**

This is the most common and **interview-favorite** queue application.

🧠 **When to Use:**
→ In tree or graph problems where you want to explore **level-by-level** or **breadth-first**.

📌 **Questions**:

* [Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)
* [Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/)
* [Populating Next Right Pointers](https://leetcode.com/problems/populating-next-right-pointers-in-each-node/)
* [Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree/)
* [01 Matrix](https://leetcode.com/problems/01-matrix/)

---

### 5. ✅ **Topological Sort using Queue**

Often asked in **graph problems** where node dependencies must be handled.

📌 **Questions**:

* [Course Schedule](https://leetcode.com/problems/course-schedule/)
* [Course Schedule II](https://leetcode.com/problems/course-schedule-ii/)
* [Alien Dictionary (Hard)](https://leetcode.com/problems/alien-dictionary/)

---

### 6. ✅ **Design Problems using Queue**

Designing systems with real-time request/response or streaming logic.

📌 **Questions**:

* [Number of Recent Calls](https://leetcode.com/problems/number-of-recent-calls/)
* [Moving Average from Data Stream](https://leetcode.com/problems/moving-average-from-data-stream/)
* [Design Hit Counter](https://leetcode.com/problems/design-hit-counter/)
* [Design Bounded Blocking Queue (Concurrency)](https://leetcode.com/problems/design-bounded-blocking-queue/)

---

### 🧠 Tips to Master Queue:

* Understand both **simple queue** and **double-ended queue (deque)**.
* Use **LinkedList** in Java or `collections.deque` in Python for O(1) operations.
* **BFS = Queue** – Always remember this pattern.
* Practice **design problems** involving queues for system thinking.

---

### ✅ Final Thoughts

Once you understand:

* Basic queue operations
* Sliding window max/min with deque
* BFS traversal logic
* Topological sorting

You’ll have **mastered queues for all key placements and interviews**.

---
