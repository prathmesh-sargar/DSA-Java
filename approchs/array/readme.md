### ✅ Check if the array is sorted and rotated.


🔹 **Input:**
`[3, 4, 5, 1, 2]`

🔹 **Output:**
`true`

🔹 **Approach:**

* An array is **sorted and rotated** if it was originally sorted in ascending order and then rotated.
* We count how many times the **current element is greater than the next**.
* If this count is **more than 1**, the array is not sorted and rotated.
* We check rotation by counting **the number of drops** (i.e., `arr[i] > arr[i+1]`) in the array.

🔹 **Sample Code Snippet:**

```java
int count = 0;
for (int i = 0; i < arr.length; i++) {
    int next = (i + 1) % arr.length;
    if (arr[i] > arr[next]) {
        count++;
    }
}
System.out.println(count <= 1); // true if only one rotation point
```

---


### ✅ Check if the array is sorted in either increasing or decreasing order.


🔹 **Input:**
`[1, 2, 3, 4]` → ✅
`[5, 3, 1]` → ✅
`[1, 2, 2]` → ❌

🔹 **Output:**
`true` if the array is strictly increasing or strictly decreasing, else `false`

🔹 **Approach:**

* First, check the first two elements to guess the order (increasing or decreasing).
* Traverse the array:

  * If increasing, check `arr[i] < arr[i+1]`
  * If decreasing, check `arr[i] > arr[i+1]`
* If any condition breaks, return `false`.
* If the loop completes without breaking, return `true`.

🔹 **Sample Code Snippet:**

```java
public static boolean isSorted(int[] arr) {
    if (arr.length <= 1) return true;
    if (arr[0] < arr[1]) return isAscending(arr);
    else return isDescending(arr);
}

public static boolean isAscending(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        if (arr[i] >= arr[i + 1]) return false;
    }
    return true;
}

public static boolean isDescending(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        if (arr[i] <= arr[i + 1]) return false;
    }
    return true;
}
```
---


---

### ✅ Question: Find the Missing Number

🧠 Input: `[1, 2, 4, 5, 6]`
🎯 Output: `3`

#### 💡 Approach:

* Calculate the sum of the first `n` natural numbers using the formula `n(n+1)/2`, where `n = arr.length + 1`.
* Subtract the sum of the given array from this total.
* The difference is the missing number.

#### 🔁 Sample Code:

```java
int[] arr = {1, 2, 4, 5, 6};
int totalSum = (arr.length + 1) * (arr.length + 2) / 2;
int arrSum = 0;
for (int num : arr) arrSum += num;
int missing = totalSum - arrSum;
System.out.println("Missing number is: " + missing);
```

---

---

### ✅ Question: Frequency of Each Element

🧠 Input: `[10, 20, 10, 30, 20, 10]`
🎯 Output:

```
10 -> 3  
20 -> 2  
30 -> 1
```

#### 💡 Approach:

* Use a **HashMap** to store each number as a key and its frequency (count) as value.
* Traverse the array:

  * If the number already exists in the map, increment its count.
  * Otherwise, add it to the map with count `1`.
* Finally, print all key-value pairs using any of the 3 ways:

  * `entrySet()` → cleanest & most used
  * `keySet()` → when only keys are needed
  * `forEach()` → modern & short

#### 🔁 Sample Code:

```java
int[] arr = {10, 20, 10, 30, 20, 10};
HashMap<Integer, Integer> map = new HashMap<>();
for (int num : arr) {
    map.put(num, map.getOrDefault(num, 0) + 1);
}
map.forEach((key, value) -> System.out.println(key + " -> " + value));
```

---

---

### ✅ Question: Return the Subarray with Maximum Sum (Kadane's Algorithm)

🧠 Input: `[-2, 1, -3, 4, -1, 2, 1, -5, 4]`
🎯 Output: `[4, -1, 2, 1]` (sum = 6)

#### 💡 Approach:

* Use **Kadane’s Algorithm** to keep track of:

  * `current_max`: running sum of current subarray
  * `max_sum`: max sum seen so far
* Track subarray indices using `start`, `end`, and `tempStart`.
* If `current_max + arr[i] < arr[i]`, start a **new subarray** from index `i`.
* Update `max_sum` and range when a new max is found.

#### 🔁 Sample Code:

