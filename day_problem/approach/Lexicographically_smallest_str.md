
## 📝 Problem Statement

Given a lowercase string `s`, remove all duplicate characters and return a **new string** where

1. All **vowels** (`a, e, i, o, u`) appear first in **lexicographical (sorted) order**, and
2. All **consonants** appear after the vowels, also in **sorted order**.

---

## 🔹 Input / Output

**Input:**

* A single string `s` consisting of lowercase English letters.
* Example: `"acbacae"`

**Output:**

* A string with **unique characters**, vowels first (sorted), then consonants (sorted).
* Example: `"aacebc"` → Output: `"ae b c"` → `"aebc"`

---

## 💡 Approach

1. **Use a Set to remove duplicates:**

   * Traverse the string and add each character to a `HashSet` to keep only unique letters.

2. **Separate vowels and consonants:**

   * Iterate over the unique set.
   * Append vowels to a `StringBuilder` `vowels` and consonants to another `StringBuilder` `consonants`.

3. **Sort each group:**

   * Convert `vowels` and `consonants` to character arrays.
   * Use `Arrays.sort()` to sort them individually in ascending lexicographical order.

4. **Combine the result:**

   * Concatenate the sorted vowels + sorted consonants and return.

---

## 🧩 Sample Code Logic

```java
public static String lexicographicalStr(String s) {
    Set<Character> set = new HashSet<>();
    for (char ch : s.toCharArray()) set.add(ch);   // remove duplicates

    StringBuilder vowels = new StringBuilder();
    StringBuilder consonants = new StringBuilder();

    for (char ch : set) {
        if ("aeiou".indexOf(ch) != -1) vowels.append(ch);
        else consonants.append(ch);
    }

    char[] vArr = vowels.toString().toCharArray();
    char[] cArr = consonants.toString().toCharArray();
    Arrays.sort(vArr);
    Arrays.sort(cArr);

    return new String(vArr) + new String(cArr);
}
```

---

## ⏱️ Time Complexity

* **Building set:** `O(n)` (where `n` is the length of input).
* **Sorting:** At most 26 letters → `O(26 log 26)` ≈ `O(1)` (constant).
* **Total:** **O(n)** (dominated by traversing the string).

## 🗂️ Space Complexity

* Set + two builders: up to 26 unique chars → **O(1)** extra space.

