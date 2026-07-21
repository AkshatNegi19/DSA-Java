class Solution {
    int countTriplets(int sum, int arr[]) {
        // code here
        Arrays.sort(arr);
        int res = 0;
        int n = arr.length;
        
        for (int i=0; i<n-2; i++) {
            int left = i+1;
            int right = n-1;
            
            while (left<right) {
                int currentSum = arr[i] + arr[left] + arr[right];
                
                if (currentSum==sum || currentSum>sum) {
                    right--;
                } else {
                    res = res + (right-left);
                    left++;
                }
            }
        };
        
        return res;
    }
}
