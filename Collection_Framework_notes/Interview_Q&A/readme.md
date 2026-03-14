# Java Collection Framework — Important Interview Questions (Developer Notes)

---

# 1. What is the Java Collection Framework?

### Interview Answer

> The Java Collection Framework (JCF) is a set of interfaces and classes in the `java.util` package that provide a unified architecture to store, manipulate, and process groups of objects dynamically.

### Why it exists

Before collections we used arrays:

```java
int arr[] = new int[5];
```

Problems:

* Fixed size
* Difficult to insert/delete
* No built-in algorithms
* Poor abstraction

Collections solved these problems.

### Key features

* Dynamic size
* Ready-made data structures
* Built-in algorithms
* Standardized APIs

---

# 2. What are the main components of the Collection Framework?

Three components exist.

### 1️⃣ Interfaces

Define behavior.

Examples:

```
List
Set
Queue
Map
Collection
```

### 2️⃣ Classes (Implementation)

Provide actual implementation.

Examples:

```
ArrayList
LinkedList
HashSet
TreeSet
HashMap
```

### 3️⃣ Algorithms

Utility methods for operations.

Examples:

```
Collections.sort()
Collections.reverse()
Collections.binarySearch()
```

---

# 3. Explain the Collection Framework hierarchy

The structure of collections follows **interface inheritance**.

```
Iterable
   |
Collection
   |
   |---- List
   |---- Set
   |---- Queue
             |
           Deque

Map (separate hierarchy)
```

Explanation:

| Interface  | Purpose                        |
| ---------- | ------------------------------ |
| Iterable   | Allows iteration               |
| Collection | Root interface for collections |
| List       | Ordered collection             |
| Set        | Unique elements                |
| Queue      | FIFO processing                |
| Deque      | Double ended queue             |

Map is separate because it stores **key-value pairs**.

---

# 4. Difference Between Collection and Collections

Many students confuse this.

### Collection

An **interface**.

Represents a group of objects.

Example:

```java
Collection<Integer> c = new ArrayList<>();
```

### Collections

A **utility class**.

Provides helper methods.

Example:

```java
Collections.sort(list);
```

Difference:

| Collection  | Collections         |
| ----------- | ------------------- |
| Interface   | Utility class       |
| Stores data | Provides algorithms |

---

# 5. Difference Between List and Set

| Feature      | List       | Set         |
| ------------ | ---------- | ----------- |
| Duplicates   | Allowed    | Not allowed |
| Order        | Maintained | Usually not |
| Index access | Yes        | No          |

Example:

### List

```java
[10, 20, 20, 30]
```

### Set

```java
[10, 20, 30]
```

---

# 6. Difference Between ArrayList and LinkedList

### ArrayList

Internal structure:

```
Dynamic Array
```

Advantages:

* Fast access
* Less memory

Disadvantages:

* Slow insertion in middle

Example:

```java
ArrayList<Integer> list = new ArrayList<>();
```

---

### LinkedList

Internal structure:

```
Doubly Linked List
```

Advantages:

* Fast insertion
* Fast deletion

Disadvantages:

* Slow random access

Example:

```java
LinkedList<Integer> list = new LinkedList<>();
```

---

### Time Complexity

| Operation | ArrayList | LinkedList |
| --------- | --------- | ---------- |
| Access    | O(1)      | O(n)       |
| Insert    | O(n)      | O(1)       |
| Delete    | O(n)      | O(1)       |

---

# 7. Difference Between HashSet and TreeSet

### HashSet

Uses hashing.

Properties:

* No duplicates
* No order

Example:

```java
HashSet<Integer> set = new HashSet<>();
```

Time complexity:

```
O(1)
```

---

### TreeSet

Uses Red-Black Tree.

Properties:

* Sorted order
* No duplicates

Example:

```java
TreeSet<Integer> set = new TreeSet<>();
```

Time complexity:

```
O(log n)
```

---

# 8. Difference Between HashMap and HashSet

Important interview question.

### HashMap

Stores:

```
key → value
```

Example:

```java
map.put(1,"Java");
```

