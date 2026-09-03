class Solution {
    public boolean uniformArray(int[] nums1) {

        int n = nums1.length;
        int min=Integer.MAX_VALUE;
        int even=0;
        int odd=0;

        for(int i=0;i<n;i++){
            if(nums1[i]%2==1){
                min = Math.min(min,nums1[i]);
                ++odd;
            }else ++even;
        }
        if(odd==n || even==n) return true;
        for(int i=0;i<n;i++){
            if(nums1[i]%2==0 && min>nums1[i]) return false;
        }
        
        return true;
    }
}