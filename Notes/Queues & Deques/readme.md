
# 📚 DSA Topic: **Queues & Deques (Double-Ended Queue)**

A **Queue** is a **FIFO (First In First Out)** structure. A **Deque** (Double-Ended Queue) allows **insertion and deletion at both ends**. These data structures are critical in:

* **BFS Traversals**
* **Sliding Window**
* **Monotonic Data Maintenance**
* **OS-level scheduling**

---

## 🧩 Queue/Deque Patterns

---

### 1. ✅ **Basic Queue Operations**

Use built-in queue or implement using arrays/lists.

🧠 **When to Use:**
→ Tasks are processed **in the order they arrive**.

📌 **Questions**:

* [Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/)
* [Design Circular Queue](https://leetcode.com/problems/design-circular-queue/)
* [Number of Recent Calls](https://leetcode.com/problems/number-of-recent-calls/)
* [Moving Average from Data Stream](https://leetcode.com/problems/moving-average-from-data-stream/)

---

### 2. ✅ **Breadth First Search (BFS) Using Queue**

BFS traversal for graphs, trees, and grids.

🧠 **When to Use:**
→ To explore elements **level by level**.

📌 **Questions**:

* [Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)
* [Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree/)
* [Rotting Oranges](https://leetcode.com/problems/rotting-oranges/)
* [Walls and Gates (Leetcode Premium)](https://leetcode.com/problems/walls-and-gates/)
* [Shortest Path in Binary Matrix](https://leetcode.com/problems/shortest-path-in-binary-matrix/)

---

### 3. ✅ **Monotonic Queue (Sliding Window Max/Min)**

Maintain **maximum or minimum** value in a **sliding window** using deque.

🧠 **When to Use:**
→ For window-based **min/max tracking in O(n)**.

📌 **Questions**:

* [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)
* [First Negative Integer in Every Window of Size K (GFG)](https://www.geeksforgeeks.org/first-negative-integer-every-window-size-k/)
* [Maximum of All Subarrays of Size K (GFG)](https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/)

---

### 4. ✅ **Deque for Palindrome / Index Tracking**

Use **both ends of a deque** for symmetry problems or **index tracking**.

📌 **Questions**:

* [Palindrome Checker (GFG)](https://www.geeksforgeeks.org/check-if-a-given-string-is-palindrome-using-deque/)
* [Sliding Window Maximum (Index Trick)](https://leetcode.com/problems/sliding-window-maximum/)
* [Design Front Middle Back Queue (Leetcode Premium)](https://leetcode.com/problems/design-front-middle-back-queue/)

---

### 5. ✅ **Multi-Level Queue / Priority-Based Queue**

Advanced system simulations using multiple queues or combining **priority logic**.

📌 **Questions**:

* [Dota2 Senate](https://leetcode.com/problems/dota2-senate/)
* [Design Hit Counter](https://leetcode.com/problems/design-hit-counter/)
* [LRU Cache (Uses deque + hashmap)](https://leetcode.com/problems/lru-cache/)

---

## 🧠 Tips to Master Queue/Deque:

* BFS always uses a queue — remember to **mark visited nodes early**.
* Deque is essential for **O(n) max/min window problems**.
* Understand when to use **deque vs queue**:
  → Deque: flexible both-end access
  → Queue: simple FIFO processing
* Combine deque with **index logic** in problems like `Sliding Window Max`.

---

## ✅ Final Thoughts

Once you master:

* Standard queue operations
* BFS traversal
* Monotonic queue patterns
* Real-time sliding window problems

You’ll be fully prepared for **company rounds involving traversal, scheduling, and stream processing** — these problems are **very common in Amazon, Microsoft, and Google**.

