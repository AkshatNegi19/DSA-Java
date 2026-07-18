# 26. Remove Duplicates from Sorted Array

## Problem

Given a sorted integer array, remove the duplicate elements in-place such that every unique element appears only once.

Return the total number of unique elements.

---

## Pattern

Two Pointers

---

## Difficulty

Easy

---

## My Understanding

The main logic of this problem is based on the fact that the array is already sorted.

Since the array is sorted, all duplicate values appear next to each other.

The first element of the array is always unique, so we keep one pointer (`officer`) at the first element.

Another pointer (`cm`) starts from the second element and traverses the array.

While traversing:

- If the current element is the same as the previous element, it is a duplicate, so we simply move to the next element.
- If the current element is different, it is a new unique value.
  - Move the `officer` pointer one step ahead.
  - Copy the current element to the next unique position.
  - Increase the count of unique elements.

This way, all unique elements are placed at the beginning of the array without using any extra space.

---

## Dry Run

Input

```
[1,1,1,2,2,3]
```

Initially

```
officer = 0
cm = 1
unique = 1
```

The first three elements are the same, so only `cm` moves.

When `cm` reaches `2`, a new unique value is found.

Copy it to the next position and move the `officer` pointer.

Continue the same process until the end of the array.

Final Array

```
[1,2,3,...]
```

Unique Elements

```
3
```

---

## Algorithm

1. The array is already sorted.
2. Initialize:
   - `officer = 0`
   - `cm = 1`
   - `unique = 1`
3. Traverse the array using `cm`.
4. If the current element is equal to the previous element:
   - Move `cm`.
5. Otherwise:
   - Copy the current value to `arr[officer + 1]`.
   - Move the `officer` pointer.
   - Increase the unique count.
6. Continue until the end of the array.
7. Return the total number of unique elements.

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
