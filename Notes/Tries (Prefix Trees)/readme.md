
# 📚 DSA Topic: **Tries (Prefix Trees)**

A **Trie** (pronounced "try") is a special tree used to store **strings** (usually lowercase English words).
It's ideal for **fast prefix lookups**, **word suggestions**, and **dictionary-like queries**.

---

## 🧩 Trie Patterns and Use-Cases

---

### 1. ✅ **Basic Trie Insertion & Search**

Each node represents a character. Use a `children[26]` array or HashMap to map next characters.

🧠 **When to Use:**
→ Fast lookup of prefixes, exact word search, autocomplete, or spell-checking.

📌 **Questions**:

* [Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/)
* [Add and Search Word - Data structure design](https://leetcode.com/problems/add-and-search-word-data-structure-design/)
* [Search Suggestions System](https://leetcode.com/problems/search-suggestions-system/)

---

### 2. ✅ **Prefix Count and AutoComplete**

Track how many words start with a given prefix or suggest top K matches.

📌 **Questions**:

* [Search Suggestions System](https://leetcode.com/problems/search-suggestions-system/)
* [Longest Word in Dictionary](https://leetcode.com/problems/longest-word-in-dictionary/)
* [Replace Words](https://leetcode.com/problems/replace-words/)
* [Prefix Matching (GFG)](https://www.geeksforgeeks.org/prefix-matching-using-trie/)

---

### 3. ✅ **Word Dictionary / Wildcard Support**

Handle patterns like `addWord("bad"), search(".ad")` where `.` is any letter.

📌 **Questions**:

* [Add and Search Word - Design](https://leetcode.com/problems/add-and-search-word-data-structure-design/)
* [Design a Search Autocomplete System (Hard)](https://leetcode.com/problems/design-search-autocomplete-system/)

---

### 4. ✅ **Trie + DFS or Backtracking**

Combine trie with backtracking/DFS to speed up word search.

📌 **Questions**:

* [Word Search II](https://leetcode.com/problems/word-search-ii/)
* [Concatenated Words](https://leetcode.com/problems/concatenated-words/)
* [Stream of Characters](https://leetcode.com/problems/stream-of-characters/)

---

### 5. ✅ **Bitwise Trie (for Numbers)**

Use tries for **bit manipulation problems** like XOR, max AND pairs, etc.

📌 **Questions**:

* [Maximum XOR of Two Numbers in an Array](https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/)
* [Find Maximum XOR With an Element From Array (Hard)](https://leetcode.com/problems/maximum-xor-with-an-element-from-array/)
* [Count of Pairs with Given XOR](https://www.geeksforgeeks.org/count-number-of-pairs-with-given-xor/)

---

## 🧠 Tips to Master Trie:

* Use **Node class with 26 children (or HashMap)** and a `isWordEnd` flag.
* When asked for:

  * **Starts with** → Use prefix logic
  * **Wildcard matching** → Combine DFS with `.`
  * **Autocomplete** → DFS from a prefix node
* For number problems, **treat each number as a binary string** for bitwise trie.

---

## ✅ Final Thoughts

Mastering Tries means you’re ready to:

* Solve **word-based problems with blazing speed**
* Tackle **Google-level autocomplete logic**
* Blend **tree, string, and backtracking logic**

This topic is **loved in big tech interviews** because it blends logic, optimization, and structure.

---