```java
int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
int maxSum = arr[0], currMax = arr[0];
int start = 0, end = 0, tempStart = 0;

for (int i = 1; i < arr.length; i++) {
    if (arr[i] > currMax + arr[i]) {
        currMax = arr[i];
        tempStart = i;
    } else {
        currMax += arr[i];
    }

    if (currMax > maxSum) {
        maxSum = currMax;
        start = tempStart;
        end = i;
    }
}

System.out.println("Max Subarray:");
for (int i = start; i <= end; i++) {
    System.out.print(arr[i] + " ");
}
```

---

---

### ✅ Question: Find All Leaders in an Array

🧠 Input: `[16, 17, 3, 5, 2]`
🎯 Output: `17 5 2`

#### 💡 Approach:

* An element is a **leader** if it is **greater than all elements to its right**.
* Start from the rightmost element — it is **always a leader**.
* Traverse the array in reverse and keep track of `maxRight`.
* If `arr[i] >= maxRight`, it's a leader → update `maxRight`.

#### 🔁 Sample Code:

```java
int[] arr = {16, 17, 3, 5, 2};
int maxRight = arr[arr.length - 1];

for (int i = arr.length - 1; i >= 0; i--) {
    if (arr[i] >= maxRight) {
        maxRight = arr[i];
        System.out.print(arr[i] + " ");
    }
}
```


---

### ✅ Question: Left Rotate Array by k positions

🧠 Input: `[1, 2, 3, 4, 5]`, `k = 3`
🎯 Output: `[4, 5, 1, 2, 3]`

#### 💡 Approach:

* Store the first `k` elements in a temporary array.
* Shift the rest of the array `k` steps to the left.
* Copy back the stored elements from the temp array to the end.

#### 🔁 Sample Code:

```java
int k = 3;
int[] temp = new int[k];
for (int i = 0; i < k; i++) temp[i] = arr[i];

for (int i = k; i < arr.length; i++) arr[i - k] = arr[i];

for (int i = 0; i < k; i++) arr[arr.length - k + i] = temp[i];
```


---

### ✅ Question: Left Rotate Array by `k` (using reversal, no extra space)

🧠 Input: `[1, 2, 3, 4, 5]`, `k = 2`
🎯 Output: `[3, 4, 5, 1, 2]`

#### 💡 Approach:

* Reverse the first `k` elements → `[2, 1, 3, 4, 5]`
* Reverse the rest → `[2, 1, 5, 4, 3]`
* Reverse the entire array → `[3, 4, 5, 1, 2]`

#### 🔁 Sample Code:

```java
public static void reverse(int[] arr, int start, int end) {
    while (start < end) {
        int temp = arr[start];
        arr[start++] = arr[end];
        arr[end--] = temp;
    }
}

public static void LeftRotate(int[] arr, int k) {
    int n = arr.length;
    k %= n;
    reverse(arr, 0, k - 1);
    reverse(arr, k, n - 1);
    reverse(arr, 0, n - 1);
}
```


---

### ✅ Question: Maximum Subarray Sum (Kadane’s Algorithm)

🧠 Input: `[-2, 1, -3, 4, -1, 2, 1, -5, 4]`
🎯 Output: `6` → (subarray `[4, -1, 2, 1]`)

#### 💡 Approach:

* Initialize `current_sum` and `max_sum` with first element.
* For each element, either extend the previous subarray or start a new one.
* Track max sum seen so far.

#### 🔁 Sample Code:

```java
int current_max = arr[0];
int max_sum = arr[0];

for(int i = 1; i < arr.length; i++) {
    current_max = Math.max(arr[i], current_max + arr[i]);
    max_sum = Math.max(max_sum, current_max);
}
System.out.println(max_sum);
```

---



### ✅ Question: Longest Consecutive 1’s in Binary Array

🧠 Input: `[1, 1, 0, 1, 1, 1]`
🎯 Output: `3`

#### 💡 Approach:

* Use two counters: `curr_max` for the current sequence of 1’s, and `max_sum` for the longest found.
* When `0` is found, reset `curr_max` to 0.
* Keep updating `max_sum = max(curr_max, max_sum)`.

#### 🔁 Sample Code:

```java
int max_sum = 0;
int curr_max = 0;

for(int i = 0; i < arr.length; i++) {
    if(arr[i] == 1) {
        curr_max++;
        max_sum = Math.max(curr_max, max_sum);
    } else {
        curr_max = 0;
    }
}
System.out.println("Max 1's: " + max_sum);
```

