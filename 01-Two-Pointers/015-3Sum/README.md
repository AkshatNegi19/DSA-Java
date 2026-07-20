# 3Sum

**LeetCode Problem:** 15  
**Difficulty:** Medium  
**Topic:** Arrays, Sorting, Two Pointers

---

# Problem Statement

Given an integer array `nums`, return all the unique triplets `[nums[i], nums[j], nums[k]]` such that:

- `i != j`
- `i != k`
- `j != k`
- `nums[i] + nums[j] + nums[k] == 0`

The solution set must not contain duplicate triplets.

---

# Example 1

### Input

```text
nums = [-1,0,1,2,-1,-4]
```

### Output

```text
[
  [-1,-1,2],
  [-1,0,1]
]
```

---

### Example 2

### Input

```text
nums = [0,1,1]
```

### Output

```text
[]
```

---

### Example 3

### Input

```text
nums = [0,0,0]
```

### Output

```text
[
  [0,0,0]
]
```

---

# Intuition

This problem is an extension of the classic **Two Sum** problem.

Instead of finding **two numbers** whose sum equals a target, we need to find **three numbers** whose sum equals **0**.

Suppose,

```text
a + b + c = 0
```

If we fix one element,

```text
a
```

then we only need to find two numbers such that

```text
b + c = -a
```

Now the problem becomes a **Two Sum** problem, which can be efficiently solved using the **Two Pointer** technique after sorting the array.

---

# Brute Force Approach

Generate every possible triplet.

```text
for i
    for j
        for k
```

If

```text
nums[i] + nums[j] + nums[k] == 0
```

store the triplet.

Since duplicate triplets are not allowed, additional duplicate checking is required.

---

## Time Complexity

```text
O(n³)
```

## Space Complexity

```text
O(1)
```

(ignoring the output array)

---

# Optimized Approach

## Step 1

Sort the array.

Example

```text
[-1,0,1,2,-1,-4]

↓

[-4,-1,-1,0,1,2]
```

Sorting allows us to:

- Apply Two Pointer
- Skip duplicates easily
- Search efficiently

---

## Step 2

Iterate through the array.

For every index `i`,

consider `nums[i]` as the first element of the triplet.

Now we need two numbers whose sum is

```text
-target = -nums[i]
```

---

## Step 3

Initialize

```text
left = i + 1

right = n - 1
```

Calculate

```text
currentSum = nums[left] + nums[right]
```

If

```text
currentSum == -nums[i]
```

we found a valid triplet.

Store it.

Move both pointers.

---

## Step 4

Skip duplicates.

Duplicate triplets are not allowed.

Skip duplicate fixed elements.

Skip duplicate left values.

Skip duplicate right values.

---

# Dry Run

Input

```text
nums = [-1,0,1,2,-1,-4]
```

Sorted array

```text
[-4,-1,-1,0,1,2]
```

---

### i = 0

Fixed element

```text
-4
```

Need

```text
4
```

No valid pair exists.

---

### i = 1

Fixed element

```text
-1
```

Need

```text
1
```

Pointers

```text
left = 2

right = 5
```

Current sum

```text
-1 + 2 = 1
```

Target found.

Triplet

```text
[-1,-1,2]
```

Move both pointers.

---

Current pointers

```text
left = 3

right = 4
```

Current sum

```text
0 + 1 = 1
```

Again,

Target found.

Triplet

```text
[-1,0,1]
```

Move both pointers.

---

### i = 2

Current element is the same as the previous one.

Skip it to avoid duplicate triplets.

---

Final Answer

```text
[
[-1,-1,2],
[-1,0,1]
]
```

---

# Algorithm

1. Sort the array.
2. Iterate from `0` to `n - 3`.
3. Skip duplicate fixed elements.
4. Initialize two pointers.
5. Compare the current pair sum with `-nums[i]`.
6. Store valid triplets.
7. Skip duplicate left and right values.
8. Continue until pointers meet.
9. Return the answer.

---

# Complexity Analysis

## Time Complexity

Sorting

```text
O(n log n)
```

Outer loop

```text
O(n)
```

Two Pointer traversal

```text
O(n)
```

Overall

```text
O(n²)
```

---

## Space Complexity

```text
O(1)
```

Ignoring the output array.

---

# Why Does the Two Pointer Technique Work?

After sorting,

- Moving the **left** pointer increases the sum.
- Moving the **right** pointer decreases the sum.

This allows us to efficiently search for the required pair without checking every combination.

---

# Why Do We Skip Duplicates?

Suppose the sorted array is

```text
[-4,-1,-1,0,1,2]
```

If we process both `-1` values as the fixed element, we will generate the same triplets again.

Similarly,

after finding a valid triplet,

duplicate values on the left and right pointers would also generate duplicate answers.

Therefore, we skip consecutive duplicate values to ensure every triplet is unique.

---

# Key Learning

- Convert **3Sum** into a **Two Sum** problem.
- Sorting enables the Two Pointer technique.
- Duplicate handling is essential.
- Reduce the time complexity from **O(n³)** to **O(n²)**.
- This pattern is frequently asked in coding interviews.

---

# Related Problems

- Two Sum
- Two Sum II
- 3Sum Closest
- 3Sum Smaller
- 4Sum
- Container With Most Water

---

# Tags

- Arrays
- Sorting
- Two Pointers
- Interview Questions
- LeetCode Medium
```
