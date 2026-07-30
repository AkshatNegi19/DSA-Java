# Longest Substring with K Distinct Characters

## Problem Statement

Given a string `s` consisting of lowercase English letters and an integer `k`, find the length of the **longest substring containing exactly `k` distinct characters**.

If no such substring exists, return **-1**.

---

## Example

### Input

```text
s = "aabacbebebe"
k = 3
```

### Output

```text
7
```

### Explanation

The longest substring containing exactly **3 distinct characters** is

```text
cbebebe
```

Length = **7**

---

## Pattern Identification

- String Problem ✅
- Longest Substring ✅
- Variable Size Sliding Window ✅
- HashMap for Frequency Count ✅

---

## Approach

Since the problem asks for the **longest substring**, the window size is **not fixed**.

We maintain a sliding window using two pointers:

- `low` → Left boundary of the window
- `high` → Right boundary of the window

A `HashMap<Character, Integer>` stores the frequency of characters inside the current window.

### Steps

1. Expand the window by moving `high`.
2. Add the current character to the HashMap.
3. If the number of distinct characters becomes greater than `k`:
   - Shrink the window from the left.
   - Decrease the frequency of `s[low]`.
   - Remove the character if its frequency becomes `0`.
4. Whenever the HashMap contains exactly `k` distinct characters:
   - Update the maximum length.
5. Continue until the end of the string.

---

## Dry Run

```text
s = "aabacb"
k = 2
```

| Window | Distinct Characters | Length | Maximum |
|---------|---------------------|--------|---------|
| a | 1 | - | - |
| aa | 1 | - | - |
| aab | 2 | 3 | 3 |
| aaba | 2 | 4 | 4 |
| abac | 3 | Shrink | 4 |
| bac | 3 | Shrink | 4 |
| ac | 2 | 2 | 4 |
| acb | 3 | Shrink | 4 |

Final Answer:

```text
4
```

Substring:

```text
aaba
```

---

## Algorithm

1. Initialize:
   - `low = 0`
   - `HashMap<Character, Integer>`
   - `maxLength = -1`
2. Traverse the string using `high`.
3. Insert the current character into the HashMap.
4. While the number of distinct characters is greater than `k`:
   - Decrease the frequency of `s[low]`.
   - Remove it if the frequency becomes `0`.
   - Move `low`.
5. If the HashMap size equals `k`:
   - Update the maximum length.
6. Return the answer.

---

## Java Solution

```java
class Solution {
    public int longestKSubstr(String s, int k) {

        HashMap<Character, Integer> map = new HashMap<>();

        int low = 0;
        int res = -1;

        for (int high = 0; high < s.length(); high++) {

            char c = s.charAt(high);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() > k) {

                char ch = s.charAt(low);

                map.put(ch, map.get(ch) - 1);

                if (map.get(ch) == 0) {
                    map.remove(ch);
                }

                low++;
            }

            if (map.size() == k) {
                res = Math.max(res, high - low + 1);
            }
        }

        return res;
    }
}
```

---

## Complexity Analysis

### Time Complexity

- Each character enters the window once.
- Each character leaves the window at most once.

Overall:

```text
O(n)
```

### Space Complexity

```text
O(k)
```

In the worst case, the HashMap stores at most `k` distinct characters.

---

## Key Takeaways

- Variable Size Sliding Window
- HashMap for frequency counting
- Expand the window while valid
- Shrink the window when distinct characters exceed `k`
- Update the answer only when the window contains **exactly `k` distinct characters**

---

## Related Problems

- `3` Longest Substring Without Repeating Characters
- `76` Minimum Window Substring
- `159` Longest Substring with At Most Two Distinct Characters
- `340` Longest Substring with At Most K Distinct Characters
- `424` Longest Repeating Character Replacement
- `438` Find All Anagrams in a String
- `567` Permutation in String
