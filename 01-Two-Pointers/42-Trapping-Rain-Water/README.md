# 42. Trapping Rain Water

## Problem Statement

Given `n` non-negative integers representing an elevation map where the width of each bar is `1`, compute how much water it can trap after raining.

---

## Example 1

**Input**

```text
height = [0,1,0,2,1,0,1,3,2,1,2,1]
```

**Output**

```text
6
```

---

## Example 2

**Input**

```text
height = [4,2,0,3,2,5]
```

**Output**

```text
9
```

---

## Approach

The amount of water trapped at any index depends on the tallest bar on its left and the tallest bar on its right.

Instead of storing the left and right maximum heights in separate arrays, we can use the **Two Pointers** technique to achieve **O(1)** extra space.

- Initialize two pointers:
  - `left = 0`
  - `right = n - 1`
- Maintain:
  - `leftMax`
  - `rightMax`
- Compare the heights at both pointers:
  - If `height[left] <= height[right]`, process the left side.
  - Otherwise, process the right side.
- Update the corresponding maximum height or add trapped water.
- Continue until both pointers meet.

---

## Algorithm

1. Initialize two pointers at both ends of the array.
2. Maintain the maximum height seen so far from the left and right.
3. Move the pointer with the smaller height.
4. If the current height is smaller than its maximum, add the trapped water.
5. Otherwise, update the maximum height.
6. Repeat until `left >= right`.

---

## Complexity Analysis

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`

---

## Java Solution

```java
class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int water = 0;

        while (left < right) {

            if (height[left] <= height[right]) {

                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }

                left++;

            } else {

                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }

                right--;
            }
        }

        return water;
    }
}
```

---

## Key Takeaways

- The problem can be solved optimally using the **Two Pointers** technique.
- The amount of trapped water depends on the smaller of the maximum heights on the left and right.
- By maintaining only two maximum values (`leftMax` and `rightMax`), we avoid using extra arrays.
- This optimizes the space complexity from **O(n)** to **O(1)** while keeping the time complexity **O(n)**.

---

## Topics

- Array
- Two Pointers
- Dynamic Programming (Alternative Approach)
