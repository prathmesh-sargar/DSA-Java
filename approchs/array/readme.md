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


## ✅ Problem: Subarray Sum Equals K

### 🧠 Input:

```java
nums = [1, 1, 1], k = 2
```

### 🎯 Output:

```java
2
```

---

## 💡 Approach: Prefix Sum + HashMap (Best Optimized Approach)

### ❓ Why Not Sliding Window?

* Sliding Window works only for **positive integers** because it depends on increasing window sizes to find the target sum.
* But here, since elements can be **negative**, the sum may increase or decrease unpredictably — making sliding window **invalid** in such cases.

---

### ✅ Brute Force Approach:

* Use **two nested loops** to check the sum of all subarrays.
* Time Complexity: **O(n²)** — inefficient for large arrays.

---

### ✅ Optimal Approach: Prefix Sum + HashMap

#### 🔍 Key Idea:

* A **prefix sum** is the sum of all elements from index `0` to index `i`.
* We want to check if a **subarray sum = k** exists.
  So if the **current prefix sum is `sum`**, then we look for the number of times `(sum - k)` has occurred before.

#### 🔐 Formula:

```java
if prefixSum[j] - prefixSum[i-1] == k
=> prefixSum[i-1] = prefixSum[j] - k
```

#### 🧱 Steps:

1. Initialize:

   * A `HashMap<Integer, Integer>` to store **prefix sums** and their frequency.
   * Add `prefixSum.put(0, 1)` to handle the case where subarray starts from index 0.

2. Iterate through the array:

   * Add the current element to the running sum.
   * If `(sum - k)` exists in map, add its frequency to the count.
   * Update the map with current sum and its frequency.

#### 🔁 Example Walkthrough:

For `nums = [1, 1, 1]` and `k = 2`

* Running prefix sums: `[1, 2, 3]`
* Count is incremented when we find `sum - k` in the map:

  * At index 1: `sum = 2`, `sum - k = 0` → found → `count = 1`
  * At index 2: `sum = 3`, `sum - k = 1` → found → `count = 2`

---

### 🧪 Sample Code:

```java
int count = 0, sum = 0;
HashMap<Integer, Integer> prefixsum = new HashMap<>();
prefixsum.put(0, 1);  // important initialization

for (int num : nums) {
    sum += num;

    if (prefixsum.containsKey(sum - k)) {
        count += prefixsum.get(sum - k);
    }

    prefixsum.put(sum, prefixsum.getOrDefault(sum, 0) + 1);
}
```

---

### 📈 Time & Space Complexity:

| Type             | Value |
| ---------------- | ----- |
| Time Complexity  | O(n)  |
| Space Complexity | O(n)  |

---

### ✅ Summary:

* Use Prefix Sum with HashMap when the array can contain **negative** numbers.
* This pattern is very useful in many **subarray problems** like:

  * Subarray Sum Equals K
  * Count subarrays with XOR = K
  * Count subarrays with sum divisible by K, etc.

---



## ✅ Problem: Range Sum Query – Immutable

### 🧠 Input:

```java
nums = [-2, 0, 3, -5, 2, -1]
Query 1: sumRange(0, 2) => Output: 1
Query 2: sumRange(2, 5) => Output: -1
Query 3: sumRange(0, 5) => Output: -3
```

---

### 🎯 Goal:

Efficiently answer multiple queries asking for the **sum of elements from index `left` to `right` (inclusive)**.

---

## 💡 Approach: Prefix Sum (Preprocessing Technique)

### 🚀 Key Idea:

Instead of recalculating the sum again and again, **precompute a prefix sum array** so that each query is answered in **O(1) time**.

---

### 🧱 Steps:

1. **Preprocess**:

   * Create a `prefix[]` array where:

     ```
     prefix[i] = nums[0] + nums[1] + ... + nums[i]
     ```

2. **Answer Queries**:

   * If `left == 0`, return `prefix[right]`
   * Else, return `prefix[right] - prefix[left - 1]`

---

### 🔁 Example:

```java
nums = [-2, 0, 3, -5, 2, -1]
prefix = [-2, -2, 1, -4, -2, -3]

// sumRange(0, 2) => prefix[2] = 1
// sumRange(2, 5) => prefix[5] - prefix[1] = -3 - (-2) = -1
// sumRange(0, 5) => prefix[5] = -3
```

---

### 🧪 Sample Code:

```java
int[] prefix;

public static int RangeSum(int left, int right) {
    if (left == 0) return prefix[right];
    return prefix[right] - prefix[left - 1];
}
```

```java
// Inside main:
prefix = new int[n];
prefix[0] = nums[0];
for (int i = 1; i < n; i++) {
    prefix[i] = prefix[i - 1] + nums[i];
}
```

---

### 📈 Time & Space Complexity:

| Operation        | Time | Space |
| ---------------- | ---- | ----- |
| Preprocessing    | O(n) | O(n)  |
| Query sumRange() | O(1) | —     |

---

### ✅ Summary:

