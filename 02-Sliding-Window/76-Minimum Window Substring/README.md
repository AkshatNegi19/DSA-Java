# Minimum Window Substring

## Problem Statement

Given two strings **`s`** and **`t`**, return the **minimum window substring** of `s` such that every character in `t` (including duplicates) is present in the window.

If no such substring exists, return an empty string `""`.

**Example**

```text
Input:
s = "ADOBECODEBANC"
t = "ABC"

Output:
"BANC"
```

---

# Pattern Identification

### Step 1: Identify the Pattern

This is a **Sliding Window** problem.

---

### Step 2: Fixed or Variable Window?

This is a **Variable Size Sliding Window** because:

- We keep expanding the window until it becomes valid.
- Once it is valid, we try to shrink it to find a smaller valid window.

---

### Step 3: Window Information

We need to know whether the current window contains **all characters of `t` with the required frequency**.

To do this, maintain two frequency arrays:

- **needed[]** → frequency of characters in `t`
- **have[]** → frequency of characters inside the current window

Both arrays are of size **256** (ASCII characters).

---

### Step 4: Check if the Window is Valid

The window is valid if

For every character,

```text
have[ch] >= needed[ch]
```

If this condition is true for every required character, the window is correct.

Otherwise, continue expanding the window.

---

# Algorithm

### 1. Store Frequency of `t`

```java
for each character c in t
    needed[c]++
```

---

### 2. Expand the Window

Move the `high` pointer one character at a time.

```java
have[s[high]]++;
```

---

### 3. Check if Window is Valid

If the window contains every required character,

- Calculate its length.
- Update the answer if it is the smallest so far.

```java
len = high - low + 1

if(len < result)
{
    result = len;
    start = low;
}
```

---

### 4. Shrink the Window

Since the current window is already valid, try to make it smaller.

```java
have[s[low]]--;
low++;
```

Continue shrinking until the window becomes invalid.

---

### 5. Return Answer

If no valid window was found,

```java
return "";
```

Otherwise,

```java
return s.substring(start, start + result);
```

---

# Flow of the Algorithm

```text
Start

        |
        V

Build frequency array of t (needed[])

        |
        V

Move high pointer

        |
        V

Include s[high] in have[]

        |
        V

Is window valid?

      /      \
    No        Yes
    |          |
Move high   Update answer
               |
               V
      Remove s[low]
               |
               V
          low++
               |
               V
     Still valid?
         /    \
      Yes      No
       |        |
Continue    Move high

        |
        V

Finished scanning?

        |
        V

Return minimum substring
```

---

# Pseudocode

```java
Create have[256]
Create needed[256]

Store frequency of t inside needed[]

low = 0
result = Infinity
start = 0

for(high = 0; high < s.length(); high++)
{
    have[s.charAt(high)]++;

    while(correct(have, needed))
    {
        length = high - low + 1;

        if(length < result)
        {
            result = length;
            start = low;
        }

        have[s.charAt(low)]--;
        low++;
    }
}

if(result == Infinity)
    return "";

return s.substring(start, start + result);
```

---

# Time Complexity

### Building frequency array

```text
O(m)
```

where `m = length of t`

### Sliding Window

Each character enters the window once and leaves once.

```text
O(n)
```

where `n = length of s`

### Overall Complexity

```text
O(n + m)
```

---

# Space Complexity

Two frequency arrays of size **256**.

```text
O(256 + 256)
```

Since 256 is constant,

```text
O(1)
```

---

# Key Observation

- Expand the window until it satisfies all required characters.
- Once valid, shrink it as much as possible.
- Every valid window is a candidate answer.
- The smallest valid window is the final answer.

This **expand → validate → shrink** strategy is the standard approach for **Variable Size Sliding Window** problems.
