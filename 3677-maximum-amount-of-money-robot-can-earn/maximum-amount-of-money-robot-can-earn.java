class Solution {
    int m;
    int n;
    int dp[][][];

    int f(int i,int j,int k,int coins[][]){
        if(i == m-1 && j == n-1){
            if(coins[i][j]<0 && k>0) return 0;
            else return coins[i][j];
        }

        if(i==m || j==n) return (int)(-1e8);
        if(dp[i][j][k]!=-1) return dp[i][j][k];
        int r=Integer.MIN_VALUE;
        int d=Integer.MIN_VALUE;
        int rn=Integer.MIN_VALUE;
        int dn=Integer.MIN_VALUE;

        if(coins[i][j]<0 && k>0){
            rn = f(i,j+1,k-1,coins);
            dn = f(i+1,j,k-1,coins);
        }
        r = Math.max(rn,coins[i][j]+f(i,j+1,k,coins));
        d = Math.max(dn,coins[i][j]+f(i+1,j,k,coins));
        return dp[i][j][k] = Math.max(r,d);
    }
    public int maximumAmount(int[][] coins) {
        m = coins.length;
        n = coins[0].length;
        
        dp = new int[m][n][3];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }

        return f(0,0,2,coins);
    }
}