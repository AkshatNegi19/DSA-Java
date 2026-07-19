class Solution {
    public int[] sortedSquares(int[] nums) {
        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();

        // Finding negative and positive elements
        for (int num:nums) {
            if (num<0) {
                neg.add(num);
            } else {
                pos.add(num);
            }
        };

        // If it contains of only negative elements

        if (pos.size()==0) {
            for (int i=0; i<neg.size(); i++) {
                neg.set(i,neg.get(i)*neg.get(i));
            };
            Collections.reverse(neg);
            return neg.stream().mapToInt(Integer::intValue).toArray();
        };

        // If it contains only positive elements 

        if (neg.size()==0) {
            for (int i=0; i<pos.size(); i++) {
                pos.set(i,pos.get(i)*pos.get(i));
            };
            return pos.stream().mapToInt(Integer::intValue).toArray();
        };

        // If it contains both the values negative as well as positive 

        int i=0,j=0,id=0;
        int n1 = neg.size();
        int n2 = pos.size();
        int[] res = new int[n1+n2];

        // Squaring the negative values and then reversing them 

        for (i=0; i<n1; i++) {
            neg.set(i,neg.get(i)*neg.get(i));
        };
        Collections.reverse(neg);

        // Squaring the positive values

        for (i=0; i<n2; i++) {
            pos.set(i,pos.get(i)*pos.get(i));
        };

        // Merging the two sorted arrays using merge sort 
        i=0;
        j=0;
        
        while (i<n1 && j<n2) {
            if (neg.get(i)<=pos.get(j)) {
                res[id++] = neg.get(i++);
            } else {
                res[id++] = pos.get(j++);
            }
        };

        // If negative elements are still left in the list 

        while (i<n1) {
            res[id++] = neg.get(i++);
        };

        // If positive elements are still left in the list

        while (j<n2) {
            res[id++] = pos.get(j++);
        };

        return res;
    }
}
