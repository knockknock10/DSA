class Solution {
    public long countCommas(long n) {
        long c = 0;
        if(n>=1000){
            c+=(n-999);
        }
        if(n>=1000000){
            c+=(n-999999);
        }
        if(n>=1000000000L){
            c+=(n-999999999L);
        }
        if(n>=1000000000000L){
            c+=(n-999999999999L);
        }
        if(n>=1000000000000000L){
            c+=(n-999999999999999L);
        }
        return c;
        
    }
}
