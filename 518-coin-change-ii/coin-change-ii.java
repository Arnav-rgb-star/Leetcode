class Solution {
    int dp[][];
    int f(int n,int amt,int a[]){
        for(int i=0;i<=amt;i++) dp[0][i]=(i%a[0]==0)?1:0;

        for(int i=1;i<n;i++){
            for(int j=0;j<=amt;j++){
                int take=0;
                if(j>=a[i]) take=dp[i][j-a[i]];
                int notTake=dp[i-1][j];

                dp[i][j]=take+notTake;
            }
        }
        return dp[n-1][amt];
    }
    public int change(int amount, int[] coins) {
        dp=new int[coins.length][amount+1];
        for(int i=0;i<dp.length;i++) Arrays.fill(dp[i],-1);
        return f(coins.length,amount,coins);
    }
}