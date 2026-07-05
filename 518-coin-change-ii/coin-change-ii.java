class Solution {
    int dp[][];
    int f(int i,int amt,int a[]){
        if(i==0){
            if(amt%a[0]==0) return 1;
            else return 0;
        }
        if(dp[i][amt]!=-1) return dp[i][amt];
        int take=0;
        int notTake=f(i-1,amt,a);
        if(amt>=a[i]) take=f(i,amt-a[i],a);

        return dp[i][amt] = (take+notTake);
    }
    public int change(int amount, int[] coins) {
        dp=new int[coins.length][amount+1];
        for(int i=0;i<dp.length;i++) Arrays.fill(dp[i],-1);
        return f(coins.length-1,amount,coins);
    }
}