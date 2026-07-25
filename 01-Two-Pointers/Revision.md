# Two Pointers - Revision Notes

This file contains my quick revision notes, observations, and instincts for identifying and solving **Two Pointers** problems.

---

# When to Use Two Pointers

## Flowchart

```text
Question
    │
    ▼
Is it an Array or Linked List?
    │
    ├── No → Probably another pattern
    │
    └── Yes
         │
         ▼
Does sorting help?
OR
Is the array already sorted?
OR
Does the problem require:
• Rearranging elements
• Removing duplicates
• Merging in-place
• Finding subarrays
• Finding pairs, triplets, or quadruplets
         │
         └── Yes → Think Two Pointers
```

---

# Questions Covered

## 1. Two Sum

### Why Two Pointers?

- Array ✅
- Sorting helps ✅

### Observation

Sort the array and place one pointer at the beginning and one at the end. Move the pointers based on the current sum.

---

## 2. 3 Sum

### Why Two Pointers?

- Array ✅
- Sorting helps ✅
- Need to find triplets ✅

### Observation

```text
3 Sum = Loop + 2 Sum
```

Fix one element and solve the remaining part using the Two Sum approach.

---

## 3. Squares of a Sorted Array

### Why Two Pointers?

- Array ✅
- Already sorted ✅

### Observation

Although squaring changes the order, the problem behaves like **merging two sorted arrays**. Compare absolute values from both ends and place the larger square at the end of the answer.

---

## 4. Remove Duplicates from Sorted Array

### Why Two Pointers?

- Array ✅
- Already sorted ✅
- Remove duplicates ✅

### Observation

Use a slow pointer to maintain the position of the next unique element and a fast pointer to scan the array.

---

## 5. Dutch National Flag

### Why Two Pointers?

- Array ✅
- Sorted ❌
- Rearrange in-place ✅
- No extra space ✅

### Observation

Use three pointers (`low`, `mid`, `high`) to partition the array into three sections.

---

## 6. 3Sum Closest

### Why Two Pointers?

- Array ✅
- Sorting helps ✅
- Need to find triplets ✅
- Closest value to target ✅

### Observation

Sort the array, fix one element, and use Two Pointers to move toward the target while tracking the closest sum.

---

## 7. Triplets With Smaller Sum

### Why Two Pointers?

- Array ✅
- Sorting helps ✅
- Need to count triplets ✅

### Observation

After sorting, fix one element and use Two Pointers. If the current sum is smaller than the target, then every element between the two pointers also forms a valid triplet.

---

## 8. Subarrays With Product Less Than Target

### Why Two Pointers?

- Array ✅
- Contiguous subarrays ✅
- Sliding window / Two Pointers ✅

### Observation

Maintain a window whose product is less than the target. Expand and shrink the window as needed.

---

## 9. Sort Colors

### Why Two Pointers?

- Same as Dutch National Flag ✅

### Observation

Partition the array into three regions using `low`, `mid`, and `high` pointers.

---

## 10. Compare Strings Containing Backspaces

### Why Two Pointers?

- Two strings ✅
- Traverse from the end ✅
- Constant extra space ✅

### Observation

Move backwards while skipping characters deleted by backspaces, then compare the remaining characters.

---

## 11. Minimum Window Sort

### Why Two Pointers?

- Array ✅
- Find the smallest unsorted subarray ✅

### Observation

Find the first and last misplaced elements, then expand the window until every element outside the window is already in its correct position.

---

# Main Instinct

Whenever you see:

- Array or Linked List
- Sorting helps (or already sorted)
- Rearrange elements
- Remove duplicates
- Merge in-place
- No extra space
- Find pairs, triplets, or quadruplets
- Subarray-related problems

➡️ **Think: Two Pointers**

---

# Mental Formula

```text
Array
      +
Sorting (or Already Sorted)
      +
Rearrange / Remove / Merge
      +
In-place (No Extra Space)
      ↓
     TWO POINTERS
```

---

# Quick Revision

| Problem | Key Observation |
|---------|-----------------|
| Two Sum | Sort + Two Pointers |
| 3 Sum | Loop + Two Sum |
| Squares of Sorted Array | Merge two sorted arrays |
| Remove Duplicates | Slow & Fast Pointer |
| Dutch National Flag | Three-way partition |
| 3Sum Closest | Loop + Two Pointers + Track closest sum |
| Triplets With Smaller Sum | If one triplet works, all elements between pointers work |
| Subarrays With Product < Target | Sliding Window / Two Pointers |
| Sort Colors | Dutch National Flag algorithm |
| Compare Strings With Backspaces | Traverse from the end |
| Minimum Window Sort | Expand the unsorted window |

---

> **Golden Rule:** Whenever the problem involves **arrays**, **sorting**, **in-place operations**, or **finding multiple elements efficiently**, your first instinct should be to check whether the **Two Pointers** pattern can reduce the complexity.
