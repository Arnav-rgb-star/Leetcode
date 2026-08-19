class Solution {
    int n;
    int dp[];
    int f(int i,int a[]){
        if(i>=(n-1)) return 0;
        if(dp[i]!=-1) return dp[i];

        int min=n + 1;
        for(int j=1;j<=a[i] && (i+j)<n ;j++) min=Math.min(min,1+f(i+j,a));

        return dp[i] = min;

    }
    public int jump(int[] nums) {
        n = nums.length;
        dp = new int[n];

        for(int i=0;i<n;i++) dp[i]=-1;
        return f(0,nums);
    }
}