
# 📚 DSA Topic: **Dynamic Programming (DP)**

Dynamic Programming is used when problems have **overlapping subproblems** and **optimal substructure**. It is all about breaking problems into smaller subproblems and **storing the results (memoization/tabulation)** to avoid recomputation.

---

## 🧩 Dynamic Programming Patterns

---

### 1. ✅ **0/1 Knapsack Pattern**

Each item can either be included or excluded — used in **choice-based DP** problems.

🧠 **When to Use:**
→ Whenever a problem says “pick/not pick”, “yes/no”, or involves **weights, profits, limits**.

📌 **Questions**:

* [0/1 Knapsack (GFG)](https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/)
* [Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/)
* [Target Sum](https://leetcode.com/problems/target-sum/)
* [Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/)
* [Count of Subset Sum](https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/)

---

### 2. ✅ **Unbounded Knapsack Pattern**

Unlike 0/1, you can **pick the same item multiple times** (repetition allowed).

📌 **Questions**:

* [Coin Change](https://leetcode.com/problems/coin-change/)
* [Coin Change II](https://leetcode.com/problems/coin-change-ii/)
* [Rod Cutting Problem (GFG)](https://www.geeksforgeeks.org/cutting-a-rod-dp-13/)
* [Minimum Number of Coins](https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/)

---

### 3. ✅ **Fibonacci-Type DP**

Solve the problem based on **n-1, n-2, etc.** — classic bottom-up or top-down problems.

📌 **Questions**:

* [Fibonacci Number](https://leetcode.com/problems/fibonacci-number/)
* [Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)
* [House Robber](https://leetcode.com/problems/house-robber/)
* [House Robber II](https://leetcode.com/problems/house-robber-ii/)
* [N-th Tribonacci Number](https://leetcode.com/problems/n-th-tribonacci-number/)

---

### 4. ✅ **DP on Strings**

Problems related to **LCS (Longest Common Subsequence)**, palindrome, etc.

🧠 **When to Use:**
→ Compare two strings, substrings, and palindromic structures.

📌 **Questions**:

* [Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/)
* [Longest Palindromic Subsequence](https://leetcode.com/problems/longest-palindromic-subsequence/)
* [Edit Distance](https://leetcode.com/problems/edit-distance/)
* [Distinct Subsequences](https://leetcode.com/problems/distinct-subsequences/)
* [Regular Expression Matching](https://leetcode.com/problems/regular-expression-matching/)

---

### 5. ✅ **DP on Subsets**

Divide input into two groups that satisfy certain conditions.

📌 **Questions**:

* [Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/)
* [Can Partition K Subsets](https://leetcode.com/problems/partition-to-k-equal-sum-subsets/)
* [Count of Subsets with Given Sum (GFG)](https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/)

---

### 6. ✅ **DP on Grids / 2D Matrix**

Move in a matrix with directions (right/down/diagonal).

📌 **Questions**:

* [Unique Paths](https://leetcode.com/problems/unique-paths/)
* [Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/)
* [Dungeon Game](https://leetcode.com/problems/dungeon-game/)
* [Cherry Pickup](https://leetcode.com/problems/cherry-pickup/)
* [Maximal Square](https://leetcode.com/problems/maximal-square/)

---

### 7. ✅ **Palindrome DP**

Use DP to analyze substrings that are palindromes.

📌 **Questions**:

* [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)
* [Palindromic Substrings](https://leetcode.com/problems/palindromic-substrings/)
* [Palindrome Partitioning II](https://leetcode.com/problems/palindrome-partitioning-ii/)

---

### 8. ✅ **DP on Trees / Graphs**

When solving tree or DAG (directed acyclic graph) problems with recursion + memo.

📌 **Questions**:

* [House Robber III (Tree)](https://leetcode.com/problems/house-robber-iii/)
* [Longest Path in a Tree (GFG)](https://www.geeksforgeeks.org/longest-path-undirected-tree/)
* [Minimum Height Trees](https://leetcode.com/problems/minimum-height-trees/)

---

## 🧠 Tips to Master DP:

* Master **Top-Down (Memoization)** → Recursion + cache
* Then learn **Bottom-Up (Tabulation)** → Iterative + table
* Learn **State Identification**: What changes in each call?
* Learn **State Transition**: How does `dp[i][j]` depend on previous states?

📘 Practice writing:

* Recurrence relation
* Base case
* Memo array or table logic

---

## ✅ Final Thoughts

Once you understand:

* Fibonacci, knapsack, and LCS base
* How to define subproblems
* How to write recurrence → then tabulate

You’ll be ready to crack **any Amazon, Google, or Flipkart-level DP interview**.

---
