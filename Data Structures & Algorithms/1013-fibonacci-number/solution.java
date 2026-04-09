class Solution {
       
    private int fibs(int n,int dp[]){
        if(n==1 || n==0){
            return n;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        dp[n] = fibs(n-1,dp)+fibs(n-2,dp);
        return dp[n];
    }
    public int fib(int n) {
        int dp[] = new int[n+1];
        int ans = fibs(n,dp);
        return ans;
    }
}
