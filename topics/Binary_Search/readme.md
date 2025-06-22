
# 📚 DSA Topic: **Binary Search**

Binary Search is not just about finding an element in a sorted array. It's a **technique** that helps solve many problems efficiently — even **unsorted problems can be converted into binary search** on answer/range/condition!

---

## 🧩 Binary Search Patterns

---

### 1. ✅ **Classic Binary Search (on Sorted Array)**

The basic pattern — divide and conquer until the target is found.

🧠 **When to Use:**
→ Array is sorted and you need to **find an exact element**.

📌 **Questions**:

* [Binary Search](https://leetcode.com/problems/binary-search/)
* [Guess Number Higher or Lower](https://leetcode.com/problems/guess-number-higher-or-lower/)
* [Search Insert Position](https://leetcode.com/problems/search-insert-position/)
* [First Bad Version](https://leetcode.com/problems/first-bad-version/)

---

### 2. ✅ **Binary Search on Answer (Search Space)**

Also called **"Binary Search on the Range"** — used when you're not searching for a value directly but **finding the minimum or maximum possible value**.

🧠 **When to Use:**
→ The answer lies within a **range (like 1 to N)** and you're asked to find a **maximum or minimum** satisfying a condition.

📌 **Questions**:

* [Koko Eating Bananas](https://leetcode.com/problems/koko-eating-bananas/)
* [Minimum Number of Days to Make m Bouquets](https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/)
* [Capacity To Ship Packages Within D Days](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/)
* [Find the Smallest Divisor Given a Threshold](https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/)
* [Split Array Largest Sum](https://leetcode.com/problems/split-array-largest-sum/)

---

### 3. ✅ **Binary Search on Rotated Sorted Array**

Array is sorted but **rotated at some pivot**. You'll need to handle **split sorted parts**.

📌 **Questions**:

* [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)
* [Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
* [Search in Rotated Sorted Array II (with duplicates)](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/)

---

### 4. ✅ **Find First / Last Occurrence**

Classic variation where the **target occurs multiple times**, and you need to find **first or last index**.

📌 **Questions**:

* [Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
* [Count Occurrences of a Number (GFG)](https://www.geeksforgeeks.org/count-number-of-occurrences-in-a-sorted-array/)
* [Find Peak Element](https://leetcode.com/problems/find-peak-element/)

---

### 5. ✅ **Binary Search on 2D Matrix**

Convert a 2D matrix into a 1D indexable space using `row * col + colIndex`.

📌 **Questions**:

* [Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/)
* [Search a 2D Matrix II](https://leetcode.com/problems/search-a-2d-matrix-ii/)
* [Matrix Median (GFG)](https://www.geeksforgeeks.org/find-median-row-wise-sorted-matrix/)

---

### 6. ✅ **Upper Bound / Lower Bound (Ceiling / Floor)**

Find the smallest/largest number **greater/lesser than the target**.

📌 **Questions**:

* [Ceiling in a Sorted Array (GFG)](https://www.geeksforgeeks.org/ceiling-in-a-sorted-array/)
* [Find Smallest Letter Greater Than Target](https://leetcode.com/problems/find-smallest-letter-greater-than-target/)
* [Floor in a Sorted Array (GFG)](https://www.geeksforgeeks.org/floor-in-a-sorted-array/)

---

### 7. ✅ **Binary Search with Greedy Logic**

Sometimes you apply binary search with a **greedy condition** inside to validate a mid value.

📌 **Questions**:

* [Aggressive Cows (SPOJ/GFG)](https://www.spoj.com/problems/AGGRCOW/)
* [Book Allocation Problem (GFG)](https://www.geeksforgeeks.org/allocate-minimum-number-pages/)
* [Painter’s Partition Problem (GFG)](https://www.geeksforgeeks.org/painters-partition-problem/)

---

## 🧠 Tips to Master Binary Search:

* Always ask yourself:
  👉 "Can I apply binary search on this array?"
  👉 "Can I convert this into a range where I can apply binary search?"

* Remember:

  * `low = 0`, `high = n - 1`
  * Mid calculation: `mid = low + (high - low) / 2`
  * Adjust `low` and `high` carefully (`<=`, `<`, `>=` matter!)

* Learn **binary search templates**:

  * First occurrence
  * Last occurrence
  * Binary Search on range

---

## ✅ Final Thoughts

If you master:

* Classic binary search
* Rotated & 2D binary search
* Binary search on answers
* Greedy + binary search combo

Then you can solve **some of the trickiest real-world problems and company questions**, especially in **Amazon, Google, and Meta** rounds.

---
