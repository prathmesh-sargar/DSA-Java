
## 🧩 Problem Name: Valid Parentheses

## 🎯 Problem Statement:

You're given a string containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['`, and `']'`.
Write a function to check if the input string is valid.

✅ A string is valid if:

1. Open brackets are closed by the same type of brackets.
2. Open brackets are closed in the correct order.

---

## 🧠 Approach (Using Stack):

1. Create a stack to keep track of opening brackets.
2. Traverse the string character by character.
3. If you find an **opening bracket** (`(`, `{`, `[`), **push it to the stack**.
4. If you find a **closing bracket** (`)`, `}`, `]`):

   * Check if the stack is not empty and the **top of the stack** is the matching opening bracket.
   * If yes, **pop** it.
   * If no, return **false** immediately.
5. At the end, if the stack is **empty**, return `true`. Else, return `false`.

---

## 🧑‍💻 Code:

```java
import java.util.Stack;

public class Valid_Parentheses {

    public static boolean isvalid(String s) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else if (!st.isEmpty() && ch == ')' && st.peek() == '(') {
                st.pop();
            } else if (!st.isEmpty() && ch == ']' && st.peek() == '[') {
                st.pop();
            } else if (!st.isEmpty() && ch == '}' && st.peek() == '{') {
                st.pop();
            } else {
                return false; // unmatched closing bracket
            }
        }

        return st.isEmpty(); // valid only if all are matched
    }

    public static void main(String[] args) {
        String str = "[{()}]";
        System.out.println("is valid parentheses : " + isvalid(str));
    }
}
```

---

## ⏱️ Time and Space Complexity:

| Complexity | Value  |                                                   |
| ---------- | ------ | ------------------------------------------------- |
| Time       | `O(n)` | (We go through each character once)               |
| Space      | `O(n)` | (In the worst case, all open brackets are stored) |

---



## 🧩 Problem Name: Min Stack

 — Design a stack that supports `push()`, `pop()`, `top()`, and `getMin()` in **O(1)** time.

---

## 🎯 Problem Statement:

Design a stack that, along with normal operations like `push`, `pop`, and `top`, also supports retrieving the **minimum element** in constant time.

### Operations to implement:

* `MinStack()` → Initializes the object.
* `push(int val)` → Pushes an element onto the stack.
* `pop()` → Removes the element on the top.
* `top()` → Returns the top element.
* `getMin()` → Returns the minimum element in the stack.

All operations must be done in **O(1)** time.

---

## 🧠 Approach:

We use **two stacks**:

1. `stack` → to store all values normally.
2. `minStack` → to keep track of the **current minimum** at every point.

### Logic:

* While pushing a value, if the `minStack` is empty or the new value is **less than or equal to** the current min, also push it to `minStack`.
* While popping, if the popped value equals the top of `minStack`, pop from `minStack` too.
* `minStack.peek()` always gives the current **minimum value** in O(1) time.

---

## 👨‍💻 Code:

```java
import java.util.Stack;

public class Min_Stack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    // Constructor
    Min_Stack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int val = stack.pop();
        if (val == minStack.peek()) {
            minStack.pop();
        }
    }

    public int peek() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Min_Stack obj = new Min_Stack();
        obj.push(12);
        obj.push(-2);
        obj.push(10);
        obj.push(-3);
        obj.push(0);

        System.out.println("getMin value: " + obj.getMin()); // Output: -3
        obj.pop(); // remove 0
        obj.pop(); // remove -3
        System.out.println("Top value: " + obj.peek());      // Output: 10
        System.out.println("New getMin: " + obj.getMin());   // Output: -2
    }
}
```

---

## ⏱ Time & Space Complexity:

| Operation  | Time Complexity | Space Complexity |
| ---------- | --------------- | ---------------- |
| `push()`   | O(1)            | O(1) per call    |
| `pop()`    | O(1)            | O(1)             |
| `peek()`   | O(1)            | O(1)             |
| `getMin()` | O(1)            | O(1)             |

> ⚠️ Worst-case space = O(n) for both stacks.

---


## 🧩 Problem Name: Implement Stack using Queues

---

## 🎯 Problem Statement:

Design a **Stack** (LIFO) using only **Queue** operations (FIFO).

You need to implement the following methods:

* `push(int val)` → Push an element onto the stack.
* `pop()` → Removes and returns the top element of the stack.
* `peek()` → Returns the top element without removing it.

---

## 🧠 Approach (Using Two Queues):

We use two queues:

* `main` → This queue always holds the elements in **correct stack order**, i.e., newest at the front.
* `helper` → Temporary queue used during the `push()` operation to reorder elements.

---

### ✅ Logic:

* **Push (val)**:

  1. First, move all elements from `main` to `helper`.
  2. Then, add the new value to `main`.
  3. Move everything back from `helper` to `main`.

  * After this, `main` will always have the **top of the stack at the front**.

* **Pop()**: Just remove from the front of `main`.

* **Peek()**: Just return the front of `main`.

---

## 👨‍💻 Code:

```java
import java.util.ArrayDeque;
import java.util.Queue;

