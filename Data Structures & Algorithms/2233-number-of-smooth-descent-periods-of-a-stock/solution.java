class Solution {
    static public long getDescentPeriods(int[] prices) {
        long sum=0, des=0;
        int prev=-1;
        for (int x : prices){
            des=(x+1==prev?des:0)+1;
            sum+=des;
            prev=x;
        }
        return sum;
    }
}
