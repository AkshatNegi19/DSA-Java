class Solution {
    public String minWindow(String s, String t) {
        int[] have = new int[256];
        int[] needed = new int[256];

        for (char c:t.toCharArray()) {
            needed[c]++;
        };

        int count = t.length();
        int low = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;

        for (int high=0; high<s.length(); high++) {
            char ch = s.charAt(high);
            have[ch]++;
            if (needed[ch]>0 && have[ch]<=needed[ch]) {
                count--;
            }
            while (count==0) {
                int len = high-low+1;
                if (len<minLen) {
                    minLen = len;
                    start = low;
                };
                char leftChar = s.charAt(low);
                have[leftChar]--;
                if (needed[leftChar]>0 && have[leftChar]<needed[leftChar]) {
                    count++;
                }
                low++;
            }
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(start,start+minLen);
    }
}