public class Implement_Stack_using_Queues {

    private Queue<Integer> main;
    private Queue<Integer> helper;

    Implement_Stack_using_Queues() {
        main = new ArrayDeque<>();
        helper = new ArrayDeque<>();
    }

    public void push(int val) {
        // Step 1: Move all elements to helper
        while (!main.isEmpty()) {
            helper.add(main.remove());
        }

        // Step 2: Add new element to main
        main.add(val);

        // Step 3: Move everything back to main
        while (!helper.isEmpty()) {
            main.add(helper.remove());
        }
    }

    public int pop() {
        return main.remove();
    }

    public int peek() {
        return main.peek();
    }

    public static void main(String[] args) {
        Implement_Stack_using_Queues obj = new Implement_Stack_using_Queues();
        obj.push(12);
        obj.push(10);
        obj.push(30);

        System.out.println(obj.pop());  // Output: 30
        System.out.println(obj.peek()); // Output: 10
    }
}
```

---

## ⏱️ Time & Space Complexity:

| Operation | Time Complexity | Space Complexity |
| --------- | --------------- | ---------------- |
| `push()`  | O(n)            | O(n)             |
| `pop()`   | O(1)            | O(1)             |
| `peek()`  | O(1)            | O(1)             |

---

## 🧩 Problem Name: Evaluate Reverse Polish Notation (Postfix Expression) 


## 🎯 Problem Statement:

You're given an array of strings `tokens`, where each element is either:

* an **integer** (like `"2"`, `"10"`, `"-5"`)
* or an **operator**: `"+"`, `"-"`, `"*"`, `"/"`

You need to **evaluate the expression** and return the result as an integer.

📌 The input is a valid postfix (RPN) expression.
**RPN Rule**: Operators come **after** their operands.

---

## 🧠 Approach (Using Stack):

1. Create an empty **stack** of integers.
2. Traverse the `tokens` array:

   * If it's a **number**, push it onto the stack.
   * If it's an **operator**:

     * Pop the top **two numbers** from the stack.
     * Apply the operation: `num2 (op) num1` → Note: second popped is first operand!
     * Push the result back onto the stack.
3. At the end, the **top of the stack** is the final result.

---

## 👨‍💻 Code:

```java
import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {

    // Helper method to perform arithmetic operations
    public static int operation(int a, int b, String token) {
        switch (token) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
        }
        return -1; // Just in case
    }

    // Main evaluator
    public static int answer(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int result = operation(num2, num1, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token)); // Convert string to int
            }
        }

        return stack.pop(); // Final result
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        int calculation = answer(tokens);
        System.out.println("calculation is : " + calculation); // Output: 9
    }
}
```

---

## ⏱️ Time & Space Complexity:

| Type      | Complexity |
| --------- | ---------- |
| **Time**  | O(n)       |
| **Space** | O(n)       |


---

## ✅ Problem Name: Next Greater Element I 

---
##  Approach:

We are given two arrays:

* `nums1`: a subset of `nums2`
* `nums2`: the reference array

The task is to find the **next greater element** of each element from `nums1` *in* `nums2`.
👉 "Next greater" means the first greater element that appears **to the right** of that element in `nums2`.

### 💡 Brute Force Approach:

1. For each element in `nums1`, find its index in `nums2`.
2. Start from that index + 1, and search for the next greater element.
3. If found, store it in result. If not, store -1.

---

##  Sample Code (Logic Part Only):

```java
int[] res = new int[nums1.length];

