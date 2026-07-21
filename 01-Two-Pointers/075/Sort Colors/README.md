# Dutch National Flag

## Problem Statement

Given an array consisting of only

- `0` (Red)
- `1` (White)
- `2` (Blue)

sort the array **in-place** without using the library sort function.

### Example

```text
Input:
[2,0,2,1,1,0]

Output:
[0,0,1,1,2,2]
```

---

# Pattern Recognition

### How to identify this pattern?

- Is it an array problem? → ✅ Yes
- Does it require sorting? → ❌ No
- Are we rearranging elements? → ✅ Yes
- Is in-place sorting required? → ✅ Yes
- Can two pointers help? → ✅ Yes

**Pattern:** Two Pointers

---

# Approaches

## 1. Brute Force

Create three separate arrays:

- One for 0s
- One for 1s
- One for 2s

Merge them back.

### Complexity

```text
Time  : O(n)

Space : O(n)
```

---

## 2. Better Approach (Counting)

Count the number of

- 0s
- 1s
- 2s

using one traversal.

Traverse the array again and overwrite the values based on the counts.

This is a **two-pass** solution.

### Complexity

```text
Time  : O(n)

Space : O(1)
```

---

## 3. Best Approach (Dutch National Flag Algorithm)

Sort the array in a **single traversal**.

---

# Idea

Maintain three pointers.

```text
low
mid
high
```

Initially,

```text
low = 0
mid = 0
high = n - 1
```

The array is divided into four regions.

```text
0 .......... low-1      → All 0s

low ........ mid-1      → All 1s

mid ........ high       → Unknown region

high+1 ..... end        → All 2s
```

Only the unknown region needs processing.

---

# Rules

## If arr[mid] == 0

Swap

```text
arr[low]
arr[mid]
```

Then,

```text
low++
mid++
```

---

## If arr[mid] == 1

It is already in the correct region.

Simply,

```text
mid++
```

---

## If arr[mid] == 2

Swap

```text
arr[mid]
arr[high]
```

Then,

```text
high--
```

Notice that **mid is not incremented** because the swapped element from the end has not been processed yet.

---

# Algorithm

```text
low = 0
mid = 0
high = n-1

while(mid <= high)

    if(arr[mid] == 0)

        swap(low, mid)

        low++
        mid++

    else if(arr[mid] == 1)

        mid++

    else

        swap(mid, high)

        high--

return array
```

---

# Dry Run

### Initial Array

```text
[2,0,2,1,1,0]

low = 0
mid = 0
high = 5
```

---

### Step 1

```text
arr[mid] = 2
```

Swap `mid` and `high`.

```text
[0,0,2,1,1,2]

low = 0
mid = 0
high = 4
```

---

### Step 2

```text
arr[mid] = 0
```

Swap `low` and `mid`.

```text
[0,0,2,1,1,2]

low = 1
mid = 1
high = 4
```

---

### Step 3

```text
arr[mid] = 0
```

Swap again.

```text
[0,0,2,1,1,2]

low = 2
mid = 2
high = 4
```

---

### Step 4

```text
arr[mid] = 2
```

Swap with `high`.

```text
[0,0,1,1,2,2]

low = 2
mid = 2
high = 3
```

---

### Step 5

```text
arr[mid] = 1
```

```text
mid++
```

```text
mid = 3
```

---

### Step 6

```text
arr[mid] = 1
```

```text
mid++
```

Now,

```text
mid = 4

high = 3
```

Since

```text
mid > high
```

the loop ends.

Final array:

```text
[0,0,1,1,2,2]
```

---

# Why don't we increment `mid` after swapping with `high`?

When a `2` is found,

we swap it with the last unprocessed element.

The element coming from the right side can be either

- 0
- 1
- 2

Since it hasn't been processed yet, we must examine it again.

Therefore,

```text
Only high--
```

is performed.

---

# Complexity Analysis

### Time Complexity

```text
O(n)
```

Each element is processed at most once.

---

### Space Complexity

```text
O(1)
```

No extra space is used.

---

# Key Observation

The algorithm continuously maintains four regions:

- Left side contains only **0s**
- Middle contains only **1s**
- Right side contains only **2s**
- The remaining portion is the only part that needs processing.

By shrinking the unknown region in every iteration, the entire array gets sorted in a single pass.
