# 🍎 Fruit Into Baskets (LeetCode 904)

## Problem Statement

You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array `fruits`, where `fruits[i]` is the type of fruit produced by the `i-th` tree.

You have **only two baskets**, and each basket can hold **only one type of fruit**. However, each basket can hold an unlimited number of fruits of its assigned type.

Rules:

- You may start from **any tree**.
- Once you start, you must move **only to the right**.
- You must pick **exactly one fruit** from every tree you visit.
- If you reach a tree whose fruit type cannot fit into either basket, you must stop.

Return the **maximum number of fruits** you can collect.

---

# Intuition

Since we can carry fruits of **only two different types**, we need to find:

> **The longest contiguous subarray containing at most 2 distinct numbers.**

That longest valid subarray represents the maximum number of fruits we can collect.

---

# Approach (Sliding Window + HashMap)

We maintain a sliding window `[low...high]` that always contains **at most two distinct fruit types**.

A `HashMap<Integer, Integer>` is used to store:

- **Key** → Fruit type
- **Value** → Frequency of that fruit inside the current window

As we move the `high` pointer:

- Add the current fruit into the HashMap.
- If the window contains **2 or fewer distinct fruits**, update the answer.
- If it contains **more than 2 distinct fruits**, shrink the window by moving the `low` pointer until only two distinct fruit types remain.

---

# Algorithm

1. Initialize:
   - `low = 0`
   - `maxLength = 0`
   - A `HashMap<Integer, Integer>` to store fruit frequencies.
2. Traverse the array using the `high` pointer.
3. Add the current fruit into the HashMap.
4. If the HashMap size is:
   - **Less than or equal to 2**
     - Update the maximum window length.
   - **Greater than 2**
     - Remove fruits from the left side of the window.
     - Decrease their frequency.
     - Remove the fruit from the HashMap if its frequency becomes `0`.
     - Move the `low` pointer.
5. Continue until the end of the array.
6. Return the maximum window length.

---

# Dry Run

**Input:**

```text
fruits = [1,2,1,2,3]
```

| Window | Distinct Fruits | Length | Answer |
|--------|-----------------|--------|--------|
| [1] | 1 | 1 | 1 |
| [1,2] | 2 | 2 | 2 |
| [1,2,1] | 2 | 3 | 3 |
| [1,2,1,2] | 2 | 4 | 4 |
| [1,2,1,2,3] | 3 ❌ | Shrink Window | 4 |

Final Answer:

```text
4
```

The longest valid subarray is:

```text
[1,2,1,2]
```

---

# Time Complexity

Each element is added to and removed from the window at most once.

**Time Complexity:** `O(N)`

---

# Space Complexity

The HashMap stores at most **2** fruit types (temporarily 3 before shrinking).

**Space Complexity:** `O(1)`

---

# Key Takeaway

This problem is a classic **Sliding Window** problem.

The main objective is:

> **Find the longest contiguous subarray containing at most 2 distinct numbers.**

Whenever the number of distinct fruit types becomes greater than `2`, simply shrink the window from the left until it becomes valid again.

This pattern is commonly known as:

- **Longest Subarray with At Most K Distinct Elements** (where `K = 2`).