* Prefix Sum is powerful for range-based problems with multiple queries.
* Converts repeated O(n) operations to O(1) after O(n) preprocessing.
* Use this when the array is **immutable** and **queries are frequent**.

---


## ✅ Problem: Maximum Product Subarray

### 🧠 Input:

```java
nums = [2,3,-2,4]
```

### 🎯 Output:

```java
6
```

> The subarray `[2,3]` gives the maximum product of `6`.

---

## 💡 Approach: Dynamic Programming with Two Variables

### 🧠 Key Insight:

Unlike sum problems, **product problems need to track both max and min**, because a **negative × negative = positive** — which might give a larger product than the max-so-far.

---

### 🔥 Core Idea:

We maintain two variables at each step:

* `currMax`: The **maximum product ending at current index**
* `currMin`: The **minimum product ending at current index**

This helps handle negative numbers effectively.

---

### 🧱 Steps:

1. Initialize:

   * `res = max number in array` (handles single element cases like all negatives)
   * `currMax = 1`, `currMin = 1`

2. Loop through array:

   * Temporarily store `currMax * num` in a variable `temp`
   * Update `currMax` as:

     ```java
     max(currMax * num, currMin * num, num)
     ```
   * Update `currMin` similarly:

     ```java
     min(temp, currMin * num, num)
     ```
   * Update result:

     ```java
     res = max(res, currMax)
     ```

---

### 🔁 Sample Code Snippet:

```java
int res = Integer.MIN_VALUE;
for (int i : nums) res = Math.max(i, res);

int currMax = 1, currMin = 1;

for (int num : nums) {
    int temp = currMax * num;
    currMax = Math.max(temp, Math.max(currMin * num, num));
    currMin = Math.min(temp, Math.min(currMin * num, num));
    res = Math.max(res, currMax);
}
```

---

### 📈 Time & Space Complexity:

| Operation          | Time | Space |
| ------------------ | ---- | ----- |
| Loop through array | O(n) | O(1)  |

---

### ✅ Summary:

* Product subarray is **not straightforward** like sum.
* You must track **min & max at each step**.
* Handles negative numbers and zero cases effectively.
* Common trick in interview questions!

---

## ✅ Problem: Best Time to Buy and Sell Stock

### 🧠 Input:

```java
prices = [7,1,5,3,6]
```

### 🎯 Output:

```java
5
```

> Buy at price `1` (day 2), sell at price `6` (day 5), profit = `6 - 1 = 5`

---

## 💡 Approach: Track Minimum Buy Price & Max Profit

### 🔥 Core Idea:

* We want to **buy at the lowest price before we sell**.
* At every day `i`, we check:

  1. Can we **update our buy price** if we found a cheaper price?
  2. If not, check what profit we would make if we **sold at today's price**.
  3. **Update max profit** if that profit is greater than previous ones.

---

### 🧱 Steps:

1. Initialize:

   * `buy_price = prices[0]`
   * `max_profit = 0`

2. Traverse from index 1 to end:

   * If `prices[i] < buy_price` → update `buy_price`
   * Else, calculate `profit = prices[i] - buy_price` and update `max_profit`

---

### 🔁 Sample Code Snippet:

```java
int maxProfit = 0;
int buy_price = prices[0];

for (int i = 1; i < prices.length; i++) {
    if (buy_price > prices[i]) {
        buy_price = prices[i];
    }
    maxProfit = Math.max(maxProfit, prices[i] - buy_price);
}
```

---

### ✅ Example Dry Run:

Input:

```java
prices = [7, 1, 5, 3, 6]
```

* Day 1: buy = 7
* Day 2: price = 1 → new buy = 1
* Day 3: price = 5 → profit = 4 → maxProfit = 4
* Day 4: price = 3 → profit = 2 → maxProfit = 4
* Day 5: price = 6 → profit = 5 → maxProfit = 5 ✅

---

### 📈 Time & Space Complexity:

| Operation   | Time | Space |
| ----------- | ---- | ----- |
| Single loop | O(n) | O(1)  |

---

### ✅ Summary:

* Efficient one-pass solution ✅
* Only track **lowest price so far** and **max profit**
* No need for nested loops

---


## ✅ Problem: Find Pivot Index

### 🧠 Input:

```java
nums = [1, 7, 3, 6, 5, 6]
```

### 🎯 Output:

```java
3
```

> At index 3, the sum of elements to the left (`1+7+3 = 11`) is equal to the sum of elements to the right (`5+6 = 11`).

---

## 💡 Approach: Use Left Sum & Right Sum Logic

### 🔥 Core Idea:

* You want to find an index `i` where:

  ```
  leftSum == rightSum
  ```
* Instead of calculating the sum on both sides for every index (which takes O(n²)), we use:

  ```
  rightSum = totalSum - leftSum - nums[i]
  ```
* This allows us to **solve it in one pass** after computing total sum.

---

### 🧱 Steps:

