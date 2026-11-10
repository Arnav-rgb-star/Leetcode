class Solution {
    int dp[];
    int max = Integer.MAX_VALUE;

    int f(int i,int a[]){

        int n = a.length;
        if(i==(n)) return 0;
        if(dp[i]!=-1) return dp[i];

        int one=max;
        int two=max;
        int three=max;

        one = f(i+1,a)+1+a[i];
        if((i+2)<=n) two = f(i+2,a)+4+a[i+1];
        if((i+3)<=n) three = f(i+3,a)+9+a[i+2];

        return dp[i] = Math.min(one,Math.min(two,three));

    }
    public int climbStairs(int n, int[] costs) {
        dp = new int[n];
        Arrays.fill(dp,-1);

        return f(0,costs);
    }
}