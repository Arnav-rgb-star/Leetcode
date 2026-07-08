class Solution {
    int dp[][];
    public int longestPalindromeSubseq(String s) {
        String r = new StringBuilder(s).reverse().toString();
        int n = s.length();

        dp =new int[s.length()+1][s.length()+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==r.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                    continue;
                }
                int left = dp[i-1][j];
                int  right = dp[i][j-1];

                dp[i][j] = Math.max(dp[i][j],Math.max(left,right));
            }
        }
        return dp[n][n];
    }
}