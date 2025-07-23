
## 🧠 **HashSet OneSheet for DSA (Java)**

### 📦 **What is a HashSet?**

A **HashSet** is a data structure that stores **unique elements only** — no duplicates allowed!

```java
Set<Integer> set = new HashSet<>();
```

---

### 🛠️ **Basic Methods (with examples)**

| Method              | Purpose                           | Example            | Output / Behavior     |
| ------------------- | --------------------------------- | ------------------ | --------------------- |
| `add(element)`      | Adds an element                   | `set.add(5);`      | Adds 5 if not present |
| `contains(element)` | Checks if element is in set       | `set.contains(5);` | Returns `true`        |
| `remove(element)`   | Removes the element               | `set.remove(5);`   | Removes 5             |
| `size()`            | Returns number of unique elements | `set.size()`       | Returns `count`       |
| `isEmpty()`         | Checks if set is empty            | `set.isEmpty()`    | Returns `true/false`  |
| `clear()`           | Removes all elements              | `set.clear();`     | Empties the set       |

---

### 💡 **Common DSA Use Cases**

#### ✅ Check for duplicates in an array:

```java
int[] arr = {1, 2, 3, 2};
Set<Integer> seen = new HashSet<>();

for (int num : arr) {
    if (seen.contains(num)) {
        System.out.println("Duplicate found: " + num);
        break;
    }
    seen.add(num);
}
```

#### ✅ Count number of unique characters in a string:

```java
String s = "aabbc";
Set<Character> set = new HashSet<>();
for (char ch : s.toCharArray()) {
    set.add(ch);
}
System.out.println(set.size()); // 3 → a, b, c
```

---

### 🔁 **Looping through HashSet**

```java
for (int value : set) {
    System.out.println(value);
}
```

---

### 🧪 **Example Problems**

#### ✅ Check if two strings have same set of characters:

```java
Set<Character> set1 = new HashSet<>();
Set<Character> set2 = new HashSet<>();

for (char ch : str1.toCharArray()) set1.add(ch);
for (char ch : str2.toCharArray()) set2.add(ch);

return set1.equals(set2);
```

#### ✅ Remove duplicates from an array:

```java
int[] arr = {1, 2, 2, 3};
Set<Integer> set = new HashSet<>();
for (int num : arr) set.add(num);
// Now set contains: 1, 2, 3
```

---

### 🚩 **Common Mistakes to Avoid**

| Mistake                        | Fix                                                          |
| ------------------------------ | ------------------------------------------------------------ |
| Assuming `add()` always works  | It returns `false` if element already exists                 |
| Trying to get element by index | **HashSet has no order or index**! Use `ArrayList` if needed |
| Using `==` to compare objects  | Use `.equals()` for object comparison                        |

---

### 🧠 **Quick Recap: HashSet vs HashMap**

| Feature             | HashSet                      | HashMap                         |
| ------------------- | ---------------------------- | ------------------------------- |
| Stores              | Only values (unique)         | Key-value pairs                 |
| Duplicates allowed? | ❌ No                         | ✅ Keys: No, Values: Yes         |
| Common Use          | Duplicates check, uniqueness | Frequency maps, key-value logic |

---