for(int i = 0; i < nums1.length; i++) {
    int indexInNums2 = -1;
    
    // Find index of nums1[i] in nums2
    for(int j = 0; j < nums2.length; j++) {
        if(nums1[i] == nums2[j]) {
            indexInNums2 = j;
            break;
        }
    }

    // Find next greater element from that index
    int nextGreater = -1;
    for(int k = indexInNums2 + 1; k < nums2.length; k++) {
        if(nums2[k] > nums1[i]) {
            nextGreater = nums2[k];
            break;
        }
    }

    res[i] = nextGreater;
}
```

---

##  Time Complexity:

* Outer loop → `O(n)` where `n = nums1.length`
* Inner search for index + next greater → `O(m)` where `m = nums2.length`
* **Total: `O(n * m)`**

##  Space Complexity:

* `O(n)` for result array (no extra stack or map used)

---

##  Improvement Possibility:

You can optimize this to **O(m + n)** using a **Monotonic Stack + HashMap** 💡
If you want, I’ll show that version too — it’s commonly asked in interviews and saves time on large inputs.



Yes bro, you're grinding hard — proud of the progress 💪
Let’s break down this **Next Greater Element II** question the same way we did earlier — in proper interview-ready format. You’ll *fully own* this concept now 🔥

---

## ✅ Problem Name: Next Greater Element II 

---

##  Approach:

You're given a **circular array**. For every element in the array, you need to find the **next greater element**, going to the right — and if needed, **wrap around to the start** (circular).

### 💡 Key Observations:

* Same as *Next Greater Element I*, but since it's circular, we need to simulate traversing the array **twice**.
* Use a **monotonic decreasing stack** to keep track of possible "next greater" elements.
* We use modulo (`i % n`) to wrap around circularly.

---

##  Sample Code (Logic Part Only):

```java
int n = nums.length;
int[] res = new int[n];
Stack<Integer> stack = new Stack<>();

// Traverse 2n - 1 to 0 to simulate circular array
for (int i = 2 * n - 1; i >= 0; i--) {
    // Pop all elements smaller or equal to current
    while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
        stack.pop();
    }

    // Fill result only in the first pass (i < n)
    if (i < n) {
        res[i] = stack.isEmpty() ? -1 : stack.peek();
    }

    // Push current element for future comparisons
    stack.push(nums[i % n]);
}
```

---

##  Time Complexity:

* `O(2n)` → We iterate twice through the array
* Stack push/pop happens at most 2n times total
* So overall: **`O(n)` time**

##  Space Complexity:

* `O(n)` for stack and result array

---

## Stack Type:

We use a **monotonic decreasing stack** (i.e., top is the smallest so far), because we want to pop smaller elements when we find a bigger one → helps in finding **next greater**.

---

##  Intuition Example:
For `nums = [1, 2, 3, 4, 3]`
* From right to left, simulate the array as:
  `... 3 4 3 2 1 | 3 4 3 2 1`
* When at index 0 (value = 1), the stack already has `[4, 3]` → next greater is `2`
* For last index (value = 3), next greater is `4` since you wrap around

---



## ✅ Problem Name: Daily Temperatures 

---

##  Problem Statement:

Given an array `temperatures[]` representing daily temps, return an array `answer[]` where `answer[i]` is the number of days until a warmer temperature comes.
If no warmer temperature is coming, set `answer[i] = 0`.

---

##  Approach:

We use a **monotonic decreasing stack of indices** to track days with temperatures waiting for a warmer one.

### 💡 Why stack of **indices** not values?

* We need to **calculate how many days ahead** a warmer temp comes:
  `stack.peek() - current index`

### 💡 Monotonic Decreasing Stack:

* Stores indices of temperatures in **decreasing order**
* If the current temperature is **greater than** the one on top of stack → that means we found the next warmer day for that previous index

---

##  Sample Code (Logic Part Only):

```java
int n = temp.length;
int[] res = new int[n];
Stack<Integer> stack = new Stack<>();

