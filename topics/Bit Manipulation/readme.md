
# 📚 DSA Topic: **Bit Manipulation**

Bit Manipulation uses operations like **AND, OR, XOR, NOT, SHIFT** directly on binary representations of numbers.
This allows for:

* Ultra-fast computation
* Space-efficient solutions
* Elegant tricks in number theory

---

## 🧩 Common Bitwise Operators

| Operation   | Symbol | Example (a=5, b=3)   | Result    |       |           |
| ----------- | ------ | -------------------- | --------- | ----- | --------- |
| AND         | `&`    | `5 & 3 → 101 & 011`  | `001 → 1` |       |           |
| OR          | `\|`   | \`5                  | 3 → 101   | 011\` | `111 → 7` |
| XOR         | `^`    | `5 ^ 3 → 101 ^ 011`  | `110 → 6` |       |           |
| NOT         | `~`    | `~5 → -6` (2's comp) |           |       |           |
| Left Shift  | `<<`   | `5 << 1 → 1010`      | `10`      |       |           |
| Right Shift | `>>`   | `5 >> 1 → 010`       | `2`       |       |           |

---

## 🧠 Patterns and Popular Bit Manip Tricks

---

### 1. ✅ **Check Power of 2 / 4 / 8**

```js
n > 0 && (n & (n - 1)) == 0  // Power of 2
```

📌 **Questions**:

* [Power of Two](https://leetcode.com/problems/power-of-two/)
* [Power of Four](https://leetcode.com/problems/power-of-four/)
* [Power of Three](https://leetcode.com/problems/power-of-three/) *(for comparison)*

---

### 2. ✅ **Count Set Bits (Brian Kernighan’s Algo)**

Reduce `n = n & (n-1)` until `n == 0`

📌 **Questions**:

* [Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits/)
* [Counting Bits](https://leetcode.com/problems/counting-bits/)
* [Minimum Bit Flips to Convert Number](https://leetcode.com/problems/minimum-bit-flips-to-convert-number/)

---

### 3. ✅ **Find Single / Unique Number**

Use **XOR** property: `a ^ a = 0` and `a ^ 0 = a`

📌 **Questions**:

* [Single Number](https://leetcode.com/problems/single-number/)
* [Single Number II](https://leetcode.com/problems/single-number-ii/)
* [Single Number III](https://leetcode.com/problems/single-number-iii/)
* [Missing Number](https://leetcode.com/problems/missing-number/)

---

### 4. ✅ **Swap Using XOR**

```js
a = a ^ b  
b = a ^ b  
a = a ^ b
```

🧠 Used in:

* Space-efficient algorithms
* Memory-level tricks

---

### 5. ✅ **Bitmasking for Subsets / Combinations**

Loop through all combinations of N bits using:
`for (int mask = 0; mask < (1 << N); mask++)`

📌 **Questions**:

* [Subsets](https://leetcode.com/problems/subsets/)
* [Maximum XOR of Two Numbers](https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/)
* [Count Number of Maximum Bitwise-OR Subsets](https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/)

---

### 6. ✅ **Bitmask DP / Memoization**

Use integer masks as states for memoization.

📌 **Questions**:

* [Partition to K Equal Sum Subsets (Hard)](https://leetcode.com/problems/partition-to-k-equal-sum-subsets/)
* [Smallest Sufficient Team (Hard)](https://leetcode.com/problems/smallest-sufficient-team/)
* [Maximum AND Sum of Array](https://leetcode.com/problems/maximum-and-sum-of-array/)

---

### 7. ✅ **Gray Code (Bit Logic Based Sequence)**

Special binary sequence where only one bit changes at a time.

📌 **Questions**:

* [Gray Code](https://leetcode.com/problems/gray-code/)
* [Binary Watch](https://leetcode.com/problems/binary-watch/)

---

## 🧠 Tips to Master Bit Manipulation

* **XOR** is a secret weapon in many number problems.
* `n & (n - 1)` removes **last set bit** → useful in optimization.
* Use `1 << i` to check/set/clear ith bit.
* Visualize binary when solving — draw 0s and 1s.
* Useful in **subsets, toggles, encoding, cryptography, compression.**

---

## ✅ Final Thoughts

Mastering Bit Manipulation helps you:

* Solve **space and time efficient problems**
* Stand out in **coding contests and top company rounds**
* Unlock **low-level logic mastery** (used in compilers, drivers, AI logic trees)
