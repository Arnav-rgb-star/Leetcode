class Solution {
    int dp[][];

    int f(int i,int a,int c[]){
        if(i==0){
            if(a%c[0]==0) return a/c[0];
            else return (int)1e9;
        }
        if(dp[i][a]!=-1) return dp[i][a];
        int notTake=0+f(i-1,a,c);
        int take=(int)1e9;
        if(a>=c[i]) take = 1+f(i,a-c[i],c);

        return dp[i][a]=Math.min(take,notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp=new int[n][amount+1];

        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        int cnt = f(n-1,amount,coins);
        if(cnt ==(int)1e9) return -1;
        else return cnt;
    }
}