for (int idx = n - 1; idx >= 0; idx--) {
    // Pop days with lower or equal temperature
    while (!stack.isEmpty() && temp[idx] >= temp[stack.peek()]) {
        stack.pop();
    }

    // If a warmer day exists, calculate the gap
    if (!stack.isEmpty()) {
        res[idx] = stack.peek() - idx;
    }

    // Push current day's index onto the stack
    stack.push(idx);
}
```

---

##  Time Complexity:

* `O(n)` → Each index is pushed and popped at most once

##  Space Complexity:

* `O(n)` for the stack and result array

---

##  Stack Type:

**Monotonic Decreasing Stack (by value)** → but we store **indices** to calculate day difference.

---

##  Example Dry Run:

For `temps = [73,74,75,71,69,72,76,73]`

* At index `6` → value `76`
  → no warmer day → `res[6] = 0`

* At index `5` → value `72`
  → `stack.peek() = 6` (`76` is warmer)
  → `res[5] = 6 - 5 = 1`

---

##  Summary:

| What we're finding | "Next greater temperature"          |
| ------------------ | ----------------------------------- |
| Stack stores       | Indexes of decreasing temps         |
| Direction          | Right → Left                        |
| Stack logic        | `while (curr >= stack.top()) pop()` |
| Result logic       | `res[i] = stack.peek() - i`         |

---

## ✅ Problem Name: Largest Rectangle in Histogram 

---

## ✅ Problem Statement:

Given an array of `heights[]` representing the height of bars in a histogram (each bar has width 1), return the **area of the largest rectangle** you can make using **contiguous bars**.

---

##  Approach:

We use **Monotonic Stack** to find:

1. **Next Smaller to the Right (NSR)**
2. **Previous Smaller to the Left (PSL)**

With this info, we can calculate:

```
Area at index i = height[i] × (nextSmaller[i] - previousSmaller[i] - 1)
```

### 🔥 Why?

* We want to expand the rectangle from index `i` as much as possible to both left and right until a **smaller** bar stops us.
* So `NSR - PSL - 1` gives the **width**, and `height[i]` is the **height**.

---

##  Sample Code (Logic Part Only):

### 👉 Previous Smaller Element:

```java
for (int i = 0; i < n; i++) {
    while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
        stack.pop();
    }
    res[i] = stack.isEmpty() ? -1 : stack.peek();
    stack.push(i);
}
```

### 👉 Next Smaller Element:

```java
for (int i = n - 1; i >= 0; i--) {
    while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
        stack.pop();
    }
    res[i] = stack.isEmpty() ? n : stack.peek();
    stack.push(i);
}
```

### 👉 Calculate Area:

```java
for (int i = 0; i < n; i++) {
    int height = heights[i];
    int width = next[i] - prev[i] - 1;
    maxArea = Math.max(maxArea, height * width);
}
```

---

##  Time Complexity:

* **O(n)** for each of the two passes (NS and PS)
* **O(n)** for final area calculation
* So overall: **`O(n)`**

##  Space Complexity:

* `O(n)` for stack and result arrays

---

##  Stack Type:

* Use **Monotonic Increasing Stack** (by height)
* Because we want to find the next/previous bar that is **smaller**, so we pop bigger bars

---

##  Dry Run Example:

For `heights = [2,1,5,6,2,3]`

At `i = 2` (height = 5):

* Previous smaller is `1`
* Next smaller is `4`
* Width = 4 - 1 - 1 = 2
* Area = 5 \* 2 = 10 ✅

---

##  Summary Table:

| Index | Height | PrevSmaller | NextSmaller | Width | Area |
| ----- | ------ | ----------- | ----------- | ----- | ---- |
| 0     | 2      | -1          | 1           | 1     | 2    |
| 1     | 1      | -1          | 6           | 6     | 6    |
| 2     | 5      | 1           | 4           | 2     | 10   |
| 3     | 6      | 2           | 4           | 1     | 6    |
| 4     | 2      | 1           | 6           | 4     | 8    |
| 5     | 3      | 4           | 6           | 1     | 3    |

 Max area = **10**

---



## ✅ Problem Name:  Online Stock Span (LeetCode 901)

---

## Approach:

We are asked to calculate the **stock span** for each day, i.e.,
How many consecutive days before today (including today) the stock price was **less than or equal to today’s price**.

A **stack-based approach** works best:

* Keep a **monotonic decreasing stack** of indices (prices in non-increasing order).
* For each new price, pop elements from the stack while they are smaller or equal to the current price → because they don’t contribute to the span anymore.
* The span is the difference between the current index and the index of the last greater element (if stack not empty). If the stack is empty, the span covers all previous days → `idx + 1`.
* Push the current index to the stack.

---

## Logic in Code:

```java
class StockSpanner {
    private Stack<Integer> stack;  // stores indices of prices
    private List<Integer> prices;  // stores all prices
    
    public StockSpanner() {
        stack = new Stack<>();
        prices = new ArrayList<>();
    }

