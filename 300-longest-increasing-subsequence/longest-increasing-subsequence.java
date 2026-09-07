class Solution {
    int dp[][];

    int f(int i,int j,int a[]){
        if(i==a.length) return 0;

        if(dp[i][j+1]!=-1) return dp[i][j+1];

        int take=0;
        if(j==-1 || a[i]>a[j]) take = 1+f(i+1,i,a);
        int notTake = f(i+1,j,a);

        return dp[i][j+1] = Math.max(take,notTake);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        dp = new int[n][n+1];
        
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        f(0,-1,nums);

        return dp[0][0]; 
    }
}