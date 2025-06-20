
# 📚 DSA Topic: **Two Pointers & Sliding Window**

These are **pointer-based techniques** to reduce time complexity from brute-force `O(n²)` to `O(n)` or `O(n log n)`.
They're **efficient, elegant, and often preferred by interviewers**.

---

## 🧩 Patterns under Two Pointers & Sliding Window

---

### 1. ✅ **Two Pointers - Opposite Ends**

Use one pointer from the start and one from the end. Move them based on conditions.

🧠 **When to Use:**
→ Sorted arrays, target sums, or problems where both sides can be processed simultaneously.

📌 **Questions**:

* [Two Sum II - Input Array is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)
* [Reverse String](https://leetcode.com/problems/reverse-string/)
* [Palindrome String Check](https://leetcode.com/problems/valid-palindrome/)
* [Container With Most Water](https://leetcode.com/problems/container-with-most-water/)
* [Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/)

---

### 2. ✅ **Two Pointers - Same Direction (Fast & Slow)**

Both pointers move in the same direction — slow pointer lags behind to **track window or condition**.

🧠 **When to Use:**
→ When tracking ranges, substrings, or subarrays.

📌 **Questions**:

* [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)
* [Move Zeroes](https://leetcode.com/problems/move-zeroes/)
* [Remove Element](https://leetcode.com/problems/remove-element/)
* [Sort Colors (Dutch Flag)](https://leetcode.com/problems/sort-colors/)
* [Linked List Cycle (Floyd’s Algorithm)](https://leetcode.com/problems/linked-list-cycle/)

---

### 3. ✅ **Sliding Window - Fixed Size**

Keep a window of `k` elements and slide forward while maintaining a running sum/count.

📌 **Questions**:

* [Maximum Average Subarray I](https://leetcode.com/problems/maximum-average-subarray-i/)
* [Max Sum Subarray of Size K (GFG)](https://www.geeksforgeeks.org/find-maximum-average-subarray-of-k-length/)
* [First Negative Integer in Every Window of Size K (GFG)](https://www.geeksforgeeks.org/first-negative-integer-every-window-size-k/)

---

### 4. ✅ **Sliding Window - Variable Size**

Dynamic window expands and shrinks based on the condition.

🧠 **When to Use:**
→ When asked to find **longest/shortest subarray/substring** satisfying a condition.

📌 **Questions**:

* [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
* [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/)
* [Longest Substring with At Most K Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/)
* [Subarray Product Less Than K](https://leetcode.com/problems/subarray-product-less-than-k/)

---

### 5. ✅ **Prefix Sum + Two Pointers**

When total or average is needed **within ranges** using `start` and `end` pointers.

📌 **Questions**:

* [Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/)
* [Longest Subarray with Sum at Most K (GFG)](https://www.geeksforgeeks.org/longest-sub-array-sum-k/)
* [Shortest Subarray with Sum at Least K](https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/)

---

### 6. ✅ **Sliding Window + HashMap / HashSet**

Handle **frequency, duplicates, or character tracking** in sliding window.

📌 **Questions**:

* [Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/)
* [Permutation in String](https://leetcode.com/problems/permutation-in-string/)
* [Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/)
* [Fruit Into Baskets](https://leetcode.com/problems/fruit-into-baskets/)

---

## 🧠 Tips to Master Two Pointers & Sliding Window

* Two pointers → for **sorted arrays**, strings, or **search problems**.
* Sliding window → for **range-based optimization** (min/max sum, longest substring).
* Use **HashMap** if you're tracking characters in window.
* Don’t forget to **shrink window** when constraints break.
* Carefully manage edge cases: window size, duplicate chars, etc.

---

## ✅ Final Thoughts

Mastering:

* Both ends (start + end) pointer logic
* Dynamic window expansion/contraction
* Integration with frequency maps

Will make you confident in **intermediate-to-advanced level array and string problems**, and boost your speed during coding interviews.

---
