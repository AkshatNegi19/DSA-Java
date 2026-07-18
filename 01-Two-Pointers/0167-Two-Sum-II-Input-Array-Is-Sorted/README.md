# 167. Two Sum II - Input Array Is Sorted

## Problem

Given a **1-indexed sorted integer array** `numbers` and an integer `target`, find the two numbers whose sum is equal to the target.

Return the **1-based indices** of these two numbers.

### Important Points

- The array is already sorted in non-decreasing order.
- Exactly one valid pair always exists.
- The same element cannot be used twice.
- The returned indices must be **1-indexed**, not **0-indexed**.

---

## Pattern

Two Pointers

---

## Difficulty

Medium

---

## My Understanding

The Two Pointer technique is mainly used to reduce the time complexity of problems that would otherwise require nested loops.

It is commonly used in:

- Arrays
- Linked Lists

This technique becomes useful when:

- The array is already sorted.
- Sorting the array helps solve the problem efficiently.
- The problem asks to find pairs, triplets, or quadruplets.
- We need to merge, remove duplicates, or rearrange elements.
- Detecting cycles in linked lists using slow and fast pointers.

For this problem, using two nested loops would result in **O(n²)** time complexity.

A HashMap can solve the normal Two Sum problem in **O(n)** time, but it requires **O(n)** extra space.

Since this problem provides a **sorted array**, we can solve it using the Two Pointer approach with **O(n)** time and **O(1)** extra space.

The main idea is to place one pointer at the beginning of the array and another at the end.

- If the current sum is smaller than the target, move the left pointer.
- If the current sum is greater than the target, move the right pointer.
- If both values add up to the target, return the answer.

---

## Algorithm

1. Take the input sorted array.
2. Initialize two pointers:
   - `left = 0`
   - `right = n - 1`
3. While `left < right`
   - Calculate the current sum.
   - If the sum equals the target, return the indices.
   - If the sum is smaller than the target, move the left pointer.
   - Otherwise, move the right pointer.
4. If no pair is found, return an empty array.

---

## Time Complexity

```
O(n)
```

---

## Space Complexity

```
O(1)
```
