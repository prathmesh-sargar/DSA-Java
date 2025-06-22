
# 📚 DSA Topic: **Backtracking**

**Backtracking** is a recursive algorithmic technique to solve problems by **building a solution incrementally**, abandoning a path as soon as it is known it cannot lead to a valid solution.

> Think of it as: “**Try → Go Ahead → Fail? → Backtrack & Try Another**”

---

## 🧩 Backtracking Patterns and Use Cases

---

### 1. ✅ **Permutation & Combination Generation**

Explore **all arrangements or selections** of items.

📌 **Questions**:

* [Permutations](https://leetcode.com/problems/permutations/)
* [Permutations II (with duplicates)](https://leetcode.com/problems/permutations-ii/)
* [Combinations](https://leetcode.com/problems/combinations/)
* [Combination Sum](https://leetcode.com/problems/combination-sum/)
* [Combination Sum II (no duplicate solutions)](https://leetcode.com/problems/combination-sum-ii/)

---

### 2. ✅ **Subsets and Power Sets**

Explore **all subsets (2ⁿ)** of a given array.

📌 **Questions**:

* [Subsets](https://leetcode.com/problems/subsets/)
* [Subsets II (with duplicates)](https://leetcode.com/problems/subsets-ii/)
* [Letter Case Permutation](https://leetcode.com/problems/letter-case-permutation/)
* [Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/)

---

### 3. ✅ **N-Queens / Board Problems**

Used for placing elements with constraints on a **2D board**.

📌 **Questions**:

* [N-Queens](https://leetcode.com/problems/n-queens/)
* [Sudoku Solver](https://leetcode.com/problems/sudoku-solver/)
* [Word Search](https://leetcode.com/problems/word-search/)
* [Knight’s Tour (GFG)](https://www.geeksforgeeks.org/the-knights-tour-problem-backtracking-example/)

---

### 4. ✅ **Decision Trees / Binary Choices**

Explore paths like **yes/no, include/exclude**.

📌 **Questions**:

* [Generate Parentheses](https://leetcode.com/problems/generate-parentheses/)
* [Expression Add Operators](https://leetcode.com/problems/expression-add-operators/)
* [Flip String to Monotone Increasing](https://leetcode.com/problems/flip-string-to-monotone-increasing/)
* [Restore IP Addresses](https://leetcode.com/problems/restore-ip-addresses/)

---

### 5. ✅ **Backtracking with Constraints**

Where certain moves are restricted — **prune** early.

📌 **Questions**:

* [Word Break II](https://leetcode.com/problems/word-break-ii/)
* [Beautiful Arrangement](https://leetcode.com/problems/beautiful-arrangement/)
* [Minimum Number of Increments on Subarrays to Form a Target Array (Hard)](https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/)
* [Factor Combinations](https://leetcode.com/problems/factor-combinations/)

---

## 🧠 Backtracking Template (Pseudocode)

```js
function backtrack(path, choices):
    if goal reached:
        result.append(path)
        return

    for choice in choices:
        if valid(choice):
            make choice
            backtrack(path + choice, new_choices)
            undo choice
```

---

## 🧠 Tips to Master Backtracking

* Think in terms of **"decision tree"** — every node is a partial solution.
* **Prune** unnecessary branches early using constraints.
* Use **visited\[]**, `startIndex`, or hashsets to avoid duplicates.
* Master template-based thinking: recursion → base case → explore → backtrack.
* Start from **easy problems** → then add constraints gradually.

---

## ✅ Final Thoughts

Mastering backtracking means:

* You can handle problems with **combinatorics, constraints, and sequences**
* You're interview-ready for **Google, Facebook, Atlassian, and top product companies**
* You’ll become confident in writing recursive solutions with **smart pruning**

