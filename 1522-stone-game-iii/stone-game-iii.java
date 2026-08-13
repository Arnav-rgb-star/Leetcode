class Solution {
    int diff=0;
    int dp[][];
    public int f(int a[]){
        int n = a.length;
        
        for(int i=n-1;i>=0;i--){
            for(int l=0;l<2;l++){
                int one = Integer.MIN_VALUE;
                int two= Integer.MIN_VALUE;
                int three=Integer.MIN_VALUE;

                    one = a[i] - dp[1-l][i+1];
                    if(i+1 < n)  two= a[i] + a[i+1] - dp[1-l][i+2];
                    if(i+2 < n)  three= a[i] + a[i+1] +a[i+2] - dp[1-l][i+3];
                    
                    dp[l][i] =Math.max(Math.max(one,two),three);
            }    
        }             
        return dp[0][0];
    }
    public String stoneGameIII(int[] stoneValue) {
        
        dp = new int[2][stoneValue.length+1];

        diff = f(stoneValue);

        if(diff==0) return "Tie";
        else if(diff>0) return "Alice";
        else return "Bob";
    }
}