---


### ✅ Question: Remove Duplicates from Sorted Array (In-Place)

🧠 Input: `[1, 1, 2, 2, 3]`
🎯 Output: `1 2 3`

#### 💡 Approach:

* Use two pointers:

  * `j` tracks the position to insert the next unique element.
  * `i` traverses the array from index `1`.
* If `arr[i] != arr[j]`, move `j` forward and copy `arr[i]` to `arr[j]`.

#### 🔁 Sample Code:

```java
int j = 0;
for(int i = 1; i < arr.length; i++) {
    if(arr[j] != arr[i]) {
        j++;
        arr[j] = arr[i];
    }
}
for(int i = 0; i <= j; i++) {
    System.out.print(arr[i] + " ");
}
```

---

---

### ✅ Problem: Reverse the Array In-Place

🧠 Input: `[1, 2, 3, 4]`
🎯 Output: `[4, 3, 2, 1]`

#### 💡 Approach:

* Use two pointers:
  `start = 0`, `end = arr.length - 1`
* Swap `arr[start]` and `arr[end]` while `start < end`
* Increment `start`, decrement `end`

#### 🔁 Sample Code:

```java
int[] arr = {1, 2, 3, 4};
int start = 0;
int end = arr.length - 1;

while (start <= end) {
    int temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;
    start++;
    end--;
}
```

---



## 🔄 Reverse Array In-Place

**Input:** `[1, 2, 3, 4]`  
**Output:** `[4, 3, 2, 1]`

### ✅ Approach: Two Pointer

```java
int start = 0;
int end = arr.length - 1;

while (start <= end) {
    int temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;
    start++;
    end--;
}
````


### ✅ Right Rotate Array (In-Place, Without Extra Space)

Rotate an array to the **right by `k` positions**, using **no extra space**.

---

### 🧠 Input:

```java
[1, 2, 3, 4, 5], k = 1
```

### 🎯 Output:

```java
[5, 1, 2, 3, 4]
```

---

### 🔍 Approach (3-Step Reverse Method):

We use the **reverse method** to rotate the array efficiently **in O(n) time** and **O(1) space**.

#### ✅ Steps:

1. **Reverse the entire array** → `[5, 4, 3, 2, 1]`
2. **Reverse the first `k` elements** → `[5]` → stays the same
3. **Reverse the remaining `n-k` elements** → `[1, 2, 3, 4]`
4. Final result: `[5, 1, 2, 3, 4]`

---

### 🔧 Code:

```java
public class RightRotateWithoutSpace {

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void rightRotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n;

        // Step 1: Reverse whole array
        reverse(arr, 0, n - 1);

        // Step 2: Reverse first k elements
        reverse(arr, 0, k - 1);

        // Step 3: Reverse remaining elements
        reverse(arr, k, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 1;

        System.out.println("Original array:");
        for (int num : arr) System.out.print(num + " ");

        rightRotate(arr, k);

        System.out.println("\nRotated array:");
        for (int num : arr) System.out.print(num + " ");
    }
}
```

---

### 💡 Use Case:

* When you need to rotate large arrays in-place (no extra space allowed).
* Asked frequently in interviews (Amazon, Microsoft, Infosys).

---


### ✅ Question: Find the Second Largest Element in an Array

🧠 Input: `[2, 5, 1, 7, 3, 6]`
🎯 Output: `6`

---

#### 💡 Approach:

* Track both `max` and `secondMax`
* Update them while iterating:

  * If current element > `max`, update `secondMax = max`, `max = current`
  * Else if current > `secondMax` and not equal to `max`, update `secondMax`

---

#### 🔁 Sample Code (Logic Only):

```java
int max = arr[0];
int secondMax = Integer.MIN_VALUE;

for (int i = 1; i < arr.length; i++) {
    if (arr[i] > max) {
        secondMax = max;
        max = arr[i];
    } else if (arr[i] > secondMax && arr[i] != max) {
        secondMax = arr[i];
    }
}


