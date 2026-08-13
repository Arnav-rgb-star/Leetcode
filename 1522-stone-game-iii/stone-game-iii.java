class Solution {
    int l=0;
    int diff=0;
    int dp[][];
    public int f(int a[], int l,int i){
        
        int n = a.length;
        if(i==a.length)  return 0;
        if(dp[l][i]!=-1) return dp[l][i];

            int one = Integer.MIN_VALUE;
            int two= Integer.MIN_VALUE;
            int three=Integer.MIN_VALUE;
                 
        if(l==0){
             one = a[i] - f(a,1,i+1);
             if(i+1 < n)  two= a[i] + a[i+1] - f(a,1,i+2);
             if(i+2 < n)  three= a[i] + a[i+1] +a[i+2] - f(a,1,i+3);
             
             return dp[l][i] =Math.max(Math.max(one,two),three);
             }
             
              one = a[i] - f(a,0,i+1);
             if(i+1 < n)  two= a[i] + a[i+1] -f(a,0,i+2);
             if(i+2 < n)  three= a[i] + a[i+1] +a[i+2] - f(a,0,i+3);
             
             return  dp[l][i] = Math.max(Math.max(one,two),three);                  
        
    }
    public String stoneGameIII(int[] stoneValue) {
        
        dp = new int[2][stoneValue.length];

        Arrays.fill(dp[0],-1);
        Arrays.fill(dp[1],-1);

        diff = f(stoneValue,l,0);

        if(diff==0) return "Tie";
        else if(diff>0) return "Alice";
        else return "Bob";
    }
}