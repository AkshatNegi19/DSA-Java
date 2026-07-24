# 881. Boats to Save People

## Problem Statement

You are given an array `people` where `people[i]` is the weight of the `iᵗʰ` person, and an infinite number of boats where each boat can carry a maximum weight of `limit`.

Each boat carries at most **two people** at the same time, provided the sum of their weights is less than or equal to `limit`.

Return the **minimum number of boats** required to carry everyone.

---

## Example

### Input

```text
people = [3,2,2,1]
limit = 3
```

### Output

```text
3
```

### Explanation

- Boat 1 → [3]
- Boat 2 → [1,2]
- Boat 3 → [2]

Minimum boats required = **3**

---

## Pattern

- Two Pointers
- Greedy
- Sorting

---

## Intuition

To minimize the number of boats:

- Always try to pair the **lightest** person with the **heaviest** person.
- If they can fit together, send them in one boat.
- Otherwise, the heaviest person must go alone because they cannot pair with anyone heavier.

Sorting the array allows us to efficiently make this greedy decision using two pointers.

---

## Approach

1. Sort the array in ascending order.
2. Initialize:
   - `left` at the lightest person.
   - `right` at the heaviest person.
3. While `left <= right`:
   - If `people[left] + people[right] <= limit`
     - Pair them.
     - Move both pointers.
   - Otherwise
     - Send the heaviest person alone.
     - Move only the right pointer.
   - Count one boat in both cases.
4. Return the total number of boats.

---

## Dry Run

```text
people = [3,2,2,1]
limit = 3
```

After sorting

```text
[1,2,2,3]
```

| Left | Right | Action | Boats |
|------|-------|--------|-------|
| 1 | 3 | 1 + 3 > 3 → 3 goes alone | 1 |
| 1 | 2 | 1 + 2 = 3 → Pair | 2 |
| 2 | 2 | 2 goes alone | 3 |

Answer

```text
3
```

---

## Java Solution

```java
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;
        int boats = 0;

        while (left <= right) {

            if (people[left] + people[right] <= limit) {
                left++;
            }

            right--;
            boats++;
        }

        return boats;
    }
}
```

---

## Complexity Analysis

### Time Complexity

- Sorting: **O(n log n)**
- Two Pointer Traversal: **O(n)**

**Overall:** **O(n log n)**

### Space Complexity

- **O(1)** (excluding the sorting space used internally by Java)

---

## Key Takeaways

- Sorting enables efficient pairing.
- Greedy works because pairing the heaviest person with the lightest possible person leaves maximum room for pairing the remaining people.
- Every iteration uses exactly one boat.
- A classic interview problem combining **Sorting**, **Greedy**, and **Two Pointers**.

---

## Related Problems

- `11` Container With Most Water
- `15` 3Sum
- `16` 3Sum Closest
- `18` 4Sum
- `42` Trapping Rain Water
- `75` Sort Colors
- `167` Two Sum II - Input Array Is Sorted
- `977` Squares of a Sorted Array