🛠️ **Time:** O(n)
💾 **Space:** O(1)
```

---





---

### ✅ Question: Subarray with Given Sum (Positive Numbers Only)

🧠 **Input:** `arr = [1, 4, 20, 3, 10, 5]`, `k = 33`
🎯 **Output:** `[20, 3, 10]`

---

### 💡 Approach: Sliding Window

* This problem is perfect for the **sliding window technique**, since all elements are **positive**.
* Maintain a window from `start` to `end`
* Increase `end` and add to `current_sum`
* If `current_sum > k`, **shrink** the window from the `start`
* If `current_sum == k`, you found the subarray

---

### 🔁 Sample Code (Logic Only):

```java
int start = 0, curr_sum = 0;

for (int end = 0; end < arr.length; end++) {
    curr_sum += arr[end];

    while (curr_sum > k && start <= end) {
        curr_sum -= arr[start++];
    }

    if (curr_sum == k) {
        // Subarray found from index 'start' to 'end'
    }
}


🛠️ **Time Complexity:** O(n)
💾 **Space Complexity:** O(1)
```

---



### ✅ Question: Move All Zeros to the End

🧠 **Input:** `[0, 1, 0, 3, 12]`
🎯 **Output:** `[1, 3, 12, 0, 0]`

---

### 💡 Approach: Two Pointer Method

* Use pointer `j` to track the position of the next non-zero element.
* Traverse with pointer `i`:

  * If `arr[i] ≠ 0`, copy it to `arr[j]` and increment `j`.
* After processing all elements, fill the rest of the array (from index `j` to end) with `0`s.

---

### 🔁 Sample Code (Logic Only):

```java
int j = 0;
for (int i = 0; i < arr.length; i++) {
    if (arr[i] != 0) {
        arr[j++] = arr[i];
    }
}
while (j < arr.length) {
    arr[j++] = 0;
}


🛠️ **Time Complexity:** O(n)
💾 **Space Complexity:** O(1)
```

---



---

### ✅ Question: Two Sum – Find indices of two numbers such that their sum equals the target.

🧠 **Input:**
`arr = [2, 4, 7, 6, 8]`, `target = 13`

🎯 **Output:**
`[2, 3]` → because `7 + 6 = 13`

---

### 💡 Approach:

**Core Idea:**
We use a **HashMap** to keep track of the **elements we've already seen** and their **indices**.

---

### 🔁 Step-by-Step Logic:

1. **Start from index `i = 0` to end of array.**
2. For each element `arr[i]`, calculate its **complement** = `target - arr[i]`.
3. Check if the complement is already in the map:

   * ✅ If found → That means **arr\[i] + complement = target**, so return both indices.
   * ❌ If not → Store the current element in the map with its index: `map.put(arr[i], i)`.
4. If no such pair found by the end, return `[-1, -1]`.

---

### 🧪 Dry Run Example:

With: `arr = [2, 4, 7, 6, 8]`, `target = 13`

| i | arr\[i] | complement = 13 - arr\[i] | map                      | Found?           |
| - | ------- | ------------------------- | ------------------------ | ---------------- |
| 0 | 2       | 11                        | {2: 0}                   | ❌                |
| 1 | 4       | 9                         | {2: 0, 4: 1}             | ❌                |
| 2 | 7       | 6                         | {2: 0, 4: 1, 7: 2}       | ❌                |
| 3 | 6       | 7                         | ✅ 7 is in map at index 2 | ✅ return \[2, 3] |

So, output: `[2, 3]`

---

### ✅ Corrected Output for Your Code:

```java
arr = {2, 4, 7, 6, 8}, target = 13
Output: [2, 3] → because 7 + 6 = 13
```

---

### 🔁 Sample Code Logic (minimal):

```java
HashMap<Integer, Integer> map = new HashMap<>();

