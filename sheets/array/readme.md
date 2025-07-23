## 📚 **DSA Arrays OneSheet (Java)**

Arrays are the **foundation of DSA** — every beginner to pro-level problem builds on this. So here’s your go-to sheet 👇

---

### 📦 **What is an Array in Java?**

A **fixed-size container** that stores **elements of the same data type** in **contiguous memory**.

```java
int[] arr = new int[5];         // [0, 0, 0, 0, 0]
int[] arr2 = {1, 2, 3, 4, 5};   // Declared with values
```

---

### 🛠️ **Basic Operations**

| Operation          | Syntax                 | Notes                         |
| ------------------ | ---------------------- | ----------------------------- |
| Access element     | `arr[i]`               | `i` is index (0-based)        |
| Modify element     | `arr[i] = 10;`         | Updates value                 |
| Length of array    | `arr.length`           | Not a method, it's a property |
| Print all elements | `Arrays.toString(arr)` | Clean printing                |

---

### 🔁 **Looping Over Arrays**

#### ✅ For Loop:

```java
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

#### ✅ Enhanced For-Each Loop:

```java
for (int num : arr) {
    System.out.println(num);
}
```

---

### 🔧 **Useful Methods (from Arrays class)**

```java
import java.util.Arrays;
```

| Method                 | Example                       | Description               |
| ---------------------- | ----------------------------- | ------------------------- |
| `sort(arr)`            | `Arrays.sort(arr);`           | Sorts in ascending order  |
| `copyOf(arr, n)`       | `Arrays.copyOf(arr, 3);`      | Copies first `n` elements |
| `equals(a1, a2)`       | `Arrays.equals(arr1, arr2)`   | Compares arrays           |
| `fill(arr, val)`       | `Arrays.fill(arr, 0);`        | Fills all with same value |
| `binarySearch(arr, x)` | `Arrays.binarySearch(arr, x)` | **Sorted array only**     |

---

### ⚒️ **Common DSA Use Cases**

#### ✅ 1. Find Max & Min:

```java
int max = arr[0];
int min = arr[0];
for (int num : arr) {
    max = Math.max(max, num);
    min = Math.min(min, num);
}
```

#### ✅ 2. Reverse Array:

```java
int left = 0, right = arr.length - 1;
while (left < right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
    left++;
    right--;
}
```

#### ✅ 3. Check for Duplicate:

```java
Set<Integer> set = new HashSet<>();
for (int num : arr) {
    if (set.contains(num)) {
        System.out.println("Duplicate: " + num);
        break;
    }
    set.add(num);
}
```

#### ✅ 4. Frequency Count:

```java
Map<Integer, Integer> freq = new HashMap<>();
for (int num : arr) {
    freq.put(num, freq.getOrDefault(num, 0) + 1);
}
```

#### ✅ 5. Sum of Array:

```java
int sum = 0;
for (int num : arr) sum += num;
```

---

### 🔥 **Common Interview Questions**

| Question Type                    | Example                            |
| -------------------------------- | ---------------------------------- |
| Find 2 numbers with sum = target | Use HashMap or 2-pointer if sorted |
| Move all zeros to end            | Use two pointers                   |
| Rotate array                     | Reverse approach or use temp array |
| Maximum subarray sum             | Kadane’s Algorithm                 |
| Merge two sorted arrays          | Two-pointer approach               |

---

### 🚩 **Common Mistakes to Avoid**

| Mistake                         | Fix                                  |
| ------------------------------- | ------------------------------------ |
| Index out of bounds             | Always use `i < arr.length`          |
| Using `.length()` like a method | It's a **property**, not a method    |
| Confusing array vs ArrayList    | Array is fixed, ArrayList is dynamic |

---

### 🧠 **Tip for Arrays in DSA**

* Always **dry run** problems on paper.
* Use **HashMap or HashSet** when you need frequency or uniqueness.
* For **sorted arrays**, think of **two-pointer** or **binary search** techniques.

---