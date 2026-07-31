# Minimum Size Subarray Sum (Medium)

## Question

Given an array of **positive integers** `nums` and a positive integer `target`, return the **minimum length** of a subarray whose sum is **greater than or equal to** `target`.

If there is no such subarray, return `0`.

### Example

```text
target = 7
nums = [2,3,1,2,4,3]

Output:
2
```

**Explanation**

The subarray `[4,3]` has a sum of `7`, and its length is `2`, which is the smallest possible answer.

---

# Identifying the Pattern

* Array → ✅
* Subarray/Substring → ✅
* Minimum/Maximum + Sum → ✅

This is a **Sliding Window** problem.

---

# Step 1 → Identify the Pattern

Since we are dealing with a **contiguous subarray** and we need the **minimum length**, Sliding Window is the correct approach.

---

# Step 2 → Fixed or Variable Window?

The size of the window is **not given**.

Therefore, this is a **Variable Size Sliding Window** problem.

---

# Step 3 → Get the Information

Whenever the window sum becomes **greater than or equal to the target**, we try to **shrink the window** from the left to make it as small as possible while still satisfying the condition.

---

# Dry Run

```text
nums = [1,2,4,4]
target = 4
```

Initially,

```text
low = 0
high = 0
sum = 0
```

### Step 1

```text
Add 1

sum = 1
```

Target not reached.

---

### Step 2

```text
Add 2

sum = 3
```

Target not reached.

---

### Step 3

```text
Add 4

sum = 7
```

Now,

```text
sum >= target
```

Window:

```text
[1,2,4]

Length = 3

Answer = 3
```

Shrink the window.

Remove `1`

```text
sum = 6
```

Still,

```text
sum >= target
```

Window:

```text
[2,4]

Length = 2

Answer = 2
```

Shrink again.

Remove `2`

```text
sum = 4
```

Still,

```text
sum >= target
```

Window:

```text
[4]

Length = 1

Answer = 1
```

Shrink again.

Remove `4`

```text
sum = 0
```

Move `high` forward.

---

### Step 4

Add the next `4`

```text
sum = 4
```

Again,

```text
sum >= target
```

Window:

```text
[4]

Length = 1
```

Minimum length remains

```text
1
```

---

# Algorithm

1. Initialize two pointers `low` and `high`.
2. Maintain the sum of the current window.
3. Expand the window by moving `high`.
4. Whenever the sum becomes **greater than or equal to the target**, calculate the window length.
5. Update the minimum answer.
6. Shrink the window by moving `low`.
7. Continue until the array ends.
8. If no valid window exists, return `0`.

---

# Code Algorithm

```java
low = 0;
high = 0;
sum = 0;
res = Integer.MAX_VALUE;

while (high < n) {

    sum += nums[high];

    while (sum >= target) {

        int len = high - low + 1;

        res = Math.min(res, len);

        sum -= nums[low];

        low++;
    }

    high++;
}

if (res == Integer.MAX_VALUE)
    return 0;

return res;
```

---

# Why does this work?

Since all numbers are **positive**, adding a new element always increases the window sum, and removing an element always decreases it.

This property allows us to safely move each pointer only forward, making Sliding Window the optimal solution.

---

# Complexity Analysis

**Time Complexity**

```text
O(n)
```

Each element is added and removed from the window at most once.

**Space Complexity**

```text
O(1)
```

Only a few variables are used regardless of the input size.