for (int i = 0; i < arr.length; i++) {
    int complement = target - arr[i];

    if (map.containsKey(complement)) {
        return new int[]{map.get(complement), i};
    }

    map.put(arr[i], i);
}
```

---

---

### ✅ Question: Maximum Difference (Optimized)

🧠 **Input:**
`[1, 5, 2, 10]`

🎯 **Output:**
`9` → `10 - 1`

---

### 💡 Optimized Approach (One Pass):

1. Initialize `minSoFar = arr[0]` to keep track of the **smallest element seen so far**.
2. Initialize `maxDiff = -1` to store the **maximum difference**.
3. Loop from index 1 to end:

   * If `arr[i] > minSoFar`, calculate difference: `arr[i] - minSoFar`
   * Update `maxDiff = max(maxDiff, diff)`
   * If `arr[i] < minSoFar`, update `minSoFar = arr[i]`
4. After the loop, `maxDiff` holds the result.

---

### ✅ Sample Code (Optimized):

```java
public class MaxDifferenceOptimized {
    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 10};
        int minSoFar = arr[0];
        int maxDiff = -1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > minSoFar) {
                int diff = arr[i] - minSoFar;
                maxDiff = Math.max(maxDiff, diff);
            } else {
                minSoFar = arr[i];
            }
        }

        System.out.println("Maximum Difference: " + maxDiff);
    }
}
```

---

### 🔁 Dry Run on `[1, 5, 2, 10]`

| i | arr\[i] | minSoFar | arr\[i] > min? | diff | maxDiff |
| - | ------- | -------- | -------------- | ---- | ------- |
| 1 | 5       | 1        | ✅              | 4    | 4       |
| 2 | 2       | 1        | ✅              | 1    | 4       |
| 3 | 10      | 1        | ✅              | 9    | 9       |

✅ Final Output: **`9`**

---

---

### ✅ Question: Maximum Difference

**Find the maximum difference between two elements such that the larger element appears after the smaller one.**

🧠 **Input:**
`[1, 5, 2, 10]`

🎯 **Output:**
`9` → `10 - 1 = 9`

---

### 💡 Approach:

1. Use **two nested loops** to compare every pair `(i, j)` where `i < j`.
2. Check if `arr[j] > arr[i]`, meaning the second number is larger and comes **after** the first.
3. If valid, calculate the difference: `arr[j] - arr[i]`.
4. Track the **maximum difference** seen so far using `maxDiff = Math.max(maxDiff, diff)`.

---

### 🔁 Step-by-step Dry Run:

For `arr = [1, 5, 2, 10]`

| i | j | arr\[i] | arr\[j] | Valid? | Diff | maxDiff |
| - | - | ------- | ------- | ------ | ---- | ------- |
| 0 | 1 | 1       | 5       | ✅      | 4    | 4       |
| 0 | 2 | 1       | 2       | ✅      | 1    | 4       |
| 0 | 3 | 1       | 10      | ✅      | 9    | 9       |
| 1 | 2 | 5       | 2       | ❌      | -    | 9       |
| 1 | 3 | 5       | 10      | ✅      | 5    | 9       |
| 2 | 3 | 2       | 10      | ✅      | 8    | 9       |

✅ Final **maxDiff = 9**

---

### 🧪 Edge Case:

If the array is strictly decreasing like `[5, 4, 3]`, there is no valid pair → Output: `-1`

---

### 🔁 Sample Code Logic:

```java
int maxDiff = -1;

for (int i = 0; i < arr.length; i++) {
    for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] > arr[i]) {
            int diff = arr[j] - arr[i];
            maxDiff = Math.max(maxDiff, diff);
        }
    }
}
```

---

---

### ✅ Question: Best Time to Buy and Sell Stock

🧠 **Input:** `prices = [7, 1, 5, 3, 6, 8]`
🎯 **Output:** `7`
📘 **Explanation:** Buy on day 2 (price = 1), sell on day 6 (price = 8). Profit = 8 - 1 = 7

---

### 💡 Optimized Approach (One Pass):

* Initialize `minPrice = prices[0]`
* Initialize `maxProfit = 0`
* Traverse the array from index 1 to n:

  * If `prices[i] < minPrice`, update `minPrice`
  * Else calculate profit: `prices[i] - minPrice`
  * Update `maxProfit` if profit is higher

---

### ✅ Sample Code (Optimized):

```java
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 8};
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int profit = prices[i] - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        System.out.println("Max Profit is: " + maxProfit);
    }
}
```

---

### 🔁 Dry Run on `[7, 1, 5, 3, 6, 8]`

| i | prices\[i] | minPrice | profit | maxProfit |
| - | ---------- | -------- | ------ | --------- |
| 1 | 1          | 1        | -      | 0         |
| 2 | 5          | 1        | 4      | 4         |
| 3 | 3          | 1        | 2      | 4         |
| 4 | 6          | 1        | 5      | 5         |
| 5 | 8          | 1        | 7      | 7         |

✅ Final Output: **`7`**

---

---

### ✅ Question: Maximum Distance Between Houses with Different Colors

🧠 **Input**: `[1, 1, 1, 6, 1, 1, 1]`
🎯 **Output**: `3`
🎯 **Goal**: Find the maximum distance between two houses having different colors.

---

### 💡 Approach:

* The problem is asking for the **maximum index difference** between two elements with **different values** (colors).
* You only need to compare:

  * The first element (`colors[0]`) with all elements from the **end to start**.
  * The last element (`colors[n - 1]`) with all elements from **start to end**.
* This reduces the number of comparisons needed and ensures the maximum distance is captured.

---

### 🔁 Sample Logic:

```java
// Check from the end for a different color from the start
for (int i = n - 1; i >= 0; i--) {
    if (colors[0] != colors[i]) {
        maxDist = Math.max(maxDist, i);
        break; // early exit for max distance from start
    }
}

