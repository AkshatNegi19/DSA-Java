# Sliding Window - Maximum Sum Subarray of Size K

## Introduction

The **Sliding Window** technique is used to optimize problems involving **arrays** and **strings** where we need to process a **contiguous sequence of elements** (subarray or substring).

Instead of checking every possible subarray, we maintain a window and slide it across the array, reducing the time complexity from **O(n²)** to **O(n)**.

---

# What is a Sliding Window?

A sliding window is a range of consecutive elements.

- The window expands by moving the **right (high)** pointer.
- The window shrinks by moving the **left (low)** pointer.
- Both pointers move only in the **forward direction**.

```
Expand Window
low                high
 ↓                   ↓
[ 1 2 3 4 ]

Shrink Window
     low        high
      ↓           ↓
[ 1 2 3 4 ]
```

---

# When Should You Think of Sliding Window?

Use the following checklist.

```
Array / String
       │
       ▼
Subarray / Substring
       │
       ▼
Need to Find?
├── Maximum
├── Minimum
├── Longest
├── Shortest
├── Sum
├── Count
├── Average
├── At Most K
├── At Least K
└── Exactly K
```

If most of these conditions are true, Sliding Window is likely the correct approach.

---

# Types of Sliding Window

## 1. Fixed Size Window

The size of the window is already given.

Examples

- Maximum sum of subarray of size K
- Average of every subarray of size K

---

## 2. Variable Size Window

The size is not given.

The window expands and shrinks according to a condition.

Examples

- Smallest subarray with sum ≥ target
- Longest substring without repeating characters

---

# Problem Statement

Given an array of integers **arr[]** and an integer **k**, return the **maximum sum** of any subarray of size **k**.

### Example

```
Input

arr = [100, 200, 300, 400]
k = 2

Output

700
```

### Explanation

Possible subarrays of size 2

```
[100,200] → 300

[200,300] → 500

[300,400] → 700
```

Maximum Sum = **700**

---

# Pattern Identification

```
Array
   │
   ▼
Subarray
   │
   ▼
Maximum Sum
   │
   ▼
Window Size Given
   │
   ▼
Fixed Sliding Window
```

---

# Algorithm

### Step 1

Take two pointers.

```
low = 0
high = k - 1
```

---

### Step 2

Calculate the sum of the first window.

```
sum = arr[0] + arr[1] + ... + arr[k-1]
```

---

### Step 3

Store the answer.

```
res = sum
```

---

### Step 4

Slide the window.

- Remove the left element.
- Add the new right element.
- Update the maximum answer.

```
sum = sum - arr[low]

low++

high++

sum = sum + arr[high]
```

---

### Step 5

Repeat until the end of the array.

---

# Pseudocode

```java
low = 0;
high = k - 1;

sum = 0;

for(int i = low; i <= high; i++){
    sum += arr[i];
}

res = 0;

while(high < n){

    res = Math.max(res, sum);

    low++;
    high++;

    sum = sum - arr[low - 1];

    if(high == n)
        break;

    sum = sum + arr[high];
}

return res;
```

---

# Dry Run

### Input

```
arr = [100,200,300,400]

k = 2
```

### First Window

```
[100,200]

Sum = 300

Maximum = 300
```

---

### Slide Window

```
Remove 100

Add 300

Window

[200,300]

Sum = 500

Maximum = 500
```

---

### Slide Again

```
Remove 200

Add 400

Window

[300,400]

Sum = 700

Maximum = 700
```

---

### Final Answer

```
700
```

---

# Complexity Analysis

### Time Complexity

```
O(n)
```

Each element is added once and removed once.

---

### Space Complexity

```
O(1)
```

Only a few variables are used.

---

# Key Takeaways

- This is the simplest **Sliding Window** problem.
- Since the window size is fixed, it is called a **Fixed Size Sliding Window**.
- Instead of recalculating every window sum, reuse the previous sum by removing one element and adding one new element.
- This optimization reduces the time complexity from **O(n²)** to **O(n)**.

---

# Formula to Remember

```
New Window Sum

=

Previous Window Sum

− Left Element

+ New Right Element
```
