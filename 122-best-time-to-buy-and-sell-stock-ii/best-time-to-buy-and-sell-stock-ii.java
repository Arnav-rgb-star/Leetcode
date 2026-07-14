class Solution {
    int dp[][];
    int f(int i,int last,int a[]){
        if(i==a.length) return 0;
        if(dp[i][last]!=-1) return dp[i][last];
        int profit;
        if(last==0){
            int take = f(i+1,1,a)-a[i];
            int skip = f(i+1,0,a);
            profit = Math.max(take,skip);
        }else{
            int sell = f(i+1,0,a)+a[i];
            int leave  = f(i+1,1,a);
            profit = Math.max(sell,leave);
        }
        return dp[i][last] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int [n][2];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return f(0,0,prices);
    }
}