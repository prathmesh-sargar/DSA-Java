Yes Prathmesh, I completely got your point — you want a **simple and effective one-sheet** that covers **everything important related to `HashMap` in Java**, especially used in **DSA (like Strings, Hashing, Frequency Map, etc.)**.

Here’s your **DSA-friendly HashMap OneSheet** 👇

---

## 🧠 **HashMap OneSheet for DSA (Java)**

### 📦 **What is a HashMap?**

A **HashMap** is a data structure that stores data in **key-value** pairs.

```java
Map<Character, Integer> map = new HashMap<>();
```

---

### 🛠️ **Basic Methods (with examples)**

| Method                       | Purpose                           | Example                     | Output / Behavior                 |
| ---------------------------- | --------------------------------- | --------------------------- | --------------------------------- |
| `put(key, value)`            | Insert or update value for key    | `map.put('a', 1);`          | Adds key `'a'` with value `1`     |
| `get(key)`                   | Get value for key                 | `map.get('a');`             | Returns `1`                       |
| `getOrDefault(key, default)` | Get value if exists, else default | `map.getOrDefault('b', 0);` | If `'b'` not in map → returns `0` |
| `containsKey(key)`           | Check if key exists               | `map.containsKey('a')`      | Returns `true`                    |
| `containsValue(value)`       | Check if any key has this value   | `map.containsValue(1)`      | Returns `true`                    |
| `remove(key)`                | Remove entry by key               | `map.remove('a')`           | Removes key `'a'`                 |
| `size()`                     | Get number of entries             | `map.size()`                | Returns `number` of entries       |
| `isEmpty()`                  | Check if map is empty             | `map.isEmpty()`             | Returns `true/false`              |
| `clear()`                    | Delete all entries                | `map.clear()`               | Empties the map                   |

---

### 💡 **Common Use Case in DSA: Frequency Map**

#### Count frequency of characters in a string:

```java
String s = "aabbc";
Map<Character, Integer> freq = new HashMap<>();

for (char ch : s.toCharArray()) {
    freq.put(ch, freq.getOrDefault(ch, 0) + 1);
}
```

> `getOrDefault(ch, 0)` → gives current count or 0 if not present
> Then we add 1 to it.

---

### 🔁 **Looping through HashMap**

#### Loop through keys:

```java
for (char key : freq.keySet()) {
    System.out.println(key);
}
```

#### Loop through values:

```java
for (int value : freq.values()) {
    System.out.println(value);
}
```

#### Loop through key-value pairs:

```java
for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
    System.out.println(entry.getKey() + " -> " + entry.getValue());
}
```

---

### 🧪 **Example Problems**

#### ✅ Find the first non-repeating character:

```java
Map<Character, Integer> map = new HashMap<>();
for (char ch : s.toCharArray()) {
    map.put(ch, map.getOrDefault(ch, 0) + 1);
}
for (int i = 0; i < s.length(); i++) {
    if (map.get(s.charAt(i)) == 1) return i;
}
return -1;
```

---

### 🚩 **Common Mistakes to Avoid**

| Mistake                                  | Fix                                            |
| ---------------------------------------- | ---------------------------------------------- |
| Forgetting `getOrDefault()` for counting | Always use it to avoid `null`                  |
| Assuming `map.get(key)` is never `null`  | Always check for `null` or use `containsKey()` |
| Using `==` to compare values             | Use `.equals()` for object values              |

---

### ✅ **Tips for DSA with HashMap**

* Use **Character** as key for **char** problems
* Use **String** as key for **substring** problems
* Use **Integer** as key for **index or number** frequency
* Always initialize with `new HashMap<>();`

---