1. Calculate total sum of the array.
2. Initialize `leftSum = 0`.
3. Loop over the array:

   * At index `i`, calculate `rightSum = totalSum - leftSum - nums[i]`.
   * If `leftSum == rightSum`, return index `i` (pivot index).
   * Else, add `nums[i]` to `leftSum` and continue.
4. If no pivot is found, return `-1`.

---

### 🔁 Sample Code Snippet:

```java
public static int pivotIndex(int[] nums) {
    int totalSum = 0;
    for (int num : nums) {
        totalSum += num;
    }

    int leftSum = 0;
    for (int i = 0; i < nums.length; i++) {
        int rightSum = totalSum - leftSum - nums[i];
        if (leftSum == rightSum) {
            return i;
        }
        leftSum += nums[i];
    }

    return -1;
}
```

---

### ✅ Dry Run:

```java
nums = [1, 7, 3, 6, 5, 6]
totalSum = 28

i = 0 → left = 0, right = 27 → ❌  
i = 1 → left = 1, right = 20 → ❌  
i = 2 → left = 8, right = 17 → ❌  
i = 3 → left = 11, right = 11 → ✅ return 3
```

---

### 📈 Time & Space Complexity:

| Operation              | Complexity |
| ---------------------- | ---------- |
| Time                   | O(n)       |
| Space (no extra array) | O(1)       |

---

### ✅ Summary:

* Use prefix logic without building extra arrays.
* Efficient one-pass check with `leftSum` & `rightSum`.
* Returns the **leftmost** pivot index.

---



---

## ✅ Problem: Minimum Value to Get Positive Step-by-Step Sum

### 🧾 Problem Statement

You are given an array `nums` of integers.
You need to choose a **starting value** `startValue`, and then traverse the array while keeping a **running total** (`prefix sum`).
If at any point this total falls **below 1**, the `startValue` was too small.

> Return the **minimum positive value** of `startValue` such that the running total is **never less than 1**.

---

### 🧠 Intuition

The running total at any point must always be ≥ 1.
So we simulate the running sum and track the **lowest point** it reaches.

If the **minimum prefix sum** during the traversal is negative, then we must offset that by increasing our `startValue`.

---

### ✅ Key Observation

Let `minPrefixSum` = minimum value the running sum reaches.
Then the answer is:

```java
startValue = 1 - minPrefixSum
```

Why?
Because we want the **lowest running sum to be at least 1**, and this formula ensures that.

---

### 🧮 Dry Run

**Input:** `[-3, 2, -3, 4, 2]`
**Running Sum:**

```
0 → -3 → -1 → -4 → 0 → 2
minPrefixSum = -4
startValue = 1 - (-4) = 5 ✅
```

---

### 🧑‍💻 Code (Java - Greedy Approach)

```java
public class MinPrefixSum {
    public static int minStartvalue(int[] nums) {
        int sum = 0;
        int minPrefixSum = 0;

        for (int num : nums) {
            sum += num;
            minPrefixSum = Math.min(minPrefixSum, sum);
        }

        return 1 - minPrefixSum;
    }

    public static void main(String[] args) {
        int[] nums = {-3, 2, -3, 4, 2};
        System.out.println("Minimum start value is: " + minStartvalue(nums));
    }
}
```

---

### 📈 Time and Space Complexity

| Metric           | Value    |
| ---------------- | -------- |
| Time Complexity  | **O(n)** |
| Space Complexity | **O(1)** |

---

### 🟨 Alternate Approaches

1. **Brute Force** – Try increasing `startValue` until it works ✅
   ⛔ Inefficient: O(n²) in worst case

2. **Binary Search** – As discussed before
   ✅ Time: O(n log maxValue), Good for large input constraints

---

### 📌 Summary

* Track the minimum prefix sum while traversing the array
* Final answer is `1 - minPrefixSum`
* Very common **prefix sum** based greedy question

---
## ✅ Problem: Find Pivot Index

### 🧠 Input:

```java
nums = [1, 7, 3, 6, 5, 6]
```

### 🎯 Output:

```java
3
```

> At index 3, the sum of elements to the left (`1+7+3 = 11`) is equal to the sum of elements to the right (`5+6 = 11`).

---

## 💡 Approach: Use Left Sum & Right Sum Logic

### 🔥 Core Idea:

* You want to find an index `i` where:

  ```
  leftSum == rightSum
  ```
* Instead of calculating the sum on both sides for every index (which takes O(n²)), we use:

  ```
  rightSum = totalSum - leftSum - nums[i]
  ```
* This allows us to **solve it in one pass** after computing total sum.

---

### 🧱 Steps:

1. Calculate total sum of the array.
2. Initialize `leftSum = 0`.
3. Loop over the array:

   * At index `i`, calculate `rightSum = totalSum - leftSum - nums[i]`.
   * If `leftSum == rightSum`, return index `i` (pivot index).
   * Else, add `nums[i]` to `leftSum` and continue.
4. If no pivot is found, return `-1`.

---

### 🔁 Sample Code Snippet:

```java
public static int pivotIndex(int[] nums) {
    int totalSum = 0;
    for (int num : nums) {
        totalSum += num;
    }

    int leftSum = 0;
    for (int i = 0; i < nums.length; i++) {
        int rightSum = totalSum - leftSum - nums[i];
        if (leftSum == rightSum) {
            return i;
        }
        leftSum += nums[i];
    }

    return -1;
}
```

---

### ✅ Dry Run:

```java
nums = [1, 7, 3, 6, 5, 6]
totalSum = 28

i = 0 → left = 0, right = 27 → ❌  
i = 1 → left = 1, right = 20 → ❌  
i = 2 → left = 8, right = 17 → ❌  
i = 3 → left = 11, right = 11 → ✅ return 3
```

---

### 📈 Time & Space Complexity:

| Operation              | Complexity |
| ---------------------- | ---------- |
| Time                   | O(n)       |
| Space (no extra array) | O(1)       |

---

### ✅ Summary:

* Use prefix logic without building extra arrays.
* Efficient one-pass check with `leftSum` & `rightSum`.
* Returns the **leftmost** pivot index.

---


### ✅ Question: Merge Overlapping Intervals

> Given `intervals = [[1,3],[2,6],[8,10],[15,18]]`, return the non-overlapping intervals that cover all input intervals.

🧠 **Input:** `[[1,3],[2,6],[8,10],[15,18]]`
🎯 **Output:** `[[1,6],[8,10],[15,18]]`

---

### 💡 Approach

1. **Sort** all intervals by their start time.
2. Keep a running interval `prev` (initially the first interval).
3. For every next interval `curr`

   * **If** `curr.start ≤ prev.end` → they overlap → merge by
     `prev.end = max(prev.end, curr.end)`
   * **Else** → add `prev` to answer list and set `prev = curr`.
4. After the loop, add the last `prev` to the list.

---

#### 🔁 Sample Logic Code (Java – core only)

```java
// intervals is already sorted by start
List<int[]> merged = new ArrayList<>();
int[] prev = intervals[0];

for (int i = 1; i < intervals.length; i++) {
    int[] curr = intervals[i];

    if (curr[0] <= prev[1]) {                // overlap
        prev[1] = Math.max(prev[1], curr[1]); // merge
    } else {                                 // no overlap
        merged.add(prev);
        prev = curr;
    }
}
merged.add(prev);                             // last interval
```

Time `O(n log n)` (sorting)   Space `O(n)` (output list)

---

## 📚 Related Interview Classics

| Problem             | Goal                                                                  | Typical Hint                                                                       |
| ------------------- | --------------------------------------------------------------------- | ---------------------------------------------------------------------------------- |
| **Meeting Room I**  | Given meeting intervals, **can a single person attend all meetings?** | Sort by start time; check if any `curr.start < prev.end`.                          |
| **Meeting Room II** | **Minimum number of meeting rooms** required for all intervals        | Sort start & end times separately, or use a min-heap of end times; count overlaps. |

*Meeting Room I* is essentially **overlap detection** (true/false).
*Meeting Room II* asks for the **maximum number of simultaneous intervals**, i.e., the peak room count – conceptually similar to tracking overlaps but counting them instead of merging.



Here's the README-style **approach** explanation for the **Insert Interval** problem:

---
---



## ✅ Problem: Insert Interval and Merge Overlapping

You are given:

* A list of non-overlapping, **sorted** intervals.
* A **new interval** to insert.

📌 **Goal:** Insert the new interval in the correct place and **merge** any overlapping intervals.

---

## ✅ Example

```java
intervals = [[1,3],[6,9]]
newInterval = [2,5]
```

🔄 After inserting and merging:

```java
Output: [[1,5],[6,9]]
```

Why?

* \[2,5] overlaps with \[1,3] → merge to \[1,5]

---

## 💡 Approach

1. **Add `newInterval`** to the interval list.
2. **Sort** all intervals by the start time.
3. Use **Merge Intervals** logic to remove overlaps:

   * If `curr.start <= prev.end`, merge by updating `prev.end`.
   * Else, add `prev` to result and update `prev = curr`.
4. Add the last `prev` interval.

---

## 🧠 Core Logic (Java Snippet)

```java
List<int[]> merged = new ArrayList<>();
int[] prev = allIntervals.get(0);

for (int i = 1; i < allIntervals.size(); i++) {
    int[] curr = allIntervals.get(i);
    if (curr[0] <= prev[1]) {
        prev[1] = Math.max(prev[1], curr[1]);
    } else {
        merged.add(prev);
        prev = curr;
    }
}
merged.add(prev);  // add the final interval
```

---

## 🕰️ Time & Space Complexity

| Step       | Time       | Space |
| ---------- | ---------- | ----- |
| Add & sort | O(n log n) | O(n)  |
| Merge      | O(n)       | O(n)  |

---


Here’s the **README-style approach** for the **Sort Colors** problem:

---
---


## ✅ Problem: Sort Colors (Dutch National Flag Algorithm)

You're given an array `nums` containing only 0s, 1s, and 2s representing colors:

