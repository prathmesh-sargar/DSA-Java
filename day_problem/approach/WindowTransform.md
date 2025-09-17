
## 📝 Problem Statement

You are given an integer array `arr` and an integer `k`.

* Slide a window of size `k` across the array **one element at a time**.
* For each window:

  1. If the **sum of the elements in the window is even**, **reverse** the window.
  2. If the sum is odd, **sort** the window in ascending order.
* Collect all elements from these processed windows in their traversal order **without duplicates** while maintaining the order of first appearance.
* Return the final list of unique integers.

---

## 🔹 Input / Output

**Input:**

* Integer array `arr` (length `n`)
* Integer `k` (window size)

**Output:**

* A list of integers (unique, in order of first occurrence) gathered after processing every window.

**Example:**

```
arr = [5, 2, 9, 1, 7, 4, 6]
k   = 3
```

**Output:**

```
[9, 2, 5, 1, 7, 4, 6]
```

---

## 💡 Approach

1. **Edge Case:**

   * If `n < k`, return an empty list because no full window exists.

2. **Initialize Sliding Window:**

   * Compute the sum of the first `k` elements to start.

3. **Iterate Over Each Window (start → n-k):**

   * Extract the current window using `Arrays.copyOfRange`.
   * **Check sum parity:**

     * If sum is even → reverse the window in place.
     * Else → sort the window.
   * Add processed window elements to a `LinkedHashSet` (`seen`) to keep order and avoid duplicates.

4. **Update Window Sum Efficiently:**

   * For next iteration, subtract the element going out and add the new incoming element.

5. **Return Result:**

   * Convert `seen` to an `ArrayList` and return.

---

## 🧩 Sample Code Logic

```java
public static List<Integer> process(int[] arr, int k) {
    Set<Integer> seen = new LinkedHashSet<>();
    int n = arr.length;
    if (n < k) return new ArrayList<>();

    int windowSum = 0;
    for (int i = 0; i < k; i++) windowSum += arr[i];

    for (int start = 0; start <= n - k; start++) {
        int[] window = Arrays.copyOfRange(arr, start, start + k);

        if (windowSum % 2 == 0) {           // even → reverse
            for (int l = 0, r = k - 1; l < r; l++, r--) {
                int tmp = window[l];
                window[l] = window[r];
                window[r] = tmp;
            }
        } else {                            // odd → sort
            Arrays.sort(window);
        }

        for (int num : window) seen.add(num);

        if (start + k < n)                  // slide window
            windowSum = windowSum - arr[start] + arr[start + k];
    }
    return new ArrayList<>(seen);
}
```

---

## ⏱️ Time Complexity

* **Initial sum:** `O(k)`
* **For each of the (n - k + 1) windows:**

  * Copy window: `O(k)`
  * Reverse or sort: `O(k)` for reverse, `O(k log k)` for sort.
* Worst case: **O((n - k + 1) \* k log k)**.

  * If k is small compared to n, this is roughly **O(n k log k)**.

## 🗂️ Space Complexity

* Extra structures:

  * Window array of size k → **O(k)**
  * `LinkedHashSet` for unique elements → up to n → **O(n)**.
* Total: **O(n + k)**.

---

⚡ **Final Example**
Input: `arr = [5, 2, 9, 1, 7, 4, 6], k = 3`
Processing windows yields: `[9, 2, 5, 1, 7, 4, 6]` ✅

---
