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