* `0` → Red
* `1` → White
* `2` → Blue

🔧 **Task:** Sort the array in-place **without** using the built-in sort function.

---

## ✅ Example

```java
Input:  nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
```

---

## 🔍 Constraints

* Must be **in-place**.
* Must **not** use sorting libraries.
* Must be **O(n)** time and **O(1)** space ideally.

---

## 💡 Approach 1: Frequency Count using HashMap (📦 Extra Space)

### 🔧 Logic:

1. Count how many 0s, 1s, and 2s.
2. Refill the original array using the frequencies.

```java
HashMap<Integer, Integer> count = new HashMap<>();
count.put(0, 0);
count.put(1, 0);
count.put(2, 0);

for (int num : nums) count.put(num, count.get(num) + 1);

int idx = 0;
for (int color = 0; color < 3; color++) {
    int freq = count.get(color);
    for (int i = 0; i < freq; i++) {
        nums[idx++] = color;
    }
}
```

### ✅ Time: O(n)

### ❌ Space: O(1) (technically O(3), still uses a HashMap)

---

## 💡 Approach 2: Dutch National Flag Algorithm (⚡ Optimal)

### 🔧 Logic:

Use 3 pointers:

* `red` for placing 0s (left)
* `white` for scanning
* `blue` for placing 2s (right)

### 🔄 Steps:

* If `nums[white] == 0` → swap with `nums[red]`, `red++`, `white++`
* If `nums[white] == 1` → `white++`
* If `nums[white] == 2` → swap with `nums[blue]`, `blue--` (don’t move white)

```java
int red = 0, white = 0, blue = nums.length - 1;

while (white <= blue) {
    if (nums[white] == 0) {
        swap(nums, white, red);
        red++;
        white++;
    } else if (nums[white] == 1) {
        white++;
    } else {
        swap(nums, white, blue);
        blue--;
    }
}
```

> Where `swap` just swaps two array elements.

### ✅ Time: O(n)

### ✅ Space: O(1)

---

## 🧠 Why Is This Called “Dutch National Flag”?

* Because it sorts the array into **three parts** like the Dutch flag colors: red, white, blue in one pass.

---

## 🧪 Dry Run

```java
Input: [2,0,2,1,1,0]

Start → red=0, white=0, blue=5
Step 1 → swap 2 and 0 → [0,0,2,1,1,2]
Step 2 → white=1 → swap 0 and 0
Step 3 → white=2 → skip (2) → swap with blue → blue--
...
End Result: [0,0,1,1,2,2]
```

---

## ✅ Final Notes

* ✅ Prefer **Dutch Flag Algorithm** → Efficient and in-place.
* 🚫 Avoid frequency count if asked for optimal space.
* ⚙ Great question to test **in-place partitioning** logic.

---



## ✅ Problem: Contains Duplicate II

Given an integer array `nums` and an integer `k`, check if there exist **two indices `i` and `j`** such that:

* `nums[i] == nums[j]`
* `abs(i - j) <= k`

---

### ✅ Example

```java
Input: nums = [1,2,3,1], k = 3
Output: true  // nums[0] == nums[3] and |3 - 0| = 3 ≤ k

Input: nums = [1,2,3,1,2,3], k = 2
Output: false  // No such pair within distance 2
```

---

## 💡 Approach: HashMap 🧠

### 🔹 Idea:

Track the **last index** where each value was seen using a HashMap.
If we see the same value again and the **index difference** is ≤ `k`, return `true`.

---

### 🔧 Code Logic Snippet:

```java
HashMap<Integer, Integer> seen = new HashMap<>();

for (int i = 0; i < nums.length; i++) {
    if (seen.containsKey(nums[i]) && i - seen.get(nums[i]) <= k) {
        return true;
    }
    seen.put(nums[i], i);
}
return false;
```

---

### 🕒 Time Complexity:

**O(n)** – Loop through the array once.

### 🧠 Space Complexity:

**O(n)** – Store values and their indices in HashMap.

---



## ✅ Problem: Intersection of Two Arrays

Given two integer arrays `nums1` and `nums2`, return an array of their **intersection**.
Each element in the result must be **unique**, and the result **can be returned in any order**.

---

### ✅ Examples:

```java
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4] or [4,9]
```

---

## 💡 Approach 1: Brute Force with Set (Nested Loops)

### 🔹 Idea:

* For each element in the smaller array, iterate through the larger one to find a match.
* Store matches in a HashSet to ensure uniqueness.

### 🔧 Code Logic Snippet:

```java
for (int i = 0; i < nums1.length; i++) {
    for (int j = 0; j < nums2.length; j++) {
        if (nums1[i] == nums2[j]) {
            set.add(nums1[i]); // or nums2[j]
            break;
        }
    }
}
```

### 🕒 Time Complexity:

**O(n \* m)** where n = length of `nums1` and m = length of `nums2`

### 🧠 Space Complexity:

**O(min(n, m))** – To store the result set

---

