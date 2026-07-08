class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int m = s.length();
        String r = new StringBuilder(s).reverse().toString();
        int dp[][]=new int[s.length()+1][s.length()+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==r.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return (n-dp[n][m]); 
    }
}