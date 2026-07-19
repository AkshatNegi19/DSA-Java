# 977. Squares of a Sorted Array

## Difficulty

**Easy**

---

# Pattern

**Two Pointers**

---

# Problem Statement

Given an integer array `nums` sorted in **non-decreasing order**, return an array of the **squares** of each number, also sorted in **non-decreasing order**.

### Example

```text
Input:
nums = [-4,-1,0,3,10]

Output:
[0,1,9,16,100]
```

---

# Brute Force Approach

The simplest approach is:

1. Traverse the array and square every element.
2. Sort the resulting array.

### Steps

- Square every element.
- Sort the squared array.
- Return the sorted array.

### Time Complexity

```
Squaring  -> O(n)
Sorting   -> O(n log n)

Overall   -> O(n log n)
```

Although this approach works, sorting increases the overall time complexity.

---

# Optimized Approach

Instead of sorting after squaring, we can make use of the fact that the input array is already sorted.

The negative numbers appear first, followed by the non-negative numbers.

We split the array into two arrays:

- Negative numbers
- Non-negative numbers

After squaring:

- The negative array becomes sorted in **decreasing order**, so we reverse it.
- The positive array is already sorted after squaring.

Finally, merge both sorted arrays using the **Two Pointer** technique.

This reduces the overall time complexity to **O(n)**.

---

# My Understanding

Consider the array:

```text
nums = [-4,-1,0,3,10]
```

Split it into two arrays:

```text
Negative Array

[-4,-1]

Positive Array

[0,3,10]
```

After squaring:

```text
Negative

[16,1]

Positive

[0,9,100]
```

Reverse the negative array:

```text
[1,16]
```

Now both arrays are sorted.

```text
[1,16]

[0,9,100]
```

Merge both arrays using Two Pointers.

Final Answer:

```text
[0,1,9,16,100]
```

---

# Algorithm

## Step 1

Traverse the original array.

Store:

- Negative numbers in array `a`
- Positive numbers in array `b`

---

## Step 2

Square every element of both arrays.

---

## Step 3

Reverse the negative array because:

```text
[-4,-1]

↓

[16,1]

↓

[1,16]
```

---

## Step 4

Merge both sorted arrays.

```
i = 0
j = 0

while(i < n && j < m)

    if(a[i] <= b[j])

        res[id] = a[i]
        i++

    else

        res[id] = b[j]
        j++

    id++

Copy remaining elements of both arrays.
```

---

# Special Cases

### Case 1

Only positive numbers

```text
[1,2,3]
```

Simply square every element.

No reversing is required.

---

### Case 2

Only negative numbers

```text
[-5,-3,-1]
```

Square every element.

Reverse the array.

Return the result.

---

### Case 3

Both negative and positive numbers

```text
[-4,-1,0,3,10]
```

Split

↓

Square

↓

Reverse the negative array

↓

Merge

↓

Return the result

---

# Time Complexity

Traversing Array

```
O(n)
```

Squaring Elements

```
O(n)
```

Reversing Negative Array

```
O(n)
```

Merging Both Arrays

```
O(n)
```

Overall Time Complexity

```
O(n)
```

---

# Space Complexity

Two additional arrays are created for storing:

- Negative numbers
- Positive numbers

Hence,

```
O(n)
```

---

# Key Learning

- Whenever an array is **already sorted**, try to use that property instead of sorting again.
- Squaring negative numbers changes their order.
- Reversing the squared negative array makes it sorted.
- Two Pointers can efficiently merge two sorted arrays in linear time.
- The optimized solution avoids the extra **O(n log n)** sorting step and achieves **O(n)** time complexity.