    public int next(int price) {
        int idx = prices.size();    // current index
        prices.add(price);

        // Maintain decreasing stack (pop all smaller/equal prices)
        while (!stack.isEmpty() && price >= prices.get(stack.peek())) {
            stack.pop();
        }

        int span;
        if (stack.isEmpty()) {
            span = idx + 1; // covers all days so far
        } else {
            span = idx - stack.peek(); // distance from last greater price
        }

        stack.push(idx);
        return span;
    }
}
```

---

## Time Complexity (TC):

* Each element is pushed **once** and popped **at most once**.
* So across **n calls**, total work is **O(n)**.
* For each `next` call → **Amortized O(1)**.

---

## Space Complexity (SC):

* Stack stores indices → at most **O(n)** in worst case (strictly decreasing prices).
* Prices list also stores all values → **O(n)**.
* So, total **O(n)**.

---


### 📌 Problem Name: Remove All Adjacent Duplicates in String

---

### 🔑 Approach

* Use a **stack** to simulate the process of removing adjacent duplicates.
* Traverse the string one character at a time:

  * If the stack is **not empty** and the **top element is equal** to the current character → **pop** it (remove duplicate).
  * Otherwise → **push** the current character onto the stack.
* At the end, the stack will contain the result but in **reverse order**, so use a `StringBuilder` to reconstruct the string.

---

### 📝 Sample Logic (Pseudo + Java snippet)

```java
public String removeDuplicates(String s) {
    Stack<Character> stack = new Stack<>();
    
    for (char c : s.toCharArray()) {
        if (!stack.isEmpty() && stack.peek() == c) {
            stack.pop();  // remove duplicate
        } else {
            stack.push(c); // add character
        }
    }
    
    StringBuilder result = new StringBuilder();
    while (!stack.isEmpty()) {
        result.append(stack.pop());
    }
    
    return result.reverse().toString();
}
```

---

### ⏱ Time Complexity (TC)

* **O(n)** → Each character is pushed and popped at most once.

### 🗂 Space Complexity (SC)

* **O(n)** in worst case → if no duplicates exist, all characters stored in stack.



Do you want me to also show you the **optimized approach without stack** (using just a `StringBuilder` as stack)? That’s often asked in interviews.

---

Perfect bro 💯 let’s document this one also in the same **interview-notes style**.

---

### ✅ Problem Name : Sum of Subarray Minimums

---

### 🔑 Approach

We need to calculate the sum of the minimum element of every possible contiguous subarray.

👉 Brute force way (checking all subarrays) would be **O(n²)** or **O(n³)** → not efficient.
👉 Optimized approach uses **Monotonic Stack** to find:

* **Next Smaller Element on the Left (NSL)** → nearest index to the left with smaller value.
* **Next Smaller Element on the Right (NSR)** → nearest index to the right with smaller (or equal) value.

Why?

* Each element `arr[i]` will act as the **minimum** for some subarrays.
* Count how many subarrays it contributes to by calculating:

  * `leftDist = i - NSL[i]` → how many choices for left boundary.
  * `rightDist = NSR[i] - i` → how many choices for right boundary.
* Total subarrays where `arr[i]` is the minimum = `leftDist * rightDist`.
* Contribution of `arr[i]` = `arr[i] * leftDist * rightDist`.

Finally, add all contributions modulo **1e9+7**.

---

### 📝 Sample Logic (Pseudo + Java snippet)

```java
public int sumSubarrayMins(int[] arr) {
    int n = arr.length;
    int MOD = 1_000_000_007;
    
    int[] left = findLeftNextSmaller(arr, n);   // Nearest smaller index to left
    int[] right = findRightNextSmaller(arr, n); // Nearest smaller index to right
    
    long total = 0;
    for (int i = 0; i < n; i++) {
        long leftDist = i - left[i];
        long rightDist = right[i] - i;
        long ways = leftDist * rightDist;
        long contribution = (ways * arr[i]) % MOD;
        total = (total + contribution) % MOD;
    }
    return (int) total;
}

