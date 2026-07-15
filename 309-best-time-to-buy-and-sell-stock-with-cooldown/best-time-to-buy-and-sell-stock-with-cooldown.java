class Solution {
    int dp[][];
    int f(int n,int buy,int a[]){

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<2;j++){
                int profit=0;
                if(j==0) profit = Math.max(dp[i+1][1]-a[i] ,dp[i+1][0]);
                else profit = Math.max(dp[i+2][0]+a[i],dp[i+1][1]);
                dp[i][j] = profit;
            }
        }
        return dp[0][0];
    }
    public int maxProfit(int[] prices) {
        dp = new int[prices.length+2][2];

        return f(prices.length,0,prices);
    }
}