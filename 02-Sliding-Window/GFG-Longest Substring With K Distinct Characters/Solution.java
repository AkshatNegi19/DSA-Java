class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        HashMap<Character,Integer> map = new HashMap<>();
        int res = -1;
        int low = 0;
        
        for (int high=0; high<s.length(); high++) {
            char c = s.charAt(high);
            map.put(c,map.getOrDefault(c,0)+1);
            
            while (map.size()>k) {
                char ch = s.charAt(low);
                map.put(ch,map.get(ch)-1);
                
                if (map.get(ch)==0) {
                    map.remove(ch);
                };
                
                low++;
            };
            
            if (map.size()==k) {
                int len = high - low + 1;
                res = Math.max(res,len);
            }
        };
        
        return res;
    }
}