## 💡 Approach 2: Optimized Using HashSet ✅

### 🔹 Idea:

* Store all elements of `nums1` in a HashSet.
* Traverse `nums2`, and if any element exists in the set, add it to a result set.
* This ensures O(1) lookups and avoids duplicates.

### 🔧 Code Logic Snippet:

```java
Set<Integer> set = new HashSet<>();
for (int num : nums1) {
    set.add(num);
}

Set<Integer> resultSet = new HashSet<>();
for (int num : nums2) {
    if (set.contains(num)) {
        resultSet.add(num); // add only unique intersection elements
    }
}
```

---

## 🔁 Conversion to Result Array:

```java
int[] result = new int[resultSet.size()];
int idx = 0;
for (int num : resultSet) {
    result[idx++] = num;
}
```

---

### 🕒 Time Complexity:

* **O(n + m)** — One pass through both arrays

### 🧠 Space Complexity:

* **O(n)** — For HashSet and result array

---

Here is a concise **README-style approach** for the problem **"Longest Consecutive Sequence"**:

---

## ✅ Problem: Longest Consecutive Sequence

Given an **unsorted array** of integers `nums`, return the length of the **longest consecutive elements sequence**.

* Your algorithm must run in **O(n)** time.

---

### Example

```java
Input: nums = [100, 4, 200, 1, 3, 2]
Output: 4  // The longest consecutive sequence is [1, 2, 3, 4]
```

---

## 💡 Approach: Using HashSet for O(n) Time

### 🔹 Idea:

* Store all elements in a `HashSet` to allow O(1) lookups.
* For each number `num`, check if it's the **start of a sequence** by checking if `(num - 1)` is **not in the set**.
* If it’s a sequence start, count how long the sequence goes (i.e., check `num + 1`, `num + 2`, ...).
* Keep updating `maxLength` as you find longer sequences.

---

### 🔧 Code Logic Snippet:

```java
HashSet<Integer> set = new HashSet<>();
for (int num : nums) {
    set.add(num);
}

int maxLen = 0;
for (int num : set) {
    if (!set.contains(num - 1)) {  // Only start from beginning of sequence
        int current = num;
        int length = 1;

        while (set.contains(current + 1)) {
            current++;
            length++;
        }

        maxLen = Math.max(maxLen, length);
    }
}
```
---

## ⏱ Time Complexity:

* **O(n)** – Each element is processed once.

## 🧠 Space Complexity:

* **O(n)** – HashSet for storing all elements.

---



## 📌 Problem: Find Minimum in Rotated Sorted Array

You're given a **rotated sorted array** `nums` of **unique elements**.

🔍 **Goal**: Return the **minimum element**.

🕒 **Time Complexity Required**: O(log n)

---

## 💡 Approach: Binary Search

### 🔹 Idea:

* The array is **sorted and rotated**, so the smallest value will be the **rotation pivot**.
* We can apply **binary search** to efficiently find this pivot point.

---

### 🔧 Steps:

1. **If array is already sorted** (`nums[0] < nums[n - 1]`), return `nums[0]`.
2. Perform **binary search**:

   * Compute `mid = (start + end) / 2`
   * If `nums[mid] < nums[mid - 1]`, then `nums[mid]` is the minimum.
   * If `nums[mid] > nums[mid + 1]`, then `nums[mid + 1]` is the minimum.
   * If `nums[start] <= nums[mid]`, the left part is sorted, so go right: `start = mid + 1`.
   * Else, go left: `end = mid - 1`.

---

### 🔧 Code Snippet:

```java
int start = 0, end = nums.length - 1;
while (start <= end) {
    int mid = (start + end) / 2;

    if (mid > 0 && nums[mid] < nums[mid - 1])
        return nums[mid];
    if (mid < nums.length - 1 && nums[mid] > nums[mid + 1])
        return nums[mid + 1];

    if (nums[start] <= nums[mid])
        start = mid + 1;
    else
        end = mid - 1;
}
```

---

## ⏱ Time Complexity:

* **O(log n)** — Binary search on the rotated array.

## 🧠 Space Complexity:

* **O(1)** — Constant space.

---



## 📌 Problem: Median of Two Sorted Arrays

You're given two **sorted arrays** `nums1` and `nums2`.

🔍 **Goal**: Return the **median** of the merged sorted array.

🕒 **Expected Time Complexity**: **O(log (m+n))**
👉 But your current approach runs in **O(m+n)** (merging), which is valid for interviews when optimal log-time is not required.

---

## 💡 Approach 1: Merge and Find Median (Simple but Not Optimal)

### 🔹 Idea:

* Merge the two sorted arrays into one sorted array.
* Find the median of the merged array:

  * If the length is **odd**, return the middle element.
  * If the length is **even**, return the average of the two middle elements.

---

### 🧱 Steps:

1. Use **two pointers** `p1`, `p2` to traverse both arrays.
2. At each step, pick the **smaller value** and add to the result.
3. Once merged, calculate the **median** based on array length:

   * **Odd length**: `arr[n/2]`
   * **Even length**: `(arr[n/2] + arr[n/2 - 1]) / 2`

