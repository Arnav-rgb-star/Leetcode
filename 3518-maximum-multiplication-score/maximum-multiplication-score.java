class Solution {
    int n;
    long dp[][];
    long f(int i,int j,int a[],int b[]){
        if(j==4) return 0;
        if(i==n && j!=4) return (long)(-1e15);
        if(dp[i][j]!=-1) return dp[i][j];

        long take = (long)a[j]*b[i] + f(i+1,j+1,a,b);
        long notTake = f(i+1,j,a,b);

        return dp[i][j] = Math.max(take,notTake);
    }
    public long maxScore(int[] a, int[] b) {
        n = b.length;
        dp = new long[n][4];

        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return f(0,0,a,b);
    }
}