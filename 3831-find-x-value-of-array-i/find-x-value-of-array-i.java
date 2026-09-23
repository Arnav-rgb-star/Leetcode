class Solution {
    long dp[][];
    long ans[];

    long f(int i,int p,int k,int x,int nums[]){
        if(i>=nums.length) return 0;

        int w=0;
        int rem = ((nums[i]%k)*p)%k;
        if(dp[i][rem]!=-1) return dp[i][rem];
        if(rem==x) w=1;
        return dp[i][rem] = (w+f(i+1,rem,k,x,nums));
    
    }
    public long[] resultArray(int[] nums, int k) {
        ans = new long[k];
        int n = nums.length;

        dp = new long[n][k];
        
        for(int x=0;x<k;x++){

            for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
            for(int i=0;i<n;i++){
                ans[x]+=f(i,1,k,x,nums);
            }
        }
        return ans;
    }
}