---

### 🔧 Code Snippet:

```java
public static int[] merge(int[] num1, int[] num2) {
    int[] ans = new int[num1.length + num2.length];
    int p1 = 0, p2 = 0, p3 = 0;

    while (p1 < num1.length || p2 < num2.length) {
        int val1 = p1 < num1.length ? num1[p1] : Integer.MAX_VALUE;
        int val2 = p2 < num2.length ? num2[p2] : Integer.MAX_VALUE;

        if (val1 < val2) {
            ans[p3++] = val1;
            p1++;
        } else {
            ans[p3++] = val2;
            p2++;
        }
    }

    return ans;
}
```

```java
int[] merged = merge(nums1, nums2);
int n = merged.length;

if (n % 2 == 0) {
    return (merged[n/2] + merged[n/2 - 1]) / 2.0;
} else {
    return merged[n/2];
}
```

---

## ✅ Example:

### Input:

`nums1 = [1,2]`, `nums2 = [3,5,6]`

### Merged:

`[1,2,3,5,6]`

### Median:

`3` (middle element of 5 elements)

---

## ⏱ Time Complexity:

* **O(m + n)** for merging.

## 🧠 Space Complexity:

* **O(m + n)** for the new array.

---

## 🏁 Note:

* This is not the **optimal** approach.
* The **optimal** solution uses **binary search** and achieves **O(log(min(m,n)))**, which you can implement later for advanced optimization.

---

### 🔍 Problem: Search in Rotated Sorted Array

You are given a rotated sorted array `nums` and an integer `target`. Your task is to find the index of the target element. If the element is not found, return `-1`.

* You **must** use an algorithm with **O(log n)** time complexity.

---

### ✅ Approach: Modified Binary Search

A **rotated sorted array** always has **one half sorted** — either the left or the right. Use this property to decide which half to search in.

---

### 🔧 Steps:

1. Initialize two pointers: `start = 0`, `end = nums.length - 1`.
2. Use a loop while `start <= end`:

   * Find the middle index: `mid = (start + end) / 2`.
   * If `nums[mid] == target`, return `mid`.
   * If **left half is sorted** (`nums[start] <= nums[mid]`):

     * If `target` lies in the left half (`target >= nums[start] && target < nums[mid]`):

       * Move left: `end = mid - 1`.
     * Else:

       * Move right: `start = mid + 1`.
   * Else (**right half is sorted**):

     * If `target` lies in the right half (`target > nums[mid] && target <= nums[end]`):

       * Move right: `start = mid + 1`.
     * Else:

       * Move left: `end = mid - 1`.
3. If not found, return `-1`.

---

### 💡 Why This Works:

Each time, you eliminate half of the array, like in normal binary search — hence the time complexity remains **O(log n)**.

---

### 📦 Example:

```java
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
```

The number `0` is found at index `4`.

---

### 🧠 Edge Cases:

* `nums = [1]`, `target = 0` → return `-1`
* `nums = [1,3]`, `target = 3` → return `1`

---

### 🔍 Problem: Search Insert Position

Given a **sorted array** of **distinct integers** and a target value, return the **index if the target is found**.
If not, return the index **where it would be inserted** to maintain the order.

* Must be solved in **O(log n)** time complexity.

---

### ✅ Approach: Binary Search

We apply binary search to either:

* Find the index of the target.
* Or find the correct insertion position if the target is not present.

---

### 🔧 Steps:

1. Initialize two pointers:

   * `start = 0`
   * `end = nums.length - 1`
2. Loop while `start <= end`:

   * Compute `mid = (start + end) / 2`
   * If `nums[mid] == target`: return `mid`
   * If `nums[mid] < target`: search right → `start = mid + 1`
   * If `nums[mid] > target`: search left → `end = mid - 1`
3. If the loop ends and target isn’t found, return `start` — this is the correct insertion position.

---

### 💡 Why This Works:

Binary search helps locate the **first number greater than target**, which is exactly where it should be inserted.
The `start` pointer always ends at that position.

---

### 📦 Example:

```java
Input: nums = [1,3,5,6], target = 2
Output: 1
Explanation: 2 would be inserted between 1 and 3.
```

---

### 🧠 Edge Cases:

* `target` smaller than all → returns `0`
* `target` larger than all → returns `nums.length`

---



## 🍬 Problem: Candy Distribution

You are given `n` children standing in a line, each with a **rating**. You must distribute candies to them according to the following rules:

1. **Each child gets at least one candy**.
2. A child with a **higher rating than their neighbor** must get **more candies**.

---

## ✅ Objective

Return the **minimum number of candies** required to satisfy these rules.

---

## 📌 Approach: Two Pass Greedy Strategy

### 🔹 Step 1: Initialization

* Create a `candies[]` array and initialize **each child with 1 candy**.

### 🔹 Step 2: Left to Right Pass

