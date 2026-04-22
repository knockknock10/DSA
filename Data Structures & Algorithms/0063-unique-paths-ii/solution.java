class Solution {
    private int util(int row,int col,int[][] dp,int m,int n,int[][] obstacleGrid){
        //check the obstacle at after all bcz there is test case which fails where there is obstacle at the end
        // if(row==m-1 && col==n-1) return 1;
        if(row>=m || row<0 || col>=n || col<0) return 0;
        //for obstacle
        if(obstacleGrid[row][col]==1) return 0;

        if(row==m-1 && col==n-1) return 1;
        if(dp[row][col]!= -1) return dp[row][col];

        int down = util(row+1,col,dp,m,n,obstacleGrid);
        int right = util(row,col+1,dp,m,n,obstacleGrid);
        int res = down+right;
        return dp[row][col] = res;

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        return util(0,0,dp,m,n,obstacleGrid);
    }
}
