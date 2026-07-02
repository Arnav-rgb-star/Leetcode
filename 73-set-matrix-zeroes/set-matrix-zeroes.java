class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<int[]> l = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    l.add(new int[]{i,j});
                }
            }
        }
        for(int i=0;i<l.size();i++){
            int r = l.get(i)[0];
            int c = l.get(i)[1];

        for (int row = 0; row < n; row++) matrix[row][c] = 0;

        for (int col = 0; col < m; col++) matrix[r][col] = 0;
        }
    }
}