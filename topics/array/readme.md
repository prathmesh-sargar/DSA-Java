
## 📚 DSA Topic: Arrays

Mastering the **Array** topic is the first key step in cracking DSA interviews. Below are **essential patterns**, each with a brief explanation and **curated Leetcode problems** that help you build deep understanding and pattern recognition.

---

### 🧩 Array Patterns

---

#### 1. ✅ **Two Pointers**

Used when working on sorted arrays or strings to **reduce time complexity**. Involves using two indices moving toward each other or in the same direction.

**When to use?**
→ Problems involving **pair checking, sorting, merging, duplicates**.

📌 **Questions**:

* [Two Sum II - Input array is sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)
* [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)
* [Reverse String](https://leetcode.com/problems/reverse-string/)
* [Container With Most Water](https://leetcode.com/problems/container-with-most-water/)
* [3Sum](https://leetcode.com/problems/3sum/)

---

#### 2. ✅ **Sliding Window**

Efficient for **contiguous subarray** problems involving sums, averages, max/min values, etc.

**When to use?**
→ When dealing with **window/k-sized subarrays**.

📌 **Questions**:

* [Maximum Average Subarray I](https://leetcode.com/problems/maximum-average-subarray-i/)
* [Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)
* [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
* [Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/)
* [Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/)

---

#### 3. ✅ **Kadane’s Algorithm**

Used to find the **maximum subarray sum** in O(n). It's a must-know DP-like linear technique.

📌 **Questions**:

* [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)
* [Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/)
* [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
* [Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/)

---

#### 4. ✅ **Prefix Sum**

Helps in reducing time complexity of multiple subarray sum queries.

📌 **Questions**:

* [Range Sum Query - Immutable](https://leetcode.com/problems/range-sum-query-immutable/)
* [Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/)
* [Pivot Index](https://leetcode.com/problems/find-pivot-index/)
* [Minimum Value to Get Positive Step by Step Sum](https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/)

---

#### 5. ✅ **Sorting-Based Problems**

Sorting enables optimization in many problems — especially around **intersections, duplicates, or intervals**.

📌 **Questions**:

* [Merge Intervals](https://leetcode.com/problems/merge-intervals/)
* [Insert Interval](https://leetcode.com/problems/insert-interval/)
* [Sort Colors](https://leetcode.com/problems/sort-colors/)
* [Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii/)

---

#### 6. ✅ **Hashing with Arrays**

Useful when solving **frequency-based** problems or quick lookups.

📌 **Questions**:

* [Two Sum](https://leetcode.com/problems/two-sum/)
* [Intersection of Two Arrays](https://leetcode.com/problems/intersection-of-two-arrays/)
* [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)
* [Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/)

---

#### 7. ✅ **Binary Search in Arrays**

Used for **searching efficiently** in sorted arrays.

📌 **Questions**:

* [Search Insert Position](https://leetcode.com/problems/search-insert-position/)
* [Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
* [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)
* [Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/)

---

#### 8. ✅ **Greedy (Array-based)**

Used where a **local optimal choice** leads to a global solution.

📌 **Questions**:

* [Jump Game](https://leetcode.com/problems/jump-game/)
* [Jump Game II](https://leetcode.com/problems/jump-game-ii/)
* [Gas Station](https://leetcode.com/problems/gas-station/)
* [Candy](https://leetcode.com/problems/candy/)

---

#### 9. ✅ **Miscellaneous Must-Know**

A few questions that involve **combinations of above patterns** or logical tricks.

📌 **Questions**:

* [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)
* [Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/)
* [Rotate Array](https://leetcode.com/problems/rotate-array/)
* [Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/)
* [Spiral Matrix](https://leetcode.com/problems/spiral-matrix/)

---

### 🧠 Key Tips for Mastery

* 🔁 **Revise frequently**: Come back to key problems after 7–10 days.
* 📝 **Dry run tricky problems**: Don’t skip the ones you fail.
* 🚀 **Focus on approach first**, then code.
* 📌 **Tag your GitHub code** with pattern name inside folders for easy tracking.

---

## ✅ Problem: Find Pivot Index

### 🧠 Input:

```java
nums = [1, 7, 3, 6, 5, 6]
```

### 🎯 Output:

```java
3
```

> At index 3, the sum of elements to the left (`1+7+3 = 11`) is equal to the sum of elements to the right (`5+6 = 11`).

---

## 💡 Approach: Use Left Sum & Right Sum Logic

### 🔥 Core Idea:

* You want to find an index `i` where:

  ```
  leftSum == rightSum
  ```
* Instead of calculating the sum on both sides for every index (which takes O(n²)), we use:

  ```
  rightSum = totalSum - leftSum - nums[i]
  ```
* This allows us to **solve it in one pass** after computing total sum.

---

### 🧱 Steps:

1. Calculate total sum of the array.
2. Initialize `leftSum = 0`.
3. Loop over the array:

   * At index `i`, calculate `rightSum = totalSum - leftSum - nums[i]`.
   * If `leftSum == rightSum`, return index `i` (pivot index).
   * Else, add `nums[i]` to `leftSum` and continue.
4. If no pivot is found, return `-1`.

---

### 🔁 Sample Code Snippet:

```java
public static int pivotIndex(int[] nums) {
    int totalSum = 0;
    for (int num : nums) {
        totalSum += num;
    }

    int leftSum = 0;
    for (int i = 0; i < nums.length; i++) {
        int rightSum = totalSum - leftSum - nums[i];
        if (leftSum == rightSum) {
            return i;
        }
        leftSum += nums[i];
    }

    return -1;
}
```

---

### ✅ Dry Run:

```java
nums = [1, 7, 3, 6, 5, 6]
totalSum = 28

i = 0 → left = 0, right = 27 → ❌  
i = 1 → left = 1, right = 20 → ❌  
i = 2 → left = 8, right = 17 → ❌  
i = 3 → left = 11, right = 11 → ✅ return 3
```

---

### 📈 Time & Space Complexity:

| Operation              | Complexity |
| ---------------------- | ---------- |
| Time                   | O(n)       |
| Space (no extra array) | O(1)       |

---

### ✅ Summary:

* Use prefix logic without building extra arrays.
* Efficient one-pass check with `leftSum` & `rightSum`.
* Returns the **leftmost** pivot index.

---
