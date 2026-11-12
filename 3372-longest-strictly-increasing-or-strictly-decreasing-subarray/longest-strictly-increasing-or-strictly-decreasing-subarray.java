class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int up=1;
        int down=1;
        int max=1;
        int n = nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]) ++up;
            else up=1;
            max = Math.max(max,up);
        }

        for(int i=n-2;i>=0;i--){
            if(nums[i]>nums[i+1]) ++down;
            else down=1;
            max = Math.max(max,down);
        }
        return max;
    }
}