class Solution {
    int dp[][];
    int f(int i,int j,String a,String b){
        if(i<0) return (j+1);
        if(j<0) return (i+1);

        if(dp[i][j]!=-1) return dp[i][j];
        if(a.charAt(i)==b.charAt(j)) return dp[i][j] = f(i-1,j-1,a,b);
        else{
            return dp[i][j] = 1 + Math.min(f(i-1,j,a,b),Math.min(f(i,j-1,a,b),f(i-1,j-1,a,b)));
        }

    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m=word2.length();
        dp=new int[n][m];

        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return f(n-1,m-1,word1,word2);
    }
}