* Traverse from left to right.
* If `ratings[i] > ratings[i-1]`, then `candies[i] = candies[i-1] + 1`.

This ensures **each child gets more candies than the left neighbor** if rated higher.

### 🔹 Step 3: Right to Left Pass

* Traverse from right to left.
* If `ratings[i] > ratings[i+1]`, update:

  ```java
  candies[i] = max(candies[i], candies[i+1] + 1);
  ```

This ensures **each child gets more candies than the right neighbor** if rated higher, while **preserving the left-to-right assignment**.

### 🔹 Step 4: Sum All Candies

* Add up all the values in the `candies[]` array for the final result.

---

## 📦 Example

### Input:

```java
ratings = [1, 0, 2]
```

### Execution:

* Initial: `[1,1,1]`
* Left to Right: `[1,1,2]`
* Right to Left: `[2,1,2]`

### Output:

```java
Total Candies = 2 + 1 + 2 = 5
```

---

## ⏱️ Time & Space Complexity

* **Time:** O(n)
* **Space:** O(n) (for extra candies array)

---

## 🚀 Problem: Jump Game

You are given an array `nums` where each element represents the **maximum jump length** at that position.
You start at index `0` and need to determine **if you can reach the last index**.

---

## ✅ Objective

Return `true` if it is possible to reach the **last index**, else return `false`.

---

## 🧠 Intuition

We keep track of the **last position** from which we can jump to the end.
We iterate **backward**, updating this position whenever a new index can jump to or beyond the last known good position.

---

## 🔍 Approach: Greedy from Right to Left

### 🔹 Step-by-step:

1. Start from the **end** of the array and move backwards.
2. Maintain a variable `lastIndex` that tracks the **minimum index from which we can reach the end**.
3. At each index `i`, if `i + nums[i] >= lastIndex`, we update `lastIndex = i`.
4. After the loop, if `lastIndex == 0`, return `true`, else return `false`.

---

## 🔁 Example

### Input:

```java
nums = [2,3,1,1,4]
```

### Process:

* Start from last index → `lastIndex = 4`
* At `i=3`: 3+1 >= 4 → update `lastIndex = 3`
* At `i=2`: 2+1 < 3 → skip
* At `i=1`: 1+3 >= 3 → update `lastIndex = 1`
* At `i=0`: 0+2 >= 1 → update `lastIndex = 0`

### Output:

```java
true (you can reach the last index)
```

---

## 📦 Code: Java Implementation

```java
public class Jump_Game {
    public static boolean reachLastIndex(int[] nums) {
        int lastIndexPosition = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= lastIndexPosition) {
                lastIndexPosition = i;
            }
        }

        return lastIndexPosition == 0;
    }

    public static void main(String[] args) {
        int[] jumpArray = {3, 2, 1, 0, 4};
        boolean result = reachLastIndex(jumpArray);
        System.out.println("Can reach last index: " + result);
    }
}
```

---

## ⏱ Time & Space Complexity

* **Time:** O(n) — single pass from end to start.
* **Space:** O(1) — no extra space used.

---

## ⛽ Problem: Gas Station

You’re given two integer arrays:

* `gas[i]`: gas available at station `i`
* `cost[i]`: gas required to go from station `i` to `i+1` (circularly)

You need to find the **starting station index** from which you can complete the full circle **once**, or return `-1` if it's not possible.

> **Note**: If a solution exists, it is guaranteed to be **unique**.

---

## 🧠 Intuition

To complete the circuit:

* The **total gas** should be at least equal to the **total cost**.
* If at any point, the gas in the tank becomes negative, the current start station is not valid — restart from the next station.

---

## ✅ Approach: Greedy

### 🔹 Step-by-step:

1. **Check Feasibility**:

   * If `totalGas < totalCost`, return `-1`.

2. **Find Starting Index**:

   * Initialize `startIndex = 0` and `currentGas = 0`
   * Traverse all stations:

     * At each station, calculate `currentGas += gas[i] - cost[i]`
     * If `currentGas` goes below 0:

       * Reset `currentGas = 0`
       * Set `startIndex = i + 1` (start from next station)

---

## 💡 Why it works?

If you can't reach station `i+1` from `i`, then any station between the old start and `i` can't be a valid start either (they would have less gas). So you safely move the start forward.

---

## 📦 Java Code

```java
public class Gas_Station {

    public static int firstStartIndex(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;

        // 1. Calculate total gas and cost
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        // 2. If not enough gas overall, return -1
        if (totalGas < totalCost) {
            return -1;
        }

        // 3. Greedy: Find valid start index
        int currentGas = 0;
        int startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            currentGas += gas[i] - cost[i];

            if (currentGas < 0) {
                currentGas = 0;
                startIndex = i + 1;
            }
        }

        return startIndex;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int res = firstStartIndex(gas, cost);
        System.out.println("Start index is: " + res); // Output: 3
    }
}
```

---

## ⏱ Time & Space Complexity

* **Time:** O(n) – One pass to calculate total, another to find start
* **Space:** O(1) – Constant extra space

---
