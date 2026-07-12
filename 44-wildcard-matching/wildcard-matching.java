class Solution {
    int dp[][];
    int f(int i,int j,String s,String p){
        if(j<0 && i<0) return 1;
        if(j<0) return 0;
        if(i<0){
            while(j>=0){
                if(p.charAt(j)!='*') return 0;
                --j;
            }
            return 1;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?') return f(i-1,j-1,s,p);

        if(p.charAt(j)=='*'){
            return dp[i][j] = (f(i,j-1,s,p) | f(i-1,j,s,p));
        }

        return dp[i][j] = 0;
    }
    public boolean isMatch(String s, String p) {

        int n = s.length();
        int m = p.length();
        dp=new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        int v = f(n-1,m-1,s,p);

        if(v==1) return true;
        else return false;
    }
}