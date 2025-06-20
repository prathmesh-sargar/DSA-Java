
# 📚 DSA Topic: **Graphs – BFS, DFS, Topological Sort, Dijkstra, Union Find**

A **graph** is a set of nodes connected by edges. It can be:

* **Directed / Undirected**
* **Weighted / Unweighted**
* **Cyclic / Acyclic**

Used in problems involving **connections, paths, dependencies, and components**.

---

## 🧩 Graph Patterns and Algorithms

---

### 1. ✅ **Graph Representation**

Store graphs using:

* **Adjacency List** (most common)
* **Adjacency Matrix**
* **Edge List**

📌 **Questions**:

* [Graph Valid Tree](https://leetcode.com/problems/graph-valid-tree/)
* [Find if Path Exists in Graph](https://leetcode.com/problems/find-if-path-exists-in-graph/)
* [Find the Town Judge](https://leetcode.com/problems/find-the-town-judge/)

---

### 2. ✅ **Depth-First Search (DFS)**

Explore as far as possible before backtracking. Used for:

* Path finding
* Cycle detection
* Connected components

📌 **Questions**:

* [Number of Islands](https://leetcode.com/problems/number-of-islands/)
* [Flood Fill](https://leetcode.com/problems/flood-fill/)
* [Surrounded Regions](https://leetcode.com/problems/surrounded-regions/)
* [Max Area of Island](https://leetcode.com/problems/max-area-of-island/)

---

### 3. ✅ **Breadth-First Search (BFS)**

Level-order traversal of graph — good for shortest path in **unweighted graphs**.

📌 **Questions**:

* [Shortest Path in Binary Matrix](https://leetcode.com/problems/shortest-path-in-binary-matrix/)
* [Rotting Oranges](https://leetcode.com/problems/rotting-oranges/)
* [Word Ladder](https://leetcode.com/problems/word-ladder/)
* [Open the Lock](https://leetcode.com/problems/open-the-lock/)

---

### 4. ✅ **Topological Sort (Kahn's Algo / DFS Stack)**

Used in **DAGs (Directed Acyclic Graphs)** to find ordering of tasks with dependencies.

📌 **Questions**:

* [Course Schedule](https://leetcode.com/problems/course-schedule/)
* [Course Schedule II](https://leetcode.com/problems/course-schedule-ii/)
* [Alien Dictionary (Hard)](https://leetcode.com/problems/alien-dictionary/)
* [Parallel Courses](https://leetcode.com/problems/parallel-courses/)

---

### 5. ✅ **Cycle Detection**

Find cycles using:

* DFS with visited+recStack (Directed)
* Union-Find / BFS for undirected graphs

📌 **Questions**:

* [Course Schedule (Cycle Check)](https://leetcode.com/problems/course-schedule/)
* [Detect Cycle in Undirected Graph (GFG)](https://www.geeksforgeeks.org/detect-cycle-undirected-graph/)
* [Redundant Connection](https://leetcode.com/problems/redundant-connection/)
* [Find Eventual Safe States](https://leetcode.com/problems/find-eventual-safe-states/)

---

### 6. ✅ **Dijkstra's Algorithm (Shortest Path in Weighted Graph)**

Use min-heap to compute shortest paths from source.

📌 **Questions**:

* [Network Delay Time](https://leetcode.com/problems/network-delay-time/)
* [Path with Minimum Effort](https://leetcode.com/problems/path-with-minimum-effort/)
* [Cheapest Flights Within K Stops](https://leetcode.com/problems/cheapest-flights-within-k-stops/)

---

### 7. ✅ **Union Find (Disjoint Set)**

Used for:

* Cycle detection
* Connected components
* Kruskal’s MST

📌 **Questions**:

* [Accounts Merge](https://leetcode.com/problems/accounts-merge/)
* [Graph Valid Tree](https://leetcode.com/problems/graph-valid-tree/)
* [Redundant Connection](https://leetcode.com/problems/redundant-connection/)
* [Number of Connected Components in an Undirected Graph](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/)

---

### 8. ✅ **Minimum Spanning Tree (MST)**

Find the lowest-cost subset of edges connecting all nodes.

📌 **Questions**:

* [Kruskal’s Algorithm (GFG)](https://www.geeksforgeeks.org/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/)
* [Prim’s Algorithm (GFG)](https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/)
* [Connecting Cities With Minimum Cost (Leetcode)](https://leetcode.com/problems/min-cost-to-connect-all-points/)

---

## 🧠 Tips to Master Graphs

* Always clarify if the graph is **directed/undirected**, **weighted/unweighted**, and **cyclic/acyclic**.
* Use `visited[]` array to prevent revisits.
* For shortest path:

  * **Unweighted** → use **BFS**
  * **Weighted** → use **Dijkstra**
* Understand **difference between DFS and BFS** deeply.
* For Topological sort, know both **DFS-based** and **Kahn’s Algorithm** (BFS-based).

---

## ✅ Final Thoughts

Graph mastery means:

* You're ready to build **navigation systems, dependency resolvers, and AI paths**
* You can solve questions across **Google, Microsoft, Adobe, Flipkart, Codenation, and Infosys**
* You become confident with **recursive + iterative + greedy + backtracking** logic