fucntion() -----------------
 public static int[] findLeftNextSmaller(int[] arr , int len){

        int[]res = new int[len];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<len;i++){

            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i] = -1;
            }else {
                res[i] = stack.peek();
            }
            stack.push(i);
        }
        
        return res;
    }

    public static int[] findRightNextSmaller(int[] arr , int len){

        int[]res = new int[len];
        Stack<Integer> stack = new Stack<>();

        for(int i = len-1;i>=0;i--){

            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }

            if(stack.isEmpty()){
                res[i] = len;
            }else{
                res[i] = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }


```

---

### ⏱ Time Complexity (TC)

* **O(n)** → Each element is pushed and popped once in monotonic stack for NSL and NSR.

### 🗂 Space Complexity (SC)

* **O(n)** → Arrays for `left` and `right` + stack usage.

---



### ✅ Problem Name : Backspace String Compare

---

### 🔑 Approach

We need to compare two strings where `#` acts like a backspace. After applying all backspaces, check if the final strings are equal.

👉 Naive way: Build both strings fully (using `Stack` or `StringBuilder`) → then compare.
👉 Optimized way (your code): Traverse from **right to left**, count how many backspaces (`#`) we need to apply, and skip those characters instead of building the whole string step by step.

Steps:

1. Start from the end of the string.
2. Maintain a `hashCount` (backspace count).
3. If `#` → increase `hashCount`.
4. If it’s a character:

   * If `hashCount > 0` → skip it (backspace applied).
   * Otherwise, append it to result.
5. Reverse the built string at the end.
6. Do this for both `s` and `t`, then compare.

---

### 📝 Sample Logic (Java snippet)

```java
public static String buildString(String str) {
    StringBuilder sb = new StringBuilder();
    int skip = 0;

    for (int i = str.length() - 1; i >= 0; i--) {
        char c = str.charAt(i);
        if (c == '#') {
            skip++;
        } else {
            if (skip > 0) {
                skip--; // skip this char
            } else {
                sb.append(c);
            }
        }
    }
    return sb.reverse().toString();
}

public static boolean backspaceCompare(String s, String t) {
    return buildString(s).equals(buildString(t));
}
```

---

### ⏱ Time Complexity (TC)

* **O(n + m)** → where `n` = length of `s`, `m` = length of `t`.
  (Each char is processed once).

### 🗂 Space Complexity (SC)

* **O(n + m)** in worst case if we store results in `StringBuilder`.
* Can be optimized to **O(1)** by using **two pointers without building strings** (direct compare from right to left).

---


### ✅ Problem Name : Basic Calculator
 (Evaluate Expression with `+`, `-`, and parentheses)

---

### 🔑 Approach

We need to evaluate a string expression with:

* Integers
* `+`, `-` operators
* Parentheses `()`

👉 We can’t use `eval()`, so simulate the evaluation manually.

Steps:

1. Traverse each character in the string.
2. **Digits** → build the current number `num` (take care of multi-digit numbers).
3. **Operator `+` or `-`** → add the previously formed number (`sign * num`) to `result`, reset `num`, update `sign`.
4. **Opening parenthesis `(`** → Push the current `result` and `sign` onto the stack, then reset `result` and `sign`.

   * This is like starting a new sub-expression.
5. **Closing parenthesis `)`** → Finish the current number, pop sign and previous result from stack, and combine them.
6. At the end, add any remaining number into the result.

---

### 📝 Sample Logic (Java snippet)

```java
public static int calculate(String s) {
    Stack<Integer> stack = new Stack<>();
    int result = 0;
    int num = 0;
    int sign = 1; // +1 or -1

    for (char ch : s.toCharArray()) {
        if (Character.isDigit(ch)) {
            num = num * 10 + (ch - '0'); // build number
        } else if (ch == '+') {
            result += sign * num;
            num = 0;
            sign = 1;
        } else if (ch == '-') {
            result += sign * num;
            num = 0;
            sign = -1;
        } else if (ch == '(') {
            stack.push(result); // save result so far
            stack.push(sign);   // save sign before parenthesis
            result = 0;
            sign = 1;
        } else if (ch == ')') {
            result += sign * num; // finalize inside parenthesis
            num = 0;
            int prevSign = stack.pop();
            int prevResult = stack.pop();
            result = prevResult + prevSign * result;
        }
    }

    if (num != 0) {
        result += sign * num; // last number
    }
    return result;
}
```

---

### ⏱ Time Complexity (TC)

* **O(n)** → One pass through the string.
* Each character is processed once.

### 🗂 Space Complexity (SC)

* **O(n)** in worst case → when we store nested parentheses in the stack.

---


### 📌 Problem Name: Basic Calculator II
 (Evaluate Expression with `+`, `-`, `*`, `/`)

---

### 🔑 Approach

We need to evaluate expressions with **operator precedence**:

* Multiplication `*` and Division `/` have higher priority.
* Addition `+` and Subtraction `-` have lower priority.

👉 Strategy:

* Use a **stack** to store numbers.
* Keep track of the **current number** (`num`) and the **last operator** (`opr`).
* Traverse the string:

  * If digit → build `num`.
  * If operator (or last char):

    * If previous `opr` was `+` → push `num`.
    * If previous `opr` was `-` → push `-num`.
    * If previous `opr` was `*` → pop top of stack, multiply with `num`, push result.
    * If previous `opr` was `/` → pop top of stack, divide by `num`, push result (truncate toward zero).
    * Reset `num` and update `opr`.
* At the end, sum everything in the stack.

---

### 📝 Sample Logic (Java snippet)

```java
public static int calculate(String s) {
    Stack<Integer> stack = new Stack<>();
    int num = 0;
    char opr = '+'; // default sign is '+'
    int n = s.length();

    for (int i = 0; i < n; i++) {
        char ch = s.charAt(i);

        if (Character.isDigit(ch)) {
            num = num * 10 + (ch - '0');
        }

        // If operator or last character
        if (!Character.isDigit(ch) && ch != ' ' || i == n - 1) {
            if (opr == '+') {
                stack.push(num);
            } else if (opr == '-') {
                stack.push(-num);
            } else if (opr == '*') {
                stack.push(stack.pop() * num);
            } else if (opr == '/') {
                stack.push(stack.pop() / num);
            }
            opr = ch;
            num = 0;
        }
    }

    int sum = 0;
    while (!stack.isEmpty()) {
        sum += stack.pop();
    }
    return sum;
}
```

---

### ⏱ Time Complexity (TC)

* **O(n)** → one pass through the string, each number/operator processed once.

### 🗂 Space Complexity (SC)

* **O(n)** → stack stores numbers in worst case (all `+`/`-` operations).

---

### 📌 Problem Name: Design Browser History

---

### 🔑 Approach

We need to simulate a browser’s history navigation system with the following operations:

* **visit(url)** → Navigate to a new page, clear all forward history.
* **back(steps)** → Move back up to `steps` pages, or as much as possible.
* **forward(steps)** → Move forward up to `steps` pages, or as much as possible.

👉 Idea:
Use **two stacks**:

* `backStack`: stores all pages you can go back to.
* `forwardStack`: stores all pages you can go forward to.
* `curr`: keeps track of the current page.

Operations:

1. **HomePage(url)** → set `curr` to homepage.
2. **visit(url)** → push `curr` into `backStack`, update `curr`, and clear `forwardStack`.
3. **back(steps)** → move elements from `backStack` to `forwardStack` until `steps` exhausted.
4. **forward(steps)** → move elements from `forwardStack` to `backStack` until `steps` exhausted.

---

### 📝 Sample Logic (Java snippet)

```java
class BrowserHistory {
    private Stack<String> backStack;
    private Stack<String> forwardStack;
    private String curr;

    public BrowserHistory(String homepage) {
        backStack = new Stack<>();
        forwardStack = new Stack<>();
        curr = homepage;
    }

    public void visit(String url) {
        backStack.push(curr);
        curr = url;
        forwardStack.clear(); // clear forward history
    }

    public String back(int steps) {
        while (!backStack.isEmpty() && steps > 0) {
            forwardStack.push(curr);
            curr = backStack.pop();
            steps--;
        }
        return curr;
    }

    public String forward(int steps) {
        while (!forwardStack.isEmpty() && steps > 0) {
            backStack.push(curr);
            curr = forwardStack.pop();
            steps--;
        }
        return curr;
    }
}
```

---

### Example Run

```java
BrowserHistory obj = new BrowserHistory("leetcode.com");
obj.visit("google.com");
obj.visit("facebook.com");
obj.visit("instagram.com");

System.out.println(obj.back(1));    // facebook.com
System.out.println(obj.back(1));    // google.com
System.out.println(obj.forward(2)); // instagram.com
```

---

### ⏱ Time Complexity (TC)

* **visit(url)** → O(1)
* **back(steps)** → O(min(steps, size of backStack))
* **forward(steps)** → O(min(steps, size of forwardStack))

### 🗂 Space Complexity (SC)

* **O(n)** → For storing history in stacks.

---
