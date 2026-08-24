class Solution {
    int dp[];
    int prefix[];
    
    int f(int i){
        if(dp[i]!=-1) return dp[i];
        if(i==prefix.length-1) return dp[i]=prefix[i];
        
        int notTake = f(i+1);
        int take = prefix[i]-notTake;
        
        return dp[i] = Math.max(take,notTake);
    }
    public int stoneGameVIII(int[] stones) {
        dp = new int [stones.length];
        prefix = new int [stones.length];

        prefix[0]=stones[0];
        Arrays.fill(dp,-1);
        for(int i=1;i<stones.length;i++) prefix[i]=prefix[i-1]+stones[i];
        return f(1);
    }
}