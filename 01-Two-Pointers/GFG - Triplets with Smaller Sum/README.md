# Triplets with Smaller Sum

## Problem Statement

Given an array `arr[]` of **distinct integers** and an integer `target`, count the number of triplets `(i, j, k)` such that:

- `i < j < k`
- `arr[i] + arr[j] + arr[k] < target`

### Example

```text
Input:
arr = [-2, 0, 1, 3]
target = 2

Output:
2

Explanation:
The valid triplets are:
(-2, 0, 1)
(-2, 0, 3)
```

---

# Pattern Recognition

### How to identify this pattern?

- Is it an array problem? → ✅ Yes
- Do we need all triplets? → ✅ Yes
- Is the array unsorted? → ✅ Yes
- Does sorting help? → ✅ Yes
- Can two pointers be used after sorting? → ✅ Yes

**Pattern:** Sorting + Two Pointers

---

# Approach

## Step 1

Sort the array.

```text
Original:
[-2,0,1,3]

Sorted:
[-2,0,1,3]
```

---

## Step 2

Fix one element using a loop.

```java
for(int i = 0; i < n-2; i++)
```

For every fixed element,

```text
left = i + 1
right = n - 1
```

---

## Step 3

Find the current sum.

```text
currentSum = arr[i] + arr[left] + arr[right]
```

There are only two cases.

### Case 1

```text
currentSum >= target
```

The sum is too large.

Move the right pointer.

```java
right--;
```

---

### Case 2

```text
currentSum < target
```

This is the important observation.

If

```text
arr[i] + arr[left] + arr[right]
```

is already smaller than the target,

then every element between

```text
left+1 ... right
```

will also form a valid triplet because the array is sorted.

Therefore,

```java
count += (right - left);
left++;
```

instead of checking each one individually.

---

# Why do we add `(right - left)`?

Suppose

```text
Sorted Array

[-2, 0, 1, 3]

target = 5

i = 0
left = 1
right = 3

Sum = -2 + 0 + 3 = 1
```

Since

```text
1 < 5
```

then

```text
(-2,0,1)
```

will also be valid because

```text
1 < 3
```

and replacing `3` with a smaller value only decreases the sum.

Instead of checking one by one,

we directly add

```text
right - left
```

valid triplets.

---

# Algorithm

```text
Sort the array.

count = 0

for every index i

    left = i + 1
    right = n - 1

    while(left < right)

        currentSum = arr[i] + arr[left] + arr[right]

        if(currentSum >= target)
            right--

        else
            count += (right - left)
            left++

return count
```

---

# Complexity Analysis

### Time Complexity

```text
Sorting  : O(n log n)

Two Pointer Traversal : O(n²)

Overall : O(n²)
```

---

### Space Complexity

```text
O(1)
```

---

# Key Observation

Whenever

```text
arr[i] + arr[left] + arr[right] < target
```

every element before `right` will also satisfy the condition because the array is sorted.

This allows us to count multiple triplets in one step, making the solution efficient.
