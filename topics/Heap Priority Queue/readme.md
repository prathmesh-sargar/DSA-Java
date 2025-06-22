
# 📚 DSA Topic: **Heaps & Priority Queues**

A **Heap** is a special **binary tree-based structure** that satisfies the **heap property**:

* **Max-Heap**: Parent ≥ children
* **Min-Heap**: Parent ≤ children

A **Priority Queue** is a data structure built using a heap to serve elements by priority.

---

## 🧩 Patterns and Use Cases of Heaps

---

### 1. ✅ **Top K Elements**

Heap helps track largest/smallest K elements efficiently using `O(n log k)`.

🧠 **When to Use:**
→ Whenever you’re asked for **top/smallest/largest K elements**.

📌 **Questions**:

* [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)
* [Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)
* [Find K Closest Elements](https://leetcode.com/problems/find-k-closest-elements/)
* [K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/)

---

### 2. ✅ **Sort Using Heap**

Heap Sort is a classic sorting algorithm using Max Heap.

📌 **Questions**:

* [Sort Characters by Frequency](https://leetcode.com/problems/sort-characters-by-frequency/)
* [Reorganize String](https://leetcode.com/problems/reorganize-string/)
* [Merge K Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/)
* [Sort a Nearly Sorted Array](https://www.geeksforgeeks.org/nearly-sorted-algorithm/)

---

### 3. ✅ **Running Median / Dynamic Stream**

Use two heaps (min + max) to maintain balance and find the median in stream.

📌 **Questions**:

* [Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/)
* [Sliding Window Median (Hard)](https://leetcode.com/problems/sliding-window-median/)
* [Heaps in Real-Time Median](https://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/)

---

### 4. ✅ **Greedy Scheduling (Custom Priority Queues)**

Problems that require **dynamic ordering based on weights, deadlines, or cost**.

📌 **Questions**:

* [Task Scheduler](https://leetcode.com/problems/task-scheduler/)
* [IPO (Hard)](https://leetcode.com/problems/ipo/)
* [Minimum Cost to Connect Sticks](https://leetcode.com/problems/minimum-cost-to-connect-sticks/)
* [Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii/)

---

### 5. ✅ **Heap + Map Combo**

When elements are **updated frequently**, use `heap + hashmap` to ensure valid tracking.

📌 **Questions**:

* [Design Twitter](https://leetcode.com/problems/design-twitter/)
* [Least Number of Unique Integers After K Removals](https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/)
* [Dota2 Senate (also uses Queue)](https://leetcode.com/problems/dota2-senate/)

---

## 🧠 Tips to Master Heaps

* Use `heapq` in Python (default is min-heap) or `PriorityQueue` in Java.
* For max-heap in Python: push `-val` or use `heapq._heapify_max` carefully.
* Always **track custom elements** with tuples:
  `(priority, data)` → useful in real scheduling
* Understand the logic behind **two heaps**: max-heap on left, min-heap on right for median problems.
* **Don’t overuse heap**: in some problems, sorting + sliding window is faster.

---

## ✅ Final Thoughts

Mastering Heaps means:

* You can optimize problems that involve **"top K"** or **streamed data**
* You can use **greedy strategies with dynamic priority**
* You're fully ready for **Facebook, Google, Amazon style problems**

