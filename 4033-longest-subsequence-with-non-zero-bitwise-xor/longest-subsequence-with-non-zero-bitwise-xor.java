class Solution {
    public int longestSubsequence(int[] nums) {
        int x =0;
        int cnt=0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            x=x^nums[i];
            if(nums[i]==0) ++cnt; 
        } 
        if(cnt==n) return 0;
        else if(x!=0) return n;
        else return n-1;
    }
}