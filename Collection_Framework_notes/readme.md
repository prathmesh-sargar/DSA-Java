# Java Collection Framework — Developer & Interview Notes

## 1. What is the Collection Framework?

**Definition (Interview answer):**

> The Java Collection Framework (JCF) is a set of interfaces and classes in the `java.util` package that provide a standardized way to store, manage, and manipulate groups of objects dynamically.

### Why it exists

Before collections:

```java
int arr[] = new int[5];
```

Problems with arrays:

* Fixed size
* Cannot grow dynamically
* No built-in operations (search, delete, sort)
* Poor abstraction

So Java introduced **Collections in JDK 1.2**.

Collections provide:

* Dynamic data structures
* Reusable algorithms
* Standard APIs

---

# 2. Collection Framework Architecture

This is **one of the most important interview concepts**.

```
                Iterable
                    |
                Collection
         ___________|___________
        |           |           |
      List         Set        Queue
                                  |
                                Deque

Separate Interface:
Map
```

Important point:

**Map is NOT part of Collection**

Why?

Because:

* Collection → stores individual objects
* Map → stores key-value pairs

Example:

```
Collection → [10,20,30]

Map → {1=Prathmesh, 2=Rahul}
```

---

# 3. Iterable Interface

Top interface in the hierarchy.

Important method:

```
iterator()
```

Example:

```java
Iterator<Integer> it = list.iterator();

while(it.hasNext()){
   System.out.println(it.next());
}
```

Why important?

Because **for-each loop internally uses Iterator**.

Example:

```java
for(Integer i : list)
```

This internally converts to iterator.

---

# 4. Collection Interface

Root interface of most collections.

Important methods:

```
add()
remove()
size()
isEmpty()
contains()
clear()
```

Example:

```java
Collection<Integer> c = new ArrayList<>();

c.add(10);
c.add(20);
```

---

# 5. List Interface

Definition:

> Ordered collection that allows duplicates.

Properties:

* Maintains insertion order
* Allows duplicates
* Allows indexing

Example:

```
[10,20,20,30]
```

Implementations:

```
ArrayList
LinkedList
Vector
Stack
```

---

# 6. ArrayList

Most widely used List implementation.

Internal structure:

```
Dynamic Array
```

Example:

```java
ArrayList<Integer> list = new ArrayList<>();

list.add(10);
list.add(20);
list.add(30);
```

Output:

```
[10,20,30]
```

---

## ArrayList Time Complexity

| Operation     | Complexity |
| ------------- | ---------- |
| add()         | O(1)       |
| get()         | O(1)       |
| insert middle | O(n)       |
| delete        | O(n)       |

Reason:

Elements shift in memory.

Example:

```
[10,20,30,40]

insert 25 at index 2
```

Result:

```
[10,20,25,30,40]
```

Elements shift → O(n)

---

# 7. ArrayList Internal Working

Default capacity:

```
10
```

When capacity exceeds:

New capacity formula:

```
newCapacity = oldCapacity + oldCapacity/2
```

Example:

```
10 → 15 → 22 → 33
```

This process is called:

```
Dynamic resizing
```

---

# 8. LinkedList

Internal structure:

```
Doubly Linked List
```

Node structure:

```
prev | data | next
```

Example:

```
10 ⇄ 20 ⇄ 30 ⇄ 40
```

Example code:

```java
LinkedList<Integer> list = new LinkedList<>();

list.add(10);
list.add(20);
list.add(30);
```

---

## LinkedList Time Complexity

| Operation       | Complexity |
| --------------- | ---------- |
| insert          | O(1)       |
| delete          | O(1)       |
| access by index | O(n)       |

Because traversal required.

---

# 9. ArrayList vs LinkedList

| Feature   | ArrayList     | LinkedList         |
| --------- | ------------- | ------------------ |
| Structure | Dynamic array | Doubly linked list |
| Access    | Fast          | Slow               |
| Insert    | Slow          | Fast               |
| Memory    | Less          | More               |

Interview answer summary:

> Use ArrayList for frequent reads and LinkedList for frequent insertions/deletions.

---

# 10. Vector

Vector is a **legacy class**.

Similar to ArrayList but:

```
Thread-safe
```

Example:

```java
Vector<Integer> v = new Vector<>();
```

Problem:

All methods are synchronized → slower.

Modern replacement:

```
ArrayList
CopyOnWriteArrayList
```

---

# 11. Stack

Follows:

```
LIFO
Last In First Out
```

Example:

```
push(10)
push(20)
push(30)

pop() → 30
```

Methods:

```
push()
pop()
peek()
```

Modern Java recommendation:

```
Deque instead of Stack
```

