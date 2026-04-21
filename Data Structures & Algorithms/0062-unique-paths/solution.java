class Solution {
    private int paths(int row,int col,int dp[][],int m,int n){
        if(row==m-1 && col == n-1) return 1;
        if(row>=m || col >=n || row<0 || col<0) return 0;

        if(dp[row][col] !=-1) return dp[row][col];
        int down = paths(row+1,col,dp,m,n);
        int right = paths(row,col+1,dp,m,n);
        int res = down + right;
        return dp[row][col] = res;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp  = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        return paths(0,0,dp,m,n);
    }
}
