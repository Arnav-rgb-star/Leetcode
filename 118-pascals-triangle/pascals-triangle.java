class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        int n=numRows;
        int dp[][]=new int[n+1][n+1];

        for(int i=0;i<=n;i++) dp[i][1]=1;

        for(int i=1;i<=n;i++){
            triangle.add(new ArrayList<>());
            for(int j=1;j<=i;j++){
                dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
                triangle.get(i-1).add(dp[i][j]);
            }
        }

        return triangle;
    }
}