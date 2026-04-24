class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        
        int[][] count = new int[n][m];
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0){
                    count[i][j] = matrix[i][j];
                }else if(matrix[i][j]==1){
                    count[i][j] = 1+Math.min(count[i-1][j],
                        Math.min(count[i-1][j-1],count[i][j-1]));
                }ans+=count[i][j];
            }
        }
        return ans;
    }
}
