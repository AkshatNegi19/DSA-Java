class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length==0) return 0;
        
        int i = 0;
        int res = 1;
        
        for (int j=1; j<nums.length; j++) {
            if (nums[j]!=nums[i]) {
                nums[i+1] = nums[j];
                i++;
                res++;
            }
        }

        return res;
    }
}
