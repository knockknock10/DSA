class Solution {
    public int numSpecial(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int result=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j]==1){
                    boolean found = false;
                    for(int k=0; k<m; k++){
                        if(mat[i][k]==1 && k!=j){
                            found = true;
                            break;
                        }
                    }
                    if(found)break;

                    for(int k=0; k<n; k++){
                        if(mat[k][j]==1 && k!=i){
                            found = true;
                            break;
                        }
                    }

                    if(found)break;

                    result++;
                }
            }
        }
        return result;
    }
}
