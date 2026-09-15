class Solution {
    int dp[][];
    int prefix[];

    int f(int l,int r){

        if(l>=r) return 0;
        if(dp[l][r]!=-1) return dp[l][r]; 

        int ans=0;

        for(int k=l;k<=r;k++){
            int left  = prefix[k+1]-prefix[l];
            int right = prefix[r+1] - prefix[k+1];
            int score=0;

            if(left>right) score = right + f(k+1,r);
            else if(right>left) score = left+f(l,k);
            else score = left + Math.max(f(l,k),f(k+1,r));

            ans = Math.max(ans,score); 
        }

        return dp[l][r] = ans;
        
    }
    public int stoneGameV(int[] stoneValue) {

        int n = stoneValue.length;
        prefix = new int[n+1];        
 
        for(int i=0;i<n;i++) prefix[i+1] = prefix[i]+stoneValue[i];

        dp  = new int [n][n];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);

        return f(0,n-1);
    }
}