class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        TreeSet<Integer> ts=new TreeSet<>((a,b)->Integer.compare(b,a));
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ts.add(grid[i][j]);
                for(int size=1;size<=Math.min(m,n);size++){
                    int sum=0;
                    boolean valid=true;
                    int x1=i,y1=j,x2=i,y2=j;
                    int dir1=-1,dir2=1;
                    int temp=0;
                    while(temp<=2*size){
                        if(Math.min(x1,x2)<0||Math.max(x1,x2)>=m||Math.min(y1,y2)<0||Math.max(y1,y2)>=n){
                            valid=false;
                            break;
                        }
                        if(x1==x2&&y1==y2){
                            sum+=grid[x1][y1];
                        }else{
                            sum+=grid[x1][y1];
                            sum+=grid[x2][y2];
                        }
                        if(temp==size){
                            dir2=dir2*dir1;
                            dir1=dir2*dir1;
                        }
                        x1--;
                        x2--;
                        y1=y1+dir1;
                        y2=y2+dir2;
                        temp++;
                    }
                    if(valid){
                        ts.add(sum);
                    }
                }
            }
        }
        List<Integer> lst=new ArrayList<>();
        while(!ts.isEmpty()&&lst.size()<3){
            lst.add(ts.getFirst());
            ts.removeFirst();
        }
        return lst.stream().mapToInt(Integer::intValue).toArray();
    }
}
