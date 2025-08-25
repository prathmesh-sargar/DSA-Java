
---

# 📝 Linked List Cheat Sheet (Java)

---

## 🔹 1. Node Structure

### Singly Linked List Node

```java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
```

### Doubly Linked List Node

```java
class DNode {
    int data;
    DNode prev, next;

    DNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
```

### Circular Linked List Node

(Same as singly/doubly, but last node connects back to head.)

---

## 🔹 2. Creating and Initializing Nodes

```java
Node head = new Node(10);         // first node
head.next = new Node(20);         // second node
head.next.next = new Node(30);    // third node
```

➡️ Now list = `10 -> 20 -> 30 -> null`

---

## 🔹 3. Traversal

```java
void printList(Node head) {
    Node curr = head;
    while (curr != null) {
        System.out.print(curr.data + " -> ");
        curr = curr.next;
    }
    System.out.println("null");
}
```

For **circular linked list**:

```java
void printCircular(Node head) {
    if (head == null) return;
    Node curr = head;
    do {
        System.out.print(curr.data + " -> ");
        curr = curr.next;
    } while (curr != head);
    System.out.println("(back to head)");
}
```

---

## 🔹 4. Insertion

### At Head

```java
Node newNode = new Node(val);
newNode.next = head;
head = newNode;
```

### At Tail

```java
Node newNode = new Node(val);
if (head == null) {
    head = newNode;
} else {
    Node curr = head;
    while (curr.next != null) curr = curr.next;
    curr.next = newNode;
}
```

### At Position (pos starts from 1)

```java
void insertAtPos(Node head, int pos, int val) {
    Node newNode = new Node(val);
    if (pos == 1) {
        newNode.next = head;
        head = newNode;
        return;
    }
    Node curr = head;
    for (int i = 1; i < pos - 1 && curr != null; i++) {
        curr = curr.next;
    }
    if (curr == null) return;
    newNode.next = curr.next;
    curr.next = newNode;
}
```

---

## 🔹 5. Deletion

### Delete Head

```java
head = head.next;
```

### Delete Tail

```java
Node curr = head;
while (curr.next.next != null) {
    curr = curr.next;
}
curr.next = null;
```

### Delete at Position

```java
void deleteAtPos(Node head, int pos) {
    if (head == null) return;
    if (pos == 1) {
        head = head.next;
        return;
    }
    Node curr = head;
    for (int i = 1; i < pos - 1 && curr != null; i++) {
        curr = curr.next;
    }
    if (curr == null || curr.next == null) return;
    curr.next = curr.next.next;
}
```

---

## 🔹 6. Important Operations

### Length of Linked List

```java
int length(Node head) {
    int count = 0;
    Node curr = head;
    while (curr != null) {
        count++;
        curr = curr.next;
    }
    return count;
}
```

### Search

```java
boolean search(Node head, int key) {
    Node curr = head;
    while (curr != null) {
        if (curr.data == key) return true;
        curr = curr.next;
    }
    return false;
}
```

---

## 🔹 7. Key Patterns for DSA/LeetCode

### Reverse a Linked List

```java
Node reverse(Node head) {
    Node prev = null, curr = head, next = null;
    while (curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}
```

### Find Middle (Tortoise & Hare)

```java
Node middle(Node head) {
    Node slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}
```

### Detect Cycle (Floyd’s Algorithm)

```java
boolean hasCycle(Node head) {
    Node slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) return true;
    }
    return false;
}
```

### Remove Nth Node from End

```java
Node removeNthFromEnd(Node head, int n) {
    Node dummy = new Node(0);
    dummy.next = head;
    Node first = dummy, second = dummy;
    for (int i = 0; i <= n; i++) first = first.next;
    while (first != null) {
        first = first.next;
        second = second.next;
    }
    second.next = second.next.next;
    return dummy.next;
}
```

### Merge Two Sorted Lists

```java
Node merge(Node l1, Node l2) {
    Node dummy = new Node(0), tail = dummy;
    while (l1 != null && l2 != null) {
        if (l1.data < l2.data) {
            tail.next = l1; l1 = l1.next;
        } else {
            tail.next = l2; l2 = l2.next;
        }
        tail = tail.next;
    }
    tail.next = (l1 != null) ? l1 : l2;
    return dummy.next;
}
```

---

## 🔹 8. Doubly Linked List (Basics)

* Traversal works both ways (`next` and `prev`).
* Insertion and deletion require updating **two pointers** instead of one.

Example insert at head:

```java
DNode newNode = new DNode(val);
newNode.next = head;
if (head != null) head.prev = newNode;
head = newNode;
```

---

## 🔹 9. Circular Linked List

* Last node points back to head.
* Useful for **round-robin scheduling**, **Josephus problem**.

Example insertion at tail:

```java
void insertCircular(Node head, int val) {
    Node newNode = new Node(val);
    if (head == null) {
        newNode.next = newNode;
        head = newNode;
        return;
    }
    Node curr = head;
    while (curr.next != head) curr = curr.next;
    curr.next = newNode;
    newNode.next = head;
}
```

---

## 🔹 10. Time Complexity Recap

| Operation      | Singly | Doubly                      | Notes |
| -------------- | ------ | --------------------------- | ----- |
| Traversal      | O(n)   | O(n)                        | —     |
| Insert at head | O(1)   | O(1)                        | —     |
| Insert at tail | O(n)   | O(1) (if tail pointer kept) |       |
| Delete at head | O(1)   | O(1)                        | —     |
| Delete at tail | O(n)   | O(1) (if tail pointer kept) |       |
| Search         | O(n)   | O(n)                        | —     |

---

## 🏆 Summary

* **Learn Node structure** (singly, doubly, circular).
* **Know how to initialize nodes and connect them**.
* **Master common operations** (insert, delete, traverse, search).
* **Memorize key DSA patterns** (reverse, middle, cycle, remove Nth, merge).
* **Understand time complexities**.

---
