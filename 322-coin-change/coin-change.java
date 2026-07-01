class Solution {
    int dp[][];
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp=new int[n][amount+1];

        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0) dp[0][i]=i/coins[0];
            else dp[0][i]=(int)1e9;
        }
        for(int i=1;i<n;i++){
            for(int t=0;t<=amount;t++){
                int take=(int)1e9;
                int notTake=dp[i-1][t];
                if(t>=coins[i]) take=1+dp[i][t-coins[i]];

                dp[i][t]=Math.min(take,notTake);
            }
        }
        if(dp[n-1][amount]>=(int)1e9) return -1;
        else return dp[n-1][amount];
    }
}