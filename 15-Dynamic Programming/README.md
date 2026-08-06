# Dynamic Programming (DP)

## What is Dynamic Programming?

Dynamic Programming (DP) is an algorithmic technique used to solve optimization problems efficiently by storing the results of previously solved subproblems.

Instead of solving the same subproblem multiple times (as in plain recursion), DP computes it once, stores the answer, and reuses it whenever required.

This optimization often reduces the time complexity from **exponential** to **polynomial**.

---

# Why Do We Need Dynamic Programming?

Consider the Fibonacci sequence.

### Recursive Solution

```text
fib(5)
├── fib(4)
│   ├── fib(3)
│   │   ├── fib(2)
│   │   └── fib(1)
│   └── fib(2)
└── fib(3)
    ├── fib(2)
    └── fib(1)
```

Notice that:

- `fib(3)` is calculated multiple times.
- `fib(2)` is calculated even more times.

These repeated calculations make recursion slow.

Dynamic Programming solves this by storing the answer after computing it once.

---

# Core Idea

> **Don't solve the same subproblem more than once.**

Whenever a subproblem is solved:

1. Store its answer.
2. Reuse it whenever needed.

This avoids unnecessary recursive calls.

---

# When Should You Apply Dynamic Programming?

A problem is a good candidate for DP if:

- It can be solved using **recursion**.
- The recursive solution solves the **same subproblems repeatedly**.
- The problem has **overlapping subproblems**.
- The problem exhibits **optimal substructure**, meaning the optimal solution can be built using optimal solutions of smaller subproblems.

### Simple Rule

> If recursion keeps solving the same thing again and again, use Dynamic Programming.

---

# Two Properties of DP

## 1. Overlapping Subproblems

The same subproblem appears multiple times.

Example:

```text
fib(5)

fib(3) is calculated more than once.
fib(2) is calculated multiple times.
```

Instead of recomputing them, store their answers.

---

## 2. Optimal Substructure

The answer of a larger problem depends on the answers of smaller problems.

Example:

```text
fib(5) = fib(4) + fib(3)
```

If we already know `fib(4)` and `fib(3)`, computing `fib(5)` is easy.

---

# Approaches in Dynamic Programming

## 1. Memoization (Top-Down)

- Uses recursion.
- Stores answers in a lookup table (usually an array or HashMap).
- Before solving a subproblem, check whether it has already been solved.

### Steps

1. Write the recursive solution.
2. Create a DP array.
3. If the answer already exists, return it.
4. Otherwise, compute it.
5. Store the answer.
6. Return it.

Example:

```java
if(dp[n] != -1)
    return dp[n];

dp[n] = fib(n-1) + fib(n-2);

return dp[n];
```

### Time Complexity

```
O(Number of States)
```

---

## 2. Tabulation (Bottom-Up)

- No recursion.
- Start from the smallest subproblem.
- Build the solution iteratively.

Example:

```java
dp[0] = 0;
dp[1] = 1;

for(int i = 2; i <= n; i++)
{
    dp[i] = dp[i-1] + dp[i-2];
}
```

---

## 3. Space Optimization

Sometimes only a few previous states are needed.

Instead of storing the entire DP array, keep only the required variables.

Example (Fibonacci):

```java
prev2 = 0;
prev1 = 1;

for(int i = 2; i <= n; i++)
{
    curr = prev1 + prev2;
    prev2 = prev1;
    prev1 = curr;
}
```

Space reduces from:

```
O(n) → O(1)
```

---

# DP Workflow

```text
Can the problem be solved using recursion?
            │
            ▼
Does recursion solve the same subproblem repeatedly?
            │
           Yes
            │
            ▼
Use Memoization
            │
            ▼
Convert Memoization to Tabulation
            │
            ▼
Optimize Space (if possible)
```

---

# Time Complexity Improvement

| Approach | Time Complexity |
|----------|-----------------|
| Plain Recursion | Exponential |
| Memoization | Polynomial |
| Tabulation | Polynomial |
| Space Optimized DP | Polynomial |

---

# Common DP Problems

- Fibonacci Number
- Climbing Stairs
- House Robber
- Coin Change
- Longest Common Subsequence (LCS)
- Longest Increasing Subsequence (LIS)
- Edit Distance
- Matrix Chain Multiplication (MCM)
- 0/1 Knapsack
- Unbounded Knapsack
- Partition Equal Subset Sum
- Bellman-Ford Algorithm
- Floyd-Warshall Algorithm

---

# Memoization vs Memorization

A common confusion is the spelling.

- **Memoization ✅**
  - Used in Dynamic Programming.
  - Comes from the word **memo** (a note where we write things down).
  - Means storing computed results for future use.

- **Memorization ❌**
  - Means remembering something in your brain.
  - Not related to Dynamic Programming.

Always use the term **Memoization** when discussing DP.

---

# Key Takeaways

- DP is an optimization over recursion.
- Store answers to avoid repeated calculations.
- DP is applicable when recursion has overlapping subproblems.
- Every memoization solution can usually be converted into tabulation.
- Many DP problems can be further optimized to use constant space.

---

# DP Roadmap

```
Recursion
     ↓
Memoization (Top-Down)
     ↓
Tabulation (Bottom-Up)
     ↓
Space Optimization
```

---

# My Understanding

> Dynamic Programming is used when a problem can be solved using recursion, but the recursive solution keeps solving the same subproblems repeatedly. Instead of recalculating them, we store their answers and reuse them later. This transforms an inefficient exponential solution into a much faster polynomial-time solution.