// Check from the start for a different color from the end
for (int i = 0; i < n; i++) {
    if (colors[n - 1] != colors[i]) {
        maxDist = Math.max(maxDist, (n - 1) - i);
        break; // early exit for max distance from end
    }
}
```

---

### ✅ Output:

```java
maxDist: 3
```



---

### ✅ Question: Replace Elements with Greatest Element on Right Side

🧠 **Input**:
`arr = [17, 18, 5, 4, 6, 1]`
🎯 **Output**:
`[18, 6, 6, 6, 1, -1]`

---

### 💡 Approach:

* We need to **replace each element** in the array with the **greatest element on its right**.
* The **last element** will always be `-1` since it has no elements to its right.
* To solve this efficiently in **O(n)** time, we **traverse from the end** of the array:

  * Keep track of the **maximum element seen so far** (`maxRight`)
  * At each index:

    * Store the current element in a temporary variable
    * Replace the current index with `maxRight`
    * Update `maxRight` as the maximum between itself and the temp value

---

### 🔁 Sample Logic:

```java
int maxRight = -1;

for (int i = n - 1; i >= 0; i--) {
    int temp = arr[i];
    arr[i] = maxRight;
    maxRight = Math.max(maxRight, temp);
}
```

---

### ✅ Output:

```java
[18, 6, 6, 6, 1, -1]
```

---

### ✅ Question: Check If Array is Special (Even-Odd Alternating)

🧠 **Input**:
`nums = [2, 1, 4]`
🎯 **Output**:
`true`

---

### 📘 Definition:

An array is **special** if every pair of **adjacent elements** has **different parity**. That means:

* One is **even**, the other is **odd**

---

### 💡 Approach:

* Traverse the array starting from the second element (index `1`)
* For each adjacent pair `(arr[i-1], arr[i])`:

  * Check if **both are even** or **both are odd**
  * If yes → Return `false` (array is not special)
* If loop completes without returning `false` → Return `true`

---

### 🔁 Sample Logic:

```java
for (int i = 1; i < arr.length; i++) {
    if (arr[i] % 2 == arr[i - 1] % 2) {
        return false;
    }
}
return true;
```

---

### ✅ Output Example:

```java
Input: [2, 1, 4] → true  
Input: [4, 3, 1, 6] → false (3 and 1 are both odd)
```


---

### ✅ Question: Container With Most Water

🧠 **Input:** `[1,8,6,2,5,4,8,3,7]`
🎯 **Output:** `49`

---

### 💡 Approach:

* Use the **two-pointer technique**: one pointer at the start (`left`), another at the end (`right`) of the array.
* At each step:

  * Calculate the **current area** using:

    ```
    area = min(height[left], height[right]) * (right - left)
    ```
  * Update `maxArea` if the current area is larger.
  * Move the pointer with the **shorter line** (since it limits the area):

    * If `height[left] < height[right]`, increment `left`
    * Else, decrement `right`

---

### 🔁 Sample Logic Code:

```java
int left = 0;
int right = arr.length - 1;
int maxArea = 0;

