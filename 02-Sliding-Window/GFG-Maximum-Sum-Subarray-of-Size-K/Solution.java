class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int sum = 0;
        int n = arr.length;
        
        int low = 0;
        int high = k-1;
        
        for (int i=low; i<=high; i++) {
            sum += arr[i];
        };
        
        int res = sum;
        
        while (high<n) {
            low++;
            high++;
            if (high==n) {
                break;
            };
            sum -= arr[low-1];
            sum += arr[high];
            
            res = Math.max(res,sum);
        };
        
        return res;
    }
}
