# 3Sum Closest

**LeetCode Problem:** 16  
**Difficulty:** Medium  
**Topic:** Arrays, Sorting, Two Pointers

---

# Problem Statement

Given an integer array `nums` of length `n` and an integer `target`, find three integers in the array whose sum is closest to the target.

Return the sum of the three integers.

You may assume that each input has exactly one solution.

---

# Example 1

### Input

```text
nums = [-1,2,1,-4]
target = 1
```

### Output

```text
2
```

### Explanation

The triplet

```text
[-1, 2, 1]
```

has a sum of

```text
2
```

which is the closest possible value to the target `1`.

---

# Example 2

### Input

```text
nums = [0,0,0]
target = 1
```

### Output

```text
0
```

---

# Intuition

This problem is an extension of the **3Sum** problem.

Instead of finding a triplet whose sum is exactly equal to the target, we need to find the triplet whose sum is **closest** to the target.

The brute force approach checks every possible triplet, but it is inefficient.

After sorting the array, we can fix one element and use the **Two Pointer** technique to efficiently search for the closest sum.

---

# Brute Force Approach

Generate every possible triplet.

```text
for i
    for j
        for k
```

Calculate

```text
currentSum = nums[i] + nums[j] + nums[k]
```

Store the triplet whose difference from the target is minimum.

---

## Time Complexity

```text
O(n³)
```

## Space Complexity

```text
O(1)
```

---

# Optimized Approach

## Step 1

Sort the array.

Example

```text
[-1,2,1,-4]

↓

[-4,-1,1,2]
```

Sorting allows us to use the Two Pointer technique.

---

## Step 2

Fix one element.

For every index `i`, initialize

```text
left = i + 1

right = n - 1
```

Now calculate

```text
sum = nums[i] + nums[left] + nums[right]
```

---

## Step 3

Update the closest answer.

If

```text
abs(target - sum)
```

is smaller than the previous difference,

update the answer.

---

## Step 4

Move the pointers.

If

```text
sum < target
```

move

```text
left++
```

because we need a larger sum.

Otherwise

```text
right--
```

because we need a smaller sum.

---

# Dry Run

Input

```text
nums = [-1,2,1,-4]

target = 1
```

Sorted array

```text
[-4,-1,1,2]
```

---

### i = 0

Fixed element

```text
-4
```

Pointers

```text
left = 1

right = 3
```

Current sum

```text
-4 + (-1) + 2 = -3
```

Difference

```text
|-3 - 1| = 4
```

Move left.

---

Current sum

```text
-4 + 1 + 2 = -1
```

Difference

```text
|-1 - 1| = 2
```

Update answer.

Move left.

Pointers cross.

---

### i = 1

Fixed element

```text
-1
```

Pointers

```text
left = 2

right = 3
```

Current sum

```text
-1 + 1 + 2 = 2
```

Difference

```text
|2 - 1| = 1
```

This is better than the previous answer.

Update answer.

Move right.

Pointers cross.

---

Final Answer

```text
2
```

---

# Algorithm

1. Sort the array.
2. Initialize the closest answer.
3. Iterate through every element.
4. Fix one element.
5. Use two pointers.
6. Calculate the current sum.
7. Update the answer if the current sum is closer.
8. Move the left pointer if the sum is smaller.
9. Move the right pointer if the sum is larger.
10. Return the closest sum.

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

No extra space is used apart from a few variables.

---

# Why Two Pointers Work?

After sorting,

- Moving the left pointer increases the sum.
- Moving the right pointer decreases the sum.

This property allows us to efficiently search for the closest sum without checking every possible triplet.

---

# Key Learning

- Sorting simplifies searching.
- Two Pointer technique reduces the complexity from **O(n³)** to **O(n²)**.
- Keep updating the closest answer using the minimum absolute difference.
- Pointer movement depends on the comparison between the current sum and the target.

---

# Related Problems

- Two Sum
- Two Sum II
- 3Sum
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
