
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