class Solution {
    int dp[][];
    int lcs(int i,int j,String a,String b){
        if(i<0 || j<0 ) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(a.charAt(i)==b.charAt(j)) return 1+lcs(i-1,j-1,a,b);
            int l = lcs(i-1,j,a,b);
            int r = lcs(i,j-1,a,b);
            return dp[i][j] = Math.max(l,r);
    }
    public int longestPalindromeSubseq(String s) {
        String r = new StringBuilder(s).reverse().toString();
        dp =new int[s.length()][s.length()];
        for(int i=0;i<dp.length;i++) Arrays.fill(dp[i],-1);
        return lcs(s.length()-1,r.length()-1,s,r);
    }
}