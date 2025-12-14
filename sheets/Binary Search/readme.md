
```md
# 📌 Binary Search – Complete Cheat Sheet (Placement Ready)

This document is a **complete revision guide** for Binary Search.
It covers **all major patterns**, **edge cases**, **templates**, and **interview logic**.

If you master everything here, Binary Search is DONE for placements.

---

## 1️⃣ What is Binary Search (Real Meaning)

Binary Search is **NOT just searching in a sorted array**.

Binary Search =  
👉 Searching in a **monotonic search space**  
👉 Where the answer changes from **false → true** (or reverse)

```

false false false true true true

````

Whenever you see this pattern → Binary Search applies.

---

## 2️⃣ When to Use Binary Search (IDENTIFICATION RULES)

Ask these questions:

### ✅ Rule 1: Is the data sorted or partially sorted?
- Sorted array
- Rotated sorted array
- 2D matrix with row-wise order

### ✅ Rule 2: Is the answer within a range?
- Minimum / maximum value
- Capacity / speed / days / pages
- “Find smallest X such that…”

### ✅ Rule 3: Can I check an answer X in O(n)?
If YES → Binary Search on Answer

---

## 3️⃣ Core Binary Search Templates (Java)

### 🔹 Classic Binary Search (Exact Match)

```java
while (low <= high) {
    int mid = low + (high - low) / 2;

    if (nums[mid] == target) return mid;
    else if (nums[mid] < target) low = mid + 1;
    else high = mid - 1;
}
return -1;
````

---

### 🔹 First Occurrence (Left Boundary)

```java
while (low <= high) {
    int mid = low + (high - low) / 2;

    if (nums[mid] >= target) {
        ans = mid;
        high = mid - 1;
    } else {
        low = mid + 1;
    }
}
```

---

### 🔹 Last Occurrence (Right Boundary)

```java
while (low <= high) {
    int mid = low + (high - low) / 2;

    if (nums[mid] <= target) {
        ans = mid;
        low = mid + 1;
    } else {
        high = mid - 1;
    }
}
```

---

## 4️⃣ Binary Search on 2D Matrix

Treat matrix as a **1D sorted array**.

### Mapping:

```
row = mid / cols
col = mid % cols
```

### Template:

```java
low = 0;
high = rows * cols - 1;

while (low <= high) {
    int mid = low + (high - low) / 2;
    int r = mid / cols;
    int c = mid % cols;

    if (matrix[r][c] == target) return true;
    else if (matrix[r][c] < target) low = mid + 1;
    else high = mid - 1;
}
```

---

## 5️⃣ Rotated Sorted Array (NO duplicates)

### Key Idea:

👉 One half is always sorted

### Template:

```java
if (nums[low] <= nums[mid]) {
    // left sorted
    if (nums[low] <= target && target < nums[mid])
        high = mid - 1;
    else
        low = mid + 1;
} else {
    // right sorted
    if (nums[mid] < target && target <= nums[high])
        low = mid + 1;
    else
        high = mid - 1;
}
```

---

## 6️⃣ Rotated Sorted Array (WITH duplicates)

### Problem:

```
nums[low] == nums[mid] == nums[high]
```

No direction info.

### Solution:

```java
low++;
high--;
```

### Full Rule Order:

1. If target found → return true
2. If duplicates → shrink
3. Else check sorted half

---

## 7️⃣ Find Minimum in Rotated Sorted Array

### Without duplicates:

```java
while (low < high) {
    int mid = low + (high - low) / 2;

    if (nums[mid] > nums[high])
        low = mid + 1;
    else
        high = mid;
}
return nums[low];
```

### With duplicates:

```java
if (nums[mid] == nums[high])
    high--;
```

---

## 8️⃣ Binary Search on Answer (MOST IMPORTANT)

### General Pattern:

```java
low = minimum_possible_answer
high = maximum_possible_answer

while (low <= high) {
    mid = low + (high - low) / 2;

    if (check(mid)) {
        answer = mid;
        high = mid - 1;
    } else {
        low = mid + 1;
    }
}
return answer;
```

---

## 9️⃣ Ceiling Logic (VERY IMPORTANT)

When work **cannot be split**:

### ❌ Wrong:

```java
hours += pile / speed;
```

### ✅ Correct:

```java
hours += (pile + speed - 1) / speed;
```

Equivalent to:

```java
Math.ceil((double)pile / speed)
```

---

## 🔟 Binary Search on Answer – Must-Know Problems

| Problem                 | Answer Means             |
| ----------------------- | ------------------------ |
| Koko Eating Bananas     | Minimum speed            |
| Min Days for Bouquets   | Minimum day              |
| Ship Packages           | Minimum capacity         |
| Split Array Largest Sum | Minimum max subarray sum |
| Book Allocation         | Minimum max pages        |
| Painter’s Partition     | Minimum max time         |

---

## 1️⃣1️⃣ Feasibility Check Pattern (Greedy)

General rule:

* Traverse array
* Accumulate work
* If exceeds limit → new group
* Count groups

If groups ≤ allowed → feasible

---

## 1️⃣2️⃣ Edge Cases Checklist (INTERVIEW GOLD)

Always check:

* Empty array
* Single element
* `m * k > n` (bouquets)
* `students > books`
* `max element > mid`
* Overflow in `mid` calculation

---

## 1️⃣3️⃣ Common Binary Search Mistakes

❌ Using `low = mid - 1`
❌ Infinite loops due to wrong boundaries
❌ Sorting when order matters
❌ Forgetting monotonic condition
❌ Mixing two different strategies

---

## 1️⃣4️⃣ One-Line Interview Rule

> If the question asks for
> **“minimum / maximum X such that…”**
> → Binary Search on Answer.

---

## 1️⃣5️⃣ Final Advice (READ THIS)

* Don’t memorize code
* Memorize **decision logic**
* Every binary search is:

  1. Search space
  2. Condition
  3. Boundary control

If these three are clear → you can code ANY binary search problem.

---