
# 1. What is Recursion

Recursion means:

> A function **calls itself** to solve a smaller version of the same problem.

Basic structure:

```java
function(parameters){

    if(base condition)
        return answer

    do some work

    call function(smaller input)
}
```

Example:

Factorial

```
n! = n * (n-1)!
```

Java:

```java
int factorial(int n){
    if(n == 0) return 1;
    return n * factorial(n-1);
}
```

---

# 2. The 3 Rules of Recursion

Every recursive solution must have:

### 1️⃣ Base Case

Stopping condition.

Example:

```
n == 0
```

---

### 2️⃣ Smaller Subproblem

Each recursion must move toward the base case.

Example:

```
n → n-1
```

---

### 3️⃣ Stack Memory

Each function call is stored in the **call stack**.

Example:

```
factorial(4)
factorial(3)
factorial(2)
factorial(1)
```

Then stack unwinds.

---

# 3. Types of Recursion

### 1️⃣ Linear Recursion

Only **one recursive call**.

Example:

```
factorial
sum of numbers
```

Example code:

```java
int sum(int n){
    if(n == 0) return 0;
    return n + sum(n-1);
}
```

---

### 2️⃣ Binary Recursion

Two recursive calls.

Example:

```
Fibonacci
Subsequences
```

Example:

```java
fib(n) = fib(n-1) + fib(n-2)
```

---

### 3️⃣ Tree Recursion

Multiple recursive branches.

Example:

```
Subsets
Permutations
Backtracking
```

---

# 4. Recursion vs Iteration

| Iteration              | Recursion              |
| ---------------------- | ---------------------- |
| Uses loops             | Uses function calls    |
| Memory efficient       | Uses stack             |
| Hard for tree problems | Easy for tree problems |

---

# 5. Recursion Call Stack Example

Example:

```
print(3)
```

Code:

```java
void print(int n){
    if(n==0) return;

    print(n-1);

    System.out.println(n);
}
```

Call stack:

```
print(3)
print(2)
print(1)
print(0)
```

Output:

```
1
2
3
```

---

# 6. Two Core Recursion Styles

This is **VERY IMPORTANT**.

Most recursion problems follow **one of these**.

---

# Style 1 — Parameter Recursion

We **pass data as parameters**.

Example:

Subsequence sum.

```java
void solve(index, sum)
```

State is carried via parameters.

Example code:

```java
void print(int i){
    if(i == 0) return;
    print(i-1);
}
```

---

# Style 2 — Functional Recursion

Function **returns something**.

Example:

```
return left + right
```

Example:

```java
int sum(int n){
    if(n == 0) return 0;

    return n + sum(n-1);
}
```

---

# 7. Backtracking

Backtracking means:

> Undo a change before exploring another branch.

Example:

```
Add element
Explore recursion
Remove element
```

Example:

```java
current.add(arr[i]);

solve(i+1);

current.remove(current.size()-1);
```

Used in:

```
subsets
permutations
n queens
sudoku
```

---

# 8. Subsequence Pattern (VERY IMPORTANT)

Given array:

```
[1,2,3]
```

Total subsequences:

```
2^n
```

Because every element has two choices:

```
take
not take
```

Template:

```java
void solve(int index){

    if(index == n){
        print answer
        return;
    }

    take element
    solve(index+1)

    remove element

    not take element
    solve(index+1)
}
```

---

# 9. Subsequence Variations

### 1️⃣ Print all subsequences

Example:

```
[1,2]
```

Output:

```
[]
[1]
[2]
[1,2]
```

---

### 2️⃣ Subsequence sum = K

Add a **sum variable**.

```
if(sum == k)
    print
```

---

### 3️⃣ Print only one subsequence

Use **boolean return**.

```
if(found) return true
```

Stop recursion early.

---

### 4️⃣ Count subsequences

Return count.

```
return left + right
```

Example:

```java
return take + notTake;
```

---

# 10. Subset / Power Set Pattern

Same as subsequence.

Example:

```
[1,2,3]
```

Subsets:

```
[]
[1]
[2]
[3]
[1,2]
[1,3]
[2,3]
[1,2,3]
```

---

# 11. Permutation Pattern

Here each element must appear **once per position**.

Example:

```
[1,2,3]
```

Permutations:

```
123
132
213
231
312
321
```

Template:

```java
for(int i=0;i<n;i++){

    if(!used[i]){

        choose element

        recurse

        undo choice
    }
}
```

---

# 12. Combination Sum Pattern

Classic recursion problem.

Example:

```
arr = [2,3,6,7]
target = 7
```

Output:

```
[7]
[2,2,3]
```

Idea:

```
take element again
or move to next element
```

---

# 13. Recursion Time Complexity

If each step has 2 choices:

[
T(n) = 2^n
]

Example:

```
subsequences
subset generation
```

If permutations:

```
O(n!)
```

---

# 14. Common Recursion Interview Problems

### Easy

```
factorial
sum of array
reverse string
print 1 to n
```

---

### Medium

```
subsequences
subset sum
combination sum
permutations
```

---

### Hard

```
n queens
sudoku solver
word search
rat in maze
```

---

# 15. How To Identify Recursion

Ask yourself:

```
Can the problem be broken into smaller identical problems?
```

Example:

```
factorial
subsets
permutations
tree traversal
```

If yes → recursion works.

---

# 16. Common Mistakes

### 1️⃣ Missing base case

Causes infinite recursion.

---

### 2️⃣ Wrong state handling

Not restoring state.

Example:

```
forgot remove()
```

---

### 3️⃣ Stack overflow

Too deep recursion.

---

# 17. When NOT to Use Recursion

Avoid recursion when:

```
n very large
deep recursion
memory sensitive
```

Example:

```
fibonacci naive recursion
```

---

# 18. Convert Recursion to Iteration

Recursion uses:

```
call stack
```

Iteration uses:

```
loop + manual stack
```

Example:

Tree traversal using stack.

---

# 19. The Master Recursion Template

Most backtracking problems follow this:

```java
void solve(parameters){

    if(base case){
        store answer
        return;
    }

    for(each choice){

        make choice

        solve(next state)

        undo choice
    }
}
```

This solves:

```
subsets
permutations
n queens
combination sum
sudoku
```

---

# 20. Final Mental Model

Every recursion problem follows:

```
state
choices
base case
recursion
backtrack
```

---

# Brutal Truth For Placements

If you want recursion mastery for interviews, you must solve at least:

```
25 recursion problems
```

Key problems:

```
subsets
subset sum
permutations
combination sum
n queens
```

