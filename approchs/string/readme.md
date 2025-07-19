
### ✅ Problem:

Check whether a given string is a **valid palindrome**, after:

* Converting all characters to lowercase.
* Removing all **non-alphanumeric** characters (like spaces, commas, colons, etc.).
* Then checking if the processed string reads the same forward and backward.

---

###  Approach:

1. **Preprocessing the String**:

   * Create a `StringBuilder` to store only **alphanumeric characters**.
   * Convert **uppercase letters to lowercase**.
   * Ignore non-alphanumeric characters.

2. **Check for Palindrome using Two Pointers**:

   * Use two pointers: one from the start and one from the end.
   * Compare characters until the pointers cross.
   * If at any point they don’t match → return false.
   * If the loop completes → it’s a palindrome.

---

###  Core Logic (Code Sample Only):

```java
StringBuilder sb = new StringBuilder();

for (int i = 0; i < s.length(); i++) {
    char ch = s.charAt(i);
    if (Character.isLetterOrDigit(ch)) {
        sb.append(Character.toLowerCase(ch));
    }
}

int start = 0, end = sb.length() - 1;
while (start < end) {
    if (sb.charAt(start) != sb.charAt(end)) {
        return false;
    }
    start++;
    end--;
}
return true;
```

---

###  Time and Space Complexity:

| Complexity | Value | Explanation                                         |
| ---------- | ----- | --------------------------------------------------- |
| ⏰ Time     | O(n)  | One pass to filter and one pass to check palindrome |
| 🧠 Space   | O(n)  | `StringBuilder` stores the filtered characters      |

---



## ✅ Problem:

Given a string `s`, return `true` \*\*if it can become a palindrome after deleting ***at most one character***.

### ✨ Examples:

* `"aba"` → ✅ already a palindrome → return `true`
* `"abca"` → ❌ not a palindrome, but if we remove `'c'`, it becomes `"aba"` → return `true`
* `"abc"` → ❌ even after removing one character, it can’t be a palindrome → return `false`

---

##  Approach:

1. Use **two pointers**: `left` at the start, `right` at the end.
2. Traverse:

   * If characters match → move both pointers.
   * If characters **don’t match** → you can:

     * Remove the left character: check if `s[left+1...right]` is a palindrome
     * Remove the right character: check if `s[left...right-1]` is a palindrome
   * If either of those substrings is a palindrome → return `true`.
3. If loop finishes normally → it's a valid palindrome.

---

##  Core Logic (Code Sample Only):

```java
public static boolean isPalindrome(String s, int left, int right) {
    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) return false;
        left++;
        right--;
    }
    return true;
}

public static boolean validPalindrome(String s) {
    int left = 0, right = s.length() - 1;

    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) {
            return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
        }
        left++;
        right--;
    }
    return true;
}
```

---

##  Time and Space Complexity:

| Complexity | Value | Explanation                                                                 |
| ---------- | ----- | --------------------------------------------------------------------------- |
| ⏰ Time     | O(n)  | One pass through the string, worst case two passes when checking substrings |
| 🧠 Space   | O(1)  | Constant extra space (no data structures used)                              |

---

## 💡 Intuition Tip:

You're allowed **only 1 delete**, so as soon as mismatch happens, you branch into **two possibilities**:

* remove left
* remove right
  And check if either of them is a valid palindrome.

---


## ✅ Problem:

Given the `head` of a **singly linked list**, return `true` if the linked list is a **palindrome**, and `false` otherwise.

### ✨ Example:

```plaintext
Input:  1 → 2 → 2 → 1  
Output: true

Input:  1 → 2 → 3 → 1  
Output: false
```

---

##  Approach:

### 📌 Method: **Stack + Two Pointers**

1. Traverse the linked list from head and **push all values into a Stack** (LIFO).
2. Then, traverse the list again from the beginning.
3. On each step:

   * Pop from the stack (which gives reverse order).
   * Compare with current node value.
4. If all values match → it's a palindrome.

---

##  Core Logic (Code Sample Only):

```java
public static boolean isPalindrome(ListNode head) {
    Stack<Integer> st = new Stack<>();
    ListNode ptr = head;

    // Push all node values into stack
    while (ptr != null) {
        st.push(ptr.val);
        ptr = ptr.next;
    }

    // Reset pointer to head
    ptr = head;

    // Compare node values with stack
    while (ptr != null) {
        if (ptr.val != st.pop()) {
            return false;
        }
        ptr = ptr.next;
    }

    return true;
}
```

---

##  Time and Space Complexity:

| Complexity | Value | Explanation                                                           |
| ---------- | ----- | --------------------------------------------------------------------- |
| ⏰ Time     | O(n)  | Two full traversals of the list (once for stack, once for comparison) |
| 🧠 Space   | O(n)  | Stack stores all node values                                          |

---

##  Alternate Efficient Approach (Optional)

Want to reduce space to **O(1)**? You can:

* Find the middle using **slow and fast pointers**
* Reverse the second half
* Compare both halves

Let me know if you want this optimized method too!

---



## ✅ Problem:

Given a string `s`, find the **length of the longest substring** without repeating characters.

### ✨ Example:

```
Input:  "abcabcbb"   → Output: 3  → Explanation: "abc"
Input:  "bbbbb"      → Output: 1  → Explanation: "b"
Input:  "pwwkew"     → Output: 3  → Explanation: "wke"
```

> ⚠️ Note: The answer must be a **substring** (continuous characters), not a **subsequence**.

---

##  Approach: Sliding Window + HashSet

1. Use two pointers: `left` and `right` to define a window over the string.
2. Use a `HashSet` to store characters in the current window.
3. Expand the `right` pointer to add new characters.
4. If a duplicate character is found:

   * Remove characters from the `left` side **until** the duplicate is removed.
