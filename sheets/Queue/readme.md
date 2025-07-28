
## 📌 QUEUE DSA CONCEPT SHEET

### ✅ 1. What is a Queue?

* **FIFO**: First In, First Out
* Think of a **line at the ATM** or **printer queue**.
* Used in:

  * BFS (Breadth First Search)
  * Caching systems
  * CPU/task scheduling
  * Level-order traversal in Trees

---

### ✅ 2. Java Queue Declaration

```java
Queue<Integer> q = new LinkedList<>();
```

Java doesn't allow direct Queue instantiation — we use `LinkedList` or `ArrayDeque`.

---

### ✅ 3. Common Queue Methods

| Method      | Description                                      |
| ----------- | ------------------------------------------------ |
| `add(x)`    | Adds `x` to queue (throws error if full)         |
| `offer(x)`  | Adds `x` to queue (returns false if fails)       |
| `poll()`    | Removes and returns head (null if empty)         |
| `remove()`  | Removes and returns head (throws error if empty) |
| `peek()`    | Returns head without removing (null if empty)    |
| `element()` | Same as peek but throws error if empty           |
| `isEmpty()` | Checks if queue is empty                         |

---

### ✅ 4. Queue Types You Should Know

| Type             | Description                 | Use Case                         |
| ---------------- | --------------------------- | -------------------------------- |
| `Queue`          | Basic FIFO                  | BFS, simple tasks                |
| `Deque`          | Double-ended queue          | Palindrome, sliding window       |
| `PriorityQueue`  | Min/Max heap                | Dijkstra, Kth largest element    |
| `Circular Queue` | Fixed-size with wrap-around | Caching, memory-constrained apps |

---

### ✅ 5. Custom Queue with Array (Manual)

```java
class MyQueue {
    int[] arr = new int[1000];
    int front = 0, rear = 0;

    void enqueue(int x) {
        arr[rear++] = x;
    }

    int dequeue() {
        return arr[front++];
    }

    boolean isEmpty() {
        return front == rear;
    }

    int peek() {
        return arr[front];
    }
}
```

---

### ✅ 6. Queue Problem Patterns (🔥Leetcode Favorites)

| Pattern                 | Examples                                                    |
| ----------------------- | ----------------------------------------------------------- |
| **BFS** in Trees/Graphs | `102. Level Order Traversal`, `994. Rotting Oranges`        |
| **Sliding Window**      | `239. Sliding Window Maximum`, `567. Permutation in String` |
| **Monotonic Queue**     | `862. Shortest Subarray with Sum ≥ K`                       |
| **Queue + Visited Set** | `773. Sliding Puzzle`, `752. Open the Lock`                 |
| **Simulations**         | `1700. Number of Students Unable to Eat Lunch`              |
| **Topological Sorting** | `207. Course Schedule` (use queue + indegree)               |

---

### ✅ 7. BFS Template using Queue (Very Important)

```java
Queue<TreeNode> q = new LinkedList<>();
q.offer(root);

while (!q.isEmpty()) {
    int size = q.size();
    for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();

        // Process node
        if (node.left != null) q.offer(node.left);
        if (node.right != null) q.offer(node.right);
    }
}
```

---

### ✅ 8. PriorityQueue in Java

#### ✅ Min Heap (default behavior)

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
```

#### ✅ Max Heap

```java
PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
```

---

### ✅ 9. Deque (Double-Ended Queue)

```java
Deque<Integer> dq = new ArrayDeque<>();
dq.addFirst(x); // like stack
dq.addLast(x);  // like queue
dq.removeFirst(); // stack pop
dq.removeLast();  // opposite end
```

Used in:

* Sliding Window Maximum
* Palindrome checkers
* Efficient two-end processing

---

### ✅ 10. Tips While Solving Queue Problems

* ⚠️ Always use `.offer()` and `.poll()` over `.add()` and `.remove()` (avoids exceptions).
* 💡 In **BFS**, use `visited[]` or `Set` to avoid reprocessing.
* 🎯 Queue size matters → `int size = q.size()` is used to track levels.
* 🔥 For **sliding windows**, use **Deque** (helps in O(n)).

---

### ✅ Recommended Leetcode Questions (Queue Starter Pack)

| Level  | Questions                                                                            |
| ------ | ------------------------------------------------------------------------------------ |
| Easy   | 933. Number of Recent Calls, 225. Implement Stack using Queues                       |
| Medium | 102. Binary Tree Level Order Traversal, 994. Rotting Oranges, 200. Number of Islands |
| Hard   | 239. Sliding Window Maximum, 207. Course Schedule                                    |

---

### ⚡ Bonus: Queue vs Stack Differences

| Feature    | Stack                   | Queue                       |
| ---------- | ----------------------- | --------------------------- |
| Order      | LIFO                    | FIFO                        |
| Use Cases  | Recursion, Backtracking | BFS, Scheduling             |
| Methods    | `push`, `pop`           | `offer`, `poll`             |
| Java Class | `Stack<T>`              | `Queue<T>` via `LinkedList` |

---