while (left < right) {
    int height = Math.min(arr[left], arr[right]);
    int width = right - left;
    int area = height * width;

    maxArea = Math.max(maxArea, area);

    if (arr[left] < arr[right]) {
        left++;
    } else {
        right--;
    }
}
```

---



### ✅ Question: 3Sum (Find All Triplets That Sum to Zero)

🧠 **Input:** `[-1, 0, 1, 2, -1, -4]`
🎯 **Output:** `[[-1, -1, 2], [-1, 0, 1]]`

---

### 💡 Approach:

* First, **sort the array**. Sorting helps in identifying and skipping duplicates and using the two-pointer technique effectively.
* Iterate through the array with a loop:

  * For every element `nums[i]`, use **two pointers** (`j = i + 1`, `k = n - 1`) to find two other numbers such that the sum is `0`.
  * Skip duplicate values of `nums[i]` to avoid duplicate triplets.
  * Inside the loop:

    * If `nums[i] + nums[j] + nums[k] > 0`: move `k--` (need a smaller number).
    * If the sum is `< 0`: move `j++` (need a bigger number).
    * If the sum is `0`: store the triplet, and skip duplicates for `j` using `while` loop.

---

### 🔁 Sample Logic Code:

```java
Arrays.sort(nums);

for (int i = 0; i < nums.length; i++) {
    if (i > 0 && nums[i] == nums[i - 1]) continue;

    int j = i + 1;
    int k = nums.length - 1;

    while (j < k) {
        int total = nums[i] + nums[j] + nums[k];

        if (total > 0) {
            k--;
        } else if (total < 0) {
            j++;
        } else {
            res.add(Arrays.asList(nums[i], nums[j], nums[k]));
            j++;
            while (j < k && nums[j] == nums[j - 1]) j++;
        }
    }
}
```

---



### ✅ Question: Two Sum II – Input Array Is Sorted

🧠 **Input:**
`numbers = [2, 7, 11, 15], target = 9`
🎯 **Output:**
`[1, 2]`
(Indexes are 1-based)

---

### 💡 Approach:

* This is a **two-pointer problem** because the input array is already sorted.
* Initialize two pointers:

  * `start = 0` (beginning of array)
  * `end = arr.length - 1` (end of array)
* Check the sum of the elements at these two pointers:

  * If `arr[start] + arr[end] == target` → found the answer
  * If the sum is **greater** than target → move `end--` to reduce sum
  * If the sum is **less** than target → move `start++` to increase sum
* Return indices **+1** since the problem requires 1-based indexing.

✅ This solution works in **O(n)** time and uses **constant extra space**.

---

### 🔁 Sample Logic Code:

```java
while (start < end) {
    if (arr[start] + arr[end] == target) {
        return new int[]{start + 1, end + 1};
    }
    if (arr[start] + arr[end] > target) {
        end--;
    } else {
        start++;
    }
}
```

---

### ✅ Question: Remove Duplicates from Sorted Array

🧠 **Input:**
`nums = [1,1,2,2]`
🎯 **Output:**
`2` (Unique elements placed at start → `[1, 2, _, _]`)

---

### 💡 Approach:

* Since the array is **sorted**, duplicates will be adjacent.
* Use the **two-pointer technique**:

  * `j` tracks the **position of last unique element**.
  * Traverse from `i = 1` to end.
  * If `arr[i] != arr[j]`, then a new unique element is found:

    * Increment `j`
    * Copy `arr[i]` to `arr[j]`
* Finally, the number of unique elements is `j + 1`.

✅ Time Complexity: `O(n)`
✅ Space Complexity: `O(1)`
✅ In-place without using extra space.

---

### 🔁 Sample Logic Code:

```java
int j = 0;
for (int i = 1; i < arr.length; i++) {
    if (arr[j] != arr[i]) {
        j++;
        arr[j] = arr[i];
    }
}
System.out.println("Unique count: " + (j + 1));
```

---



### ✅ Question: Maximum Average Subarray of Size `k`

🧠 **Input:**
`nums = [1,12,-5,-6,50,3]`, `k = 4`
🎯 **Output:**
`12.75`
👉 Maximum average subarray of size `k` is `[12, -5, -6, 50] → sum = 51 → avg = 12.75`

---

### 💡 Approach: Sliding Window

* To avoid recalculating the sum every time, use the **Sliding Window** technique:

  * First, calculate the sum of the **first `k` elements**.
  * Then, **slide the window** one element at a time:

    * Subtract the element that's leaving the window.
    * Add the new element that’s entering the window.
    * Track the maximum sum at each step.
* Finally, return `max_sum / k` as the maximum average.

---

### ✅ Time Complexity: `O(n)`

✅ Space Complexity: `O(1)`
✅ Efficient for large arrays

---

### 🔁 Sample Logic Code:

```java
int sum = 0;
for (int i = 0; i < k; i++) {
    sum += nums[i];
}
double max_sum = sum;

