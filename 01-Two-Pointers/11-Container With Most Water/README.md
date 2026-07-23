# 11. Container With Most Water

## Problem Statement

You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that the two endpoints of the `iᵗʰ` line are `(i, 0)` and `(i, height[i])`.

Find two lines that together with the x-axis form a container that can store the maximum amount of water.

Return the maximum amount of water the container can store.

### Example

**Input:**

```text
height = [1,8,6,2,5,4,8,3,7]
```

**Output:**

```text
49
```

---

## Approach - Two Pointers

### Logic

The main logic of this problem is to use the **Two Pointer** approach. We place one pointer at the beginning (`left`) of the array and the other at the end (`right`).

At every step:

- The **width** of the container is `right - left`.
- The **height** of the container is the smaller of the two heights because water can only be stored up to the height of the shorter line.
- The area is calculated as:

```text
Area = Width × Minimum Height
```

We keep track of the maximum area found so far.

After calculating the current area, we move the pointer pointing to the **smaller height**.

This is because moving the taller line cannot increase the height of the container, while the width will definitely decrease. The only chance of finding a larger area is by moving the shorter line and hoping to find a taller one.

We continue this process until both pointers meet.

---

## Algorithm

1. Initialize two pointers:
   - `left = 0`
   - `right = n - 1`

2. Initialize `maxWater = 0`.

3. While `left < right`:
   - Calculate the width.
   - Calculate the minimum height.
   - Compute the current area.
   - Update the maximum area.
   - Move the pointer having the smaller height.
     - If `height[left] < height[right]`, increment `left`.
     - Otherwise, decrement `right`.

4. Return `maxWater`.

---

## Java Solution

```java
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;

        while (left < right) {

            int width = right - left;
            int h = Math.min(height[left], height[right]);
            int area = width * h;

            maxWater = Math.max(maxWater, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}
```

---

## Dry Run

### Input

```text
height = [1,8,6,2,5,4,8,3,7]
```

| Left | Right | Width | Height | Area | Max Area |
|------|-------|------:|-------:|-----:|---------:|
| 0 | 8 | 8 | 1 | 8 | 8 |
| 1 | 8 | 7 | 7 | 49 | 49 |
| 1 | 7 | 6 | 3 | 18 | 49 |
| 1 | 6 | 5 | 8 | 40 | 49 |
| 2 | 6 | 4 | 6 | 24 | 49 |
| 3 | 6 | 3 | 2 | 6 | 49 |
| 4 | 6 | 2 | 5 | 10 | 49 |
| 5 | 6 | 1 | 4 | 4 | 49 |

Final Answer:

```text
49
```

---

## Time Complexity

- **O(n)**

Each pointer moves at most `n` times.

---

## Space Complexity

- **O(1)**

Only a few extra variables are used.

---

## Concepts Used

- Two Pointers
- Greedy Observation
- Arrays
