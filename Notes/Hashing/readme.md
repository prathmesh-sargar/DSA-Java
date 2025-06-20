
# 📚 DSA Topic: **Hashing – HashMap / HashSet / Frequency Maps**

**Hashing** uses a function to map data to a **fixed-size table**. It's used to store key-value pairs efficiently with constant-time access (in average case).

It forms the core of:

* Frequency counting
* Detecting duplicates
* Caching
* Lookup optimization

---

## 🧩 Hashing Patterns and Use-Cases

---

### 1. ✅ **Frequency Counting**

Use a HashMap to count characters, numbers, or strings.

📌 **Questions**:

* [Majority Element](https://leetcode.com/problems/majority-element/)
* [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)
* [Sort Characters by Frequency](https://leetcode.com/problems/sort-characters-by-frequency/)
* [Group Anagrams](https://leetcode.com/problems/group-anagrams/)
* [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/)

---

### 2. ✅ **Detecting Duplicates**

Detect repeated items in `O(n)` time.

📌 **Questions**:

* [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)
* [Contains Duplicate II](https://leetcode.com/problems/contains-duplicate-ii/)
* [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
* [Check if Two Strings Are Isomorphic](https://leetcode.com/problems/isomorphic-strings/)

---

### 3. ✅ **Prefix Sum + HashMap**

Track prefix sums and their frequencies to solve subarray problems.

📌 **Questions**:

* [Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/)
* [Continuous Subarray Sum](https://leetcode.com/problems/continuous-subarray-sum/)
* [Longest Substring with Equal 0s and 1s (GFG)](https://www.geeksforgeeks.org/longest-subarray-with-equal-number-of-0s-and-1s/)

---

### 4. ✅ **HashSet for Unordered Uniqueness**

Use a set to store only **unique elements** or track visited items.

📌 **Questions**:

* [Happy Number](https://leetcode.com/problems/happy-number/)
* [Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/)
* [Intersection of Two Arrays](https://leetcode.com/problems/intersection-of-two-arrays/)
* [Valid Sudoku](https://leetcode.com/problems/valid-sudoku/)

---

### 5. ✅ **Custom Hashing (Pairs, Tuples, etc.)**

Sometimes you must hash **pairs or custom structures** (like `(i, j)` index or grid).

📌 **Questions**:

* [Number of Boomerangs](https://leetcode.com/problems/number-of-boomerangs/)
* [Maximum Size Subarray Sum Equals K](https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/)
* [Word Pattern](https://leetcode.com/problems/word-pattern/)
* [Max Points on a Line](https://leetcode.com/problems/max-points-on-a-line/)

---

### 6. ✅ **Sliding Window + HashMap**

When you want a **window-based frequency tracker** (used in many substring problems).

📌 **Questions**:

* [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/)
* [Permutation in String](https://leetcode.com/problems/permutation-in-string/)
* [Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/)
* [Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/)

---

## 🧠 Tips to Master Hashing

* For frequency: `map[char]++`
* For checking presence: `if (set.contains(x))`
* For prefix sum + hash: store `sum` and use `map[sum - k]` to check subarray
* Always clear/reset maps when doing sliding window across multiple strings

---

## ✅ Final Thoughts

Mastering Hashing helps you:

* Reduce brute force `O(n^2)` to `O(n)`
* Build efficient lookups, counters, and validations
* Solve **core interview problems in Amazon, Google, Adobe, and Flipkart**

It’s **essential** and one of the **top 3 most used techniques** in all online judges.

