class Solution {
    List<Integer> ans;
    int dp[][];
    List<Integer> cnt(int c[]){
        int n = c.length;

        for(int i=1;i<=n;i++){
            
            dp = new int[ans.size()+1][i+1];

            for(int r[]:dp){
                Arrays.fill(r,-1);
            }
            int w = ways(0,i);
            int left = c[i-1]-w;

            if(left==1) ans.add(i);
            else if(left!=0) return new ArrayList<>();
        }
        return ans;
    }
    int ways(int i,int amt){
        if(amt==0) return 1;
        if(amt<0 || i==ans.size()) return 0;
        if(dp[i][amt]!=-1) return dp[i][amt];

        int take = ways(i,amt-ans.get(i));
        int notTake = ways(i+1,amt);

        return dp[i][amt] = take+notTake;
    }
    public List<Integer> findCoins(int[] numWays) {
        ans = new ArrayList<>();

        return cnt(numWays);
    }
}