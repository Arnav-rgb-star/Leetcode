class Solution {
    public int minimumDeletions(int[] nums) {
        int min=0;
        int max=0;
        int n = nums.length;

        for(int i=1;i<n;i++){
            if(nums[i]>nums[max]) max=i;
            if(nums[i]<nums[min]) min=i;
        }
        int l = Math.max(min,max)+1;
        int r = n-Math.min(max,min);
        int lr = Math.min(max,min) + n+1-Math.max(min,max);

        return Math.min(Math.min(l,r),lr);
    }
}