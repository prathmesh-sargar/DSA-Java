
## 🔥 Basic Concepts of `String` in Java

### ✅ 1. **String is Immutable**

* Once a string is created, it **cannot be changed**.

```java
String str = "Hello";
str.concat("World"); // does not change str
System.out.println(str); // Output: Hello
```

To change, you must reassign:

```java
str = str.concat("World");
```

---

### ✅ 2. **Creating Strings**

```java
String s1 = "Hello";             // String literal (stored in String pool)
String s2 = new String("Hello"); // new object in heap
```

---

### ✅ 3. **String Comparison**

```java
s1.equals(s2);       // content check ✅ (recommended)
s1 == s2;            // reference check ❌ (avoid unless necessary)
```

---

### ✅ 4. **Important String Methods**

| Method                            | Description                       | Example                           |
| --------------------------------- | --------------------------------- | --------------------------------- |
| `length()`                        | length of string                  | `"abc".length()` → 3              |
| `charAt(i)`                       | character at index                | `"abc".charAt(1)` → 'b'           |
| `substring(i,j)`                  | substring from i to j-1           | `"abcdef".substring(1,4)` → "bcd" |
| `equals(str2)`                    | compares content                  |                                   |
| `equalsIgnoreCase(str2)`          | case-insensitive compare          |                                   |
| `toCharArray()`                   | converts string to char array     |                                   |
| `indexOf(ch)`                     | first occurrence index            | `"apple".indexOf('p')` → 1        |
| `lastIndexOf(ch)`                 | last occurrence index             |                                   |
| `contains(str)`                   | checks if substring exists        |                                   |
| `startsWith("ab")`                | check prefix                      |                                   |
| `endsWith("yz")`                  | check suffix                      |                                   |
| `toLowerCase()` / `toUpperCase()` |                                   |                                   |
| `replace(old, new)`               | replaces characters or substrings |                                   |

---

### ✅ 5. **StringBuilder (for mutable strings)**

Use this when doing a lot of `+` operations.

```java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");   // modifies the same object
System.out.println(sb.toString()); // Hello World
```

**Why use `StringBuilder`?**
It avoids creating new objects again and again → faster and memory efficient.

---

### ✅ 6. **Conversion Between String and Others**

```java
// String → char array
char[] arr = str.toCharArray();

// char array → String
String str = new String(arr);

// int → String
String.valueOf(num); OR Integer.toString(num);

// String → int
Integer.parseInt(str); OR Integer.valueOf(str);
```

---

### ✅ 7. **Common DSA Problems on Strings**

Be prepared to solve:

* Reverse a string
* Palindrome check
* Remove duplicates
* Longest substring without repeating characters
* Anagram check
* String compression
* Count vowels/consonants/digits/special characters
* Substrings and subsequences
* Word count / frequency

---

### ✅ 8. **Character Functions**

```java
Character.isLetter(c)
Character.isDigit(c)
Character.isUpperCase(c)
Character.toLowerCase(c)
Character.toUpperCase(c)
```

---

## 💡 Tips to Master String Questions

* Use `StringBuilder` for heavy string manipulation
* Always understand time complexity of operations
* Practice character count using arrays or maps
* Focus on edge cases: empty string, same letters, different cases

---
