
# 📚 DSA Topic: **Trees (Binary Trees + Binary Search Trees)**

A **tree** is a **non-linear** hierarchical data structure consisting of nodes, where each node has a value and references to child nodes.
Two major types you’ll frequently use:

* **Binary Tree (BT)** – each node has at most 2 children
* **Binary Search Tree (BST)** – left < root < right

---

## 🧩 Tree-Based Patterns

---

### 1. ✅ **Tree Traversals**

Basic way to visit all nodes in a tree in a certain order.

📌 **Types**:

* **Inorder (LNR)** – left → root → right
* **Preorder (NLR)** – root → left → right
* **Postorder (LRN)** – left → right → root
* **Level Order** – BFS

📌 **Questions**:

* [Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/)
* [Binary Tree Preorder Traversal](https://leetcode.com/problems/binary-tree-preorder-traversal/)
* [Binary Tree Postorder Traversal](https://leetcode.com/problems/binary-tree-postorder-traversal/)
* [Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)
* [Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)

---

### 2. ✅ **Recursive Tree Problems (DFS)**

Use recursion to go deep and solve subproblems from bottom-up.

📌 **Questions**:

* [Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/)
* [Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/)
* [Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree/)
* [Same Tree](https://leetcode.com/problems/same-tree/)
* [Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/)

---

### 3. ✅ **Binary Search Tree (BST) Logic**

Use sorted property: left < root < right.

🧠 **When to Use:**
→ When you need fast searching, insertion, and deletion.

📌 **Questions**:

* [Search in a BST](https://leetcode.com/problems/search-in-a-binary-search-tree/)
* [Validate BST](https://leetcode.com/problems/validate-binary-search-tree/)
* [Lowest Common Ancestor of BST](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)
* [Insert into a BST](https://leetcode.com/problems/insert-into-a-binary-search-tree/)
* [Delete Node in a BST](https://leetcode.com/problems/delete-node-in-a-bst/)

---

### 4. ✅ **Lowest Common Ancestor (LCA)**

Find the lowest node in the tree that is an ancestor of two given nodes.

📌 **Questions**:

* [LCA of Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)
* [LCA of BST](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)

---

### 5. ✅ **Path Problems**

Track paths, sums, or node sequences.

📌 **Questions**:

* [Path Sum](https://leetcode.com/problems/path-sum/)
* [Path Sum II](https://leetcode.com/problems/path-sum-ii/)
* [Binary Tree Paths](https://leetcode.com/problems/binary-tree-paths/)
* [Sum Root to Leaf Numbers](https://leetcode.com/problems/sum-root-to-leaf-numbers/)
* [Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/)

---

### 6. ✅ **Tree Construction from Traversals**

Rebuild the tree given its traversals.

📌 **Questions**:

* [Construct Binary Tree from Preorder and Inorder](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)
* [Construct Binary Tree from Inorder and Postorder](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
* [Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)

---

### 7. ✅ **Morris Traversal (Advanced)**

Inorder traversal with **O(1) space**.

📌 **Questions**:

* [Binary Tree Inorder Traversal (Hard – without stack/recursion)](https://leetcode.com/problems/binary-tree-inorder-traversal/)

---

## 🧠 Tips to Master Trees

* Draw the **recursive call stack** to deeply understand tree recursion.
* Use **BFS (Queue)** for level-wise logic, **DFS (Stack/Recursion)** for depth-based.
* For BSTs: always apply **sorted order logic**.
* For LCA, practice both for **BT** and **BST** — they're very different.
* Don’t forget **edge cases**: null nodes, single node, unbalanced trees.

---

## ✅ Final Thoughts

Mastering Trees will help you:

* Ace questions in **Amazon, Microsoft, Google interviews**
* Build confidence in **recursion + tree logic**
* Prepare for **complex structures** like Segment Trees, Heaps, and Tries
