# Time Complexity

Time Complexity is a way of measuring how the running time of an algorithm grows as the size of the input increases. It helps us compare different approaches and choose the most efficient solution.

---

# Why is Time Complexity Important?

- It helps us choose the best algorithm.
- It allows us to predict how an algorithm performs for large inputs.
- It helps avoid **Time Limit Exceeded (TLE)** errors on coding platforms like LeetCode.

---

# LeetCode Input Constraints

Before solving any problem, always observe the input size.

Examples:

```
n = 100
n = 1,000
n = 10,000
n = 100,000
```

LeetCode generally allows approximately:

```
10^8 simple operations ≈ 1 second
```

If your algorithm performs significantly more than this, it may result in **Time Limit Exceeded (TLE)**.

---

# Common Time Complexities

| Time Complexity | Description |
|-----------------|-------------|
| O(1) | Constant Time |
| O(log n) | Logarithmic Time |
| O(n) | Linear Time |
| O(n log n) | Linearithmic Time |
| O(n²) | Quadratic Time |
| O(n³) | Cubic Time |

---

# O(1) - Constant Time

The number of operations does not depend on the input size.

Example:

```java
System.out.println("Hello");

int a = 10;
int b = 20;

return a + b;
```

Time Complexity:

```
O(1)
```

---

# O(n) - Linear Time

The number of operations increases proportionally with the input size.

Example:

```java
for(int i = 0; i < n; i++) {
    System.out.println(i);
}
```

Time Complexity:

```
O(n)
```

---

# Fixed Loop

A loop running a fixed number of times does **not** depend on the input.

Example:

```java
for(int i = 0; i < 100; i++) {
    System.out.println(i);
}
```

Time Complexity:

```
O(1)
```

because the loop always executes exactly **100 times**, regardless of the input size.

---

# Nested Loops

When one loop runs inside another loop, their time complexities multiply.

Example:

```java
for(int i = 0; i < n; i++) {

    for(int j = 0; j < n; j++) {

        System.out.println("Hello");

    }

}
```

Outer loop:

```
O(n)
```

Inner loop:

```
O(n)
```

Overall Time Complexity:

```
O(n²)
```

---

# Independent Code Sections

When a program contains multiple independent sections, calculate the time complexity of each section separately.

The overall time complexity is the **highest** among them.

Example:

```java
System.out.println("Hello");

for(int i = 0; i < n; i++) {

    System.out.println("World");

}
```

Time Complexities:

```
O(1)
O(n)
```

Overall Time Complexity:

```
O(n)
```

---

# Sorting Example

Example:

```java
System.out.println("Hello");

for(int i = 0; i < n; i++) {

    System.out.println(i);

}

Arrays.sort(arr);
```

Time Complexities:

```
O(1)
O(n)
O(n log n)
```

Overall Time Complexity:

```
O(n log n)
```

because it is the highest time complexity among all independent sections.

---

# Simplifying Time Complexity

While writing Big-O notation:

Ignore constants.

Examples:

```
O(n - 1)   → O(n)

O(2n)      → O(n)

O(3n + 5)  → O(n)

O(n² + 2n + n) → O(n²)
```

Only the highest-order term is considered.

---

# How to Find Time Complexity

1. Identify all loops.
2. Check whether the loops are nested or independent.
3. Multiply nested loops.
4. Compare independent sections.
5. Ignore constants and lower-order terms.
6. Write the highest-order term as the final Big-O notation.

---

# Key Takeaways

- Always check the input constraints before choosing an approach.
- Approximately **10⁸ operations** are acceptable for most LeetCode problems.
- Fixed loops have **O(1)** time complexity.
- A loop depending on **n** has **O(n)** time complexity.
- Nested loops multiply their complexities.
- For independent code sections, take the **maximum** time complexity.
- Ignore constants and lower-order terms while writing Big-O notation.
