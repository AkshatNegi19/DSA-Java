class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int low = 0;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        for (int high=0; high<nums.length; high++) {
            int num = nums[high];
            sum += num;
            while (sum>=target) {
                int len = high-low+1;
                res = Math.min(len,res);
                sum-=nums[low];
                low++;
            }
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}
