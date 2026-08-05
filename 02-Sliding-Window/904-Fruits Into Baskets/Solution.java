class Solution {
    public int totalFruit(int[] fruits) {
        if (fruits.length==1) {
            return 1;
        }
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int low = 0;
        int k = 2;
        
        for (int high=0; high<fruits.length; high++) {
            int num = fruits[high];
            map.put(num,map.getOrDefault(num,0)+1);

            while (map.size()>k) {
                int val = fruits[low];
                map.put(val,map.get(val)-1);

                if (map.get(val)==0) {
                    map.remove(val);
                };
                low++;
            };

            if (map.size()==k || map.size()<k) {
                int len =  high - low + 1;
                res = Math.max(len,res);
            }
        };

        return res;
    }
}
