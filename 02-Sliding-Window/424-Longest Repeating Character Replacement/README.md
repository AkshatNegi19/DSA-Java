# Longest Repeating Character Replacement (LeetCode 424)

## Question

You are given a string `s` and an integer `k`. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most `k` times.

Return the length of the **longest substring containing the same letter** that can be obtained after performing at most `k` replacements.

### Example 1

```text
Input:
s = "ABAB"
k = 2

Output:
4

Explanation:
Replace the two 'A's with 'B's (or vice versa), making the entire string consist of the same character.
```

### Example 2

```text
Input:
s = "AABABBA"
k = 1

Output:
4

Explanation:
Replace one 'A' with 'B' to obtain the substring "BBBB".
```

---

# Identifying the Pattern

### Is it an Array/String problem?

✅ Yes

### Does it involve a Substring?

✅ Yes

### Is it asking for the Longest Substring?

✅ Yes

### Is there a Condition?

✅ The number of replacements required must not exceed `k`.

This is a **Variable Size Sliding Window** problem.

---

# Observation

For every window:

```text
Window Length = high - low + 1
```

Suppose the current window is

```text
A A B A
```

Frequency:

```text
A = 3
B = 1
```

The character with the highest frequency is

```text
maxCount = 3
```

To make the entire window consist of the same character, we only need to replace the remaining characters.

```text
Replacements Required = Window Length - maxCount
```

If

```text
Replacements Required <= k
```

the current window is valid.

Otherwise,

shrink the window from the left until it becomes valid again.

---

# Brute Force Approach

Generate every possible substring.

For each substring:

* Count the frequency of every character.
* Find the maximum frequency.
* Calculate the number of replacements required.
* Update the answer if the substring is valid.

### Time Complexity

```text
O(n² × 26)
```

### Space Complexity

```text
O(26)
```

---

# Optimal Approach (Sliding Window)

Maintain a variable-size sliding window.

Expand the window by moving `high`.

For every new character:

* Update its frequency.
* Find the character with the maximum frequency.
* Calculate

```text
replacements = windowLength - maxCount
```

If

```text
replacements > k
```

shrink the window by moving `low`.

Continue until the window becomes valid again.

Update the maximum window length.

---

# Algorithm

1. Create a frequency array of size `26`.
2. Initialize:

   * `low = 0`
   * `result = 0`
3. Traverse the string using `high`.
4. Increase the frequency of `s[high]`.
5. Find the maximum frequency inside the current window.
6. Calculate:

```text
replacements = windowLength - maxCount
```

7. If replacements exceed `k`, shrink the window by moving `low`.
8. Continue until the window becomes valid.
9. Update the maximum window length.
10. Return the answer.

---

# Dry Run

```text
s = "AABABBA"
k = 1
```

### Initial

```text
low = 0
result = 0
```

---

### Window = "A"

```text
Length = 1

maxCount = 1

Replacement = 0
```

Valid

```text
result = 1
```

---

### Window = "AA"

```text
Length = 2

maxCount = 2

Replacement = 0
```

Valid

```text
result = 2
```

---

### Window = "AAB"

```text
Length = 3

maxCount = 2

Replacement = 1
```

Valid

```text
result = 3
```

---

### Window = "AABA"

```text
Length = 4

maxCount = 3

Replacement = 1
```

Valid

```text
result = 4
```

---

### Window = "AABAB"

```text
Length = 5

maxCount = 3

Replacement = 2
```

Not Valid

Shrink the window.

```text
low++
```

Window becomes

```text
ABAB
```

Now continue expanding.

The maximum valid window length remains

```text
4
```

---

# Intuition

To make every character in a window the same:

* Keep the character that appears the most.
* Replace every other character.

So,

```text
Characters to Replace

=

Window Length

-

Maximum Frequency Character
```

If this value is less than or equal to `k`, the window is valid.

Otherwise, shrink the window.

---

# Pseudocode

```java
low = 0
result = 0

for(high = 0; high < n; high++) {

    frequency[s[high]]++;

    windowLength = high - low + 1;

    maxCount = findMaximumFrequency();

    replacements = windowLength - maxCount;

    while(replacements > k) {

        frequency[s[low]]--;

        low++;

        windowLength = high - low + 1;

        maxCount = findMaximumFrequency();

        replacements = windowLength - maxCount;
    }

    result = Math.max(result, high - low + 1);
}

return result;
```

# Complexity Analysis

### Time Complexity

```text
O(26 × n)

≈ O(n)
```

Since the frequency array always has only 26 uppercase English letters, finding the maximum frequency takes constant time.

### Space Complexity

```text
O(26)

≈ O(1)
```

---

# Key Takeaways

* Variable Size Sliding Window.
* Maintain the frequency of characters inside the current window.
* Keep track of the most frequent character.
* Characters to replace = **Window Length − Maximum Frequency**.
* If replacements exceed `k`, shrink the window.
* The largest valid window is the answer.

---

# Similar Problems

* Longest Substring with At Most K Distinct Characters
* Max Consecutive Ones III
* Longest Subarray with Ones After Replacement
* Fruit Into Baskets
* Longest Repeating Character Replacement
