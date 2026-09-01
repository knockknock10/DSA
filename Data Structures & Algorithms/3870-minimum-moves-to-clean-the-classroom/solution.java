class Solution{
    public int minMoves(String[] classroom,int energy){
        int m=classroom.length;
        int n=classroom[0].length();
        int[][] litterId=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                litterId[i][j]=-1;
            }
        }
        int sr=0,sc=0;
        int litterCount=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                char ch=classroom[i].charAt(j);
                if(ch=='S'){
                    sr=i;
                    sc=j;
                }else if(ch=='L'){
                    litterId[i][j]=litterCount++;
                }
            }
        }
        if(litterCount==0){
            return 0;
        }
        int allCollected=(1<<litterCount)-1;
        boolean[][][][] visited=new boolean[m][n][1<<litterCount][energy+1];
        java.util.Queue<int[]> queue=new java.util.LinkedList<>();
        queue.offer(new int[]{sr,sc,0,energy});
        visited[sr][sc][0][energy]=true;
        int moves=0;
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-->0){
                int[] state=queue.poll();
                int r=state[0];
                int c=state[1];
                int mask=state[2];
                int currentEnergy=state[3];
                if(mask==allCollected){
                    return moves;
                }
                for(int d=0;d<4;d++){
                    int nr=r+dr[d];
                    int nc=c+dc[d];
                    if(nr<0||nr>=m||nc<0||nc>=n){
                        continue;
                    }
                    if(classroom[nr].charAt(nc)=='X'){
                        continue;
                    }
                    if(currentEnergy==0){
                        continue;
                    }
                    int newEnergy=currentEnergy-1;
                    int newMask=mask;
                    if(classroom[nr].charAt(nc)=='L'){
                        int id=litterId[nr][nc];
                        newMask|=(1<<id);
                    }
                    if(classroom[nr].charAt(nc)=='R'){
                        newEnergy=energy;
                    }
                    if(!visited[nr][nc][newMask][newEnergy]){
                        visited[nr][nc][newMask][newEnergy]=true;
                        queue.offer(new int[]{nr,nc,newMask,newEnergy});
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}