5. Track the maximum length of a valid window (no duplicates).

---

##  Code (Core Logic Only):

```java
public static int lengthOfLongestSubstring(String s) {
    int left = 0, maxLen = 0;
    HashSet<Character> set = new HashSet<>();

    for (int right = 0; right < s.length(); right++) {
        char ch = s.charAt(right);
        while (set.contains(ch)) {
            set.remove(s.charAt(left));
            left++;
        }
        set.add(ch);
        maxLen = Math.max(maxLen, right - left + 1);
    }

    return maxLen;
}
```

---

##  Time and Space Complexity:

| Complexity | Value          | Explanation                                                    |
| ---------- | -------------- | -------------------------------------------------------------- |
| ⏰ Time     | O(n)           | Each character is processed at most twice                      |
| 🧠 Space   | O(min(n, 128)) | Because at most 128 ASCII characters are stored in the HashSet |

---

## 💡 Tip:

This is a **perfect example of sliding window technique**. If you're good at this one, you'll be able to solve more advanced problems like:

* Longest substring with at most K distinct characters
* Minimum window substring
* Longest repeating character replacement

---

### ✅ Problem Statement:

Given strings `s` and `p`, return all the **start indices** of `p`'s anagrams in `s`.

---

###  Key Concepts Used:

* **Sliding Window**: A window of size `p.length()` slides over string `s`.
* **Frequency Count**: Count of each character in both the window (sCount) and pattern (pCount).
* **Comparing Arrays**: If both frequency arrays are equal, it means the current window is an anagram.

---

###  Step-by-Step Approach:

#### 🔹 Step 1: Create a frequency count for `p`

* Create an array `pCount[26]` to store character counts of pattern `p`.

#### 🔹 Step 2: Use sliding window on `s`

* Iterate through each character in `s`.
* Maintain a window of size equal to `p.length()` by updating `sCount[26]`.

#### 🔹 Step 3: Shrink the window when its size exceeds `p.length()`

* Remove the character that is sliding out from the left of the window.

#### 🔹 Step 4: Compare frequency arrays

* If the current window’s frequency matches `pCount`, record the start index.

---

###  Dry Run Example:

Let `s = "cbaebabacd"` and `p = "abc"`

* `pCount = [1,1,1,...]` for a, b, c
* Sliding window:

  * `"cba"` → match → add `0`
  * `"bae"` → no match
  * `"aeb"` → no match
  * ...
  * `"bac"` → match → add `6`

---

###  Time and Space Complexity:

* **Time:** O(n) where `n = s.length()` (each character is processed once)
* **Space:** O(1) – only 26-length arrays used

---

###  Java Code (Optimized and Clean):

```java
public class Find_All_Anagrams_in_a_String {
    public static List<Integer> findAnagrams(String s, String p) {
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        List<Integer> result = new ArrayList<>();

        // Frequency count of pattern p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            // Add current char to sCount
            sCount[s.charAt(i) - 'a']++;

            // Remove char left out of window
            if (i >= p.length()) {
                sCount[s.charAt(i - p.length()) - 'a']--;
            }

            // Compare frequency arrays
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p)); // Output: [0, 6]
    }
}
```

---

### ✅ Summary:

* Use sliding window + frequency count for optimal solution.
* This avoids sorting or extra memory.
* Works in linear time with constant space.

Let me know if you want a visual explanation or animation-based dry run.




### 🔍 ** ✅Problem: Minimum Window Substring**

**Goal**: Find the smallest substring in `s` that contains all characters of string `t` (including duplicates).
**Constraints**:

* If no such substring exists, return `""`.
* Time complexity should be better than brute force.

---

### **Approach (Optimized using Sliding Window + HashMap)**

#### 1. **Understand the problem**

We are given two strings:

* `s` (the full string we search within)
* `t` (the target string whose characters must appear in the window)

We need to return the smallest window from `s` that contains all characters from `t`.

---

#### 2. **Create a frequency map for `t`**

We first create a HashMap `mp` to store how many times each character appears in `t`.
This helps us keep track of what characters are needed and how many of them are needed.

```java
for(char ch : t.toCharArray()){
    mp.put(ch, mp.getOrDefault(ch, 0) + 1);
}
```

---

#### 3. **Use Two Pointers `i` and `j` to form the sliding window**

* `j` is the end of the current window (expanding).
* `i` is the start of the current window (shrinking).

We move `j` one by one to include characters and try to match all characters from `t`.
We reduce the required character count (`requireCount`) every time we match a character.

---

#### 4. **When all required characters are matched**

That means `requireCount == 0`.
Now we try to **shrink** the window from the left (`i++`) to find the smallest valid window.

---

#### 5. **Track the minimum window**

We store:

* `start_i`: starting index of smallest window found
* `minWindowsize`: its length

Update these when we find a new smaller valid window.

---

#### 6. **Shrinking logic**

When shrinking the window, if we remove a character that is in `t` (map), we must **increase** `requireCount` again because we lost one needed character.

---

#### 7. **Final Result**

After the loop ends, if `minWindowsize` is never updated (still `Integer.MAX_VALUE`), return empty string `""`.
Else return the substring from `start_i` of length `minWindowsize`.

```java
return minWindowsize == Integer.MAX_VALUE ? "" : s.substring(start_i, start_i + minWindowsize);
```

---

### ⏱️ **Time Complexity**

* O(n + m): where n is the length of `s`, m is the length of `t`.
* Each character is processed at most twice (once by `j`, once by `i`).

---

### ✅ **Example**

**Input:**
`s = "ADOBECODEBANC"`
`t = "ABC"`

**Output:** `"BANC"`
Because it is the shortest window that contains A, B, and C.

