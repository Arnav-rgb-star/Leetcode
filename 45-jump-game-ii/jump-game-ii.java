class Solution {
    int n;
    int dp[];
    int f(int a[]){
        
        for(int i=0;i<n;i++) dp[i]=n+1;
        dp[n-1] = 0;

        for(int i=n-1;i>=0;i--)
        for(int j=1;j<=a[i] && (i+j)<n ;j++) dp[i]=Math.min(dp[i],1+dp[i+j]);

        return dp[0];

    }
    public int jump(int[] nums) {
        n = nums.length;
        dp = new int[n];
        return f(nums);
    }
}