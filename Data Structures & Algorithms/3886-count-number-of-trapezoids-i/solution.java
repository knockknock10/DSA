class Solution {
    public int countTrapezoids(int[][] points) {
        long mod=1000000007L;
        Map<Integer,Long> mapy=new HashMap<>();
        for(int []row:points){
            mapy.put(row[1],mapy.getOrDefault(row[1],0L)+1);
        }
        List<Long> height=new ArrayList<>();
        for(long val:mapy.values()){
            if(val>=2){
                long ways=(val*(val-1))/2;
                height.add(ways%mod);
            }
        }
        long ans=0,sum=0;
        for(long val:height){
            ans=(ans+(val*sum)%mod)%mod;
            sum=(sum+val)%mod;
        }
        return (int)ans;
    }
}