---

### HashSet

Stores only values.

Example:

```java
set.add(10);
```

Important concept:

> HashSet internally uses HashMap.

Internally:

```
map.put(element, PRESENT)
```

---

# 9. How does HashMap work internally?

HashMap stores elements using **hashing**.

Steps:

### Step 1

Key's hashcode calculated.

```
hash(key)
```

### Step 2

Index calculated.

```
hash % capacity
```

### Step 3

Element stored in bucket.

Example:

```
index 3 → (key,value)
```

---

### Collision

Collision occurs when two keys produce the same index.

Example:

```
index 3 → (10,A) → (20,B)
```

Handled using:

```
Linked List
Red-Black Tree (Java 8)
```

---

# 10. What is Load Factor in HashMap?

Load factor determines when resizing occurs.

Default value:

```
0.75
```

Formula:

```
capacity × load factor
```

Example:

```
16 × 0.75 = 12
```

When size exceeds 12 → resizing happens.

---

# 11. What is Rehashing?

When capacity exceeds threshold:

1. New array created
2. Elements rehashed
3. Elements moved to new buckets

This process is called:

```
Rehashing
```

---

# 12. Difference Between HashMap and TreeMap

| Feature    | HashMap    | TreeMap        |
| ---------- | ---------- | -------------- |
| Order      | Unordered  | Sorted         |
| Structure  | Hash table | Red-Black Tree |
| Complexity | O(1)       | O(log n)       |

---

# 13. What is Comparable vs Comparator?

Used for sorting.

### Comparable

Defines natural ordering.

Example:

```java
class Student implements Comparable<Student>{
   public int compareTo(Student s){
       return this.age - s.age;
   }
}
```

---

### Comparator

Defines custom ordering.

Example:

```java
Collections.sort(list,(a,b)->a.age-b.age);
```

---

# 14. What is Fail Fast vs Fail Safe?

### Fail Fast

Throws exception when collection modified during iteration.

Example:

```
ArrayList
HashMap
```

Exception:

```
ConcurrentModificationException
```

---

### Fail Safe

Works on a copy.

Example:

```
CopyOnWriteArrayList
ConcurrentHashMap
```

---

# 15. What is Iterator?

Iterator is used to traverse collections.

Methods:

```
hasNext()
next()
remove()
```

Example:

```java
Iterator<Integer> it = list.iterator();

while(it.hasNext()){
    System.out.println(it.next());
}
```

---

# 16. What is Queue?

Queue follows:

```
FIFO
First In First Out
```

Example:

```
10 → 20 → 30
remove → 10
```

Common implementations:

```
PriorityQueue
LinkedList
ArrayDeque
```

---

# 17. What is PriorityQueue?

PriorityQueue processes elements based on priority.

Example:

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
```

Internal structure:

```
Binary Heap
```

Time complexity:

```
O(log n)
```

---

# 18. What is Deque?

Deque means:

```
Double Ended Queue
```

Elements can be added or removed from both ends.

Example:

```java
Deque<Integer> dq = new ArrayDeque<>();
```

Methods:

```
addFirst()
addLast()
removeFirst()
removeLast()
```

---

# 19. Why Map is not part of Collection?

Because Collection stores:

```
Single elements
```

Example:

```
[10,20,30]
```

Map stores:

```
Key-value pairs
```

Example:

```
1 → "Java"
```

So it has a separate hierarchy.

---

# 20. When to use which collection?

| Situation              | Collection    |
| ---------------------- | ------------- |
| Fast access            | ArrayList     |
| Frequent insert/delete | LinkedList    |
| Unique elements        | HashSet       |
| Sorted data            | TreeSet       |
| Key-value lookup       | HashMap       |
| Sorted keys            | TreeMap       |
| Priority tasks         | PriorityQueue |

---

# Final Advice

If you want to **master collections for interviews**, focus deeply on:

```
HashMap internal working
Hashing
Load factor
Rehashing
equals() and hashCode()
Comparable vs Comparator
ConcurrentHashMap
```

Those topics appear in **almost every Java interview**.

---