---

# 12. Set Interface

Definition:

> Collection that does not allow duplicate elements.

Example:

```
[10,20,30]
```

If duplicate added:

```
set.add(20)
```

Ignored.

Implementations:

```
HashSet
LinkedHashSet
TreeSet
```

---

# 13. HashSet

Internal structure:

```
HashMap
```

Very important interview point.

When we write:

```java
set.add(10);
```

Internally:

```
map.put(10, PRESENT)
```

So HashSet internally uses HashMap.

---

# 14. Hashing Concept

Hashing converts key → index.

Example:

```
hash(key) % capacity
```

Example:

```
index 2 → [20,50,70]
```

If multiple elements map to same bucket → collision.

Solutions:

```
Linked list
Tree (after Java 8)
```

---

# 15. LinkedHashSet

Maintains insertion order.

Example:

```
[10,20,30]
```

Internal structure:

```
Hash table + Linked list
```

---

# 16. TreeSet

Stores elements in sorted order.

Example:

```java
TreeSet<Integer> set = new TreeSet<>();

set.add(30);
set.add(10);
set.add(20);
```

Output:

```
10 20 30
```

Internal structure:

```
Red Black Tree
```

Complexity:

```
O(log n)
```

---

# 17. Queue Interface

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

Methods:

```
offer()
poll()
peek()
```

Implementations:

```
PriorityQueue
LinkedList
ArrayDeque
```

---

# 18. PriorityQueue

Elements ordered by priority.

Example:

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();

pq.add(30);
pq.add(10);
pq.add(20);
```

Output order:

```
10 20 30
```

Internal structure:

```
Binary Heap
```

---

# 19. Deque

Double ended queue.

Operations:

```
addFirst()
addLast()
removeFirst()
removeLast()
```

Implementation:

```
ArrayDeque
```

Used as:

```
Stack
Queue
```

---

# 20. Map Interface

Stores:

```
key → value
```

Example:

```java
Map<Integer,String> map = new HashMap<>();

map.put(1,"Prathmesh");
map.put(2,"Rahul");
```

Implementations:

```
HashMap
LinkedHashMap
TreeMap
Hashtable
```

---

# 21. HashMap

Most important collection.

Internal structure:

```
Array of buckets
```

Each bucket contains:

```
Node(hash,key,value,next)
```

Example bucket:

```
index 2 → (10,A) → (20,B)
```

Collision handled by:

```
Linked list
Red Black Tree (Java 8)
```

---

# 22. Load Factor

Load factor determines when resizing happens.

Default:

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

After 12 elements → resizing happens.

---

# 23. Comparable vs Comparator

Sorting mechanisms.

### Comparable

Natural ordering.

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

Custom sorting.

Example:

```java
Collections.sort(list,(a,b)->a.age-b.age);
```

---

# 24. Collections Utility Class

Important methods:

```
sort()
reverse()
shuffle()
min()
max()
binarySearch()
```

Example:

```java
Collections.sort(list);
```

---

# 25. Fail Fast vs Fail Safe

Fail Fast example:

```
ArrayList
HashMap
```

Throws:

```
ConcurrentModificationException
```

Example:

```java
for(Integer i : list){
 list.remove(i);
}
```

---

Fail Safe example:

```
CopyOnWriteArrayList
ConcurrentHashMap
```

Works on copy.

---

# 26. Real World Examples

### Example 1 — Instagram followers

Duplicates not allowed:

```
Set
```

---

### Example 2 — Banking system

Account number → account details

```
Map
```

---

### Example 3 — Playlist

Songs order matters:

```
List
```

---

### Example 4 — Task scheduling

Priority based:

```
PriorityQueue
```

---

# 27. Important Interview Questions

### Why Map is not part of Collection?

Because Map stores key-value pairs.

---

### Difference between HashMap and HashSet?

HashSet internally uses HashMap.

---

### Difference between HashMap and TreeMap?

| HashMap   | TreeMap  |
| --------- | -------- |
| Unordered | Sorted   |
| O(1)      | O(log n) |

---

### Why equals() and hashCode() important?

Used for hashing collections like:

```
HashMap
HashSet
```

---

# 28. Things Good Developers Must Know

You should deeply understand:

```
HashMap internal working
Hashing
Load factor
Rehashing
equals() vs hashCode()
Comparable vs Comparator
ConcurrentHashMap
```

---

# Final Advice (honest one)

Most students **memorize class names**.

Interviewers test:

```
How HashMap works internally
How collision resolved
Why equals and hashCode needed
How resizing works
```

If you know these deeply → you look like a **real Java developer**, not a tutorial watcher.

---