for (int i = k; i < nums.length; i++) {
    sum = sum - nums[i - k] + nums[i];  // slide window
    max_sum = Math.max(max_sum, sum);
}
System.out.println("Max Average: " + (max_sum / k));
```

---

### ✅ Question: Minimum Size Subarray Sum

🧠 **Input:**
`target = 7`, `nums = [2,3,1,2,4,3]`
🎯 **Output:**
`2`
👉 The subarray `[4,3]` has the minimum length with sum ≥ 7.

---

### 💡 Approach: Sliding Window

* Use the **two-pointer sliding window** technique:

  * Expand the window by moving the `end` pointer and keep adding to `sum`.
  * When `sum >= target`, try **shrinking the window** from the left (`start` pointer) while maintaining the condition.
  * Track the **minimum window size** during the process.
* If no valid subarray is found, return `0`.

---

### ✅ Time Complexity: `O(n)`

✅ Space Complexity: `O(1)`
⚡ Efficient for large input sizes.

---

### 🔁 Sample Logic Code:

```java
int start = 0, sum = 0;
int minLen = Integer.MAX_VALUE;

for (int end = 0; end < nums.length; end++) {
    sum += nums[end];
    while (sum >= target) {
        minLen = Math.min(minLen, end - start + 1);
        sum -= nums[start++];
    }
}

int result = minLen == Integer.MAX_VALUE ? 0 : minLen;
System.out.println("Minimum subarray length: " + result);
```

---


### ✅ Question: Max Consecutive 1’s III (Flip at Most `k` Zeroes)

🧠 **Input:**
`nums = [1,1,1,0,0,0,1,1,1,1,0]`, `k = 2`
🎯 **Output:**
`6`
🔍 Explanation: You can flip at most 2 zeroes. Flipping two 0's (at index 3 and 4), the longest subarray becomes `[1,1,1,1,1,1]`.

---

### 💡 Approach: Sliding Window (Two Pointers)

* We maintain a window `[left...right]` that always contains at most `k` zeroes.
* Each time we include a `0`, we decrement `k`.
* If `k` becomes negative, we move the `left` pointer forward:

  * If `nums[left] == 0`, we **restore** one flip by incrementing `k`.
* At every step, the **window size** `right - left + 1` is the length of the current valid subarray.
* The result will be the **maximum length** of such a window.

---

### ✅ Time Complexity: `O(n)`

✅ Space Complexity: `O(1)`
📈 Efficient for large arrays.

---

### 🔁 Sample Logic Code:

```java
int left = 0;
for (int right = 0; right < nums.length; right++) {
    if (nums[right] == 0) k--;
    if (k < 0) {
        if (nums[left] == 0) k++;
        left++;
    }
}
System.out.println("Max Consecutive ones: " + (nums.length - left));
```

---



### ✅ Question: Length of Longest Substring Without Repeating Characters

🧠 **Input:**
`s = "abcabcbb"`
🎯 **Output:**
`3`
🔍 **Explanation:** The longest substring without repeating characters is `"abc"` with a length of `3`.

---

### 💡 Approach: Sliding Window with HashSet

#### 🛠️ Key Concepts:

* Use a **sliding window** with two pointers: `left` and `right`.
* A `HashSet` is used to store characters in the current window to quickly check for duplicates.
* Move the `right` pointer through the string.

  * If the character is **already in the set**, move the `left` pointer and **remove** characters from the set until there are no duplicates.
  * Update the `max_count` with the current window size: `right - left + 1`.

---

### ✅ Time Complexity: `O(n)`

✅ Space Complexity: `O(n)` (for the `HashSet`)

---

### 🔁 Sample Logic Code:

```java
int left = 0;
int max_count = 0;
HashSet<Character> set = new HashSet<>();

for (int right = 0; right < s.length(); right++) {
    char ch = s.charAt(right);
    while (set.contains(ch)) {
        set.remove(s.charAt(left));
        left++;
    }
    set.add(ch);
    max_count = Math.max(max_count, right - left + 1);
}
System.out.println("Length Of Longest Substring : " + max_count);
```

---
