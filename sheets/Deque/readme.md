

## 🧩 What’s a Deque?

* **Name**: “Double Ended Queue” (pronounced *deck*).
* **Super-power**: Add or remove elements from **both front and back** in O(1) time.
* **Interface**: `java.util.Deque` (extends `Queue`).

---

## 🔧 How to Declare

```java
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.LinkedList;

// Most common
Deque<Integer> dq = new ArrayDeque<>();

// Or
Deque<String> dq2 = new LinkedList<>();
```

**Tip:**

* `ArrayDeque` is faster and doesn’t allow `null`.
* `LinkedList` supports `null` but is slightly heavier.

---

## 🏎️ Adding Elements

| Method                                                  | Adds to… | Throws exception on fail? | Returns special value? |
| ------------------------------------------------------- | -------- | ------------------------- | ---------------------- |
| `addFirst(e)`                                           | front    | Yes                       | —                      |
| `addLast(e)`                                            | back     | Yes                       | —                      |
| `offerFirst(e)`                                         | front    | —                         | `true/false`           |
| `offerLast(e)`                                          | back     | —                         | `true/false`           |
| Shorthand queue style: `add(e)` or `offer(e)` = addLast |          |                           |                        |

💡 **Use `offer*` when you don’t want exceptions if it’s full**.

---

## 🏁 Removing Elements

| Method                                          | From… | Throws if empty? | Returns special value if empty |
| ----------------------------------------------- | ----- | ---------------- | ------------------------------ |
| `removeFirst()`                                 | front | Yes              | —                              |
| `removeLast()`                                  | back  | Yes              | —                              |
| `pollFirst()`                                   | front | —                | `null`                         |
| `pollLast()`                                    | back  | —                | `null`                         |
| Queue style: `remove()` / `poll()` = from front |       |                  |                                |

---

## 👀 Peeking / Accessing Without Remove

| Method                       | Position |
| ---------------------------- | -------- |
| `getFirst()` / `peekFirst()` | front    |
| `getLast()`  / `peekLast()`  | back     |

* `get*` throws if empty.
* `peek*` returns `null` if empty.

---

## 🎯 Handy Utilities

```java
dq.size();      // number of elements
dq.isEmpty();   // true if empty
dq.clear();     // remove all
```

Iterating:

```java
for (int x : dq) { ... }
```

---

## 🌟 Classic Use Cases

| Problem Pattern            | Why Deque Rocks                                                      |
| -------------------------- | -------------------------------------------------------------------- |
| **Sliding Window Max/Min** | Maintain a decreasing/increasing queue of indexes for O(n) solution. |
| **Monotonic Queue**        | Track running max/min in streaming data.                             |
| **Palindrome check**       | Compare front and back characters easily.                            |
| **BFS / Level Order**      | Works like a regular queue.                                          |
| **Stack simulation**       | Use only `addFirst`/`removeFirst` like a stack (LIFO).               |

---

## ⚡ Common Templates

### 1. Sliding Window Max (Monotonic Deque)

```java
Deque<Integer> dq = new ArrayDeque<>();
for (int i = 0; i < nums.length; i++) {
    if (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst();
    while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.pollLast();
    dq.offerLast(i);
    if (i >= k - 1) ans[i - k + 1] = nums[dq.peekFirst()];
}
```

### 2. Simple Queue

```java
Deque<Integer> q = new ArrayDeque<>();
q.offer(10);
q.offer(20);
System.out.println(q.poll()); // 10
```

### 3. Stack

```java
Deque<Integer> stack = new ArrayDeque<>();
stack.push(10); // same as addFirst
stack.push(20);
System.out.println(stack.pop()); // 20
```

---

## 🧠 Quick Remember

* **add/offer** = put in
* **remove/poll** = take out
* **get/peek** = just look
* **First / Last** = front / back

