class Solution {
    int dp[][];
    int f(int n,int a[]){
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<2;j++){
                int profit=0;
                if(j==0){
                    int take = dp[i+1][1] -a[i];
                    int skip = dp[i+1][0];
                    profit = Math.max(take,skip);
                }else{
                    int sell = dp[i+1][0] +a[i];
                    int leave  = dp[i+1][1];
                    profit = Math.max(sell,leave);
                }
                dp[i][j] = profit;
            }
        }
        return dp[0][0];
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int [n+1][2];;
        return f(n,prices);
    }
}