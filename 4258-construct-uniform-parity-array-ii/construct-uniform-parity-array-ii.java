class Solution {
    public boolean uniformArray(int[] nums1) {
        int even=0;
        int odd=0;
        int n = nums1.length;

        for(int i=0;i<n;i++){
            if(nums1[i]%2==0) ++even;
            else ++odd;
        }
        if(odd==n || even==n) return true;
        else if(even >0 && odd>0){
            int min=Integer.MAX_VALUE;

            for(int i=0;i<n;i++){
                if(nums1[i]%2==1) min = Math.min(min,nums1[i]);
            }
            for(int i=0;i<n;i++){
                if(nums1[i]%2==0 && min>nums1[i]) return false;
            }
        }
        return true;
    }
}