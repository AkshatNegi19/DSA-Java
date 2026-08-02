class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int low = 0;
        int maxFreq = 0;
        int maxLen = 0;

        for (int high = 0; high < s.length(); high++) {
            char ch = s.charAt(high);
            freq[ch - 'A']++;

            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            int windowSize = high - low + 1;

            if (windowSize - maxFreq > k) {
                freq[s.charAt(low) - 'A']--;
                low++;
            }

            maxLen = Math.max(maxLen, high - low + 1);
        }
        return maxLen;
    }
}
