
# 📚 DSA Topic: **Greedy Algorithms**

Greedy algorithms work by making **locally optimal choices** at each step with the hope of reaching a **globally optimal solution**. They are **faster than DP** but not always applicable — the key is recognizing when **greedy logic guarantees correctness**.

---

## 🧩 Greedy Patterns

---

### 1. ✅ **Activity Selection / Interval Scheduling**

Pick the **maximum number of non-overlapping activities**.

🧠 **When to Use:**
→ Select tasks without overlap, based on start/end times.

📌 **Questions**:

* [Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/)
* [Meeting Rooms](https://leetcode.com/problems/meeting-rooms/)
* [Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii/)
* [Minimum Number of Arrows to Burst Balloons](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/)
* [Maximum Length of Pair Chain](https://leetcode.com/problems/maximum-length-of-pair-chain/)

---

### 2. ✅ **Minimum Platforms / Merge Intervals**

Optimize the number of platforms/resources needed by **merging overlapping intervals**.

📌 **Questions**:

* [Merge Intervals](https://leetcode.com/problems/merge-intervals/)
* [Minimum Number of Platforms Required (GFG)](https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaystation/)
* [Insert Interval](https://leetcode.com/problems/insert-interval/)

---

### 3. ✅ **Job Sequencing / Scheduling**

Schedule tasks to **maximize profit or minimize cost** under constraints.

📌 **Questions**:

* [Job Sequencing Problem (GFG)](https://www.geeksforgeeks.org/job-sequencing-problem/)
* [Task Scheduler](https://leetcode.com/problems/task-scheduler/)
* [Reorganize String](https://leetcode.com/problems/reorganize-string/)

---

### 4. ✅ **Huffman Coding / Greedy Tree Construction**

Used in **compression problems**, where frequency of elements matters.

📌 **Questions**:

* [Huffman Encoding (GFG)](https://www.geeksforgeeks.org/huffman-coding-greedy-algo-3/)
* [Reorganize String](https://leetcode.com/problems/reorganize-string/)
* [Minimum Cost of Connecting Ropes](https://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/)

---

### 5. ✅ **Fractional Knapsack**

Unlike 0/1 knapsack, you **can take fractions** — sort items by value/weight ratio.

📌 **Questions**:

* [Fractional Knapsack (GFG)](https://www.geeksforgeeks.org/fractional-knapsack-problem/)

---

### 6. ✅ **Greedy for Coins / Jumps / Reductions**

Greedy logic is used to **reduce a number optimally** or **minimize jumps**.

📌 **Questions**:

* [Jump Game](https://leetcode.com/problems/jump-game/)
* [Jump Game II](https://leetcode.com/problems/jump-game-ii/)
* [Reduce Array Size to the Half](https://leetcode.com/problems/reduce-array-size-to-the-half/)
* [Minimum Number of Taps to Open to Water a Garden](https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/)

---

### 7. ✅ **Greedy with Sorting**

Many greedy problems involve **sorting elements by custom logic**, like by deadlines, end times, or values.

📌 **Questions**:

* [Greedy Florist (HackerRank)](https://www.hackerrank.com/challenges/greedy-florist/problem)
* [Assign Cookies](https://leetcode.com/problems/assign-cookies/)
* [Boats to Save People](https://leetcode.com/problems/boats-to-save-people/)
* [Two City Scheduling](https://leetcode.com/problems/two-city-scheduling/)

---

## 🧠 Tips to Master Greedy Algorithms:

* Greedy is **fast** but doesn’t always work → verify that greedy works **mathematically** or **logically**.
* Always **sort the input** if needed before greedy steps.
* If a DP solution is too slow, ask yourself: “Can greedy work here?”
* Prefer greedy when:

  * Goal = **min/max**
  * Items can be **partially taken or skipped**
  * You're choosing **one at a time** from sorted options

---

## ✅ Final Thoughts

Once you master:

* Interval problems
* Scheduling and selection
* Min/max with sorting
* Fractional knapsack and jump logic

You’ll be able to solve **many problems in O(N log N)** that would otherwise take **DP with O(N²)**.

---
